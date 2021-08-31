<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Servlet 에서 진행되는 코드라고 이해</h2>
	<%
	int sum = 0;
	for (int cnt = 0; cnt <= 50; cnt++) {
		sum += cnt;
	}
	request.setAttribute("RESULT", sum);
	session.setAttribute("RESULT", "ENCORE");
	
	request.getRequestDispatcher("EL1_result.jsp").forward(request, response);
	
	
	%>
</body>
</html>