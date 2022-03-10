<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Join Page</h1>
  <div>
    <form action="./join" method="post" id="frm" enctype="multipart/form-data">
  	  <fieldset>
  	    <legend>ID</legend>
  	  	<input type="text" name="id" id="id">
				<span id="idResult"></span>
  	  </fieldset>	
  	  	
  	  <fieldset>
  	  	<legend>Password</legend>
  	  	<input type="password" id="pw" name="pw" placeholder="8글자 이상 12글자 이하로 작성">
  	  	<span id="pwResult"></span>
  	  </fieldset>
  	  
  	  <fieldset>
  	  	<legend>Password 확인</legend>
  	  	<input type="password" id="pw2" name="pw2" placeholder="8글자 이상 12글자 이하로 작성">
  	  	<span id="pwResult2"></span>
  	  </fieldset>
  	  
  	  <fieldset>
  	  	<legend>Name</legend>
  	  	<input type="text" name="name" id="name">
		<span id="nameResult"></span>
  	  </fieldset>
  	  
  	  <fieldset>
  	  	<legend>Phone</legend>
  	  	<input type="text" name="phone" id="phone">
		<span id="phoneResult"></span>
  	  </fieldset>
  	  
  	  <fieldset>
  	  	<legend>Email</legend>
  	  	<input type="text" name="email" id="email">
		<span id="emailResult"></span>
  	  </fieldset>
  	  
  	  <fieldset>
  	  	<legend>Photo</legend>
  	  	<input type="file" name="photo" id="photo">
		<span id="photoResult"></span>
  	  </fieldset>
  	  
  	  <fieldset>
  	  	<button type="button" id="btn">JOIN</button>
  	  </fieldset>
  	  
  	  <script type="text/javascript" src="../resources/js/join2.js"></script>
    </form>
  </div>
</body>
</html>