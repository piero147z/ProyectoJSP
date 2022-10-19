package nombredominio.controller;

import java.io.IOException;
import java.lang.reflect.AccessibleObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nombredominio.models.Usuario;
import nombredominio.modelsDAO.UsuarioDAO;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/AuthController")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String action;
	String acceso;

	Usuario usuario;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	String email, password;

	String login = "login.jsp";
	String home = "home.jsp";

	// String edit = "usuarios/edit.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");

		switch (action) {
		case "login":

			acceso = login;
			break;
			
		case "home":

			acceso = home;
			break;
			
		case "logout":
			request.getSession().removeAttribute("usuario");
			acceso = login;
			
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		action = request.getParameter("action");

		switch (action) {
		case "login":

			email = request.getParameter("email");
			password = request.getParameter("password");

			if (usuarioDAO.validate(email, password)) {

				request.getSession().setAttribute("usuario", usuarioDAO.getUsuario(email, password));
			} else {
				acceso = login;
			}

			break;

		default:
			break;
		}

		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

}
