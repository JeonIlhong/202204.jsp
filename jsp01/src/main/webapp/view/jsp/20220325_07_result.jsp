<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>좋아하는 컬러 결과창</h2>
	<%
	
	// post방식일때 request객체의 인코딩을 utf-8로
	request.setCharacterEncoding("utf-8");
	String favcolor = request.getParameter("favColor");
	
	%>
	
	<%= favcolor %>
	
</body>
</html>