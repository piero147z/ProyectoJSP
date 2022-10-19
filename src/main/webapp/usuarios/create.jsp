<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="nombredominio.modelsDAO.UsuarioDAO"%>
<%@page import="nombredominio.models.Usuario"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>USUARIOS | CREATE</title>
	</head>
	<body>
		<h1>USUARIOS CREATE</h1>
	
	
		<form method="POST" action="UsuariosController?action=create">
			<input type="hidden" name="id" value="">
			<p>Nombre:</p>
			<input type="text" name="nombre" value=""> <br>
			<p>Email:</p>
			<input type="email" name="email" value=""> <br>
	
			<button type="submit">Enviar</button>
		</form>
	</body>
</html>