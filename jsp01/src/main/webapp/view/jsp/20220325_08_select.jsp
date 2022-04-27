<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>직업선택</h2>
	<form action="">
		<select name="job">
			<option value="웹프로그래머">웹프로그래머</option>
			<option value="DB관리자">DB관리자</option>
			<option value="시스템관리자">시스템관리자</option>
			<option value="AI프로그래머">AI프로그래머</option>
		</select>
	 <button>선택</button>	
	</form>
	<% 
	String job = request.getParameter("job");
	request.setCharacterEncoding("utf-8");
	if (job != null){
		%>		당신이 선택한 직업은 <%=job%> 입니다
	
	<% 
	}
	
	
	
	%>
	<hr>
	
	
	
	

</body>
</html>