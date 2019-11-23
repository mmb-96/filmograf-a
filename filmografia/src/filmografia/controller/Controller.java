package filmografia.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.accion.Facade;
import filmografia.accion.ListaPelisDir;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "Controlador de la aplicacion", urlPatterns = { "/Controller" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String> listaDir;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
    	super();
    	listaDir = new ArrayList<String>();
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		Facade ac = null;
		String pagSiguiente = null;
		String action = request.getParameter("action");
		try {
			switch (action) {
				case "Pelis Dir":
					ac = new ListaPelisDir();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					if( request.getParameter("dir") != null) {
						listaDir.add(request.getParameter("dir"));
					}
					System.out.println(request.getParameter("dir"));
					break;
				case "Finalizar":
					System.out.println(listaDir.toString());
					request.setAttribute("listaDirec", listaDir);
					pagSiguiente = "listaConsultaDir.jsp";
					break;
				case "Vuelve Dir":
					listaDir.clear();
					pagSiguiente = "consultDir.jsp";
					break;
				case "Vuelve index":
					listaDir.clear();
	    	 		pagSiguiente = "index.html";
					break;
				default:
					pagSiguiente = "index.html";
					break;
			}
		} catch (Exception e) {
			pagSiguiente = "Error.html";
		}
		rd = request.getRequestDispatcher(pagSiguiente);
		rd.forward(request, response);
	}

}