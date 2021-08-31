<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function logoutpop() {
		alert("LogOut")
	}
</script>

</head>
<body onload="return logoutpop()">
	<b>로그아웃 되셨습니다</b>
	<br />
	<a href="login.jsp">Home..</a>
</body>
</html>






