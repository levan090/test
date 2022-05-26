<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.Busi1VO" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
//$(function(){
//	$('#tadd').click(function(){
//		$("")
//	})
//});
</script>
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
#name {
	text-align: center;
	font-size : 200%;
		}
		
#tadd{
	float: right;
}		
</style>
</head>
<body>

<div id="name">판매물품 </div>
<table>
	<thead>
		<tr id ="tr_title">
			<th>물품번호</th>
			<th>물품명</th>
			<th>브랜드코드/카테고리</th>
			<th>모델년도</th>
			<th>가격(원)</th>
			<th>판매점</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.pro_code}</td>
			<td><a href="/ubi_view.do?pro_code=${list.pro_code}">
				${list.pro_name}
				</a></td>
			<td>${list.brand_code} / ${list.pro_category}</td>
			<td>${list.pro_year}</td>
			<td>${list.pro_price}</td>
			<td>${list.store_id}</td>
		</tr>
	</c:forEach>
	</tbody>
	
</table>
<input type="button" id = "tadd" value="행추가" />
</body>
</html>