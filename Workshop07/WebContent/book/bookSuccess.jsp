<%@page import="servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>결과 페이지</h2>
<h3>${bo.title} 도서가 정상적으로 저장 되었습니다.</h3>
<a href = "Book.html">추가 등록</a>
</body>
</html>