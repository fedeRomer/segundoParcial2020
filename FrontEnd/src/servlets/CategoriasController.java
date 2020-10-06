package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.dto.Categorias;

/**
 * Servlet implementation class CategoriasController
 */
@WebServlet("/CategoriasController")
public class CategoriasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("html/tablas/datosCategorias/CategoriasData.jsp");
		Categorias c1 = new Categorias();
		c1.setCategoria(1);
		c1.setChabilitado("1");
		c1.setDescripcion("Explosivos");
		Categorias c2 = new Categorias();
		c2.setCategoria(2);
		c2.setChabilitado("1-2");
		c2.setDescripcion("Gases");
		Categorias c3 = new Categorias();
		c3.setCategoria(3);
		c3.setChabilitado("1-2-3");
		c3.setDescripcion("Liquidos Inflamables");
		Categorias c4 = new Categorias();
		c4.setCategoria(4);
		c4.setChabilitado("1-2-3-4");
		c4.setDescripcion("Solidos Inflamables");
		Categorias c5 = new Categorias();
		c5.setCategoria(5);
		c5.setChabilitado("1-2-3-4-5");
		c5.setDescripcion("Sustancias Toxicas e Infecciosas");
		
		List<Categorias> cList = new ArrayList<>();
		cList.add(c1);
		cList.add(c2);
		cList.add(c3);
		cList.add(c4);
		cList.add(c5);
		request.setAttribute("lista",cList);
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
