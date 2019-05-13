<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Listagem de músicas</h2>
<br/>
<table class="table">
	<thead>
		<th>Id</th>
		<th>Nome da música</th>
		<th>Data de criação</th>
		<th>Nome do álbum</th>
		<th>Ações</th>
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
<a href="/treinaweb-spring-mvc/musics/adicionar" class="btn btn-default">Adicionar nova música</a>