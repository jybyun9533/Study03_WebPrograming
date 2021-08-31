<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<style type="text/css">
h1 {
	text-align: center;
}

#bookTable {
	margin: auto auto;
}

p {
	text-align: center;
}

#bookTable th {
	text-align: right;
}

#bookTable td {
	border: 1px solid black;
	padding: 10px 0px;
}

#bookTable tr:nth-child(2) {
	text-align: center;
	background-color: lightgray;
}

#bookTable td {
	width: 100px;
}

#bookTable td:nth-child(2) {
	width: 300px;
}

#bookTable td:nth-child(1) {
	width: 150px;
}
</style>
</head>
<body>
	<h1>도서 목록 화면</h1>
	<table id="bookTable">
		<tr>
			<th colspan="4">
				<form action="${pageContext.request.contextPath}/front.do" method="get">
					<input type="hidden" name="action" value="search"> <select name="searchField" id="searchField">
						<option value="LIST">전체</option>
						<option value="TITLE">도서명</option>
						<option value="PUBLISHER">출판사</option>
						<option value="PRICE">가격</option>
					</select> <input type="text" id="searchText" name="searchText"> <input type="submit" value="검색">
				</form>
			</th>
		</tr>
		<tr>
			<td>도서번호</td>
			<td>도서명</td>
			<td>도서분류</td>
			<td>저자</td>
		</tr>
		<c:choose>
			<c:when test="${empty books}">
				<tr>
					<td colspan="4">입력된 도서정보가 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${books}" var="b">
					<tr>
						<td>${b.isbn}</td>
						<td><a href="${pageContext.request.contextPath}/front.do?command=view&isbn=${b.isbn}">${b.title}</a></td>
						<td>${b.catalogue}</td>
						<td>${b.author}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<p>
		<a href='Book.jsp'>도서 등록</a>
	</p>
</body>
</html>
