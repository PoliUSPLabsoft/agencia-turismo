<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<link rel="stylesheet" href="../css/bootstrap/css/bootstrap.min.css"/>
			<%@page import="java.util.Map, java.util.Set, model.Roteiro, model.Cidade" %>
		<title>Sugestão de roteiro</title>
	</head>
	<body>
	<nav class="page-header">
		<h1>Sugestão de roteiro</h1>
	</nav>
	<div class="header">Escolha um roteiro</div>
		<form action="Vender pacote">
			<%Map<Integer, Roteiro> roteiros = (Map<Integer, Roteiro>) request.getAttribute("roteiros");%>
			<%for (int i = 0; i < roteiros.keySet().size(); i++) {%>
				<%Roteiro roteiro = roteiros.get(i); %>
				<div class="well well-sm col-md-6 radio">
				    <div class="col-md-1">
				    	<input type="radio" name="roteiro" value="<%=roteiro.getId() %>">
				    </div>
				    <div class="navbar-header col-md-3"><h4><%=roteiro.getName() %></h4></div>
				
					<div class="col-md-6 left">
					    	<%for (Cidade cidade: roteiro.getCidades()){ %>
					    		<div class="label label-default ">
					    			<%=cidade.getNome() %>
					    		</div>
					    	<%} %>
					</div>
					<div class="col-md-2 label label-info">
						<h6>R$<%=roteiro.getPreco() %>,00</h6>
					</div>
				</div>
			<%} %>
			<input type="submit" class="btn btn-primary" value="Escolher roteiro"/>
		 </form>    
	</body>
</html>