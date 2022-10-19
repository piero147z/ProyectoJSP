<%
			if(request.getSession().getAttribute("usuario")!= null){
				out.println("<p>EXISTE USUARIO LOGEADO</p>");
			}else{
				response.sendRedirect("AuthController?action=login");
			}
		
%>