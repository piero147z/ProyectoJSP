package nombredominio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nombredominio.models.Usuario;
import nombredominio.modelsDAO.UsuarioDAO;

/**
 * Servlet implementation class UsuariosController
 */
@WebServlet("/UsuariosController")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String acceso;
	String action;

	Usuario usuario;
	UsuarioDAO usuarioDAO;

	String nombre, email, password;

	String index = "usuarios/index.jsp";
	String create = "usuarios/create.jsp";
	String edit = "usuarios/edit.jsp";

	ArrayList<Usuario> usuarios;
	
	int id;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		acceso = "";
		action = request.getParameter("action");

		switch (action) {
		case "index":
			usuarios = usuarioDAO.all();
			request.setAttribute("usu", usuarios);
			acceso = index;
			break;
			
		case "create":
			acceso = create;
			break;
			
		case "edit":
			id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("usu", usuarioDAO.find(id));
			
			acceso = edit;
			break;
			
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			
			usuarioDAO.delete(id);

			acceso = index;
			break;

		default:
			break;
		}
		
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		acceso = "";
		action = request.getParameter("action");

		switch (action) {
		case "create":
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			
			usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setMail(email);

			usuarioDAO.save(usuario);
			
			acceso = index;
			break;
			
		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			nombre = request.getParameter("nombre");
			email = request.getParameter("email");
			
			usuario = new Usuario();
			usuario.setId(id);
			usuario.setNombre(nombre);
			usuario.setMail(email);
			
			usuarioDAO.update(usuario);

			acceso = index;
			break;

		default:
			break;
		}
		
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
		
	}

}
