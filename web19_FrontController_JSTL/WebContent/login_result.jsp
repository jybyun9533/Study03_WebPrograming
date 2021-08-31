<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${empty vo}">
		<script>
			alert("로그인 부터 하세요.");
			location.href="login.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<b>${vo.name }님 로그인 성공</b><br>
		<a href="index.jsp">Home</a>
	</c:otherwise>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Information....</h2>
	LogIn ID : <b>${vo.id }</b><br>
	LogIn NAME : <b>${vo.name}</b><br>
	LogIn ADDRESS : <b>${vo.address }</b><br>
	LogIn JSESSTIONID : <b><%= session.getId() %></b><br>
</body>
</html>










