package servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dao.factory.ChoferesDAOFactory;
import negocio.dao.interfaces.ChoferesDAO;
import negocio.dto.Choferes;

/**
 * Servlet implementation class ChoferesController
 */
@WebServlet("/ChoferesController")
public class ChoferesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChoferesDAO choferDAO = ChoferesDAOFactory.get("database");

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChoferesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/tablas/datosCamiones/CamionesData.jsp");
		List<Choferes> choferes = new ArrayList<Choferes>();
		ChoferesDAO choferDAO = ChoferesDAOFactory.get("database");
		try {
			choferes = choferDAO.getChoferes();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lista", choferes);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ChoferesDAO choferDAO = ChoferesDAOFactory.get("database");
		String modificar = request.getParameter("modificar");
		String eliminar = request.getParameter("eliminar");
		String add = request.getParameter("nuevo");

		if (!isNullOrEmpty(modificar)) {
			try {
				this.modifyChofer(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		} else if (!isNullOrEmpty(eliminar)) {
			try {
				this.deleteChofer(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		} else if (!isNullOrEmpty(add)) {
			try {
				this.addChofer(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		}

	}

	protected void addChofer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Choferes chofer = new Choferes();
		chofer.setNombre(request.getParameter("nombre"));
		chofer.setApellido(request.getParameter("apellido"));
		chofer.setDni(Integer.parseInt(request.getParameter("dni")));
		chofer.setFechaDeNacimiento(Date.valueOf(request.getParameter("fechaDeNacimiento")));
		chofer.setCategoria(Integer.parseInt(request.getParameter("categoria")));
		chofer.setTelefono(request.getParameter("telefono"));

		if (this.choferDAO.addChofer(chofer)) {
			System.err.println("add ok");
		} else {
			System.err.println("no ok");
		}

	}

	protected void modifyChofer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Choferes chofer = new Choferes();
		chofer.setIdChoferes(Integer.parseInt(request.getParameter("id")));
		chofer.setNombre(request.getParameter("nombre"));
		chofer.setApellido(request.getParameter("apellido"));
		chofer.setDni(Integer.parseInt(request.getParameter("dni")));
		chofer.setFechaDeNacimiento(Date.valueOf(request.getParameter("fechaDeNacimiento")));
		chofer.setCategoria(Integer.parseInt(request.getParameter("categoria")));
		chofer.setTelefono(request.getParameter("telefono"));

		if (this.choferDAO.modifyChofer(chofer)) {
			System.err.println("modifyC ok");
		} else {
			System.err.println("no ok");
		}
	}

	protected void deleteChofer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		if (this.choferDAO.deleteChofer(Integer.parseInt(request.getParameter("id")))) {
			System.err.println("ok delete");
		} else {
			System.err.println("no ok");
		}
	}

	protected void getChofer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Choferes chofer = new Choferes();
		chofer.setDni(Integer.parseInt(request.getParameter("dni")));
		
		if (this.choferDAO.searchChofer(chofer)) {
			System.err.println("ok delete");
		} else {
			System.err.println("no ok");
		}
	}

}
