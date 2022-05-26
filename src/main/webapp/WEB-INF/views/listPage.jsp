<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.testVO" %>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
function getPost(mode){
	getPost(mode,"");
}
function getPost(mode,testId){		

	// 4. 함수에서는  form을 가져온다
	var theForm = document.insertText;
	if( mode == 'insert')				// 데이터 삽입
		{
			theForm.method = "post";
			theForm.action = "/inserttest.do";
		}
	else		
		{
	
			theForm.method = "post";
			theForm.action = "/modify2_proc.do";		 
			//theForm.testId = testId;					// object에 값을 넣으려고 해서 동작x
			theForm.testId.value = testId;				// value에 값을 넣어야 동작함
		
			// 5. document로 원하는 id을 가진 값을 가져온다.
			// 6. 함수로 가져온 form의 content에 넣는다.
			var content = $("#input_"+testId).val();
			//alert(theForm.testId.value);
			//alert(''+content);
			theForm.content.value = content;
		}
	// 7. submit 함
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
			<!-- 1. 리스트값을 이름붙여서 input 담아주기 -->
			<td><input id='input_${list.testId}' value="${list.content}" /></td>		
			<td>작성자표시</td>
			<div>
			
			<td><a href="/modify?testId=${list.testId}"><button>수정(requestmethod요구)</button></a> </td> 
			<!-- 2. 수정버튼에 자바스크립트 함수 실행 list.testId를 argument로 넘겨준다. -->
			<td><input type = button value = "modify" onClick="getPost('update',${list.testId});"/></td>
			<td><a href="/delete.do?testId=${list.testId}"><button>삭제</button></a></td>
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
<!-- 3. form 이름을 붙여준다. -->
<form name = insertText >
<input type="hidden" value=${vo.testId} id = "testId" name="testId" >
<input type="text" value="" id="content" name="content" > 
<input type="button" name="btn1" value="입력" onClick = "getPost('insert')" />
</form>



<!-- 페이징  -->

<div>
	<c:if test="${prev}">
		<span>[ <a href="/listPage.do?num=${startPageNum -1}">이전</a>]</span>
	</c:if>
	
	<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
		<span>
			<c:if test="${select !=num}">
				<a href="/listPage.do?num=${num}">${num}</a>
			</c:if>
			
			<c:if test="${select ==num}">
				<b>${num}</b>
			</c:if>
		</span>
	</c:forEach>
	
	<c:if test="${next}">
		<span>[ <a href="/listPage.do?num=${endPageNum + 1}">다음</a>]</span>
	</c:if>
	
 
</div>
 

</body>

</html>