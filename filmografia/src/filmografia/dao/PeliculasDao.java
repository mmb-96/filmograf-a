/**
 * 
 */
package filmografia.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import filmografia.model.Pelicula;



/**
 * @author manu
 *
 */
public class PeliculasDao implements DAO {

	PeliculasServicio peliServi;
	
	public PeliculasDao() throws ClassNotFoundException, SQLException {
		peliServi = new PeliculasServicio();
	}
	
	public List<Pelicula> mostarTodosPeliculas() throws Exception {
		List<Pelicula> pelisTotal;
		pelisTotal = peliServi.mostarTodasPeliculas();
		peliServi.disconnect();
		return pelisTotal;
	}

	public boolean altaPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		realizado = peliServi.altaPelicula(peli);
		peliServi.disconnect();
		return realizado;
	}

	public boolean borrarPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		realizado = peliServi.borrarPelicula(peli);
		peliServi.disconnect();
		return realizado;
	}

	public boolean actualizarPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		realizado = peliServi.actualizarPelicula(peli);
		peliServi.disconnect();
		return realizado;
	}

	public List<Pelicula> mostarTodosPeliculasDirector(String director) throws Exception {
		List<Pelicula> pelisDir;
		pelisDir = peliServi.mostarTodasPeliculasDirector(director);
		peliServi.disconnect();
		return pelisDir;
	}

}
