<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Datos usuario - Consulta Directores Cine</title>
</head>
<body>
	<h4>Datos usuario</h4>
	<ul>
		<li>${ Usuario }</li>
		<li>${ Contraseña }</li>
	</ul>
	<br />
	<form action="Controller" method="post">
		<input value="Vuelve index" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Volver</button>
	</form>
	<form action="Controller" method="post">
		<input value="mantenimiento" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Mantenimiento de películas</button>
	</form>
	<form action="Controller" method="post">
		<input value="crear" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Crear usuario</button>
	</form>
	<p>${ msg }</p>
	
</body>
</html>