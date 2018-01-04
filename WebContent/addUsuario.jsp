<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Novo Usuário</title>
</head>
<body>
	<form action="UsuarioController?action=salvar" method="POST" style="border: 2; margin-top: 130px;">
		<h3>Cadastro de Usuários</h3>
		<fieldset>
			<div>
				<input type="hidden"  readonly="readonly" name="id" value="<c:out value="${usuario.id}" />" />
			</div>
			<div>
				<label for="Nome">Nome</label> 
				<input type="text"
					name="nome" value="<c:out value="${usuario.nome}" />"
					placeholder="Nome" />
			</div>
			<br/>
			<div>
				<label for="Email">E-mail</label> 
				<input type="text"
					name="email" value="<c:out value="${usuario.email}" />"
					placeholder="E-mail" />
			</div>
			
			
			<div>
				<br/>
				<input type="submit" value="Salvar" />
			</div>
		</fieldset>
	</form>
</body>
</html>