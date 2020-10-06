package servlets.Landing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dao.factory.UsuarioDAOFactory;
import negocio.dao.interfaces.UsuarioDAO;
import negocio.dto.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String value = request.getParameter("button");
		if (value.equalsIgnoreCase("ingresar")) {
			// redireccionar a login html
			response.getWriter().append("value // Served at: ").append(request.getContextPath());
		} else if (value.equalsIgnoreCase("registrarse")) {
			// redireccionar a registrarse html
			response.getWriter().append("value // Served at: ").append(request.getContextPath());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDAO usuarioDAO = UsuarioDAOFactory.get("database");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(user.concat(" ").concat(password));
		try {
			Usuario usuario = usuarioDAO.getUsuario(user, password);
			if (usuario.getUsername() != null && usuario.getPassword() != null) {
				Cookie loginCookie = new Cookie("user", user);
				loginCookie.setMaxAge(30 * 60);
				//TODO: urgente cookies
				/*
				 * añadir un cookie.setValue(chofer o admin)
				 * despues en controller validar antes de entrar a X pagina y restringir o autorizar segun value equals chofer admin
				 */
				response.addCookie(loginCookie);
				response.sendRedirect("http://localhost:8080/FrontEnd/html/LoginSuccess.jsp");
				// https://www.journaldev.com/1907/java-session-management-servlet-httpsession-url-rewriting
			} else {
				response.sendRedirect("http://localhost:8080/FrontEnd");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
