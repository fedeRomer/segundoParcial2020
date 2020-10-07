package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import negocio.dao.factory.ViajesDAOFactory;
import negocio.dao.interfaces.ViajesDAO;
import negocio.dto.Viajes;

/**
 * Servlet implementation class ViajesAsignadosController
 */
@WebServlet("/ViajesAsignadosController")
public class ViajesAsignadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViajesAsignadosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session= (HttpSession) request.getSession();
		if(session.getAttribute("perfil").equals("Chofer")) {

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("html/tablas/datosViajesAsignados/ViajesAsignadosData.jsp");
			List<Viajes> viajes = new ArrayList<Viajes>();
			ViajesDAO viajesDAO = ViajesDAOFactory.get("database");
			try {
				viajes = viajesDAO.getViajes();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// request.setAttribute("chofer_dni", 38555654);
			List<Viajes> viajesFiltered = new ArrayList<Viajes>();
			for(int k=0;k<viajes.size();k++) {
				if(viajes.get(k).getChofer() ==  (Integer) session.getAttribute("idUser")) {
					viajesFiltered.add(viajes.get(k));
				}
			}
			request.setAttribute("lista", viajesFiltered);
			dispatcher.forward(request, response);
		}else {
			PrintWriter pw= response.getWriter();
			pw.println("No autorizado");
			pw.close();
			//response.sendRedirect("http://localhost:8080/FrontEnd/html/Home2.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ViajesDAO viajesDAO = ViajesDAOFactory.get("database");
		try {
			if (viajesDAO.deleteViaje(Integer.parseInt(request.getParameter("id")))) {
				System.err.println("ok delete");
			} else {
				System.err.println("no ok");
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("http://localhost:8080/FrontEnd/ViajesAsignadosController");

	}

}
