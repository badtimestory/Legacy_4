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
  <h1>BankBook Detail test page</h1>
    <table>
    	<tr>
    	  <th>Name</th>
    	  <th>Contents</th>
    	  <th>Rate</th>
    	  <th>Sale</th>
    	</tr>
    	  <td>${dto.bookName}</td>
    	  <td>${dto.bookContents}</td>
    	  <td>${dto.bookRate}</td>
    	  <td>${dto.bookSale}</td>
    	<tr>
    </table> 
    
  	<a href="./list">List</a>
  	<a href="./update?bookNumber=${dto.bookNumber}">Update</a>
  	<a href="./delete?bookNumber=${dto.bookNumber}">Delete</a>
</body>
</html>