<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Administradores - Consulta Directores Cine</title>
</head>
<body>
	<form action="Controller" method="post">
		Usuario: <input type="text" name="user">
		Contraseña: <input type="password" name="pass">
		<input value="Login" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Entrar</button>
	</form>
	<p>${ msg }</p>
</body>
</html>