<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="./template/header_css.jsp"></c:import>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<div>
	  <img alt="cute" src="./resources/images/cute.webp">
	</div>
	
	<h1>Index Page</h1>
	
	<h3>${member.name} 님 환영합니다
		<span class="material-icons-outlined">
		account_circle
		</span>
	</h3>
	
	<div>
		<c:if test="${not empty member}">
			<a href="./member/mypage/">My page</a>
			<a href="./member/logout">Logout</a>
		</c:if>
		
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	</div>
	
	<img alt="pepe" src="./resources/upload/member/7e53b62b-a5dc-4744-b53a-70e86b6bd2d5_270F6B3A567D7EA706.jfif">
</body>
</html>