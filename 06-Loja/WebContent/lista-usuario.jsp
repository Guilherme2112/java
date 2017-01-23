<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
							<th>Nome</th>
							<th>Email</th>
							<th>Senha</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuario" items="${usuarios}">
							<td>${usuario.nome}</td>
							<td>${usuario.email}</td>
							<td>${usuario.senha}</td>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="scripts.jsp" %>
</body>
</html>