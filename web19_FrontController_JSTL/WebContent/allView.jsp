<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	ArrayList<MemberVO> list=(ArrayList<MemberVO>)request.getAttribute("list");
%>
<body>
<%
if(request.getParameter("name") !=null){
	out.println(request.getParameter("name")+" 님이 회원으로 등록하셧습니다.");
}
%>
<h3 align="center">회원 명단 보기</h3><p>
<table border="2" width="350" bgcolor="yellow" align="center">
	<%
		for(int i=0; i<list.size(); i++){
	%>
	<tr>
		<td><%= list.get(i).getId() %></td>
		<td><%= list.get(i).getName() %></td>
		<td><%= list.get(i).getAddress() %></td>
	</tr>
	<% } %>
</table>
</body>
</html>















