package filmografia.accion;

import java.sql.SQLException;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.dao.PeliculasDao;
import filmografia.model.Pelicula;

public class BuscarPeli implements Facade {
	
	private PeliculasDao peliDao;

	public BuscarPeli() throws ClassNotFoundException, SQLException {
		peliDao = new PeliculasDao();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String pagSiguiente;
		String titulo = request.getParameter("titulo");
		
		Pelicula peli;
		try {
			peli = peliDao.buscarPeli(titulo);
			request.setAttribute("pelicula", peli );
			pagSiguiente = "mod-Bor-Peli.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			pagSiguiente = "Error.html";
		}
		return pagSiguiente;
	}
}
