package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CompraDAO;
import model.Compra;

/**
 * Servlet implementation class CompraServlet
 */
@WebServlet(urlPatterns = { "/compra", "/CadastroCompra", "/editar-compra", "/atualizar-compra", "/deletar-compra" })
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CompraDAO compraDAO = new CompraDAO();
	Compra compra = new Compra();

	public CompraServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/compra":
			read(request, response);
			break;

		case "/CadastroCompra":
			create(request, response);
			break;

		case "/editar-compra":
			readById(request, response);
			break;
			
		case "/atualizar-compra":
			update(request, response);
			break;
			
		case "/deletar-compra":
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
		
		compra.setnota_fiscal(Integer.parseInt(request.getParameter("nota_fiscal")));
		compra.setdata_compra(request.getParameter("data_compra"));
		compra.setnome_cliente(request.getParameter("nome_cliente"));
		compra.setquantidade_compra(Integer.parseInt(request.getParameter("quantidade_compra")));
		compra.setdestino(request.getParameter("destino"));
		compra.setvalorCompra(request.getParameter("valorCompra"));
		compraDAO.saveUser(compra);
		response.sendRedirect("compra");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Compra> lista = compraDAO.readUsers();

		request.setAttribute("compra", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/Compra/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* usuario.setId_usuario(Integer.parseInt(request.getParameter("id"))); */
		compra.setnome_cliente(request.getParameter("nome_cliente"));
		compra.setdata_compra(request.getParameter("data_compra"));
		compra.setquantidade_compra(Integer.parseInt(request.getParameter("quantidade_compra")));
		compra.setdestino(request.getParameter("destino"));
		compra.setvalorCompra(request.getParameter("valorCompra"));
		compraDAO.updateUser(compra);
		response.sendRedirect("compra");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		compraDAO.deleteUser(id);
		response.sendRedirect("compra");
	}


	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		compra = compraDAO.getcompraByid(id);
		
		
		request.setAttribute("nota_fiscal", compra.getnota_fiscal());
		request.setAttribute("data_compra", compra.getdata_compra());
		request.setAttribute("nome_cliente", compra.getnome_cliente());
		request.setAttribute("quantidade_compra", compra.getquantidade_compra());
		request.setAttribute("destino", compra.getdestino());
		request.setAttribute("valorCompra", compra.getvalorCompra());
		
		RequestDispatcher rd = request.getRequestDispatcher("./view/Compra/Atualizar.jsp");
		rd.forward(request, response);
		
	}

}
