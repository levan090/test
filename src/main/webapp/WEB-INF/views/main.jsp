<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table {
		width: 100%;
		height: 100%;
	}
	tr {
		text-align: center;
	}
	
	.td_side{
		width:300px;
	}
	
</style>
<script src="//code.jquery.com/jquery.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
	<div class = "loginSys" align="right">
				<c:if test="${member != null}">
		<div class = "logout">
				<p>${member.userId} 님 환영합니다.</p>
				<a href ="/logout.do">로그아웃</a>	
		</div>
				</c:if>
			<c:if test="${member == null}">		<!--  member가 null값이면 로그인과 회원가입이 나와야됨 -->
		<div class = "login">
				<a href="/login.do">로그인</a><br/>
				<a href="/register.do">회원가입</a>
		</div>
			</c:if>
			
			
	</div>
		</tr>
		
		<tr>
			<td class="td_side">
			<div class = "sideMenu">
				<%@ include file="../views/menu.jsp" %>  
			</div>
			</td>
			<td>
			<div class ="logintext">
				<%@ include file="../views/login.jsp" %>
			</div>
			</td>
		</tr>
	</table>
	
</body>
</html>


