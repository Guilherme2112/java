<%@taglib prefix="td" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Despesa</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
	<h1>Editar Despesa</h1>
	<div class="jumbotron">

		<form action="LancDespServlet" method="post">
			<div class="form-group">
				<label for="id-cdLancamento">Número</label> <input class="form-control"
					type="text" name="cdLancamento" id="id-cdLancamento" value ="${desp.cdLancamento }" disabled>
			</div>
			<div class="form-group">
				<label for="id-daqta">Data</label> <input class="form-control"
					type="text" name="data" id="id-data" value ="${desp.data }">
			</div>


			<div class="form-group">
				<label for="despesa">Despesa:</label> <select class="form-control"
					id="despesa" name="despesa">
					<td:forEach var="tiposDespesa" items="${tiposDespesa }">
					<option value="${tiposDespesa.cdDespesa }">${tiposDespesa.tipoDespesa }</option>
					</td:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="id-observacao">Observação</label>
				<textarea class="form-control" cols="30" rows="3" name="observacao"
					id="id-observacao"></textarea>
			</div>
			<div class="form-group">
				<label for="id-valor">Valor Hora</label> <input class="form-control"
					type="text" name="vlHora" id="id-vlHora" value="${desp.vlHora}">
			</div>
			<div class="form-group">
				<input type="hidden" name="acao" value="aplicar">
				<input type="hidden" name="cdLancamento" value = "${desp.cdLancamento }">
				<input type="hidden" name="numProc" value="${numProc}">
				<input class="btn btn-primary" type="submit" value="Aplicar">
			</div>
		
		</form>
	</div>
	</div>
</body>
</html>