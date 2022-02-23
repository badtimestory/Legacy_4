<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>BankBook Update page</h1>
  
  <!-- 요청할 서버의 URL 작성 -->
  <form action="./update" method="POST">
  	<!-- name에는 prameter -->
  	<input type="hidden" name="bookNumber" readonly="readonly" value="${dto.bookNumber}">
    <input type="text" name="bookName" placeholder="BookName" value="${dto.bookName}">
    <input type="text" name="bookRate" placeholder="BookRate" value="${dto.bookRate}">
    <textarea name="bookContents" rows="10" cols="10">${dto.bookContents}</textarea>
    
    <div>
      판매<input type="radio" name="bookSale" value="1"> 
      판매중지<input type="radio" name="bookSale" value="0">
  	</div>
  	
  	<div>
  	CheakBox
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	</div>
  	
  	<input type="submit" value="update">
  	<button>ADD</button>
  	
  </form>
</body>
</html>