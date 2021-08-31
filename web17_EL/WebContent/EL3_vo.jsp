<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%

	MemberVO vo = new MemberVO("11","11","하바리","서현동");
	request.setAttribute("vo", vo);
	request.getRequestDispatcher("EL3_view.jsp").forward(request, response);	
%> --%>

<%
ArrayList<MemberVO> list = new ArrayList<>();
MemberVO vo1 = new MemberVO("11","11","하바리","서현동");
MemberVO vo2 = new MemberVO("22","22","하바리2","서현동2");
list.add(vo1);  list.add(vo2);

request.setAttribute("list", list);
request.getRequestDispatcher("EL3_view.jsp").forward(request, response);
%>
</body>
</html>







