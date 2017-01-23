<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6">
				<form action="loginServlet" method="post" class="form">
					<fieldset>
						<h1>${mensagem}</h1>
						<div class="form-group">
							<label for="id-email">E-mail</label>
							<input type="text" name="email" id="id-email" class="form-control">
						</div>
						<div class="form-group">
							<label for="id-senha">Senha</label>
							<input type="password" name="senha" id="id-senha" class="form-control">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-lg btn-success">Enviar <i class="glyphicon glyphicon-ok"></i></button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="scripts.jsp" %>
</body>
</html>