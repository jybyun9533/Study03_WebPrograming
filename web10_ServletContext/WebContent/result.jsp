<%@page import="servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- html 주석입니다. 소스보기하면 보인다. -->
<%-- JSP 주석입니다. 소스 보기 해도 안보인다.--%>
<!--
 %=  % 출력문
 %   % 이 안의 자바 코드가 들어감
 
 jsp 내장객체들 
request -- HttpServletRequest
response -- HttpServletResponse
session -- HttpSession
out -- PrintWriter
application -- ServletContext
 -->

<%
Member vo = (Member) application.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입결과 확인</title>
</head>
<body>
	<h2>Attribute에 바인딩된 회원의 정보를 받아옵니다.</h2>
	<ul>
		<li> 당신의 이름 <%=vo.getName()%> </li>
		<li> 당신의 나이 <%=vo.getAge() %></li>
		<li> 당신의 주소 <%=vo.getAddress() %></li>
	</ul>
</body>
</html>