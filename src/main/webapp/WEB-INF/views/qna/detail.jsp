<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>QnA Detail Test Page</h1>  
  <h3>Num : ${dto.num}</h3>
  <h3>Title : ${dto.title}</h3>
  <h3>Contents : ${dto.contents}</h3>
  <h3>Writer : ${dto.writer}</h3>
  <h3>RegDate: ${dto.regDate}</h3>
  <h3>Hit: ${dto.hit}</h3>
  <h3>Ref: ${dto.ref}</h3>
  <h3>Step: ${dto.step}</h3>
  <h3>Depth: ${dto.depth}</h3>

  <a href="./update?num=${dto.num}">수정</a>
</body>
</html>