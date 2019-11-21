/**
 * 
 */
package filmografia.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import filmografia.model.pelicula;

/**
 * @author manu
 *
 */
public class PeliculasDao implements DAO {

	PeliculasServicio peliServi;
	
	public PeliculasDao() throws ClassNotFoundException, SQLException {
		peliServi = new PeliculasServicio();
	}
	
	public List<pelicula> mostarTodosPeliculas() throws Exception {
		List<pelicula> pelisTotal;
		pelisTotal = peliServi.mostarTodasPeliculas();
		peliServi.disconnect();
		return pelisTotal;
	}

	public boolean altaPelicula(String director, String titulo, Date fecha) throws Exception {
		boolean realizado;
		realizado = peliServi.loquesea();
		peliServi.disconnect();
		return realizado;
	}

	public boolean borrarPelicula(String titulo, Date fecha) throws Exception {
		boolean realizado;
		realizado = peliServi.loquesea();
		peliServi.disconnect();
		return realizado;
	}

	public boolean actualizarPelicula(String director, String titulo, Date fecha) throws Exception {
		boolean realizado;
		realizado = peliServi.loquesea();
		peliServi.disconnect();
		return realizado;
	}

	public List<pelicula> mostarTodosPeliculasDirector(String director) throws Exception {
		List<pelicula> pelisDir;
		pelisDir = peliServi.mostarTodasPeliculasDirector(director);
		peliServi.disconnect();
		return pelisDir;
	}

}
