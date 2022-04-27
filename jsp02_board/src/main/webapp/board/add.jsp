<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if('<%=request.getParameter("msg")%>' != 'null'){
		alert(<%=request.getParameter("msg") %>);
	}
	function addCheck() {
		var writer = document.getElementById('writer');
		var subject = document.getElementById('subject');
		var content = document.getElementById('content');
		
		
		if(userid.value==''){
			alert('아이디를 입력해주세요');
			userid.focus();
			return;
		}else if(passwd.value==''){
			alert('비밀번호를 입력해주세요')
			passwd.focus();
			return;
		}else if(name.value==''){
			alert('이름을 입력해주세요')
			name.focus();
			return;
		}else if(email.value==''){
			alert('이메일을 입력해주세요')
			email.focus();
			return;
		}
	
	
</script>
</head>
<body>
	<h2>게시물 등록</h2>
	<form action="/jsp02_board/add.board" method="post">
		<table>
			<tr>
				<td>작성자</td>
				<td> <input type="text" name="writer"> </td>
			</tr>
			<tr>
				<td>제목</td>
				<td> <input type="text" name="subject"> </td>
			</tr>
			<tr>
				<td>내용</td>
				<td> <textarea rows="5" cols="25" name="content"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button onclick="">저장</button>
					<button type="reset">취소</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>