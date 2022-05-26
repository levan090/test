<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">


</script>
<meta charset="UTF-8">
<title>게시물 조회</title>
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
<table>

	<tr>
		<th>제품번호</th>
		<td>${view.pro_code}</td>
	</tr>
	<tr>
		<th>제품명</th>
		<td>${view.pro_name}</td>
	</tr>
	<tr>
		<th>브랜드코드</th>
		<td>${view.brand_code}</td>
	</tr>
	<tr>
		<th>카테고리</th>
		<td>${view.pro_category}</td>
	</tr>
	<tr>
		<th>모델년도</th>
		<td>${view.pro_year}</td>
	</tr>
	<tr>
		<th>가격</th>
		<td>${view.pro_price}</td>
	</tr>
</table>
		<div>
			<a href="/ubi_modify.do?pro_code=${view.pro_code}"><button>수정</button></a>
		
		</div>
</body>
</html>