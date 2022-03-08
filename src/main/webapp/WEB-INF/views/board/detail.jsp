<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>${board} Detail Page Test</h1>
  <h3>NUM: ${dto.num}</h3>
  <h3>TITLE: ${dto.title} </h3>
  <h3>CONTENTS: ${dto.contents}</h3>
  <h3>WRITER: ${dto.writer} </h3>
  <h3>REGDATE: ${dto.regDate}</h3>
  <h3>HIT: ${dto.hit}</h3>
</body>
<a href="./list">BACK</a>
<a href="./update?num=${dto.num}">수정</a>
<a href="./delete?num=${dto.num}">삭제</a>
<a href="./reply?num=${dto.num}">답글</a>
</html>