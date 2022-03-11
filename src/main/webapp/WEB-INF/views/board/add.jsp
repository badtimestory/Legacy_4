<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>${board} add Page</h1>
  <!-- form 태그를 이용해 server로 요청을 보냄 -->
  <form action="./add" method="POST" enctype="multipart/form-data">
    <input type="text" name="title" id="title" placeholder="title">
    <input type="text" name="writer" id="writer" placeholder="writer">
    <textarea name="contents" id="contents" placeholder="contents"></textarea>
      <div>
        <input type="file" name="files">
        <input type="file" name="files">
        <input type="file" name="files">
      </div>
    <input type="submit" value="Add">
    <div>
    <a href="./list">뒤로 가기</a>
    </div>
  </form>
  <script type="text/javascript" src="../resources/js/add.js"></script>
</body>
</html>