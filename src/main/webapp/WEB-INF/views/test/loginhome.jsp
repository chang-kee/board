<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
 자바상사입니다. 어서오세요.
</h1>
<h3>"${user.name}"님 로그인되었습니다.</h3>
<button><a href="/board/logout">로그아웃</a></button><br>
<a href="/board/list">게시판</a><br>
<a href="/empCount">사원수 조회</a><br>
<a href="/comp01">회사 소개</a><br>
<a href="/comp02">회사 연혁</a><br>
<a href="/comp03">직원 소개</a><br>
<a href="/comp04">대표 말씀</a><br>
<a href="/comp05">인재상</a><br>
<a href="/comp06">발전가능성</a><br>
<a href="/comp07">제품 소개</a><br>
<a href="/comp08">수출 목표</a><br>
<a href="/comp09">채용 공고</a><br>
<a href="/comp10">오시는길</a><br>

</body>
</html>
