<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "login-validation.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hola estoy en Home</h1>
		<a href="UsuariosController?action=index">Usuarios index</a>	
		<a href="AuthController?action=logout">Cerrar sesion</a>	
	</body>
</html>