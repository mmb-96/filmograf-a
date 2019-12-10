package filmografia.accion;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import filmografia.dao.PeliculasDao;
import filmografia.dao.UsuarioDao;
import filmografia.model.Pelicula;
import filmografia.model.Usuario;

public class Login implements Facade {
	
	private UsuarioDao userDao;

	public Login() throws ClassNotFoundException, SQLException {
		userDao = new UsuarioDao();
	}

	@Override
	public String ejecutar(ServletContext sc, HttpServletRequest request, HttpServletResponse response) {
		String pagSiguiente;
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		int existe;
		try {
			existe = userDao.consulUser(new Usuario(user, pass));
			if (existe <= 0) {
				request.setAttribute("msg", "El usuario " + user + " no existe." );
				pagSiguiente = "login.jsp";
			} else {
				request.setAttribute("Usuario", user);
				request.setAttribute("Contraseña", pass);
				pagSiguiente = "datosUser.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			pagSiguiente = "Error.html";
		}
		return pagSiguiente;
	}

}
