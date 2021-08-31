<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[ ] arr = {"삼계탕", "미역국","김치볶음밥","된장찌개","순부두찌개"};
	request.setAttribute("arr", arr);
%>
<jsp:forward page="CForEach6_result.jsp" />
</body>
</html>