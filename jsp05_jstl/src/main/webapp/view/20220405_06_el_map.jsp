<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
		//판매 map
		Map<String,Object>map = new HashMap<>();
		map.put("pname", "새우깡");
		map.put("saleprice", 50000);
		request.setAttribute("map", map);
	%>
	
	<h2>jsp표현식</h2>
	
	
	
	<h2>EL</h2>
	${map.pname} <br>
	${map.saleprice} <br>
	
</body>
</html>