<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.List"%>
<%@ page import="model.Person" %>
<%@ page import="model.PersonUtil" %>

<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8" />
		<title>Listagem de pessoas</title>
		<link rel="stylesheet" type="text/css" href="estilos.css" />
	</head>
	<body>
		<%
			List<Person> pessoas = PersonUtil.castList((List) request.getAttribute("lista"), Person.class);
		%>
		<table>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>E-mail</th>
			</tr>
			<%
				for(Person pessoa: pessoas) {
			%>
			<tr>
				<td><%= pessoa.getName()%></td>
				<td><%= pessoa.getCpf()%></td>
				<td><%= pessoa.getEmail()%></td>
			</tr>
			<% } %>
		</table>
	</body>
</html>