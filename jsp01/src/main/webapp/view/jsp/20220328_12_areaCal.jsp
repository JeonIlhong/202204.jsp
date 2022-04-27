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
		//원의 넓이 계산
		int radius =Integer.parseInt( request.getParameter("radius"));
		double area = radius * radius * 3.14;
		System.out.println(area);
		
		//값담기
		request.setAttribute("area", area);
		//결과창으로 이동
		request.getRequestDispatcher("20220328_12_result.jsp").forward(request, response);
	%>
	
	
	
</body>
</html>