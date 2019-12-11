<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modificar o borrar película - Consulta Directores Cine</title>
</head>
<body>
	<form action="modPeli.html" method="post">
		Titulo: <input type="text" name="titulo" value=${ pelicula.titulo } readonly><br>
		Director: <input type="text" name="dir" value=${ pelicula.director }><br>
		Fecha: <input type="date" name="fecha" value=${ pelicula.fecha } readonly><br>
		<button type="submit">Modificar</button>
	</form>
	<br>
	<form action="borrarPeli.html" method="post">
		<input type="text" name="titulo" value=${ pelicula.titulo }  style="visibility: hidden; display: none;">
		<input type="date" name="fecha" value=${ pelicula.fecha } style="visibility: hidden; display: none;">
		<button type="submit">Borrar</button>
	</form>
</body>
</html>