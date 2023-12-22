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
	<h3 class="mb-4">고객정보</h3>
	<table class="talbe tb-row">
	<colgroup>
		<col width="180px">
		<tr>
			<th>고객명</th>
			<td>${vo.name }</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${vo.gender }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${vo.email }</td>
		</tr> 
		<tr>
			<th>전화번호</th>
			<td>${vo.phone}</td>
		</tr>
	</table>
	<div class="btn-boolbar justify-content-center gap-4" >
		<button class="btn btn-primary" onclick="location='list.cu'" >고객목록</button>
		<button class="btn btn-warning" onclick="location='modify.cu?id=${vo.customer_id}'">정보변경</button>
		<button class="btn btn-danger" go_delete() >정보삭제</button>
		
	</div>

	<script >
	function go_delete(){
		if( confirm("정말 [${name}]정보를  삭제하시겠습니까?")){
		onclick="location='delete.cu?id=${vo.customer_id}'
			
		}
		
	}
	
	</script>

</body>
</html>