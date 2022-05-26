<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시물 조회</title>
<style>
table {
	margin-left:auto;
	margin-right:auto;
	width: 750px;
}
table,tr,th,td {	
	text-align : center;		
	border : 1px solid black;
	border-collapse : collapse;}
#detail {
	text-align: center;
	font-size : 200%;
		}
#tr_title{
	background-color: rgba(51,204,204);
}
#chbutton {
	float: right;
}
</style>
</head>
<body>
<div id="detail">상세 조회</div>
<table>

	<tr id="tr_title">
		<th>물품번호</th>
		<th>물품명</th>
		<th>브랜드코드</th>
		<th>카테고리</th>
		<th>모델년도</th>
		<th>가격</th>
		<th>판매처</th>
	</tr>
	<tr>
		<td>${view.pro_code}</td>
		<td>${view.pro_name}</td>
		<td>${view.brand_code}</td>
		<td>${view.pro_category}</td>
		<td>${view.pro_year}</td>
		<td>${view.pro_price}</td>
		<td>${view.store_id}</td>
	</tr>
	
</table>
		<div id ="chbutton">
			<a href="/ubi_modify.do?pro_code=${view.pro_code}"><button>수정</button></a>
			<a href="/ubi_delete.do?pro_code=${view.pro_code}"><button>삭제</button></a>
		</div>
</body>
</html>