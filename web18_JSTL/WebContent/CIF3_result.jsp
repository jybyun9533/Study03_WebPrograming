<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.num==1004}">
		<h1>당신은 당첨되었습니다.</h1>
	</c:if>
	<c:if test="${param.num!=1004}">
		<h1>다음번을 기대해주세요.</h1>
	</c:if>
</body>
</html>