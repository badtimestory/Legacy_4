<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>QnA Update Test Page</h1>
  <form action="./update" method="post">
    <!-- PK라 무조건 보내줘야함-->
    <input type="hidden" name="num" readonly="readonly" value="${dto.num}">
    <input type="hidden" name="num" readonly="readonly" value="${dto.regDate}">
    <div>
      <!-- name="parameter name" -->
      제목 <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
      <textarea cols="30" rows="10" name="contents" placeholder="내용을 입력하세요">${dto.contents}</textarea>
    </div>
    <div>
      <button type="submit" value="update">수정</button>
    </div>
  </form>
</body>
</html>