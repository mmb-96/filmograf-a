<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar o borrar película - Consulta Directores Cine</title>
</head>
<body>
	<form action="Controller" method="post">
		Titulo: <input type="text" name="titulo" value=${ pelicula.titulo } readonly><br>
		Director: <input type="text" name="dir" value=${ pelicula.director }><br>
		Fecha: <input type="date" name="fecha" value=${ pelicula.fecha } readonly><br>
		<input value="modPeli" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Modificar</button>
	</form>
	<br>
	<form action="Controller" method="post">
		<input type="text" name="titulo" value=${ pelicula.titulo }  style="visibility: hidden; display: none;">
		<input type="date" name="fecha" value=${ pelicula.fecha } style="visibility: hidden; display: none;">
		<input value="borrarPeli" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Borrar</button>
	</form>
</body>
</html>