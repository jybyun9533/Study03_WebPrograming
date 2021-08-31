<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<h3 align="center">전체 회원 명단 보기</h3><p>
<table border="2" width="350" bgcolor="yellow" align="center">
	<c:forEach items="${list}" var="vo">
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.address}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>















