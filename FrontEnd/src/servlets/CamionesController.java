package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dao.factory.CamionesDAOFactory;
import negocio.dao.interfaces.CamionesDAO;
import negocio.dto.Camiones;

/**
 * Servlet implementation class CamionesController
 */
@WebServlet("/CamionesController")
public class CamionesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CamionesDAO camionDAO = CamionesDAOFactory.get("database");
	
	 public static boolean isNullOrEmpty(String str) {
	        if(str != null && !str.isEmpty())
	            return false;
	        return true;
	    }

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CamionesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/tablas/datosCamiones/CamionesData.jsp");

		CamionesDAO camionDAO = CamionesDAOFactory.get("database");
		List<Camiones> camiones = new ArrayList<Camiones>();
		try {
			camiones = camionDAO.getCamiones();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lista", camiones);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CamionesDAO camionDAO = CamionesDAOFactory.get("database");
		String modificar = request.getParameter("modificar");
		String eliminar = request.getParameter("eliminar");
		String add = request.getParameter("nuevo");
		
		if (!isNullOrEmpty(modificar)) {
			try {
				this.modifyCamion(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		} else if (!isNullOrEmpty(eliminar)) {
			try {
				this.deleteCamion(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		} else if (!isNullOrEmpty(add)) {
			try {
				this.addCamion(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}

		}
		response.sendRedirect("http://localhost:8080/FrontEnd/CamionesController");

	}

	protected void addCamion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Camiones camion = new Camiones();

//		camion.setIdCamiones(Integer.parseInt(request.getParameter("id")));
		camion.setMarca(request.getParameter("marca"));
		camion.setModelo(request.getParameter("modelo"));
		camion.setDominio(request.getParameter("dominio"));
		camion.setCategoria(Integer.parseInt(request.getParameter("categoria")));
		camion.setCargaMaximaTn(Integer.parseInt(request.getParameter("cargaMaximaTn")));
		camion.setLitrosTanque(Integer.parseInt(request.getParameter("litrosTanque")));
		camion.setConsumoLitrosKm(Integer.parseInt(request.getParameter("consumoLitrosKm")));

		if (this.camionDAO.addCamion(camion)) {
			System.err.println("ok add");
		} else {
			System.err.println("no ok");
		}

	}

	protected void modifyCamion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Camiones camion = new Camiones();

		camion.setIdCamiones(Integer.parseInt(request.getParameter("id")));
		camion.setMarca(request.getParameter("marca"));
		camion.setModelo(request.getParameter("modelo"));
		camion.setDominio(request.getParameter("dominio"));
		camion.setCategoria(Integer.parseInt(request.getParameter("categoria")));
		camion.setCargaMaximaTn(Integer.parseInt(request.getParameter("cargaMaximaTn")));
		camion.setLitrosTanque(Integer.parseInt(request.getParameter("litrosTanque")));
		camion.setConsumoLitrosKm(Integer.parseInt(request.getParameter("consumoLitrosKm")));

		if (this.camionDAO.modifyCamion(camion)) {
			System.err.println("ok modif");
		} else {
			System.err.println("no ok");
		}
	}

	protected void deleteCamion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		if (this.camionDAO.deleteCamion(Integer.parseInt(request.getParameter("id")))) {
			System.err.println("ok delete");
		} else {
			System.err.println("no ok");
		}

	}

}
