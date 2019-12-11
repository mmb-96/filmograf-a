/**
 * 
 */
package filmografia.accion;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.dao.PeliculasDao;
import filmografia.model.Pelicula;

/**
 * @author manu
 *
 */
public class ListaPelisDir implements Facade{
	
	private PeliculasDao peliDao;

	public ListaPelisDir() throws ClassNotFoundException, SQLException {
		peliDao = new PeliculasDao();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String pagSiguiente;
		String director = request.getParameter("dir");
		List<Pelicula> lista;
		try {
			lista = peliDao.mostarTodosPeliculasDirector(director);
			if (lista.size() == 0) {
				request.setAttribute("msg", "El director " + director + " no existe." );
				pagSiguiente = "consultDir";
			} else {
				request.setAttribute("director", director);
				request.setAttribute("peliculasDir", lista);
				pagSiguiente = "ListaPeliDir";
			}
		} catch (Exception e) {
			e.printStackTrace();
			pagSiguiente = "Error";
		}
		return pagSiguiente;
	}

}
