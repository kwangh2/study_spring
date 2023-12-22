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
	<h3 class="mb-4">고객 목록 화면</h3>
	<table class="table">
		<thead>
			<tr>
				<th>고객명</th>
				<th>성별</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
		<c:if test="${empty list}">
		<tr>
			<td colspan="3">고객 목록이없습니다</td>
		</tr>
		</c:if>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.name}</td>
				<td>${vo.gender}</td>
				<td>${vo.email}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>