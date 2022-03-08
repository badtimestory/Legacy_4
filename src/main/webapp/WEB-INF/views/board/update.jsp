<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Insert title here</title>
</head>
<body>
  <form action="./update" method="POST">
    <input type="hidden" name="num" readonly="readonly" value="${dto.num}">
    <input type="hidden" name="regDate" readonly="readonly" value="${dto.regDate}">
    <div>
      Title <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
      Writer <input type=text name="wirter" value="${dto.writer}" disabled="disabled">
    </div>
    <div>
      <textarea name="contents" cols="30" rows="10">${dto.contents}</textarea>
    </div>
    <input type="submit" value="수정">
    </form>
</body>
</html>