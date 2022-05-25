<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.Busi1VO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ubi_main</title>
<style>
/* 테이블 테두리 및 가운데 정렬*/
table {
	margin-left:auto;
	margin-right:auto;
	width: 750px;
}
table,tr,th,td {	
	text-align : center;		
	border : 1px solid black;
	border-collapse : collapse;}
#pro_price{
	text-align : right;
}
#tr_title{
	background-color: rgba(51,204,204);
}
</style>
</head>
<body>


<table>
	<thead>
		<tr id ="tr_title">
			<th>물품번호</th>
			<th>물품명</th>
			<th>브랜드코드/카테고리</th>
			<th>모델년도</th>
			<th>가격(원)</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.pro_code}</td>
			<td>${list.pro_name}</td>
			<td>${list.brand_code} / ${list.pro_category}</td>
			<td>${list.pro_year}</td>
			<td id="pro_price">${list.pro_price}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>