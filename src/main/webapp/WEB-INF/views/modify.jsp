<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('.sub').click(function(){
		var con =$(content).val();
		//alert(''+con);
	});
})
</script>
	<title>게시글 수정 </title>
</head>
<body>
<form  method="post">	
<!-- <form name="modify" action="modify_proc.do"> 	--> 

	<label>내용</label><br/>
	<input type ="text" name="content" id="content" value="" /> <br/>
	<button type ="submit" class="sub" >게시글 수정</button>
	</form>
	
</body>
</html>