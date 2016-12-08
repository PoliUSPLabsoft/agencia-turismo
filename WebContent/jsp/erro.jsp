<%@page import="model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>Erro</title>


<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/global.css" />
<%@page import="java.util.List, model.Cidade"%>

</head>

<body>
	<nav class="navbar navbar-default header page-header">
		<div class="col-sm-9 right">
			<h1>Erro</h1>
		</div>
	</nav>
	<div class="container">
		<p>
			<%=((Exception)request.getAttribute("erro")).getStackTrace().toString()%>
		</p>
	</div>
</body>
</html>