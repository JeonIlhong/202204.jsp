<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="./include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	
	
		
	//로그인 유효성체크	
	function loginCheck() {
		const userid = frmLogin.userid;
		const passwd = frmLogin.passwd;
		
		if(userid.value==''){
			alert('아이디를 입력해 주세요');
			userid.focus();
		}else if (passwd.value==''){
			alert('비밀번호를 입력해 주세요');
			passwd.focus();
		}else{
			frmLogin.action='${path}/login.member';
			frmLogin.method='post';
			frmLogin.submit();
		}
		
	}
	</script>

</head>
<body>

<%@ include file="../header.jsp" %>

	<h2>로그인</h2>
	<form action="" name="frmLogin">
	<table>
		<tr>
			<th>아이디</th>
			<td> <input type="text" name="userid" value="${cookie.userid.value}"> </td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td> <input type="password" name="passwd"> </td>
		</tr>
		<tr>
			
			<th>아이디 기억하기</th>
			<td> <c:out value="${empty cookie.userid.value?'':'checked'}" />
			<input type="checkbox" name="idsave">
			 </td>
			<%-- <td> <input type="checkbox" name="idsave"  checked <%out.print(!userid.equals("")?"checked":"");%>> </td> --%>
		</tr>
		<tr>
			<td align="center" colspan="2">
			<button type="button" onclick="loginCheck()">로그인</button>
			<button type="reset">취소</button>
			</td>
		</tr>
		
	</table>
	</form>

</body>
</html>