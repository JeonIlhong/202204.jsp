<%@page import="dto.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Member member =new Member("java","1111","박자바","java@gmail.com");
		request.setAttribute("member", member);
	%>
	
	<h2>jsp표현식</h2>
	<%=((Member)request.getAttribute("member")).getUserid() %> <br>
	<%=((Member)request.getAttribute("member")).getPasswd() %> <br>
	
</body>
</html>