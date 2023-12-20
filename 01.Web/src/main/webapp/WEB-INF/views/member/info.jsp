<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원정보</h3>
	<table border="1">
		<tr>
			<th>이름</th>
			<td>${name }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${gender }</td>
		</tr>
		<tr>
			<th>메일</th>
			<td>${email }</td>
		</tr>
				<tr>
			<th>나이</th>
			<td>${age }</td>
		</tr>
		<tr>
			<th>방식</th>
			<td>${method }</td>
		</tr>
	</table>
		<table border="1">
		<tr>
			<th>이름</th>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${vo.gender }</td>
		</tr>
		<tr>
			<th>메일</th>
			<td>${vo.email }</td>
		</tr>
				<tr>
			<th>나이</th>
			<td>${vo.age }</td>
		</tr>
		<tr>
			<th>방식</th>
			<td>${method }</td>
		</tr>
	</table>
	<input type="button" value="회원가입 화면으로" 
			onclick="location='member'">
</body>
</html>