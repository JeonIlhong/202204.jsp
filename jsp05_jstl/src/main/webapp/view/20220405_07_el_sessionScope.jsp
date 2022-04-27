<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>SessionScope</h2>
	<%
		//내장객체
		session.setAttribute("email", "hong@gmail.com");
		request.setAttribute("email", "java@gmail.com");
	
	%>
	<h2>jsp표현식</h2>
	이메일: <%=session.getAttribute("email") %>
	
	<h2>EL표현식</h2>
	${sessionScope.email}
	
	<h2>EL표현식(생략)</h2>
	<!-- requestScope와 이름이 겹칠때 requestScope먼저 가져옴 -->
	${email}
	
	
	<h2>cookie</h2>
	
	
	
</body>
</html>