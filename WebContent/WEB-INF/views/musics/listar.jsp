<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de m�sicas</h2>
<br/>
<table class="table">
	<thead>
		<th>Id</th>
		<th>Nome da m�sica</th>
		<th>Data de cria��o</th>
		<th>Nome do �lbum</th>
		<th>A��es</th>
	</thead>
	<tbody>
		<c:if test="${!empty musics}">
			<c:forEach items="${musics}" var = "music">
				<tr>
					<td>${music.id}</td>
					<td>${music.nome}</td>
					<td>${music.dataCriacao}</td>
					<td>${music.album.nome}</td>
					<td>
						<a href="/treinaweb-spring-mvc/musics/alterar/${music.id}">Alterar</a> | 
						<a href="/treinaweb-spring-mvc/musics/excluir/${music.id}">Excluir</a> |
					</td>
					
				</tr>
			</c:forEach>
		</c:if>
	</tbody>
</table> 
<br/>
<a href="/treinaweb-spring-mvc/musics/adicionar" class="btn btn-default">Adicionar nova m�sica</a>