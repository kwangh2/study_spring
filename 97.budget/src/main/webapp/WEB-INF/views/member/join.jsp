<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2024-01-05
  Time: 오후 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>회원가입</h3>
<form method="get" action="joinRequest">

    <div class="row">
        <div class="form-group col-auto" >
            <label for="user_id">아이디</label>
            <input type="text" class="form-control" id="user_id" name="user_id" aria-describedby="emailHelp" placeholder="아이디">
        </div>
    </div>
    <div class="form-group">
        <label for="user_pw">비밀번호</label>
        <input type="password" class="form-control" id="user_pw" name="user_pw" placeholder="비밀번호">
    </div>
    <div class="form-group">
        <label for="name">이름</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="이름">
    </div>
    <div class="form-group">
        <label for="email">이메일</label>
        <input type="text" class="form-control" id="email" name="email" placeholder="이메일">
    </div>
    <div class="form-group">
        <label for="birth">생일</label>
        <input type="text" class="form-control" id="birth" name="birth" placeholder="생일">
    </div>
    <div class="form-group">
        <label for="gender">성별</label>
        <input type="text" class="form-control" id="gender" name="gender" placeholder="성별">
    </div>
    <div class="form-group">
        <label for="phone">휴대전화</label>
        <input type="text" class="form-control" id="phone" name="phone" placeholder="휴대전화">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
