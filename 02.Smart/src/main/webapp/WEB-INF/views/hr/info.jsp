<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 class="table mb-4">사원정보 </h3>
<colgroup>
	<col width="180px">
</colgroup>
	<table>
		<tr>
			<th>사번</th>
			<td>${vo.employee_id }</td>
		</tr>
		<tr>
			<th>사원명</th>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${vo.email }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${vo.phone_number}</td>
		</tr>
		<tr>
			<th>입사일자</th>
			<td>${vo.hire_date }</td>
		</tr>
		<tr>
			<th>급여</th>
			<td><fmt:formatNumber value="${vo.salary }"/></td>
		</tr>
		<tr>
			<th>부서</th>
			<td>${vo.department_name }</td>
		</tr>
		<tr>
			<th>업무</th>
			<td>${vo.job_title }</td>
		</tr>
		<tr>
			<th>매니저</th>
			<td>${vo.manager_name }</td>
		</tr>
	</table>
		<div class="btn-boolbar justify-content-center gap-4" >
		<button class="btn btn-primary" onclick="location='list'" >고객목록</button>
		<button class="btn btn-warning" onclick="location='modify?id=${vo.employee_id}'">정보변경</button>
		<button class="btn btn-danger"  id ="btn-delete" >정보삭제</button>
	</div>
	<script>
	$("#btn-delete").click(function(){
		if(confirm("정말 사원 [${vo.name}] 을 하시겠습니까?")){
			location="delete?id=${vo.employee_id}"
		}
	});

	</script>
</body>
</html>