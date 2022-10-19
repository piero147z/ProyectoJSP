<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>
<%@page import="nombredominio.models.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USUARIOS | EDIT</title>
</head>
<body>
	<h1>USUARIOS EDIT</h1>
		<%
			Usuario usuario = (Usuario) request.getAttribute("usu");
		
		%>

	<form method="POST" action="UsuariosController?action=update">
	<%@ include file = "../login-validation.jsp" %>
		<input type="hidden" name="id" value="<%= usuario.getId() %>">
		<p>Nombre:</p>
		<input type="text" name="nombre" value="<%= usuario.getNombre() %>"> <br>
		<p>Email:</p>
		<input type="email" name="email" value="<%= usuario.getMail() %>"> <br>

		<button type="submit">Actualizar</button>
	</form>
</body>
</html>