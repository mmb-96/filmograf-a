package filmografia.dao;

import filmografia.model.Usuario;

/**
 * The Interface DAOUsuario.
 */
public interface DAOUsuario {

	/**
	 * Consul user.
	 *
	 * @param user the user
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public int consulUser(Usuario user) throws Exception;

	/**
	 * Alta user.
	 *
	 * @param user the user
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean altaUser(Usuario user) throws Exception;
}
