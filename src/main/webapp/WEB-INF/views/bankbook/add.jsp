<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Add Test page</h1>
  
  <form action="./add" method="POST">
  
    <input type="text" name="bookName" placeholder="BookName">
    
    <input type="text" name="bookRate" placeholder="BookRate">
    
    <textarea name="bookContents" rows="10" cols="10"></textarea>
    
    <div>
      판매<input type="radio" name="bookSale" value="1"> 판매중지<input type="radio" name="bookSale" value="0">
  	</div>
  	
  	<div>
  	CheakBox
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	<input type="checkbox" name="ch">
  	</div>
  	
  	<input type="submit" value="ADD">
  	<button>ADD</button>
  	
  </form>
</body>
</html>