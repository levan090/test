<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
function modify(pro_code){		


	var theForm = document.modify;
	
	theForm.method = "post";
	theForm.action = "/modify_proc.do";		 				
	theForm.pro_code.value = pro_code;				
	alert(theForm.pro_code.value);
	//alert(''+content);
	theForm.content.value = content;
		

	//theForm.submit();
	
}
</script>
<meta charset="UTF-8">
<title>게시물 수정</title>
<style>
table {
	margin-left:auto;
	margin-right:auto;
}
table,tr,th,td {	
	text-align : center;		
	border : 1px solid black;
	border-collapse : collapse;}
#detail {
	text-align: center;
	font-size : 200%;
		}
</style>
</head>
<body>
<div id="detail">상세 조회</div>
<form name = modify action = modify_proc.do method=post>
<table>

	<tr>
		<th>제품번호</th>
		<td><input type="text" name="pro_code" value="${view.pro_code}" /></td>
	</tr>
	<tr>
		<th>제품명</th>
		<td><input type="text" name="pro_name" value="${view.pro_name}" /></td>
	</tr>
	<tr>
		<th>브랜드코드</th>
		<td><input type="text" name="brand_code" value="${view.brand_code}" /></td>
	</tr>
	<tr>
		<th>카테고리</th>
		<td><input type="text"  name="pro_category" value="${view.pro_category}" /></td>
	</tr>
	<tr>
		<th>모델년도</th>
		<td><input type="text"  name="pro_year" value="${view.pro_year}" /></td>
	</tr>
	<tr>
		<th>가격</th>
		<td><input type="text"  name="pro_price" value="${view.pro_price}" /></td>
	</tr>
</table>
</form>
		<input type = button value = "완료2" onClick="modify(${view.pro_code});"/>	
		<button type="submit">완료</button>
</body>
</html>