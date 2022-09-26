package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import model.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet(urlPatterns = { "/cliente", "/CadastroCliente", "/editar-cliente", "/atualizar-cliente", "/deletar-cliente" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteDAO clienteDAO = new ClienteDAO();
	Cliente cliente = new Cliente();

	public ClienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/cliente":
			read(request, response);
			break;

		case "/CadastroCliente":
			create(request, response);
			break;

		case "/editar-cliente":
			readById(request, response);
			break;
			
		case "/atualizar-cliente":
			update(request, response);
			break;
			
		case "/deletar-cliente":
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

		cliente.setnome(request.getParameter("nome"));
		cliente.setemail(request.getParameter("email"));
		cliente.setcidade(request.getParameter("cidade"));
		cliente.setcep(Integer.parseInt(request.getParameter("cep")));
		cliente.setsenha(request.getParameter("senha"));
		cliente.setestado(request.getParameter("estado"));
		cliente.setsobre_nome(request.getParameter("sobre_nome"));
		clienteDAO.saveUser(cliente);
		response.sendRedirect("cliente");

	}

	// Read
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> lista = clienteDAO.readUsers();

		request.setAttribute("cliente", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./view/Cliente/");
		rd.forward(request, response);

	}

	// Update
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/* usuario.setId_usuario(Integer.parseInt(request.getParameter("id"))); */
		cliente.setnome(request.getParameter("nome"));
		cliente.setemail(request.getParameter("email"));
		cliente.setcidade(request.getParameter("cidade"));
		cliente.setcep(Integer.parseInt(request.getParameter("cep")));
		cliente.setsenha(request.getParameter("senha"));
		cliente.setsobre_nome(request.getParameter("sobre_nome"));
		cliente.setestado(request.getParameter("estado"));
		clienteDAO.updateUser(cliente);
		response.sendRedirect("cliente");
	}

	// Delete
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		clienteDAO.deleteUser(id);
		response.sendRedirect("cliente");
	}


	// Read by Id
	protected void readById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		int id = Integer.parseInt(request.getParameter("id"));
		
		cliente = clienteDAO.getclienteByid(id);
		
		
		request.setAttribute("id_cliente", cliente.getid_cliente());
		request.setAttribute("nome", cliente.getnome());
		request.setAttribute("email", cliente.getemail());
		request.setAttribute("cidade", cliente.getcidade());
		request.setAttribute("cep", cliente.getcep());
		request.setAttribute("senha", cliente.getsenha());
		request.setAttribute("sobre_nome", cliente.getsobre_nome());
		request.setAttribute("estado", cliente.getestado());
		
		RequestDispatcher rd = request.getRequestDispatcher("./view/Cliente/Atualizar.jsp");
		rd.forward(request, response);
		
	}

}
