<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#first {
	background-color: threedlightshadow;
}

* {
	color: navy;
}
</style>
<script src="http://code.jquery.com/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('[name=cartInsert]').click(function() {
			localStorage.setItem($(this).attr('id'), $(this).val());
			alert("장바구니에 담겼습니다.");
		});		
		
		$('[name=cartConfirm]').click(function() {
			location.href="cartList.jsp";
		});
	});
</script>
</head>
<body>

	<h1 align="center">
		<b>${item.name}</b>
	</h1>
	<table align="center" width="600" id="first">
		<tr>
			<td align="center">
				조회수 : ${item.count} &nbsp;&nbsp;
				<button name="cartInsert" id="${item.itemNumber}"  value="${item.url},${item.name},${item.price}">장바구니 담기</button>
			&nbsp;&nbsp;<button name="cartConfirm">장바구니 확인</button>
			</td>
		</tr>
	</table>


	<table align="center" width="600">
		<tr>
			<td rowspan="3"><img alt="" src="${item.url}"></td>
			<td>종류 : ${item.name}</td>
		</tr>
		<tr>
			<td>가격 : ${item.price}</td>
		</tr>
		<tr>
			<td>설명 : ${item.description}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="itemList.do">상품 목록 보기</a></td>
		</tr>
	</table>

</body>
</html>