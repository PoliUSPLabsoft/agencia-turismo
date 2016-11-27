<%@page import="model.Cliente"%>
<%@page import="java.util.List, model.Cidade, model.Roteiro, model.Hotel, model.Transporte, model.FormaPagamento" %>
<%@page contentType="text/html;charset=utf-8" %>

<html>
	<head>
		<%Roteiro roteiro = (Roteiro)request.getAttribute("roteiro"); %>
		<title><%=roteiro.getName() %></title>			
		<meta http-equiv = "Content-Language" content = "en"/>
<meta http-equiv = "Content-Type" content="text/html; charset=utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/global.css"/>
		
	</head>
	
	<body>
		<nav class="navbar navbar-default header page-header">
			<div class="col-sm-9 right">
				<h1><%=roteiro.getName() %></h1>
			</div>
		</nav>	
		<div class="container">
			<div class="content">
				<table>
					<tr><td>Tipo</td><td>Nome</td><td>Preço</td><td colspan="2">Descrição</td></tr>
					<%for (Hotel i: roteiro.getHoteis()) {%>
						<tr>
							<td>Hospedagem</td>
							<td><%=i.getNome() %></td>
							<td><%=i.getPreco() %>,00</td>
							<td colspan="2"><%=i.getDescricao() %></td>
						</tr>
					<%} %>
					<%for (Transporte j: roteiro.getTransportes()) {%>
						<tr>
							<td>Hospedagem</td>
							<td><%=j.getNome() %></td>
							<td><%=j.getPreco() %>,00</td>
							<td><%=j.getCidadeFrom() %></td>
							<td><%=j.getCidadeTo() %></td>
						</tr>
					<%} %>
						<tr>
							<td colspan = "3"> Total</td>
							<td colspan = "2"> <%=roteiro.getPreco() %></td>
						</tr>
						
				<form method="POST" action="RegistraCompraRoteiro">
				<label>Forma de pagamento:</label>
				<select>
					<%for (FormaPagamento pgto: FormaPagamento.values()) {%>
						<option value = "<%=pgto.getId()%>"><%=pgto.getNome() %></option>
					<%} %>
				</select>
				<input type="submit" value="Enviar">
				</form>
			</div>
		</div>
	</body>
</html>