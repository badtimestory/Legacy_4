<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>QnA Add Test page</h1>
  <form action="./add" method="post">
    <div>
      <!-- name="parameter name" -->
      제목 <input type="text" name="title">
    </div>
    <div>
      이름 <input type="text" name="writer">
    </div>
    <div>
      <textarea cols="30" rows="10" name="contents" placeholder="내용을 입력하세요"></textarea>
    </div>
    <div>
      <button type="submit" value="add">작성</button>
    </div>
  </form>
</body>
</html>