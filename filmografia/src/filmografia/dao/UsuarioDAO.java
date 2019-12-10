package filmografia.dao;

import java.sql.SQLException;

import filmografia.model.Usuario;

public class UsuarioDAO implements DAOUsuario {
	
	UsuarioServicio userServi;
	
	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		userServi = new UsuarioServicio();
	}

	@Override
	public boolean consulUser(Usuario user) throws Exception {
		return userServi.consulUser(user);
	}

	@Override
	public boolean altaUser(Usuario user) throws Exception {
		return userServi.altaUser(user);
	}

}
