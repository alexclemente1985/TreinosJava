<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix='s' uri='/struts-tags' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Pessoa cadastrada com sucesso!</h3>
	
	<p>Nome: </p>
	<p><s:property value="pessoa.nome" /></p>
	<p>Idade:</p>
	<p><s:property value="pessoa.idade"/>
</body>
</html>