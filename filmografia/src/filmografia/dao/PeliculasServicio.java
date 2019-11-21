/**
 * 
 */
package filmografia.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import filmografia.model.pelicula;

/**
 * @author manu
 *
 */
public class PeliculasServicio {

	private Connection con;
	private String sql;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public PeliculasServicio() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "manu", "621996");
	}
	
	public List<pelicula> mostarTodasPeliculas() throws Exception {
		ArrayList<pelicula> pelis = new ArrayList<pelicula>();
		sql = "Select * From pelicula";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()){
			pelis.add(new pelicula(rs.getString(1), rs.getString(2), rs.getDate(3)));
		}
		return pelis;
	}
	
	public List<pelicula> mostarTodasPeliculasDirector(String director) throws SQLException {
		ArrayList<pelicula> pelisDir = new ArrayList<pelicula>();
		sql = "Select * From pelicula where director = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, director);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			pelisDir.add(new pelicula(rs.getString(1), rs.getString(2), rs.getDate(3)));
		}
		return pelisDir;
	}
	
	public void disconnect() throws SQLException {
		if (con != null) {
			con.close();
		}
	}	
}