<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Directores consultados - Consulta Directores Cine</title>
</head>
<body>
	<h4>Lista directores consultados</h4>
	<ul>
		<c:forEach items="${ listaDirec }" var="Dir">
		<li>${ Dir }</li>
		</c:forEach>
	</ul>
	
	<form action="Controller" method="post">
		<input value="Vuelve Dir" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Volver a consultar directores</button>
	</form>
	<form action="Controller" method="post">
		<input value="Vuelve index" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Inicio</button>
	</form>
</body>
</html>