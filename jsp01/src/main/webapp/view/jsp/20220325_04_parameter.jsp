<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>요청 파라메터 정보</h2>
<form action="" method="get">
	이름: <input type = "text" name="name"> <br>
	나이: <input type = "number" name="age"> <br>
	<!--form submit기능 action값: url 
		form안의 name의 정보를 request객체에 담아서 보낸다-->
	<button>전송</button>
	
</form>

	<%
		//스트립틀릿(servlet):서버
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
	%>	
	
	이름:<%=name %><br>
	나이:<%=age %><br>
</body>
</html>