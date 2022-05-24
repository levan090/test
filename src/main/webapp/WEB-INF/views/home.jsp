<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.testVO" %>    
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<meta charset="UTF-8">
<style>
	table {
		width: 100%;
		height: 100%;
	}
	tr {
		text-align: center;
	}
	
	#td_side{
		width:100%;
		height:100%;
	}
	
</style>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
</script>

<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
		<td colspan=2>
		<div id = "loginSys" align="right">
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
		</div>
		</td>
		</tr>
		
		<tr>
			<td class="td_side">
				<div id = "sideMenu">
					<jsp:include page="menu.jsp" flush="false"/>  
				</div>
			</td>
			<td rowspan=3>
				<div id ="logintext">
					<c:if test="${member != null}">
						<p>로그인중입니다.</p>
						<jsp:include page="listPage.jsp" flush="false"/> 
						
					</c:if>
					<c:if test="${member == null}">
						<jsp:include page="login.jsp" flush="false"/> 
					</c:if>
				</div>
			</td>
		</tr>
		
	
	</table>
	
</body>
</html>


