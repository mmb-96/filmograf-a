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
import filmografia.model.Pelicula;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "Controlador de la aplicacion", urlPatterns = { "/Controller" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
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
		List<String> listaDir = new ArrayList<String>();
		try {
			switch (action) {
				case "Pelis Dir":
					listaDir.add(request.getParameter("dir"));
					ac = new ListaPelisDir();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
//				case "Muestra sueldo":
//					ac = new MuestraSueldo();
//					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
//					break;
//				case "Recuperar empleados":
//					ac = new RecuperarEmpleados();
//					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
//					break;
//				case "Modificar empleados":
//					ac = new ModificarEmpleados();
//					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
//	    	 			pagSiguiente = "Exito.html";
//					break;
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
