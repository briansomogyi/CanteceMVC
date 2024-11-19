<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Songs page</title>
<style>
table, th, td {
	border: 1px solid black;
}

.my-table {
	width: 100%;
}
</style>
</head>
<body>
	<h1>Songs page</h1>
	<table class="my-table">
		<tr>
			<th>Id</th>
			<th>Titlu</th>
			<th>Autor</th>
			<th>Detalii</th>
		</tr>
		<c:forEach var="song" items="${songs}">
			<tr>
				<td><c:out value="${song.id}" /></td>
				<td><c:out value="${song.title}" /></td>
				<td><c:out value="${song.author}" /></td>
				<td><a href="<c:url value=" /CanteceMVC/song?id=${song.id}" />">Detalii</a></td>
				<td><a
					href="<c:url value=" /CanteceMVC/songs/edit/${song.id}" />">Editeaza</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>