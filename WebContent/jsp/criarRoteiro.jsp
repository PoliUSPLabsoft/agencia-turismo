<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<html>
	<head>
		<title>Criação de Roteiro</title>
		
		
		<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/global.css"/>
		<%@page import="java.util.List, model.Cidade" %>
		
	</head>
	
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Criar Roteiro</h1>
			</div>
		</nav>	
		<div class="container">
			<div class="content">
				<h2>Escolha uma cidade:</h2>
				<% List<Cidade> cidades = (List<Cidade>) request.getAttribute("cidades"); %>
				<% if (cidades != null) {%>
					<% for (Cidade i: cidades){ %>
						<div class="col-sm-4 bloco_cidade">
							<div class="col-sm-6 nome"> <%=i.getNome() %></div>
							<div class="col-sm-6 avaliacao"> <%=i.getAvaliacao()%> </div>
							<div class="col-sm-12> descricao"> <%=i.getDescricao() %></div>
						</div>
					<% } %>
				<%} else {%>
					<p>Nenhuma cidade encontrada!<p>
				<% } %>
			</div>
		</div>
	</body>
</html>