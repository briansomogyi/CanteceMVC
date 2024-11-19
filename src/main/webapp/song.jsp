<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Song page</title>
</head>
<body>
	<h1>Single song page</h1>
	<p>
		Id is: <strong><c:out value="${song.id}" /></strong>
	</p>
	<p>
		Title is: <strong><c:out value="${song.title}" /></strong>
	</p>
	<p>
		Author is: <strong><c:out value="${song.author}" /></strong>
	</p>
	<p>
		Score link is: <strong><c:out value="${song.scoreLink}" /></strong>
	</p>
	<p>
		Lyrics are: <strong><c:out value="${song.lyrics}" /></strong>
	</p>
	<p>
		Number of votes is: <strong><c:out
				value="${song.numberOfVotes}" /></strong>
	</p>
</body>
</html>