<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!--  prefix:접두사 -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>jsp변수</h2>
	<%
		String path = request.getContextPath();
	%>
	<a href="<%=path%>/view/20220405_01_el.jsp">링크</a>
	
	<h2>jstl+el</h2>
	<!-- pageContext:웹턴테이너가 구현한 객체(request객체를 얻기 위해서) -->
	<c:set var="path" value='${pageContext.request.contextPath}' />
	
	<a href="${path}/view/20220405_01_el.jsp">링크</a>
</body>
</html>