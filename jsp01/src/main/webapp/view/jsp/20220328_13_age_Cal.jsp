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
	// 성인 미성년자 체크
	int age = Integer.parseInt(request.getParameter("age"));
	
	String result = null;
	if (age<20){
		
		result="미성년자";
	}else {
		result="성인";
	}
	request.setAttribute("age", age);
	request.setAttribute("result", result);
	//결과창으로 이동
	request.getRequestDispatcher("20220328_13_result.jsp").forward(request, response);
	%>
	
	

</body>
</html>