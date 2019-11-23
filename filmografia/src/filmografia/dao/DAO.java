/**
 * 
 */
package filmografia.dao;

import java.util.List;

import filmografia.model.Pelicula;


/**
 * @author manu
 *
 */
public interface DAO {
	
	public List<Pelicula> mostarTodosPeliculas() throws Exception;
	
	public boolean altaPelicula(Pelicula peli) throws Exception;
	
	public boolean borrarPelicula(Pelicula peli) throws Exception;
	
	public boolean actualizarPelicula(Pelicula peli) throws Exception;
	
	public List<Pelicula> mostarTodosPeliculasDirector(String director) throws Exception;

}
