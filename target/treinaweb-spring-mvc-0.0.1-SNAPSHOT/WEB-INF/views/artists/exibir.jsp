<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados do artista ${artist.getNome()}</title>
</head>
<body>
<h3>Lista de artistas</h3>
	<p><label>Nome: </label> ${artist.getNome()}</p>
	<p><label>Idade: </label> ${artist.getIdade()}</p>
	<p><label>Estilo: </label> ${artist.getEstilo()}</p>
</body>
</html>