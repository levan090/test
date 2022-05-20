<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<title>Home</title>
</head>
<script type ="text/javascript">
	
</script>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<a href="/dbtest.do">기본 리스트</a> <br/>

<a href="/listPage?num=1">리스트(페이징)</a> <br/>
<a href="/main.do">메인메뉴</a><br/>
<c:if test="${member != null}">
	<div>
		<p>${member.userId} 님 환영합니다.</p>
		<a href ="/logout.do">로그아웃</a>
	</div>
</c:if>

<c:if test="${member == null}">		<!--  member가 null값이면 로그인과 회원가입이 나와야됨 -->
	<div>
		<a href="/login.do">로그인</a><br/>
		<a href="/register.do">회원가입</a>
	</div>
</c:if>



</body>
</html>
