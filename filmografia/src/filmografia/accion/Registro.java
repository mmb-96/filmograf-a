package filmografia.accion;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.dao.UsuarioDao;
import filmografia.model.Usuario;

public class Registro implements Facade {
	
	private UsuarioDao userDao;

	public Registro() throws ClassNotFoundException, SQLException {
		userDao = new UsuarioDao();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String pagSiguiente;
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		boolean existe;
		try {
			existe = userDao.altaUser(new Usuario(user, pass));
			if (!existe) {
				request.setAttribute("msg", "El usuario " + user + " ha sido creado." );
			}
			pagSiguiente = "datosUser.jsp";
		} catch (Exception e) {
			request.setAttribute("msg", "El usuario " + user + " ya existe." );
			pagSiguiente = "datosUser.jsp";
		}
		return pagSiguiente;
	}

}
