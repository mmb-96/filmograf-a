package filmografia.accion;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.dao.PeliculasDao;
import filmografia.model.Pelicula;

public class Mantenimiento implements Facade {
	
	private PeliculasDao peliDao;

	public Mantenimiento() throws ClassNotFoundException, SQLException {
		peliDao = new PeliculasDao();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String pagSiguiente;
		List<Pelicula> lista;
		try {
			lista = peliDao.mostarTodosPeliculas();
			request.setAttribute("peliculas", lista);
			pagSiguiente = "mantenimiento.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			pagSiguiente = "Error.html";
		}
		return pagSiguiente;
	}

}
