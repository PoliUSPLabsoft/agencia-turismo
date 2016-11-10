<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/global.css"/>
		<%@page import="java.util.List, model.Transporte" %>
		<title>Escolha de Transporte</title>
	</head>
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Escolha de Transporte</h1>
			</div>
		</nav>	
		<div class="container">
			<div class="content row">
				<% List<Transporte> transportes = (List<Transporte>) request.getAttribute("transportes"); %>
				<% if (transportes != null) {%>
					<form action="Finalizar">
						<p color="#FFFFFF">Total de <%=transportes.size()%> transportes</p>
						<div class="col-sm-12 bloco_transporte">
								<div class="col-sm-1 check"> Sel. </div>
								<div class="col-sm-3 nome"> Nome</div>
								<div class="col-sm-4 tipo"> Tipo </div>
								<div class="col-sm-4 preco"> Preço </div>
							</div>
						<% for (Transporte i: transportes){ %>
							<div class="col-sm-12 bloco_transporte">
								<div class="col-sm-1 check">
									<input type="checkbox" value=<%=i.getId()%>>
								</div>
								<div class="col-sm-3 nome"> <%=i.getNome() %></div>
								<div class="col-sm-4 tipo"> <%=i.getTipo()%> </div>
								<div class="col-sm-4 preco"> <%="R$" + i.getPreco() + ",00"%> </div>
							</div>
						<% } %>
						<input type="submit" value = "OK">
					</form>
				<%} else {%>
					<p>Nenhuma cidade encontrada!<p>
				<% } %>
			</div>
		</div>
	</body>
</html>