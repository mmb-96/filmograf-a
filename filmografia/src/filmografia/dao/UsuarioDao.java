package filmografia.dao;

import java.sql.SQLException;

import filmografia.model.Usuario;

/**
 * The Class UsuarioDao.
 */
public class UsuarioDao implements DAOUsuario {
	
	/** The user servi. */
	UsuarioServicio userServi;
	
	/**
	 * Instantiates a new usuario dao.
	 *
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public UsuarioDao() throws ClassNotFoundException, SQLException {
		userServi = new UsuarioServicio();
	}

	/**
	 * Consul user.
	 *
	 * @param user the user
	 * @return the int
	 * @throws Exception the exception
	 */
	@Override
	public int consulUser(Usuario user) throws Exception {
		return userServi.consulUser(user);
	}
	

	/**
	 * Alta user.
	 *
	 * @param user the user
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	@Override
	public boolean altaUser(Usuario user) throws Exception {
		return userServi.altaUser(user);
	}

}
