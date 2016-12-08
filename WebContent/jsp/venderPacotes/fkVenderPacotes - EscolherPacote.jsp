<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<title>Configuração do Pacote</title>
		
		
		<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/global.css"/>
		<%@page import="java.util.List, model.Roteiro, model.Cidade, java.util.Map, model.Pacote, model.Hotel, model.Transporte" %>
		
	</head>
	
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Escolha o Pacote</h1>
			</div>
		</nav>	
		<div class="container">
			<div class="content">
				<%Map<Integer, Roteiro> roteiros = (Map<Integer, Roteiro>) request.getAttribute("roteiros");%>
				
				<form action="MostrarRoteiro" method="POST">
					<div class="list-group">
				<% if (roteiros != null) {%>
					<% for (int i = 0; i < roteiros.keySet().size(); i++) { %>
						<%Roteiro r = roteiros.get(i);%>
						
						<h4 class="list-group-item-heading"><%= r.getName() %></h4>
    					<p class="list-group-item-text">  
    						<input type="radio" name="id" value="<%=r.getId()%>"/>
    					</p>
					<% } %>
				<%} else {%>
					<p>Nenhum pacote encontrado!</p>
				<% } %>
					</div>
					<input type="submit" value="ok" />
				</form>
			</div>
		</div>
	</body>
</html>