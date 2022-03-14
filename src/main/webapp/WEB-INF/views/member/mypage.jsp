<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>My Page Test</h1>
	
	<h3>ID : ${dto.id}</h3>
	<h3>Name : ${dto.name}</h3>
	<h3>Phone : ${dto.phone}</h3>
	<h3>Email : ${dto.email}</h3>
	<img alt="image" src="../resources/upload/member/${dto.memberFileDTO.fileName}">
	<a href="./photoDown?fileNum=${dto.memberFileDTO.fileNum}">${dto.memberFileDTO.oriName}</a>
	<h3>Original ImageName : ${dto.memberFileDTO.oriName}</h3>
</body>
</html>