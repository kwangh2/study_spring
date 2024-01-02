<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	스마트 IoT 미들웨어 서버 프로그램 
</h1>

<h3>고객관리</h3>
<div> <a target="_blank" href="<c:url value='customer/list'/>">전체목록조회</a></div>
<div><input type="text" id="query">
 <a target="_blank" href="" id="search">검색목록조회</a></div>
 <script type="text/javascript"
	src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 <script>
 
 $("#search").click(function(){
	 $(this).attr("href","<c:url value='customer/list'/>?query=" + $("#query").val())
 })
 </script>
</body> 
</html>
