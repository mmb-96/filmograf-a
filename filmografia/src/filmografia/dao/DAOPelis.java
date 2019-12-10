/**
 * The Interface DAOPelis.
 *
 * @author manu
 */
package filmografia.dao;

import java.util.List;

import filmografia.model.Pelicula;


public interface DAOPelis {
	
	/**
	 * Mostar todos peliculas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Pelicula> mostarTodosPeliculas() throws Exception;
	
	/**
	 * Alta pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean altaPelicula(Pelicula peli) throws Exception;
	
	/**
	 * Borrar pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean borrarPelicula(Pelicula peli) throws Exception;
	
	/**
	 * Actualizar pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean actualizarPelicula(Pelicula peli) throws Exception;
	
	/**
	 * Mostar todos peliculas director.
	 *
	 * @param director the director
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<Pelicula> mostarTodosPeliculasDirector(String director) throws Exception;

}
