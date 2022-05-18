<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.testVO" %>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

function getPost(mode){
	var theForm = document.insertText;
//	var id = document.getByName("");
	if( mode == 'insert')
		{
			theForm.method = "post";
			theForm.action = "/test1/inserttest.do";
		}
	else if(mode != 'modify' )
		{
		
		}
	theForm.submit();
	
}


</script>
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
			<td><input name='input_${list.testId}' value="${list.content}"  disabled="disabled"/></td>
			<td>작성자표시</td>
			<div>
			<td><a href="/test1/modify?testId=${list.testId}"><button>수정</button></a> </td>
			<form name = "modifyform">
			<td><input type = button name ="modify" value = "수정2" onClick="getPost(${list.testId})"/></td>
			</form>	
			<td><a href="/test1/delete?testId=${list.testId}"><button>삭제</button></a></td>
			
			</div>
		</tr>
	</c:forEach>
	</tbody>
</table>

<!-- 입력 
<form name = insertText method = "post" action = "/test1/inserttest.do">
<input type="text" value="${vo.content}" name="content" > 
<input type="submit" value="댓글입력">
</form>  -->
<form name = insertText >
<input type="text" value="${vo.content}" name="content" > 
<input type="button" name="btn1" value="입력" onClick = "getPost('insert')" />
</form>



<!-- 페이징 -->

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
	
 
</div>
</body>

</html>