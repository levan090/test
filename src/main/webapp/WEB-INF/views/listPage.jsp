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

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.testId}</td>
			<td>${list.content}</td>
			<td>작성자이름</td>
			<div>
			<td><a href="/test1/modify?testId=${list.testId}"><button>수정</button></a> </td>
			<td><a href="/test1/delete?testId=${list.testId}"><button>삭제</button></a></td>
			</div>
		</tr>
	</c:forEach>
	</tbody>
</table>
<form method ="post" action="/test1/inserttest.do">
<input type="text" value="${vo.content}" name="content" > 
<input type="submit" value="댓글입력">
</form> 

<div>
	<c:if test="${prev}">
		<span>[ <a href="/test1/listPage?num=${startPageNum -1}">이전</a>]</span>
	</c:if>
	
	<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
		<span>
			<c:if test="${select !=num}">
				<a href="/test1/listPage?num=${num}">${num}</a>
			</c:if>
			
			<c:if test="${select ==num}">
				<b>${num}</b>
			</c:if>
		</span>
	</c:forEach>
	
	<c:if test="${next}">
		<span>[ <a href="/test1/listPage?num=${endPageNum + 1}">다음</a>]</span>
	</c:if>
	
 <!-- <c:forEach begin="1" end="${pageNum}" var="num">
    <span>
     <a href="/test1/listPage?num=${num}">${num}</a>
  	</span>
 </c:forEach> -->
</div>
</body>

</html>