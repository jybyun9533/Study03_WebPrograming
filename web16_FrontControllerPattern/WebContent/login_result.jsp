<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
MemberVO vo = (MemberVO) session.getAttribute("vo");
if (vo == null) { // 로그인하지않고 이곳으로 바로 접속했을 경우.(vo정보가 없다.)
%>
<h3>로그인 부터 하세요.</h3>
<a href="login.html"><b>login.html</b></a>

<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Information....</h2>
	LOGIN ID :
	<b><%=vo.getId()%></b>
	<br> LOGIN NAME :
	<b><%=vo.getName()%></b>
	<br> LOGIN ADDRESS :
	<b><%=vo.getAddress()%></b>
	<br>
	<br> LOGIN JESSESIONID :
	<b><%=session.getId()%></b>
	<br>
<a href="logout.jsp">LogOut</a>
<a href="index.html">HOME..INDEX</a>
</body>
</html>










