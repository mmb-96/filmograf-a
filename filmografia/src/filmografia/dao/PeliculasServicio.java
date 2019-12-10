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

import filmografia.model.Pelicula;

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
	
	public List<Pelicula> mostarTodasPeliculas() throws Exception {
		ArrayList<Pelicula> pelis = new ArrayList<Pelicula>();
		sql = "Select * From pelicula";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()){
			pelis.add(new Pelicula(rs.getString(1), rs.getString(2), rs.getDate(3)));
		}
		return pelis;
	}
	
	public boolean altaPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		sql = "Insert pelicula value (?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, peli.getDirector());
		pstmt.setString(2, peli.getTitulo());
		pstmt.setDate(3, peli.getFecha());
		realizado = pstmt.execute();
		return realizado;
	}

	public boolean borrarPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		sql = "Delete From pelicula Where titulo like ? and fecha = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + peli.getTitulo() + "%");
		pstmt.setDate(2, peli.getFecha());
		realizado = pstmt.execute();
		return realizado;
	}

	public boolean actualizarPelicula(Pelicula peli) throws Exception {
		boolean realizado = false;
		sql = "Update pelicula set director = ? where titulo = ? and fecha = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, peli.getDirector());
		pstmt.setString(2, peli.getTitulo());
		pstmt.setDate(3, peli.getFecha());
		realizado = pstmt.execute();
		return realizado;
	}
	
	public List<Pelicula> mostarTodasPeliculasDirector(String director) throws SQLException {
		ArrayList<Pelicula> pelisDir = new ArrayList<Pelicula>();
		sql = "Select * From pelicula Where director = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, director);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			pelisDir.add(new Pelicula(rs.getString(1), rs.getString(2), rs.getDate(3)));
		}
		return pelisDir;
	}
	
	public Pelicula buscarPeli(String titulo) throws SQLException {
		Pelicula pelisDir = null;
		sql = "Select * From pelicula Where titulo like ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + titulo + "%");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			pelisDir = new Pelicula(rs.getString(1), rs.getString(2), rs.getDate(3));
		}
		return pelisDir;
	}
	
	public void disconnect() throws SQLException {
		if (con != null) {
			con.close();
		}
	}	
}