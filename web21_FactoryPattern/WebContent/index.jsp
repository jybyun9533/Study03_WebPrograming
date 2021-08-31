<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{
		text-align: center;
		border: 2px dotted green;
	}
</style>
</head>
<body>
<h1>CafeMember :: FrontControllerPattern + EL, JSTL </h1>
<%--
jstl -- choose
           when
           
           otherwise
index페이지에서는 클라이언트가 6가지의 서비스를 요청할수 있다.
이때 인증과 권한에 따라서 요청할 수 있는 서비스가 달라져야 한다.

authentification(인증)
				 회원 검색 하기
로그인 한 사용자 -  권한(authorization)
   	             로그아웃 / 전체회원정보보기 / 정보수정

로그인 안한 사용자 - 권한(authorization)
				  회원가입 / 로그인
 --%>
<div id="wrap">	
	<a href="find.jsp">회원 검색 하기</a><p>
	<c:choose>
		<c:when test="${!empty vo}">
			<a href="front.do?command=allmember">모든 회원 보기</a><p>	
			<a href=update.jsp>회원 정보 수정</a><p>
			<a href="front.do?command=logout">로그아웃</a><p>		
		</c:when>
		<c:otherwise>
			<a href="register.jsp">회원 가입 하기</a><p>	
			<a href="login.jsp">로그인 하기</a><p>		
		</c:otherwise>	
	</c:choose>
</div>
</body>
</html>






