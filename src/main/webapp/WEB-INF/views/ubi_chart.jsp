<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="com.poha.test1.board.vo.Busi1VO" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
var count = $("#tb_list tr").length;
var num = 0;

$(document).ready(function(){
	
	$('#rowadd').click(function(){
//		alert(count);
		num = num + count - 1;
		num++;
		$("#tb_list > tbody:last").append(
				"<tr>"+
				"<td><input type ='hidden' name='pro_code' id='pro_code_"+ num +"'  style='width:90%;' value='' /></td>"+
				"<td><input type ='text' name='pro_name' id='pro_name_"+ num +"' style='width:90%;' value='' /></td>"+
				"<td><input type ='text' name='brand_code' id='brand_code_"+ num +"' style='width:90%;' value='' /></td>"+
				"<td><input type ='text' name='pro_category' id='pro_category_"+ num +"'  style='width:90%;' value='' /></td>"+
				"<td><input type ='text' name='pro_year' id='pro_year_"+ num +"' style='width:90%;' value='' /></td>"+
				"<td><input type ='text' name='pro_price' id='pro_price_"+ num +"' style='width:90%;' value='' /></td>"+
				"<td><input type ='text' name='store_id' id='store_id_"+ num +"' style='width:90%;' value='' /></td>"+
				"</tr>"
			);
	});
	
	$('#rowadd_save').click(function(){		// 입력된 데이터 저장기능 구현필요
	//	alert('1: 동작');
		var theForm = document.inserttable;
		theForm.method = "post";
		theForm.action="/ubi_write_proc.do";
	//	alert('2: ' + num);
		
	//	var pro_code = $("#pro_code_"+num).val();
	//	theForm.pro_code.value = pro_code;
	//	alert(theForm.pro_code.value);
	//  alert('3: '+$("#pro_code_"+num).val());
		
		var pro_name = $("#pro_name_"+num).val();
		theForm.pro_name.value = pro_name;
		//alert(theForm.pro_name.value);
		
		var brand_code =$("#brand_code_"+num).val();
		theForm.brand_code.value = brand_code;
		//alert(theForm.brand_code.value);
		
		var pro_category=$("#pro_category_"+num).val();
		theForm.pro_category.value = pro_category;
		//alert(theForm.pro_category.value);
		
		var pro_year=$("#pro_year_"+num).val();
		theForm.pro_year.value = pro_year;
		//alert(theForm.pro_year.value);
		
		var pro_price=$("#pro_price_"+num).val();
		theForm.pro_price.value = pro_price;
		//alert(theForm.pro_price.value);
		
		var store_id =$("#store_id_"+num).val();
		theForm.store_id.value = store_id;
		//alert(theForm.store_id.value);
		
		
	theForm.submit();
		
	});
	
	$('#rowdele').click(function(){
		num--;
		var trcount = $("#tb_list tr").length;
		if( trcount>2){
		$('#tb_list>tbody:last>tr:last').remove();
		}
		else {
			alert("최소 1개의 데이터가 있어야 합니다.");
		}
	});
	
	$('#coladd').click(function(){
	var trlengh = $('#tb_list > tbody > tr').length;
	
	for(var i = 0; i<trlengh;i++){
		var t=$('#tb_list > tbody > tr').eq(i);
		t.append("<td><input type ='text' name='comment' id='comment' style='width:90%;' value='' /></td>");
	}
});
	$("#coldele").click(function(){
	var trlength = $("#tb_list > tbody > tr").length;
	for(var i = 0; i<trlength; i++){
		var t = $('#tb_list > tbody > tr').eq(i);
		t.children().last().remove();
	}
});
	
	$('#modify').click(function(){
		//초기화
		// 현재 입력되어있는 값 insert
		var trcount = $("#tb_list tr").length - 1;
		alert(trcount);
		for(var i = 0; i<trcount;i++){
			var theForm = document.inserttable;
			theForm.method = "post";
			theForm.action="/ubi_clear&write_proc.do";
			
			var pro_name = $("#pro_name_"+ i).val();
			theForm.pro_name.value = pro_name;
			//alert(theForm.pro_name.value);
			
			var brand_code =$("#brand_code_"+i).val();
			theForm.brand_code.value = brand_code;
			//alert(theForm.brand_code.value);
			
			var pro_category=$("#pro_category_"+i).val();
			theForm.pro_category.value = pro_category;
			//alert(theForm.pro_category.value);
			
			var pro_year=$("#pro_year_"+i).val();
			theForm.pro_year.value = pro_year;
			//alert(theForm.pro_year.value);
			
			var pro_price=$("#pro_price_"+i).val();
			theForm.pro_price.value = pro_price;
			//alert(theForm.pro_price.value);
			
			var store_id =$("#store_id_"+i).val();
			theForm.store_id.value = store_id;
			//alert(theForm.store_id.value);
		
		}
		theForm.submit();
	});
	
});
</script>
<meta charset="UTF-8">
<title>ubi_main</title>
<style>
/* 테이블 테두리 및 가운데 정렬*/
table {
	margin-left:auto;
	margin-right:auto;
	width: 750px;
	table-layout : fixed;
}
table,tr,th,td {	
	text-align : center;		
	border : 1px solid black;
	border-collapse : collapse;}
#pro_price{
	text-align : right;
}
#tr_title{
	background-color: rgba(51,204,204);
}
#name {
	text-align: center;
	font-size : 200%;
		}
		
#rowadd, #rowadd_save, #rowdele, #coladd, #coldele{
	float: right;
}		
</style>
</head>
<body>

<div id="name">판매물품 </div>
<table id ="tb_list">
	<thead>
		<tr id ="tr_title">
			<th>물품번호</th>
			<th>물품명</th>
			<th>브랜드코드</th>
			<th>카테고리</th>
			<th>모델년도</th>
			<th>가격(원)</th>
			<th>판매점</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="list" varStatus ="status">
	
		<tr>
			<td><input id = '${list.pro_code}' value = '${list.pro_code}' style='width:90%;' readonly/></td>
			<td><input id = 'pro_name_${list.pro_code}' value="${list.pro_name}" style='width:90%;'/></td>
			<td><input id = 'brand_code_${list.pro_code}' value="${list.brand_code}" style='width:90%;'/></td> 
			<td><input id = 'pro_category_${list.pro_code}' value="${list.pro_category}" style='width:90%;'/></td>
			<td><input id = 'pro_year_${list.pro_code}' value="${list.pro_year}" style='width:90%;'/></td>
			<td><input id = 'pro_price_${list.pro_code}' value="${list.pro_price}" style='width:90%;'/></td>
			<td><input id = 'store_id_${list.pro_code}' value="${list.store_id}" style='width:90%;'/></td>
		</tr>
		
	</c:forEach>
	</tbody>
	
</table>
<a href="/ubi_clear.do"><button id = clear>clear</button></a>
<button id ="modify">수정</button>
<input type="button" id="rowadd_save" value="저장" /> 
<input type="button" id ="coldele" value="열삭제" />
<input type="button" id ="coladd" value="열추가" />
<input type="button" id="rowdele" value="행삭제" />
<input type="button" id ="rowadd" value="행추가" />
 



<form name = "inserttable">
	
	<input type="hidden" id = "pro_name" name="pro_name" value="" /><br/>
	
	<input type="hidden" id = "brand_code" name="brand_code" value="" /><br/>
	
	<input type="hidden" id = "pro_category" name="pro_category" value="" /><br/>
	
	<input type="hidden" id = "pro_year"name="pro_year" value="" /><br/>
	
	<input type="hidden" id = "pro_price" name="pro_price" value="" /><br/>
	
	<input type="hidden" id = "store_id" name="store_id" value="" /><br/>
	
</form>
</body>
</html>