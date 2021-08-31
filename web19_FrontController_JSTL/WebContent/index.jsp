<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap {
	text-align: center;
	border: 2px dotted green;
}
</style>
</head>
<body>
	<h2>HttpSession으로 Login 하는 Cafe Member</h2>
	<p>
	<div id="wrap">
		<c:choose>
			<c:when test="${!empty vo}">
				<li><a href="front.do?command=allmember">전체회원 명단보기</a>
					<p>
				<li><a href="update.jsp">회원정보 수정</a>
					<p>
				<li><a href="front.do?command=logout">로그아웃</a>
					<p>
			</c:when>
			<c:otherwise>
				<li><a href="register.jsp">회원 가입 하기</a>
					<p>
				<li><a href="find.jsp">회원 검색 하기</a>
					<p>
				<li><a href="login.jsp">로그인 하기</a>
					<p>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>