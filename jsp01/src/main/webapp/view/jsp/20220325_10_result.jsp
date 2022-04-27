<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 정보</h2>
	<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpasswd = request.getParameter("userpasswd");
	String email = request.getParameter("email");
	String username = request.getParameter("username");
	String gender = request.getParameter("gender");
	%>
	
	아이디:<%=userid%><br>
	비밀번호:<%=userpasswd%><br>
	이메일:<%=email%><br>
	이름:<%=username%><br>
	성별:<%=gender%><br>
	
	<% 
	String reason = request.getParameter("reason");
	request.setCharacterEncoding("utf-8");
	if (reason != null){
		%>		당신의 가입경로는 <%= reason %> 입니다
	
	<% 
	}
	%>
	
	
	<br>
	
	알바가능 시간대:
	<%
		String[] times = request.getParameterValues("time");
	if (times != null){
		for(String time:times){
	%>        <%=time%><br>
	<% 	}
	}
	%>
	
	

</body>
</html>