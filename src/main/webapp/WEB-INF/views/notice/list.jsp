<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <c:import url="../template/header_css.jsp"></c:import>
  <link href="../resources/css/table.css" rel="stylesheet">
  <link href="../resources/css/list.css" rel="stylesheet">
</head>
<body>
  <c:import url="../template/header.jsp"></c:import>
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
  <div class="table-container">
	  <h1 class="title">List Test Page</h1>
	  <table class="table-basic">
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
  </div>
</body>
</html>