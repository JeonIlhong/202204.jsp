<%@page import="dto.Emember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function modifyCheck() {
	var custname = frmModify.custname;
	var phone = frmModify.phone;
	var address = frmModify.address;
	var joindate = frmModify.joindate;
	var grade = frmModify.grade;
	var city = frmModify.city;
	if (custname.value == ''){
		alert('회원성명이 입력되지 않았습니다.');
		custname.focus();
	}else if (phone.value == ''){
		alert('회원전화가 입력되지 않았습니다.');
		phone.focus();			
	}else if (address.value == ''){
		alert('회원주소가 입력되지 않았습니다.');
		address.focus();			
	}else if (joindate.value == ''){
		alert('가입일자가 입력되지 않았습니다.');
		joindate.focus();			
	}else if (grade.value == ''){
		alert('고객등급이 입력되지 않았습니다.');
		grade.focus();			
	}else if (city.value == ''){
		alert('도시코드가 입력되지 않았습니다.');
		city.focus();			
	}else{
		frmModify.action = '/jsp03_hrd/member/modify';
		frmModify.method = 'post';
		frmModify.submit();
	}
	
}


</script>
</head>
<body>
<%
	Emember emember = (Emember)request.getAttribute("emember");
%>
<%
	String grade = emember.getGrade();
   
%>

<%@include file="header.jsp" %>
	<section>
		<h2>홈쇼핑 회원 등록</h2>
		<form  name="frmModify">
			<table border="1">
			<tr>
			<td>회원번호 <input type="number" name ="custno" readonly value="<%=emember.getCustno()%>"> </td>
			</tr>
			<tr>
			<td>회원성명 <input type="text" name ="custname" value="<%=emember.getCustname()%>"> </td>
			</tr>
			<tr>
			<td>회원전화 <input type="text" name ="phone" value= "<%=emember.getPhone()%>"> </td>
			</tr>
			<tr>
			<td>회원주소 <input type="text" name ="address" value="<%=emember.getAddress()%>"> </td>
			</tr>
			<tr>
			<td>가입일자 <input type="date" name ="joindate" value= "<%=emember.getJoindate() %>"> </td>
			</tr>
			<tr>
			<td>고객등급 
			<select name="grade" >
				<option value="A" <%out.print(grade.equals("A")?"selected":"");%>>A:VIP</option>
				<option value="B" <%out.print(grade.equals("B")?"selected":"");%>>B:일반</option>
				<option value="C" <%out.print(grade.equals("C")?"selected":"");%>>C:직원</option>
			</select> </td>
			</tr>
			<tr>
			<td>도시코드 <input type="text" name ="city" value="<%=emember.getCity()%>"> </td>
			</tr>
			<tr>
			<td colspan="2"><button  type="button" onclick="modifyCheck()" >수정</button>
			<button>조회</button></td>
			</tr>
		
			
			</table>
		</form>
		
		
	</section>
	<%@include file="footer.jsp" %>
</body>
</html>