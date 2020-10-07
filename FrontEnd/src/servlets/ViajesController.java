package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import negocio.bll.NuevoViaje;
import negocio.dao.factory.CamionesDAOFactory;
import negocio.dao.factory.ChoferesDAOFactory;
import negocio.dao.factory.ProvinciasDAOFactory;
import negocio.dao.factory.ViajesDAOFactory;
import negocio.dao.interfaces.CamionesDAO;
import negocio.dao.interfaces.ChoferesDAO;
import negocio.dao.interfaces.ProvinciasDAO;
import negocio.dao.interfaces.ViajesDAO;
import negocio.dto.Camiones;
import negocio.dto.Choferes;
import negocio.dto.Provincias;
import negocio.dto.Viajes;

/**
 * Servlet implementation class ViajesController
 */
@WebServlet("/ViajesController")
public class ViajesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ViajesDAO viajeDAO = ViajesDAOFactory.get("database");

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViajesController() {
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
		// requests datos viajes
		HttpSession session= (HttpSession) request.getSession();
		if(session.getAttribute("perfil").equals("Admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("html/tablas/datosViajes/ViajesData.jsp");
			
			List<Viajes> viajes = new ArrayList<Viajes>();
			ViajesDAO viajesDAO = ViajesDAOFactory.get("database");
			try {
				viajes = viajesDAO.getViajes();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// request.setAttribute("chofer_dni", 38555654);
			request.setAttribute("lista", viajes);
			dispatcher.forward(request, response);
		}else {
			PrintWriter pw= response.getWriter();
			pw.println("No autorizado");
			pw.close();
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// new viaje
		String add = request.getParameter("nuevo");
		String addPopulate = request.getParameter("addPopulate");

		if (!isNullOrEmpty(add)) {
			try {
				this.addViaje(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}
		} else if (!isNullOrEmpty(addPopulate)) {
			try {
				this.populateNuevoViajeForm(request, response);
			} catch (SQLException | IOException | ServletException e) {
				e.printStackTrace();
			}

		}

	}

	protected void getAllViajes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Viajes> viajes = new ArrayList<Viajes>();
		ViajesDAO viajesDAO = ViajesDAOFactory.get("database");
		try {
			viajes = viajesDAO.getViajes();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("lista", viajes);

	}

	protected void populateNuevoViajeForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("html/tablas/datosViajes/NewViaje.jsp");
		List<Choferes> choferes = new ArrayList<Choferes>();
		List<Camiones> camiones = new ArrayList<Camiones>();
		List<Provincias> provincias = new ArrayList<Provincias>();
		ChoferesDAO choferDAO = ChoferesDAOFactory.get("database");
		CamionesDAO camionDAO = CamionesDAOFactory.get("database");
		ProvinciasDAO provinciaDAO = ProvinciasDAOFactory.get("database");
		try {
			choferes = choferDAO.getChoferes();
			camiones = camionDAO.getCamiones();
			provincias = provinciaDAO.getProvincias();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("choferes", choferes);
		request.setAttribute("camiones", camiones);
		request.setAttribute("provincias", provincias);
		dispatcher.forward(request, response);

	}

	protected void addViaje(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		Viajes viaje = new Viajes();

		Choferes chofer = new Choferes();
		chofer.setIdChoferes((Integer.parseInt(request.getParameter("chofer"))));
		viaje.setChofer(chofer);

		Camiones camion = new Camiones();
		camion.setIdCamiones((Integer.parseInt(request.getParameter("camion"))));
		viaje.setCamion(camion);

		Provincias origen = new Provincias();
		origen.setIdProvincia((Integer.parseInt(request.getParameter("origen"))));
		viaje.setOrigen(origen);

		Provincias destino = new Provincias();
		destino.setIdProvincia((Integer.parseInt(request.getParameter("destino"))));
		viaje.setDestino(destino);

		// TODO: invocar BLL y calcular distancia, tiempo de viaje, tanques de
		// combustible
		// pasando como parametro id camion, id origen, id destino
		// y retornando lista de parametros
		NuevoViaje n = new NuevoViaje();
		n.addViaje(viaje);
		response.sendRedirect("http://localhost:8080/FrontEnd/ViajesController");
		
	}

}
