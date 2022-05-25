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
</style>
</head>
<body>


<table>
	<thead>
		<tr>
			<th>물품번호</th>
			<th>물품명</th>
			<th>브랜드코드</th>
			<th>카테고리</th>
			<th>모델년도</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.pro_code}</td>
			<td>${list.pro_name}</td>
			<td>${list.brand_code}</td>
			<td>${list.pro_category}</td>
			<td>${list.pro_year}</td>
			<td>${pro_price}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>