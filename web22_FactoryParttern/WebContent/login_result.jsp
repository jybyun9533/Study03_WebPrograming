<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${!empty vo}">
		<b>${vo.name}님 로그인 성공!!</b><br>
		<a href="index.jsp">Home...</a>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인 부터 진행하시기 바랍니다");
			location.href="login.jsp";
		</script>
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
LOGIN  ID : <b>${vo.id}</b><br>
LOGIN  NAME : <b>${vo.name}</b><br>
LOGIN  ADDRESS : <b>${vo.address}</b><br>
LOGIN  JSESSIONID : <b><%= session.getId() %></b><br>
<hr>
<a href="logout.do">LOG OUT</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.jsp">HOME....INDEX..</a>
</html>

















