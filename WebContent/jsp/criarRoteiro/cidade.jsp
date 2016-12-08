<%@page import="model.Cliente"%>
<%@page import="java.util.List, model.Cidade" %>
<%@page contentType="text/html;charset=utf-8" %>

<html>
	<head>
		<title>Criação de Roteiro</title>			
		<meta http-equiv = "Content-Language" content = "en"/>
<meta http-equiv = "Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css"/>
		
	</head>
	
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Criar Roteiro</h1>
			</div>"WebContent/jsp/cidade.jsp"
		</nav>	
		<div class="container">
			<div class="content">
				<%Cidade cidadeNatal =  ((Cidade) request.getSession().getAttribute("cidadeNatal"));%>
				<h3> <%="Você está em:" + cidadeNatal.getNome() %></h3>
				<h2>Escolha uma cidade:</h2>
				<% List<Cidade> cidades = (List<Cidade>) request.getAttribute("cidades"); %>
				<% if (cidades != null) {%>
					<% for (Cidade i: cidades){ %>
						<div class="bloco_cidade">
							<div class="col-sm-1 id"> <%=i.getId() %></div>
							<div class="col-sm-5 nome"> <%=i.getNome() %></div>
							<div class="col-sm-6 avaliacao"> <%=i.getAvaliacao()%> </div>
							<div class="col-sm-12> descricao"> <%=i.getDescricao() %></div>
						</div>
					<% } %>
				<%} else {%>
					<p>Nenhuma cidade encontrada!<p>
				<% } %>
				<form action="EscolheHotel" method="POST">
					<input type="hidden" name="cidadeNatal" value="<%=cidadeNatal.getId()%>">
					<input type="text" name="cidades_escolhidas" />
					<h2>Digite o nome do roteiro:</h2><input type="text" name="nomeRoteiro"/>
					<input type="submit" value="ok" />
				</form>
			</div>
		</div>
	</body>
</html>