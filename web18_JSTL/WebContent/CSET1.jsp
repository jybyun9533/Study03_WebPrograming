<!-- 
JSP를 완벽한 태그기반의 언어로 만들기 위한 기술
1. EL
2. JSTL
 - 2개의 라이브러리가 추가되어야 사용 가능한 기술 (프로젝트 단위로 직접 추가)
 - taglib 속성을 지시어에 추가해야함
 - set, if ,choose, forEach 속성을 기본적으로 이해
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 
	1. c:set 
	- 이름을 지정할때 사용(값을 저장할때 사용하는 이름을 지정)
 -->
<!-- num1이라는 이름으로 7이라는 값을 바인딩 -->
<c:set var="num1" value="7"/>
<c:set var="num2" value="9"/>
<c:set var="multiple" value="${num1*num2}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>${num1 }과 ${num2 }의 곱은 ${multiple }이다</b>
</body>
</html>