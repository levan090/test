<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<a href="/test1/dbtest.do">기본 리스트</a> <br/>

<a href="/test1/listPage?num=1">리스트(페이징)</a> <br/>

</body>
</html>
