<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8" />
		<title>Registro de pessoas</title>
		<link rel="stylesheet" type="text/css" href="estilos.css" />
	</head>
	<body>
		<form method="post" action="person">
			<label for="pessoas">
				Dados de pessoas (nome;cpf;e-mail):
			</label>
			<textarea name="pessoas" id="pessoas"></textarea>
			<input type="submit" name="submeter" value="Enviar" />
		</form>
	</body>
</html>