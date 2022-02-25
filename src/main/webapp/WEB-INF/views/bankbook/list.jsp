<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
  <h1>BankBook List page</h1>
  <!-- <h1>${ list }</h1> -->
  
  <!-- bookName, bookRate, bookSale -->
    <table>
      <tr>
      	<th>상품번호</th>
        <th>상품명</th>
        <th>이자율</th>
        <th>판매</th>
      </tr>
  	  <c:forEach items="${list}" var="book">
  	  <tr>
  	  	<td>${book.bookNumber}</td>
  	    <td><a href="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
  	    <td>${book.bookRate}</td>
  	    <td>${book.bookSale}</td>
  	  </tr>
  	  </c:forEach> 
    </table>
    
    <div>
    	<c:forEach begin="${pager.beginPagingNum}" end = "${pager.endPagingNum}" var="pagingNum">
    		<a href="list?curPage=${pagingNum}">${pagingNum}</a>
    	</c:forEach>
    </div>
    
    <a href="./add">ADD</a>
</body>
</html>