<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.Busi1VO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bike_Store</title>
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
			<th>가게번호</th>
			<th>가게이름</th>
			<th>연락처</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.store_id}</td>
			<td><a href="/bikelist.do?store_id=${list.store_id}">
			${list.store_name}</td>
			<td>${list.store_phone}</td>
		</tr>
	</c:forEach>
	</tbody>
	
</table>
</body>
</html>