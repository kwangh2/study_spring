<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:url value='/' />">홈으로 </a>
	<h3>첫번째 테스트 결과(Model객체 사용)</h3>
	<div>오늘날짜 : ${today } </div>
	<div>오늘시간 : ${now } </div>
	<div>사용한 객체 : ${type }</div>
</body>
</html>