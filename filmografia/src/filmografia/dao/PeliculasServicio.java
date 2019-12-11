/**
 * The Class PeliculasServicio.
 *
 * @author manu
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


public class PeliculasServicio {

	/** The con. */
	private Connection con;
	
	/** The sql. */
	private String sql;
	
	/** The pstmt. */
	private PreparedStatement pstmt;
	
	/** The rs. */
	private ResultSet rs;
	
	/**
	 * Instantiates a new peliculas servicio.
	 *
	 * @throws SQLException the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
	public PeliculasServicio() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "manu", "621996");
	}
	
	/**
	 * Mostar todas peliculas.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Alta pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
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

	/**
	 * Borrar pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean borrarPelicula(Pelicula peli) throws Exception {
		boolean realizado;
		sql = "Delete From pelicula Where titulo like ? and fecha = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + peli.getTitulo() + "%");
		pstmt.setDate(2, peli.getFecha());
		realizado = pstmt.execute();
		return realizado;
	}

	/**
	 * Actualizar pelicula.
	 *
	 * @param peli the peli
	 * @return true, if successful
	 * @throws Exception the exception
	 */
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
	
	/**
	 * Mostar todas peliculas director.
	 *
	 * @param director the director
	 * @return the list
	 * @throws SQLException the SQL exception
	 */
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
	
	/**
	 * Buscar peli.
	 *
	 * @param titulo the titulo
	 * @return the pelicula
	 * @throws SQLException the SQL exception
	 */
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