<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward방식 이동</h2>
	
	<%
	
		String name = "hong gil dong";
		int age = 25;
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		//forward 이동
		//1)이동경로의 정보획득
		RequestDispatcher rd = request.getRequestDispatcher("20220328_11_result.jsp");
		//2)forwarding
		rd.forward(request, response);
	
	%>

</body>
</html>