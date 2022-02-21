<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1> Member Login Page</h1>
  <div>
   <form class="frm" action="./login" method="POST">
    <fieldset>
      <legend>ID</legend>
    <!-- name 속성은 Parameter -->
      <input type="text" name="id" placeholder="아이디">
    </fieldset>

    <fieldset>
      <legend>Password</legend>
      <input type="password" name="pw" placeholder="비밀번호">
    </fieldset>

    <fieldset>
      <button type="submit">LOGIN</button>
    </fieldset>
  	</form>
  </div>
</body>
</html>