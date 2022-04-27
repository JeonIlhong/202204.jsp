<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>사각형의 넓이 결과창</h2>
	<%
	
	
	int a = (int)3.14;
		//형번환: 문자열=> 정수
	int width =	Integer.parseInt(request.getParameter("width"));
	int height =Integer.parseInt(request.getParameter("height"));	
	%>
	
	사각형의 넓이 : <%= width*height %>

</body>
</html>