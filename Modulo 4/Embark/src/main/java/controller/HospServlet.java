package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospDAO;
import model.Hospedagem;

/**
 * Servlet implementation class hospedagemServlet
 */
@WebServlet(urlPatterns = { "/hospedagem", "/CadastroHosp", "/editar-hosp", "/atualizar-hosp", "/deletar-hosp" })
public class HospServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HospDAO hospDAO = new HospDAO();
	Hospedagem hospedagem = new Hospedagem();

	public HospServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/hospedagem":
			read(request, response);
			break;

		case "/CadastroHosp":
			create(request, response);
			break;

		case "/editar-hosp":
			readById(request, response);
			break;
			
		case "/atualizar-hosp":
			update(request, response);
			break;
			
		case "/deletar-hosp":
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

		hospedagem.setnomeHosp(request.getParameter("nomeHosp"));
		hospedagem.setcidade(request.getParameter("cidade"));
		hospedagem.setestado(request.getParameter("estado"));
		hospedagem.setrua(request.getParameter("rua"));
		hospDAO.saveUser(hospedagem);
		response.sendRedirect("hospedagem");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Hospedagem> lista = hospDAO.readUsers();

		request.setAttribute("hospedagem", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/Hospedagem/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* usuario.setId_usuario(Integer.parseInt(request.getParameter("id"))); */
		hospedagem.setnomeHosp(request.getParameter("nomeHosp"));
		hospedagem.setcidade(request.getParameter("cidade"));
		hospedagem.setestado(request.getParameter("estado"));
		hospedagem.setrua(request.getParameter("rua"));
		hospDAO.updateUser(hospedagem);
		response.sendRedirect("hospedagem");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		hospDAO.deleteUser(id);
		response.sendRedirect("hospedagem");
	}


	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		hospedagem = hospDAO.gethospedagemByid(id);
		
		
		request.setAttribute("id_hosp", hospedagem.getid_hosp());
		request.setAttribute("nomeHosp", hospedagem.getnomeHosp());
		request.setAttribute("cidade", hospedagem.getcidade());
		request.setAttribute("estado", hospedagem.getestado());
		request.setAttribute("rua", hospedagem.getrua());
		RequestDispatcher rd = request.getRequestDispatcher("./view/Hospedagem/Atualizar.jsp");
		rd.forward(request, response);
		
	}

}
