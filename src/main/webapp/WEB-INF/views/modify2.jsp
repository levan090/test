<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.poha.test1.board.vo.testVO" %>
<%@ page import="java.util.List" %>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

</script>
	<title>게시글 수정2 </title>
</head>
<body>
<!--<form  method="post">	--> 
 <form name="modify2" action="modify2_proc.do"> 	

	<label>내용</label><br/>
	<input type="hidden" value="${list.testId}" id = "testId" name="testId" >
	<input type ="text" name="content" id="content" value="" /> <br/>
	<button type ="submit" class="sub" >게시글 수정</button>
	</form>
	
</body>
</html>