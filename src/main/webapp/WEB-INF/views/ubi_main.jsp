<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
#name {
	text-align: center;
	font-size : 200%;
		}
#add {
	float: right;
}
</style>
<title>ubi</title>
</head>
<body>
	<div id="name">테이블</div>
	<jsp:include page="ubi_chart.jsp" flush="false"/>
	
	<a id = "add" href="/ubi_write.do"><button>작성</button></a>

</body>
</html>