<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
UserVO vo = (UserVO) session.getAttribute("vo");
if (vo == null) {
%>
<b><a href="login.html">로그인</a></b>
<%
} else {
session.invalidate();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function logoutpop() {
		alert("Log Out")
	}
</script>

</head>
<body onload="return logoutpop()">
	<b>로그아웃 되셨습니다</b>
	<br />
	<a href="login.html">Home..</a>
</body>
</html>






