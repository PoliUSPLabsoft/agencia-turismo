<html>
	<head>
		<title> Agência de turismo</title>
		<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="css/global.css"/>
		<%@page import="java.util.List, model.Cliente" %>
	</head>
	
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1>Agência de Turismo</h1>
			</div>
			<div class="col-sm-3">
				<p>Bem vindo, <%=((Cliente)request.getSession().getAttribute("cliente")).getNome() %> <a href="#">(Sair)</a></p>
			</div>
		</nav>	
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<nav class="menu">
						<nav class="navbar-default">
							<h2>Menu</h2>
						</nav>					
						<ul>
							<li><a href="EscolheCidade">Criar roteiro</a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
							<li><a href="#"></a></li>
						</ul>
					</nav>
				</div>
				<div class="col-sm-9 content">
					<img class="apresentacao" src="img/apresentacao.jpg">
				</div>	
				<div class="col-sm-9">
				</div>
			</div>
		</div>
	</body>
</html>