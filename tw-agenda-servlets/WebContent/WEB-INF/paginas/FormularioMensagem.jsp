<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Digite seu nome...</title>
</head>
<body>
	<form method="post" action="/tw-agenda-servlets/mensagem">
		<p>Digite seu nome: </p>
		<p><input type="text" name="nomeUsuario"></p>
		<p><button type="submit">Enviar!</button></p>
	</form>
</body>
</html>