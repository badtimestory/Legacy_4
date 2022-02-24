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
  <c:import url="../template/table.jsp"></c:import>
  <h1>Notice Detail Page Test</h1>
  
  <table>
    <tr>
      <th>NUM</th>
      <th>TITLE</th>
      <th>CONTENTS</th>
      <th>WRITER</th>
      <th>REGDATE</th>
      <th>HIT</th>
    </tr>
    <tr>
      <td>${dto.num}</td>
      <td>${dto.title}</td>
      <td>${dto.contents}</td>
      <td>${dto.writer}</td>
      <td>${dto.regDate}</td>
      <td>${dto.hit}</td>
    </tr>
  </table>

</body>
<a href="./list">BACK</a>
<a href="./update?num=${dto.num}">Update</a>
<a href="./delete?num=${dto.num}">Delete</a>
</html>