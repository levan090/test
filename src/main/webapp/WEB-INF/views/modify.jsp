<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>게시글 수정 </title>
</head>
<body>
<form action="modify_proc.do" method="POST">
	
	
	<label>내용</label><br/>
	<input type ="text" name="content" value="${vo.content}" /> <br/>
	<button type ="submit">게시글 수정</button>
	</form>
	
</body>
</html>