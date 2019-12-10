<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenimiento - Consulta Directores Cine</title>
</head>
<body>
	<h4>Lista de Peliculas:</h4>
	<table border="1">
	  <tr>
	    <th>Titulo</th>
	    <th>Autor</th>
	    <th>Fecha</th>
	  </tr>
	  <c:forEach items="${ peliculas }" var="Peli">
		  <tr>
		    <td>${ Peli.titulo }</td>
		    <td>${ Peli.director }</td>
		    <td>${ Peli.fecha }</td>
		  </tr>
	  </c:forEach>
	</table>
	<br>
	<form action="Controller" method="post">
		<input value="alta" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Alta nueva pelicula</button>
	</form>
	<br>
	<form action="Controller" method="post">
		<input value="buscar" name="action" style="visibility: hidden; display: none;">
		<button type="submit">Buscar pelicula</button>
	</form>
</body>
</html>