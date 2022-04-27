<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Member> mlist = new ArrayList<>();
		
		mlist.add(new Member("java","1111","박자바","java@gmail.com"));
		mlist.add(new Member("hong","2222","홍길동","hong@gmail.com"));
		request.setAttribute("mlist", mlist);
	
	%>
	
	<%=mlist %>
	
	
	<h2>EL(dto 의 list)</h2>
	
	 <table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		
		</thead>
		<tbody>
			<c:forEach var="member" items="${mlist}">
		<tr>
			<td> ${member.userid} </td>
			<td> ${member.passwd} </td>
			<td> ${member.name} </td>
			<td> ${member.email} </td>
		</tr>
			</c:forEach>
		
		</tbody>
		
	</table> 
	
	
	
	
	
	
	

</body>
</html>