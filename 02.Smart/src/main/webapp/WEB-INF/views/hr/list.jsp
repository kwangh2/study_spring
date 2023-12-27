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
	<h3>사원목록</h3>
	<div class="row mb-2 justify-content-between">
		<div class="col-auto d-flex align">
			<label class="me-2 w-px100">부서명</label>
			<form method="post" action="list">
				<select name="department_id" class="from-select" onchange="submit()">
					<option value="-1">전체</option>
					<c:forEach items="${departments }" var="d">
						<option
							<c:if test="${department_id eq d.department_id}">selected</c:if>
							value="${d.department_id }">${d.department_name }</option>
					</c:forEach>
				</select>
			</form>
		</div>
	</div>
	<div class="row mb-2">
		<div class="col-auto">
			<a href="register" class="btn btn-primary">고객 등록</a>
		</div>
	</div>
	<table class="table tb-list">
		<colgroup>
			<col width='80px'>
			<col width='250px'>
			<col width='300px'>
			<col>
			<col width='120px'>
		</colgroup>
		<tr>
			<th>사번</th>
			<th>사원명</th>
			<th>부서</th>
			<th>업무</th>
			<th>입사일자</th>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.employee_id}</td>
				<td><a href="info?id=${vo.employee_id}">${vo.name }</a></td>
				<td>${vo.department_name }</td>
				<td>${vo.job_title }</td>
				<td>${vo.hire_date }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>