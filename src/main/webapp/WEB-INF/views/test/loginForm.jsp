<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="login" method=post>
	<p><label for="userID">아이디</label>
		<input type="text" id="userID" name="userID" /></p>
	<p><label for="userPW">비밀번호</label>
		<input type="password" id="userPW" name="userPW" /></p>
	<p><button type="submit">로그인</button></p>
	</form>
</body>
</html>