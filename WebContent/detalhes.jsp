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
		<%	Cliente cliente = (Cliente) request.getAttribute("cliente"); %>
		<tr>
				<td>
					Nome
				</td>
				<td>
					<%= cliente.getName() %>
				</td>
		</tr>
		<tr>
				<td>
					Idade
				</td>
				<td>
					<%= cliente.getAge() %>
				</td>
		</tr>
		<tr>
				<td>
					RG
				</td>
				<td>
					<%= cliente.getRg()%>
				</td>
		</tr>
		<tr>
				<td>
					CPF
				</td>
				<td>
					<%= cliente.getCpf()%>
				</td>
		</tr>
		<tr>
				<td>
					Endereço
				</td>
				<td>
					<%= cliente.getAddress()%>
				</td>
		</tr>
		
	</table>
</body>
</html>