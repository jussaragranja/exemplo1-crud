<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuários Cadastrados</title>
</head>
<body>
	<div align="center" style="margin-top: 150px;">
		<h4>
			Usuários Cadastrados
		</h4>
		<% String msg = (String) request.getAttribute("cadsatroSucesso");%>
		${msg}
		<table border="1" >
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuarios">
					<tr>
						<td><c:out value="${usuarios.id}" /></td>
						<td><c:out value="${usuarios.nome}" /></td>
						<td><c:out value="${usuarios.email}" /></td>
						
						<td><a href="UsuarioController?action=edit&id=<c:out value='${usuarios.id}'/>">Editar</a></td>
						<td><a href="UsuarioController?action=delete&id=<c:out value='${usuarios.id}' />">Remover</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<p>
			<a href="UsuarioController?action=new">Novo Usuário</a>
		</p>
	</div>
</body>
</html>
