<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Insert title here</title>
</head>
<body>
  <form action="./update" method="POST">
    <input type="hidden" name="num" readonly="readonly" value="${dto.num}">
    <input type="hidden" name="regDate" readonly="readonly" value="${dto.regDate}">
    <div>
      Title <input type="text" name="title" value="${dto.title}">
    </div>
    <div>
      Writer <input type=text name="wirter" value="${dto.writer}" disabled="disabled">
    </div>
    <div>
      <textarea name="contents" cols="30" rows="10">${dto.contents}</textarea>
    </div>
    
    <div id="files">
	    <c:forEach items="${dto.fileDTOs}" var="f">
			<div>
				${f.oriName} <button type="button" data-fileNum="${f.fileNum}" class="fileDeleteBtn">X</button>
			</div>
	    </c:forEach>
    </div>
     <div id="fileResult">

     </div>
     <div>
     	<button type="button" id="fileAdd">FileADD</button>
     </div>
    <input type="submit" value="수정">
    </form>
    <script type="text/javascript" src="../resources/js/file.js"></script>
</body>
</html>