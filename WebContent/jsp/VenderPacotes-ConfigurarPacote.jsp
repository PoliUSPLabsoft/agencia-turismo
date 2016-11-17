<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<title>Configuração do Pacote</title>
		
		
		<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/global.css"/>
		<%@page import="java.util.List, model.Cidade, java.util.Map, model.Pacote, model.Hotel, model.Transporte" %>
		
	</head>
	
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Configurar Pacote</h1>
			</div>"WebContent/jsp/cidade.jsp"
		</nav>	
		<div class="container">
			<div class="content">
				<%Cidade cidadeNatal =  ((Cidade) request.getSession().getAttribute("cidadeNatal"));%>
				<h3> <%="Você está em:" + cidadeNatal.getNome() %></h3>
				<h2>Escolha a hospedagem e transportes:</h2>
				<% 	Pacote pacote = (Pacote) request.getAttribute("pacote");
					Map<Cidade, List<Hotel>> hoteisDisponiveis = (Map<Cidade, List<Hotel>>) request.getAttribute("hoteisDisponiveis");
					Map<Cidade, List<Transporte>> transportesDisponiveis = (Map<Cidade, List<Transporte>>) request.getAttribute("transportesDisponiveis");
					
				%>
				<form action="PacotePreenchido" method="POST">
					<div class="list-group">
				<% if (pacote.getCidades() != null) {%>
					<% for (Cidade i: pacote.getCidades()){ %>
					  <a href="#" class="list-group-item">
						<h4 class="list-group-item-heading"><%=i.getNome()%></h4>
    					<p class="list-group-item-text">
    					  Transporte:
    					  <div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							Escolha o Transporte
							<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							  <%for(Transporte t : transportesDisponiveis.get(i)){ %>
							    <li><a href="#"><%=t.getNome()%></a></li>
							  <%} %>
						    </ul>
						  </div>
						  Tempo de Estadia:
    					  <input type="number" name="tempo-de-estadia-<%=i.getId()%>"/>
    					  Hotel:
						  <div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							  Escolha o Transporte
							  <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							    <%for(Transporte t : transportesDisponiveis.get(i)){ %>
							    	<li><a href="#"><%=t.getNome()%></a></li>
							    <%} %>
							   </ul>
							</div>  
    					</p>
    				  </a>
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