<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor='cyan'>
<h3>JSP Result Page</h3>
<b>Count Value :: </b>
<%= request.getParameter("cnt")%> <!-- Expression Element 출력문 -->
</body>
</html>