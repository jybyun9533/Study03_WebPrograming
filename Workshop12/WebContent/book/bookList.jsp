<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 정보</title>
<script type="text/javascript">

var xhr;

function startRequest(title){
	var isbn =title.parentNode.parentNode.childNodes[1].innerHTML;
	xhr = new XMLHttpRequest();
	
	
	xhr.onreadystatechange = callback;
	xhr.open("post","bookDesc.do");
	
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
	xhr.send("isbn="+isbn);
}

function callback(){
	if(xhr.readyState==4){
		if(xhr.status==200){
			data=xhr.responseText.split(",");
			document.getElementById("info").innerHTML = 
				"<font color = 'red'  size = 3> Book 상세정보 출력 - 제목 : "+data[0]+", 출판사 : "+data[1]+", 저자 : "+data[2]+"</font>";
		}
	}
}
</script>

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

#bookTable th{
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
			<th  colspan="4">
				<form action="${pageContext.request.contextPath}/front.do" method="get">
					<input type="hidden" name="command" value="search"> 
					<select name="searchField" id="searchField">
						<option value="LIST">전체</option>
						<option value="TITLE">도서명</option>
						<option value="PUBLISHER">출판사</option>
						<option value="PRICE">가격</option>
					</select> 
					<input type="text" id="searchText" name="searchText"> 
					<input type="submit" value="검색">
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
						<td><a href="#" onclick="startRequest(this);">${b.title}</a></td>
						<td>${b.catalogue}</td>
						<td>${b.author}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<p>
		<a href='book/Book.html'>도서 등록</a> 
	</p>
	<br>
	<div id="info" align="center"></div>
</body>
</html>
