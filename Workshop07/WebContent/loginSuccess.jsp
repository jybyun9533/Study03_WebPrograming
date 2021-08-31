<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>${vo.name} 님이 로그인 되었습니다.</b><br>
<a href = "book/Book.html">도서 등록</a>
<a href = "logout.jsp">로그아웃</a>
</body>
</html>