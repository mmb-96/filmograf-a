<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva película - Consulta Directores Cine</title>
</head>
<body>
	<form action="Controller" method="post">
		Titulo: <input type="text" name="titulo"><br>
		Director: <input type="text" name="dir"><br>
		Fecha: <input type="date" name="fecha"><br>
		<input value="altaPeli" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Entrar</button>
	</form>
</body>
</html>