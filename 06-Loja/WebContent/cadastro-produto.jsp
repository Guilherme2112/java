<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6">
				<form action="produtoServlet" method="post" class="form">
					<fieldset>
						<h1>Cadastro de Produtos</h1>
						<span><%= (request.getAttribute("mensagem") != null) ? "<div class='alert alert-success'>" + request.getAttribute("mensagem") + "</div>" : ""  %></span>
						<div class="form-group">
							<label for="id-titulo">Título</label>
							<input type="text" name="titulo" id="id-titulo" class="form-control"> 
						</div>
						<div class="form-group">
							<label for="id-descricao">Descrição</label>
							<textarea name="descricao" id="id-descricao" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<label for="id-valor">Valor</label>
							<input type="text" name="valor" id="id-valor" class="form-control">
						</div>
						<div class="form-group">
							<label for="id-fabricante">Fabricante</label>
							<select name="fabricante" id="id-fabricante" class="form-control">
								<option>Selecione</option>
								<option>Sonia</option>
								<option>Motolola</option>
								<option>Flango</option>
							</select>
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