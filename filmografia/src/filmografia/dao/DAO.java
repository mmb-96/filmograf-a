/**
 * 
 */
package filmografia.dao;

import java.sql.Date;
import java.util.List;

import filmografia.model.pelicula;


/**
 * @author manu
 *
 */
public interface DAO {
	
	public List<pelicula> mostarTodosPeliculas() throws Exception;
	
	public boolean altaPelicula(String director, String titulo, Date fecha) throws Exception;
	
	public boolean borrarPelicula(String titulo, Date fecha) throws Exception;
	
	public boolean actualizarPelicula(String director, String titulo, Date fecha) throws Exception;
	
	public List<pelicula> mostarTodosPeliculasDirector(String director) throws Exception;

}
