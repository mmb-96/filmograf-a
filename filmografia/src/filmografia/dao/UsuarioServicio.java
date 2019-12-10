package filmografia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import filmografia.model.Usuario;

/**
 * The Class UsuarioServicio.
 * 
 * @author manu
 */
public class UsuarioServicio {
	
	/** The con. */
	private Connection con;
	
	/** The sql. */
	private String sql;
	
	/** The pstmt. */
	private PreparedStatement pstmt;
	
	/** The smtp. */
	private Statement stmt;
	private ResultSet rs;

	
	/**
	 * Instantiates a new usuario servicio.
	 *
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public UsuarioServicio() throws SQLException, ClassNotFoundException {// TODO: Auto-generated Javadoc
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "manu", "621996");
	}
	
	/**
	 * Consul user.
	 *
	 * @param user the user
	 * @return the int
	 * @throws SQLException the SQL exception
	 */
	public int consulUser(Usuario user) throws SQLException {
		int resultado = 0;

		stmt = con.createStatement();
		sql = "SELECT COUNT(users) FROM usuarios WHERE users = '" + user.getUser() +"' and pass = '"+ user.getPass() +"'";
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			resultado = rs.getInt(1);
		}

		return resultado;	
	}
	
	/**
	 * Alta user.
	 *
	 * @param user the user
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean altaUser(Usuario user) throws Exception {
		boolean realizado;
		sql = "Insert usuarios value (?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUser());
		pstmt.setString(2, user.getPass());
		realizado = pstmt.execute();
		return realizado;
	}

	
	/**
	 * Disconnect.
	 *
	 * @throws SQLException the SQL exception
	 */
	public void disconnect() throws SQLException {
		if (con != null) {
			con.close();
		}
	}

}
