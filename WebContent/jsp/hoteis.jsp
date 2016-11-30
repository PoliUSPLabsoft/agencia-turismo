<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css"/>
<%@page import="java.util.List, java.util.Set, java.util.HashSet, model.Hotel" %>
<title>Sele��o de hoteis</title>
</head>
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Escolha de Hotel</h1>
			</div>
		</nav>	
		<div class="container">
			<div class="content row">
				<% List<Hotel> hoteis = (List<Hotel>) request.getAttribute("hoteis"); %>
				<% if (hoteis != null) {%>
					<%Set<String> visitadas = new HashSet<String>(); %>
					<form action="EscolheTransportes" method = "POST">
						<% int i = 0, city = 0; %>
						<%for (Hotel hotel: hoteis) {%>
								<%if (city != hotel.getCidadeId()) {%>
									<%city = hotel.getCidadeId(); %>
									<%i++; %>
									<h2><%=hotel.getCidade() %></h2>
								<%} %>
								<input type="radio" name = "<%=i %>" value = "<%=hotel.getId()%>">
								<%=hotel.getNome() %><br>					
						<%} %>
						<input type="submit" value = "OK">
					</form>
				<%} else {%>
					<p>Nenhuma cidade encontrada!<p>
				<% } %>
			</div>
		</div>
	</body>
</html>