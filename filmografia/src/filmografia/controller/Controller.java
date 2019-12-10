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

import filmografia.accion.AltaPeli;
import filmografia.accion.BorrarPeli;
import filmografia.accion.BuscarPeli;
import filmografia.accion.Facade;
import filmografia.accion.ListaPelisDir;
import filmografia.accion.Login;
import filmografia.accion.Mantenimiento;
import filmografia.accion.Registro;
import filmografia.accion.ModPeli;

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
					break;
				case "Finalizar":
					request.setAttribute("listaDirec", listaDir);
					pagSiguiente = "listaConsultaDir.jsp";
					break;
				case "Vuelve Dir":
					listaDir.clear();
					pagSiguiente = "consultDir.jsp";
					break;
				case "Vuelve a página principal":
					listaDir.clear();
	    	 		pagSiguiente = "index.html";
					break;
				case "Login":
					listaDir.clear();
					ac = new Login();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
				case "crear":
	    	 		pagSiguiente = "registro.jsp";
					break;
				case "registrar":
					ac = new Registro();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
				case "mantenimiento":
					ac = new Mantenimiento();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
				case "alta":
					pagSiguiente = "altaNuevaPeli.jsp";
					break;
				case "altaPeli":
					ac = new AltaPeli();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
				case "buscarPeli":
					ac = new BuscarPeli();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
				case "modPeli":
					ac = new ModPeli();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
					break;
				case "buscar":
					pagSiguiente = "buscarPeli.jsp";
					break;
				case "borrarPeli":
					ac = new BorrarPeli();
					pagSiguiente = ac.ejecutar(getServletContext(), request, response);
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