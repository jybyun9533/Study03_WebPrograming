<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H2>attribute에 바인딩 된 내용을 찾아옴</H2>
	<b>1~50까지의 합산결과 1) ::</b>
	<br>
	<%=request.getAttribute("RESULT")%><br>
	<%=session.getAttribute("RESULT")%><br>
	<Hr>
	<b>1~50까지의 합산결과 2) ::</b>
	<br> ${RESULT}
	<BR> ${requestScope.RESULT}
	<BR> ${sessionScope.RESULT }
	<br>
	<hr>
	${RESULT }
	<BR> ${RESULT +1000 }
	<BR>
	${NAME }
</body>
</html>