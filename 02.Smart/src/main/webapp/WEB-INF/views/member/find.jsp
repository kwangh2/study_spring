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
	<div class="col-lg-5">
		<div class="card shadow-lg border-0 rounded-lg mt-5">
			<div class="card-header">
				<h3 class="text-center font-weight-light my-4">
				<a href="<c:url value='/'/>"><img src="<c:url value='/img/hanul.logo.png'/>"></a>
				</h3>
				<h4 class="card-body">비밀번호 찾기</h4>
			</div>
			<div class="card-body">
				<form method="post" action="resetPassword">
					<div class="form-floating mb-3">
						<input class="form-control" name="user_id" type="text"
							placeholder="아이디" required> <label for="inputEmail">
							아이디</label>
					</div>
					<div class="form-floating mb-3">
						<input class="form-control" name="email" type="text"
							placeholder="이메일" required> <label for="inputPassword">이메일</label>
					</div>

					<div
						class="d-flex align-items-center justify-content-between mt-4 mb-0">
											<button class="btn btn-primary ">확인</button>
						<a class="btn btn-primary" href="login">취소</a> 
					</div>
				</form>
			</div>
			<div class="card-footer text-center py-3">
				<div class="small">
					<a href="register.html">Need an account? Sign up!</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>