<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function passCheck() {
		//비밀번호가 일치하지 않으면 페이지 이동 안되도록...
		//메세지 띄워주고
		var f = document.registerForm;
		if(f.password.value != f.repassword.value){
			alert("비밀번호가 일치하지 않습니다");
			f.repassword.value="";
			f.repassword.focus();
			return false;
		}
	}
	
	
	var xhr;
	var resultView;
	function startRequest(){
		var id = document.registerForm.id.value;
		resultView = document.getElementById("idCheckResult");
		
		if(id.length<4){
			resultView.innerHTML = "<font color='red'>아이디는 4자 이상</font>";
			return;
		}
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		xhr.open("post", "idCheck.do", true);

		xhr.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=utf-8");

		xhr.send("id=" + id);
	}
	
	function callback(){
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var flag = xhr.responseText;
				resultView = document.getElementById("idCheckResult");
				
				if(flag=='true'){
					resultView.innerHTML="<font color='red'><B>이미 존재하는 아이디 입니다.</b></font>";
				}
				else{
					resultView.innerHTML="<font color='green'><B>사용 가능한 아이디 입니다.</b></font>";
				}
			}
		} 
	}
	
</script>
</head>
<body>
	<h2 align="center">
		<b>Register Member Form....</b>
	</h2>
	<p>
	<form action="register.do" method="post" name="registerForm" onsubmit="return passCheck()">
		ID : <input type="text" name="id" required="required" onkeyup="startRequest()"> 
		<!-- <input type="button" value="중복확인" onclick="startRequest()">  -->
		<span id="idCheckResult"></span><br> <br> PASSWORD : <input type="password" name="password" required="required"><br> <br> NAME : <input type="text" name="name" required="required"><br> <br> ADDRESS : <input type="text" name="address" required="required"><br> <br> <input type="submit" value="member register">
	</form>
</body>
</html>












