<%@page import="servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%Member vo = (Member)application.getAttribute("member");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<h2><%=vo.getName()%>님 회원가입 되셨습니다.</h2><br><br>
	<a href = "">로그인 하기(미구현)</a>
	<a href = "MainServlet">홈으로</a>
	
</body>
</html>