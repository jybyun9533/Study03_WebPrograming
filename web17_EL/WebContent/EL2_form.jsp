<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Form 값을 EL로 받아오기.</h2>
<form action="EL2_view.jsp" method="post">

ID <input type="text" name="userId"><br/><br/>

<strong>좋아하는 메뉴....</strong><p>
<input type="checkbox" name="menu" value="spagetii">spagetii
<input type="checkbox" name="menu" value="haser">haser
<input type="checkbox" name="menu" value="curry">curry
<input type="checkbox" name="menu" value="noodle">noodle
<br/><br/>

<input type="submit" value="DataSend">
</form>
</body>
</html>




