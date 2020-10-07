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
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(true);
		
		UsuarioDAO usuarioDAO = UsuarioDAOFactory.get("database");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(user.concat(" ").concat(password));
		try {
			Usuario usuario = usuarioDAO.getUsuario(user, password);
			if (usuario.getUsername() != null && usuario.getPassword() != null) {
				Cookie loginCookie = new Cookie("user", user);
				loginCookie.setMaxAge(30 * 60);
				response.addCookie(loginCookie);
				session.setAttribute("perfil", usuario.getPerfil());
				session.setAttribute("idUser", usuario.getId());
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
