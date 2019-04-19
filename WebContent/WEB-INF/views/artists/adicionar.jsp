<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de artistas</title>
</head>
<body>
	<c:url var="actionAdicionar" value="/artists/adicionar"></c:url>
	<form:form action="${actionAdicionar}" method="POST" modelAttribute="artist">
		<label>Informe o nome do artista: </label>
		<form:input path="nome"/><br/>
		<form:errors path="nome"></form:errors><br/>
		<label>Informe a idade do artista: </label>
		<form:input path="idade"/><br/>
		<form:errors path="idade"></form:errors><br/>
		<label>Informe o estilo do artista: </label>
		<form:input path="estilo"/><br/>
		<form:errors path="estilo"></form:errors><br/>
		
		<input type="submit" value="Salvar!"/>
	</form:form>
</body>
</html>