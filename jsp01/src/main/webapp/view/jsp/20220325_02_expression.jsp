<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현식</h2>
	<%
	 	int a=10,b=20;
		out.println("<div id='add'>합:"+(a+b)+"</div>");
	
	
	
	%>
	<hr>
	<div id="add">
	합:<%=a+b %>
	</div>
	
	
	<hr>
	<!-- 나이가 20살 이상이면 성인, 아니면 미성년자 dom에 출력 -->
	
	<%
	    /* Scanner sc = new Scanner(System.in); */
		/* System.out.print("몇살?"); */
		int age = 19;
		String s = null;	
		if (age>19) {
	%>		
			
		<%=age%>살은 성인
			
	<%	}else {
			
	%>	<%=age%>살은 미성년자
		<% 	}
 	
 	%>
 	
 	
 	<hr>
 	<h5>구구단출력(2단)</h5>
 	
 	<%
 		
 		int dan = 2 ;
 	for(int i=1;i<10;i++){
 		int x = i*dan;
 	%> <div> <%= dan %>*<%=i%>=<%=x%> </div>
 	<% }
 	
 		
 	%>
		
	<hr>
	
	2~9단 출력
	<% 
	
	for(int i=2;i<10;i++){
	%>	<h2> <%=i %>단 </h2> <% 
		for(int j=1;j<10;j++){
			
			int y=i*j;
	%>	<div><%=i%>*<%=j%>=<%=y%></div>
	<% 	}
	} 
	
		%>
</body>
</html>