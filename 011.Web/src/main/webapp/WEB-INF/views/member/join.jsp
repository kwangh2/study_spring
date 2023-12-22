<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value='/' />">홈으로</a>
	<h3>회원 가입 </h3>
	<form method="post" action="joinRequest">
		<table border="1">
			<tr><th>성명</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr><th>성별</th>
				<td>
				<input type="radio" name="gender" id="male" value="남" checked> <!-- 라디오나 체크박스에 value넣어야 전송됨 -->
								<label for="male">남</label>
				<input type="radio" name="gender" id="female" value="여">
				<label for="female">여</label></td>
			</tr>
			<tr><th>이메일</th>
			<td><input type="text" name="email"></td>
			</tr>
						<tr><th>나이</th>
			<td><input type="text" name="age"></td>
			</tr>
		</table>
		<input type="submit" value="회원가입(HttpServletRequest)">
		<input type="submit" value="회원가입(@RequestParam)" onclick="action='joinParam'">
		<input type="submit" value="회원가입(DataObject)" onclick="action='joinData'">
		<input type="submit" value="회원가입(DataObject)" onclick="go_submit(this.form)">
	</form>
	
	<script>
	function go_submit( f ){
		f.action='joinPath/' + f.name.value +'/' + f.gender.value + '/' + f.email.value + '/' + f.age.value
		
	}
	
	</script>
</body>
</html>