<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.poha.test1.board.vo.testVO" %>
<%@ page import="java.util.List" %>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.sub').click(function(){
		var con =$(content).val();
		id = document.getElementById(('vo.testId').value);
		alert(id);		// null값이 출력됨. http://localhost:8080/modify_proc.do?testId=&content=fsafzxv	 	
		alert(''+con);	// testId부분이 누락되서 업데이트가 되지않음
	});
})


</script>
	<title>게시글 수정 </title>
</head>
<body>
<!--<form name="modify">	 -->	
<form name="modify" action="modify_proc.do">  	

	<input type="hidden"  id="testId" name="testId" value="${vo.testId}" />
	<label>내용</label><br/>
	<input type ="text" name="content" id="content" value="" /> <br/>
	<button type ="submit" class="sub" >게시글 수정</button>
	</form>
	
</body>
</html>