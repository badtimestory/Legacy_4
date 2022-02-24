<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Notice add Page</h1>
  
  <!-- form 태그를 이용해 server로 요청을 보냄 -->
  <form action="./add" method="POST">
    <input type="text" name="title" placeholder="title">
    <textarea name="contents" placeholder="contents"></textarea>
    <input type="text" name="writer" placeholder="writer">
    <input type="number" name="hit" placeholder="hit">
    
    <input type="submit" value="Add">
    
    <div>
    <a href="./list">뒤로 가기</a>
    </div>
  </form>
</body>
</html>