<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultar directores - Consulta Directores Cine</title>
</head>
<body>
	<form action="Controller" method="post">
		Nombre Director: <input type="text" name="dir">
		<input value="Pelis Dir" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Consultar</button>
	</form>
	<p>${ msg }</p>
</body>
</html>