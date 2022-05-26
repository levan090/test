<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">

#add{
	float: right;
}
</style>
<title>ubi_main</title>
</head>
<body>
	
	<jsp:include page="ubi_chart.jsp" flush="false"/>
	
	<a id = "add" href="/ubi_write.do"><button>다른 탭으로 가는 작성</button></a>
	

</body>
</html>