<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.testVO" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%
    List<testVO> testSelect = (List<testVO>)request.getAttribute("list");
    for(testVO test: testSelect) {
%>
	<h1>
	<%=test.gettestId()%>:<%=test.getContent()%>
	</h1>
<%
    }
    
%>  
<a href="/test1/inserttest">데이터 Insert</a>
</body>
</html>