<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Adicionando álbuns</title>
</head>
<body>
	<c:url var="actionAdicionar" value="/albuns/adicionar"></c:url>
	<form:form action="${actionAdicionar}" method = "POST" modelAttribute="album">
		<label>Nome do Álbum</label>
		<form:input path="nome"/><br/>
		<form:errors path="nome"></form:errors><br/>
		<label>Ano de Lançamento</label>
		<form:input path="anoDeLancamento"/><br/>
		<form:errors path="anoDeLancamento"></form:errors><br/>
		<input type="submit" value="Salvar!"/>
	</form:form>
</body>
</html>