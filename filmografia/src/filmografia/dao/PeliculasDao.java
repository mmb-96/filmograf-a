/**
 * The Class PeliculasDao.
 *
 * @author manu
 */

package filmografia.dao;

import java.sql.SQLException;
import java.util.List;

import filmografia.model.Pelicula;


public class PeliculasDao implements DAOPelis {

	/** The peli servi. */
	PeliculasServicio peliServi;

	/**
	 * Instantiates a new peliculas dao.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public PeliculasDao() throws ClassNotFoundException, SQLException {
		peliServi = new PeliculasServicio();
	}

	/**
	 * Mostar todos peliculas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Pelicula> mostarTodosPeliculas() throws Exception {
		List<Pelicula> pelisTotal;
		pelisTotal = peliServi.mostarTodasPeliculas();
		peliServi.disconnect();
		return pelisTotal;
	}

	/**
	 * Alta pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean altaPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		realizado = peliServi.altaPelicula(peli);
		peliServi.disconnect();
		return realizado;
	}

	/**
	 * Borrar pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean borrarPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		realizado = peliServi.borrarPelicula(peli);
		peliServi.disconnect();
		return realizado;
	}

	/**
	 * Actualizar pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean actualizarPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		realizado = peliServi.actualizarPelicula(peli);
		peliServi.disconnect();
		return realizado;
	}

	/**
	 * Mostar todos peliculas director.
	 *
	 * @param director the director
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Pelicula> mostarTodosPeliculasDirector(String director) throws Exception {
		List<Pelicula> pelisDir;
		pelisDir = peliServi.mostarTodasPeliculasDirector(director);
		peliServi.disconnect();
		return pelisDir;
	}

}
