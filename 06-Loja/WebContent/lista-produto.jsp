<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<!-- Recupera a lista que a servlet enviou -->
				<table class="table">
					<thead>
						<tr>
							<th>Título</th>
							<th>Descrição</th>
							<th>Valor</th>
							<th>Fabricante</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produto" items="${produtos}">
						<tr>
							<td>${produto.titulo}</td>
							<td>${produto.descricao}</td>
							<td>${produto.valor}</td>
							<td>${produto.fabricante}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="scripts.jsp" %>
</body>
</html>