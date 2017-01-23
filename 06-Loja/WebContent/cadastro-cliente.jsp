<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6">
				<form action="clienteServlet" method="post" class="form">
					<fieldset>
						<h1>Cadastro de Clientes</h1>
						<span><%= (request.getAttribute("mensagem") != null) ? "<div class='alert alert-success'>" + request.getAttribute("mensagem") + "</div>" : ""  %></span>
						<div class="form-group">
							<label for="id-nome">Nome</label>
							<input type="text" name="nome" id="id-nome" class="form-control"> 
						</div>
						<div class="form-group">
							<label for="id-endereco">Endereço</label>
							<input type="text" name="endereco" id="id-endereco" class="form-control">
						</div>
						<div class="form-group">
							<label for="id-idade">Idade</label>
							<input type="text" id="id-idade" name="idade" class="form-control">
						</div>
						<div class="form-group">
							<label>Sexo</label>
							<div class="radio">
								<label for="id-feminino"><input type="radio" name="sexo" id="id-feminino" value="feminino">Feminino</label>
							</div>
							<div class="radio">
								<label for="id-masculino"><input type="radio" name="sexo" id="id-masculino" value="masculino">Masculino</label>
							</div>
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