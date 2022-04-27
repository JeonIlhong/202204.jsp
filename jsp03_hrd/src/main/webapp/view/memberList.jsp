<%@page import="dto.Emember"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<section>
	<%
			List<Emember> mlist = (List<Emember>)request.getAttribute("mlist");
		%>
		
	
	<h2>회원목록조회/수정</h2>
	<table border="1">
	<tr>
	<th>회원번호</th>
	<th>회원성명</th>
	<th>전화번호</th>
	<th>주소</th>
	<th>가입일자</th>
	<th>고객등급</th>
	<th>거주지역</th>
	</tr>
	
	<%
		if(mlist != null) {
			for(Emember emember:mlist){
	%>		
	<tr>
							<td> <a href="/jsp03_hrd/member/modiform?custno=<%=emember.getCustno()%>"> <%=emember.getCustno() %> </a></td>
							<td><%=emember.getCustname() %></td>
							<td><%=emember.getPhone() %></td>
							<td><%=emember.getAddress() %></td>
							<td><%=emember.getJoindate() %></td>
							<td><%=emember.getGrade() %></td>
							<td><%=emember.getCity() %></td>
						</tr>		
		
		
		<% 	}
		}
	%>
	</table>
	</section>
<%@include file="footer.jsp" %>	
</body>
</html>