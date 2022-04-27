<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function removeCheck() {
		//세션체크
		if('${sessionScope.userid}' != '${member.userid}'){
			alert('권한이 없습니다.');
			return;
		}
		
		
		var result = confirm('정말로 회원탈퇴하시겠습니까?');
		if (result){
			location.href ='${path}/remove.member?userid=${member.userid}';
		}
	}

</script>
</head>
<body>
<%@ include file="../header.jsp" %>
	<h2>개인정보</h2>
<%-- 	${member} --%>
	
		<table border="1">
			<tr>
				<th>아이디</th>
				<td> ${member.userid} </td>
			</tr>
			
			<tr>
				<th>우편번호</th>
				<td> ${member.zipcode}</td>
			</tr>
				
			<tr>
				<th>도로명주소</th>
				<td> ${member.addrload} </td>
			</tr>
				
			<tr>
				<th>상세주소</th>
				<td> ${member.addrdetail} </td>
			</tr>
			<tr>
				<th>사진</th>
				<td> 
					<img alt="" src="/savedir/${member.filename}" width="100">
				${member.filename}</td>
			</tr>
			<tr>
				<th>가입일자</th>
				<td><fmt:formatDate value="${member.regidate}" pattern="yyyy년 MM월 dd일 HH:mm:ss" /> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button onclick="location.href='${path}/modiform.member?userid=${member.userid}'">수정하기</button>
				<button onclick="removeCheck()">탈퇴</button>
			</td>
			</tr>
			
		</table>
	
</body>
</html>