<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request객체</h2>
	
요청 프로토콜<%= request.getProtocol() %> <br>
요청 메소드방식<%= request.getMethod() %> <br>	
요청 경로 <%= request.getContextPath() %>	<br>
요청 url(주소) <%=request.getRequestURI() %> <br>
실경로: <%=request.getServletContext().getRealPath("/") %>
</body>
</html>