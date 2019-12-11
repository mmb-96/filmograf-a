/**
 * 
 */
package filmografia.accion;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Interface Facade.
 *
 * @author manu
 */
public interface Facade {
	
	/**
	 * Ejecutar.
	 *
	 * @param sc the sc
	 * @param request the request
	 * @param response the response
	 * @return the string
	 */
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response);

}
