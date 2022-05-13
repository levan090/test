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

<!-- 
<table>
	<thead>
	<tr>
		<th>번호</th>
		<th>내용</th>
	</tr>
	</thead>
	<tbody>
	<h1>
	<%
    List<testVO> testSelect = (List<testVO>)request.getAttribute("list");
    for(testVO test: testSelect) {
%>
		<tr>
		<td><%=test.gettestId()%></td> 
		<td><%=test.getContent()%></td> 
		<td>	<button id="btn_modify" type="button">수정</button> </td>
		<td>	<a href="/test1/delete?testId=${test.testId}">삭제</a></td>
		</tr>
	</h1>
<%
    }
    
%>  
	</tbody>
	
</table>
<form method ="post" action="/test1/inserttest.do">
<input type="text" value="${vo.content}" name="content" encType="multiplart/form-data"> 
<input type="submit" value="댓글입력">
</form> -->
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>내용</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list">
		<tr>
			<td>${list.testId}</td>
			<td>${list.content}</td>
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
 <c:forEach begin="1" end="${pageNum}" var="num">
    <span>
     <a href="/board/listPage?num=${num}">${num}</a>
  </span>
 </c:forEach>
</div>
</body>

</html>