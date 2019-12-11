package filmografia.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import filmografia.accion.AltaPeli;
import filmografia.accion.BorrarPeli;
import filmografia.accion.BuscarPeli;
import filmografia.accion.Facade;
import filmografia.accion.ListaPelisDir;
import filmografia.accion.Login;
import filmografia.accion.Mantenimiento;
import filmografia.accion.ModPeli;
import filmografia.accion.Registro;

/**
 * The Class ControllerMVC.
 */
@Controller
public class ControllerMVC {
	
	/** The lista dir. */
	private List<String> listaDir;
	
	 /**
 	 * Instantiates a new controller MVC.
 	 */
 	public ControllerMVC() {
	    	super();
	    	listaDir = new ArrayList<String>();
	    }

	/** The ac. */
	private Facade ac = null;
	
	/** The pag siguiente. */
	private String pagSiguiente = null;
	
	/**
	 * Consultar dir.
	 *
	 * @return the model and view
	 */
	@GetMapping("/consultDir")
	public ModelAndView consultarDir() {
			pagSiguiente = "consultDir";
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Login.
	 *
	 * @return the model and view
	 */
	@GetMapping("/login")
	public ModelAndView login() {
			pagSiguiente = "login";
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Lista peli dir.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/ListaPeliDir")
	public ModelAndView ListaPeliDir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new ListaPelisDir();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		if( request.getParameter("dir") != null) {
			listaDir.add(request.getParameter("dir"));
		}
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Lista consulta dir.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/listaConsultaDir")
	public ModelAndView listaConsultaDir(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		request.setAttribute("listaDirec", listaDir);
		pagSiguiente = "listaConsultaDir";
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Login user.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/LoginUser")
	public ModelAndView LoginUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new Login();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * New user.
	 *
	 * @return the model and view
	 */
	@PostMapping("/newUser")
	public ModelAndView newUser() {
		pagSiguiente = "registro";
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Registrar.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/registrar")
	public ModelAndView registrar(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new Registro();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Mantenimeinto.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/mantenimiento")
	public ModelAndView mantenimeinto(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new Mantenimiento();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Alta.
	 *
	 * @return the model and view
	 */
	@PostMapping("/alta")
	public ModelAndView alta() {
		pagSiguiente = "altaNuevaPeli";
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Alta peli.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/altaPeli")
	public ModelAndView altaPeli(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new AltaPeli();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Buscar peli.
	 *
	 * @return the model and view
	 */
	@PostMapping("/buscar")
	public ModelAndView buscarPeli() {
		pagSiguiente = "buscarPeli";
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Buscar peli.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/buscarPeli")
	public ModelAndView buscarPeli(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new BuscarPeli();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Modificar peli.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/modPeli")
	public ModelAndView modificarPeli(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new ModPeli();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	/**
	 * Borrar peli.
	 *
	 * @param request the request
	 * @param response the response
	 * @return the model and view
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	@PostMapping("/borrarPeli")
	public ModelAndView borrarPeli(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
		ac = new BorrarPeli();
		pagSiguiente = ac.ejecutar(request.getSession().getServletContext(), request, response);
		return new ModelAndView(pagSiguiente);
	}
	
	
}
