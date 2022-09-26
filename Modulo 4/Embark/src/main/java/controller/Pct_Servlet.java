package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Pct_viagemDAO;
import model.Pct_viagem;

/**
 * Servlet implementation class pct_viagemServlet
 */
@WebServlet(urlPatterns = { "/pct_viagem", "/CadastroPct", "/editar-pct", "/atualizar-pct", "/deletar-pct" })
public class Pct_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Pct_viagemDAO pct_viagemDAO = new Pct_viagemDAO();
	Pct_viagem pct_viagem = new Pct_viagem();

	public Pct_Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/pct_viagem":
			read(request, response);
			break;

		case "/CadastroPct":
			create(request, response);
			break;

		case "/editar-pct":
			readById(request, response);
			break;
			
		case "/atualizar-pct":
			update(request, response);
			break;
			
		case "/deletar-pct":
			delete(request, response);
			break;
			
		default:
			response.sendRedirect("index.html");
			break;
		}

	}

	// Create
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pct_viagem.setpreço(request.getParameter("preço"));
		pct_viagem.setdata_da_viagem(request.getParameter("data_da_viagem"));
		pct_viagem.setdestino(request.getParameter("destino"));
		pct_viagem.setcondução(request.getParameter("condução"));
	//	pct_viagem.setid_hosp(Integer.parseInt(request.getParameter("id_hosp")));
		pct_viagemDAO.saveUser(pct_viagem);
		response.sendRedirect("pct_viagem");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Pct_viagem> lista = pct_viagemDAO.readUsers();

		request.setAttribute("pct_viagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/PctViagem/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* usuario.setId_usuario(Integer.parseInt(request.getParameter("id"))); */
		pct_viagem.setpreço(request.getParameter("preço"));
		pct_viagem.setdata_da_viagem(request.getParameter("data_da_viagem"));
		pct_viagem.setdestino(request.getParameter("destino"));
		pct_viagem.setcondução(request.getParameter("condução"));
		pct_viagem.setid_hosp(Integer.parseInt(request.getParameter("id_hosp")));
		pct_viagemDAO.updateUser(pct_viagem);
		response.sendRedirect("pct_viagem");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pct_viagemDAO.deleteUser(id);
		response.sendRedirect("pct_viagem");
	}


	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		pct_viagem = pct_viagemDAO.getPct_viagemByid(id);
		
		
		request.setAttribute("id_destino", pct_viagem.getid_destino());
		request.setAttribute("preço", pct_viagem.getpreço());
		request.setAttribute("data_da_viagem", pct_viagem.getdata_da_viagem());
		request.setAttribute("destino", pct_viagem.getdestino());
		request.setAttribute("condução", pct_viagem.getcondução());
		request.setAttribute("id_hosp", pct_viagem.getid_hosp());
		
		RequestDispatcher rd = request.getRequestDispatcher("./view/PctVagem/Atualizar.jsp");
		rd.forward(request, response);
		
	}

}
