package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dao.factory.ProvinciasDAOFactory;
import negocio.dao.interfaces.ProvinciasDAO;
import negocio.dto.Provincias;

/**
 * Servlet implementation class DestinosController
 */
@WebServlet("/DestinosController")
public class DestinosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DestinosController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/tablas/datosDestinos/DestinosData.jsp");
		ProvinciasDAO provinciaDAO = ProvinciasDAOFactory.get("database");
		List<Provincias> destinos = new ArrayList<Provincias>();
		try {
			destinos = provinciaDAO.getProvincias();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("lista", destinos);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
