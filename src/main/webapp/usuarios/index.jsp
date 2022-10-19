<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import= "nombredominio.modelsDAO.UsuarioDAO" %>
<%@page import= "nombredominio.models.Usuario" %>
<%@page import= "java.util.ArrayList" %>
<%@ include file = "../login-validation.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="daw" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>USUARIOS | Index</title>
	<link href="resources/css/style.css" type="text/css" rel="stylesheet">
	</head>
		<body>
		<h1>USUARIOS INDEX</h1>
		<a href="UsuariosController?action=create">Crear Usuario</a>
		<table>
			<div class="row">
				<div class="col-lg-4"></div>
					<div class="col-lg-4">
						<table class="table">
						<thead>
							<tr>
								<th scope="col">#</th>
								<th scope="col">Nombre</th>
								<th scope="col">Email</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody class="table-group-divider">
						<%-- <%
							usuarioDAO usuDao= new usuarioDAO();
							ArrayList<usuario> usuarios= usuDao.all();
						
							for(int i=0; i< usuarios.size(); i++){
								usuario usuario = usuarios.get(i);
							
						
						<tr>
							<td><%= usuario.getId()%></td>
							<td><%= usuario.getNombre()%></td>
							<td><%= usuario.getMail()%></td>
							<td>
								<a href="UsuariosController?action=edit&id=<%= usuario.getId() %>"></a>
								<a href="UsuariosController?action=edit&id=<%= usuario.getId() %>"></a>
							</td>
						</tr>
						<%} %> --%>
						<daw:forEach var="usuario" items="${usu}">
							<tr>
								<td>${usuario.id}</td>
								<td>${usuario.nombre}</td>
								<td>${usuario.email}</td>
								<td> 
									<a href="UsuariosController?action=edit&id=${usuario.id}">Edit</a>	
									<a href="UsuariosController?action=delete&id=${usuario.id}">Delete</a>	
								</td>
							</tr>
						</daw:forEach>
					</tbody>	
				</table>		
			</div>			
		<div class="col-lg-4">
			<daw:forEach var="usuario" items="${usu}">
						<daw:if test="${usuario.id}==1">
							<h1> HOLA ${usuario.nombre}</h1>
						</daw:if>
				</daw:forEach>
			</div>
		</div>			
	</table>		
			
						
		</body>
</html>