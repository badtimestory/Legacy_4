<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>List Test Page</h1>
  <table>
    <tr>
      <th>NUM</th>
      <th>TITLE</th>
      <th>CONTENTS</th>
      <th>WRITER</th>
      <th>REGDATE</th>
      <th>HIT</th>
    </tr>
    
   <c:forEach items="${list}" var="notice">
     <tr>
       <td>${notice.num}</td>
       <td><a href="./detail?num=${notice.num}">${notice.title}</a></td>
       <td>${notice.contents}</td>
       <td>${notice.writer}</td>
       <td>${notice.regDate}</td>
       <td>${notice.hit}</td>
    </tr>
  </c:forEach>
  </table>
  <a href="./add">글 쓰기</a>
</body>
</html>