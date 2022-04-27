<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>서블릿 매핑</h2>
	
	<form action="/jsp01/J20220328_01" method="post">
		이름: <input type="text" name="name"><br>
		나이: <input type="number" name="age"><br>
		<button>전달</button>
		
	
	</form>
	
	<%=request.getAttribute("name") %> 님 환영합니다.
	<%=request.getAttribute("age") %> 살
</body>
</html>