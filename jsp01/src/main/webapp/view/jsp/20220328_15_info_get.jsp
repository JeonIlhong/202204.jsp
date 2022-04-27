<%@page import="java.net.URLEncoder"%>
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
		//메세지: 
			
		String major = request.getParameter("major");
		String name = request.getParameter("name");
		
		System.out.println(name);
		
		String prefix = major.substring(0,1);
		System.out.println(prefix);
		
		
		
		String msg;
		if(prefix.equals("A")){
			msg="공학계열";
		}else if (prefix.equals("B")){
			msg="인문계열";
		}else {
			msg="무 계열";
		}
		System.out.println(msg);
		
		
		//redirect 이동
		name = URLEncoder.encode(name,"utf-8");
		msg = URLEncoder.encode(msg,"utf-8");
		
		response.sendRedirect("20220328_15_result.jsp?major="+major+"&name="+name+"&msg="+msg);
	
	%>

</body>
</html>