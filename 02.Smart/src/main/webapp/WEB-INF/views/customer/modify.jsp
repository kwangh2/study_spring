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
	<h3 class="mb-4">고객정보수정 </h3>
	<form method="post" action="update.cu">
	<input type="hidden" name="customer_id" value="${vo.customer_id}">
	<table class="talbe">
		<colgroup>
			<col width="180px">
		<tr>
			<th>고객명</th>
			<td>
				<div class="row">
					<div class="col-auto">
						<input class="form-control" type="text" name="name"
							value="${vo.name }">
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<div class="form-check form-check-inline">
					<label class="form-check-label">
						<input class = "form-check-input" type="radio" name="gender" value="남" ${vo.gender eq '남' ? 'checked' : '' }>남
					</label>
				</div>
				<div class="form-check form-check-inline">
					<label class="form-check-label">
						<input class = "form-check-input" type="radio" name="gender" value="여" ${vo.gender eq '여' ? 'checked' : '' }>여
					</label>
				</div>
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<div class="row">
					<div class="col-auto">
						<input type="text" name="email" value="${vo.email }">
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<div class="row">
					<div class="col-auto">
						<input type="text" name="phone" value="${vo.phone }">
					</div>
				</div>
			</td>
		</tr>
	</table>
	<!-- form태그 내에 있는 버튼 태그의 타입은 기본 submit , 타입을 button으로 지정해야 submit되지않는다. -->
	<div class="btn-boolbar justify-content-center gap-4">
		<button class="btn btn-primary" onclick="">저장</button>
		<!-- <button class="btn btn-danger" onclick="history.go(-1)">취소</button> -->
		<button type="button" class="btn btn-danger" onclick="location='info.cu?id=${vo.customer_id}'">취소</button>
	</div>
	</form>
</body>
</html>