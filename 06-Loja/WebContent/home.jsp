<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-6">
				<form action="usuarioServlet" method="post" class="form">
					<fieldset>
						<h1>${mensagem}</h1>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="scripts.jsp" %>
</body>
</html>