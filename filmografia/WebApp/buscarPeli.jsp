<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscar película - Consulta Directores Cine</title>
</head>
<body>
	<form action="Controller" method="post">
		Titulo: <input type="text" name="titulo"><br>
		<input value="buscarPeli" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Buscar</button>
	</form>
</body>
</html>