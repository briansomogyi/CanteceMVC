<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song edit page</title>
</head>
<body>
	<form:form method="post"
		action="${pageContext.request.contextPath}/songs/edit"
		modelAttribute="song">
		<div>
			<label for="id">ID</label>
			<form:input path="id" />
		</div>
		<br>
		<div>
			<label for="title">Titlu</label>
			<form:input path="title" />
		</div>
		<br>
		<div>
			<label for="author">Autor</label>
			<form:input path="author" />
		</div>
		<br>
		<div>
			<label for="scoreLink">Link partitura</label>
			<form:input path="scoreLink" />
		</div>
		<br>
		<div>
			<label for="lyrics">Versuri</label>
			<form:input path="lyrics" />
		</div>
		<br>
		<div>
			<label for="numberOfVotes">Numar voturi</label>
			<form:input path="numberOfVotes" />
		</div>
		<br>
		<div>
			<input type="submit" value="Salveaza" />
		</div>
		<br>
	</form:form>
</body>
</html>