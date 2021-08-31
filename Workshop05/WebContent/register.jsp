<%@page import="servlet.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
ProductVO vo = (ProductVO) request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품이 저장되었습니다.</h1>
	<br>

	<table>
		<tbody>
			<tr>
				<td><b>상 품 명</b></td>
				<td><%=request.getParameter("name")%></td>
			</tr>
			<tr>
				<td><b>상품 가격</b></td>
				<td><%=request.getParameter("price")%></td>
			</tr>
			<tr>
				<td><b>상품 설명</b></td>
				<td><%=request.getParameter("desc")%></td>
			</tr>
		</tbody>
	</table>
	<a href="list.jsp?name=" +<%=request.getParameter("name")%>>상품정보</a>
</body>
</html>