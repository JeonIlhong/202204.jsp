<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp파라메터</h2>
	아이디:<%=request.getParameter("userid") %> <br>
	이름:<%=request.getParameter("username") %> <br>
	<h2>el파라메터</h2>
	아이디:${param.userid} <br>
	이름:${param.username} <br>
</body>
</html>