<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice update Page</h1>
	
	<form action="./update" method="POST">
	
		<input type="hidden" name="num" value="${dto.num}">
		<input type="text" name="title" placeholder="title" value="${dto.title}">
		<textarea name="contents" rows="20" cols="30" placeholder="contents">${dto.contents}</textarea>
		<input type="hidden" name="writer" value="${dto.writer}">
		<input type="hidden" name="regDate" value="${dto.regDate}">
		<input type="hidden" name="hit" value="${dto.hit}">
		
		
		<input type="submit" value="update">
		
	
	</form>
	
</body>
</html>