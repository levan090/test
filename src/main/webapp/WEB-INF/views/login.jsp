<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

.logintext {background-color: coral;}

</style>
<title>로그인창</title>
</head>
<body>
	<div class="logintext" >
<form name="frmLogin" method="post" action="/login_proc.do" encType="UTF-8">
	아이디:<input type="text" name="userId"> <br>
	비밀번호:<input type="password" name="userPass"><br>
	<input type="submit" value="로그인"> <input type="reset" value="다시 입력"><br>
	</div>

	</form>

</body>
</html>