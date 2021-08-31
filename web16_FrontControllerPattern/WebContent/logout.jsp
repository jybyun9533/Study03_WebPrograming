<%--
로그아웃 로직
1. 세션에 바인딩된 정보가 있다면 == 현재 로그인된 상태라면 ==> 로그아웃
2. 세션을 죽인다. invalidate()
3. 다시 홈으로 / 로그인 페이지로
 --%>

<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
MemberVO vo = (MemberVO) session.getAttribute("vo");
if (vo == null) {
%>
<b><a href="login.html">로그인</a></b>
<%
}else{
	session.invalidate();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type = "text/javascript">
	function logoutpop(){
		alert("Log Out")
	}
</script>

</head>
<body onload="return logoutpop()">
	<b>로그아웃 되셨습니다</b>
	<br/>
	<a href="index.html">Home..</a>
</body>
</html>






