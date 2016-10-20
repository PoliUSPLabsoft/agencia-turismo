<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%= (String)request.getAttribute("texto") %></title>
<%@ page import="java.util.List, java.util.ArrayList, main.*" %>

</head>
<body>
	<table>
		<tr>
			<td>Id</td>
			<td>Nome</td>
			<td>Detalhes</td>
		</tr>
		<%	List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
			for (Cliente cliente : clientes){
			%> <tr>
				<td>
					<%= cliente.getId() %>
				</td>
				<td>
					<%= cliente.getName() %>
				</td>
				<td>
					<a href="Detalhes?id=<%= cliente.getId() %>"> Exibir detalhes </a>
				</td>
				</tr>
			<%
		}
		%>
	</table>
</body>
</html>