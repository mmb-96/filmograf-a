package filmografia.accion;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.dao.PeliculasDao;
import filmografia.model.Pelicula;

public class BorrarPeli implements Facade {
	private PeliculasDao peliDao;

	public BorrarPeli() throws ClassNotFoundException, SQLException {
		peliDao = new PeliculasDao();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String pagSiguiente;
		String director = request.getParameter("dir");
		String titulo = request.getParameter("titulo");
		
		boolean creado;
		try {
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 Date parsedDate = dateFormat.parse(request.getParameter("fecha"));
			 java.sql.Date timestamp = new java.sql.Date (parsedDate.getTime());
			 creado = peliDao.borrarPelicula(new Pelicula(director, titulo, timestamp));
			if (!creado) {
				request.setAttribute("msg", "La película se ha borrado de la base de datos" );
				pagSiguiente = "datosUser";
			} else {
				request.setAttribute("msg", "La película no se ha borrado de la base de datos" );
				pagSiguiente = "datosUser";
			}
		} catch (Exception e) {
			e.printStackTrace();
			pagSiguiente = "Error";
		}
		return pagSiguiente;
	}
}
