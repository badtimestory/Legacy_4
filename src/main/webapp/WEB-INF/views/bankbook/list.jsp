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
  
	<!-- Search Bar-->
	<div>
		<form action="./list" method="GET">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">본문</option>
				</select>
				<!-- name element: "parameter name" -->
				<!-- value element: "it defines the text" -->
				<input type="text" name="search" value="${pager.search}">
				<button type="submit">검색</button>
			</fieldset>
		</form>
	</div>

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
    	<c:if test="${pager.curPage <= pager.perPage}">
    	<span class="material-icons-outlined">navigate_before</span>
    	</c:if>
    
    	<c:if test="${pager.before}">
    		<a href="./list?curPage=${pager.startNum-1}"><span class="material-icons-outlined">
			navigate_before
			</span></a>
    	</c:if>
    
 		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    		<a href="list?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
		</c:forEach>
		
		<c:if test="${pager.after}">
    		<a href="./list?curPage=${pager.lastNum+1}"><span class="material-icons-outlined">
			navigate_next
			</span></a>
    	</c:if>
    </div>
    
    <a href="./add">ADD</a>
</body>
</html>