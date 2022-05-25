<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>

<form name = "insert" method ="post" action="/ubi_write_proc.do">
	<label>제품명</label>
	<input type="text" name="pro_name" /><br/>
	<label>브랜드코드</label>
	<input type="text" name="brand_code" /><br/>
	<label>카테고리</label>
	<input type="text" name="pro_category" /><br/>
	<label>모델년도</label>
	<input type="text" name="pro_year" /><br/>
	<label>가격</label>
	<input type="text" name="pro_price" /><br/>
	<button type="submit">작성</button>
</form>
</body>
</html>