package filmografia.dao;

import java.sql.SQLException;

import filmografia.model.Usuario;

public class UsuarioDao implements DAOUsuario {
	
	UsuarioServicio userServi;
	
	public UsuarioDao() throws ClassNotFoundException, SQLException {
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
