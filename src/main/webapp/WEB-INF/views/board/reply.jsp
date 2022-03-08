<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>${board} Reply Page</h1>
  
  <!-- form 태그를 이용해 server로 요청을 보냄 -->
  <form action="./reply" method="POST">
  	<input type="hidden" name="num" value="${dto.num}">
    <input type="text" name="title" placeholder="title">
    <input type="text" name="writer" placeholder="writer">
    <textarea name="contents" placeholder="contents"></textarea>
    <button type="submit">reply</button>
    <div>
    <a href="./list">뒤로 가기</a>
    </div>
  </form>
</body>
</html>