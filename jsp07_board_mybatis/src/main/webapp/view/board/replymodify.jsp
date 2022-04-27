<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function modifyCheck(e) {
		e.preventDefault(); //기본 이벤트 제거
		const content = document.getElementById('content');
		alert(content.value.trim());
		if(content.value.trim() == ''){
			alert('내용을 입력해 주세요!');
			return;
		}
		document.getElementById('frmReplyModify').submit();
	}

</script>
</head>
<body>
	<h2>댓글의 수정</h2>
	<%-- ${reply} --%>
	<form  id="frmReplyModify" action="${path}/reply/modify" method="post">
		<input type="hidden" name="bnum" value="${reply.bnum}">
		<table>
			<tr>
				<th>댓글번호 :</th>
				<td> <input type="text" name="rnum" value="${reply.rnum}"> </td>
			</tr>
			<tr>
				<th>내용 : </th> 
				<td> <textarea rows="5" cols="25" name="content" id="content">${reply.content}</textarea></td>
			</tr>
			<tr>
			<td colspan="2" align="center">
				<button onclick="modifyCheck(event)">수정</button>
				<button type="reset">취소</button>
			</td>
			</tr>
		
		</table>
	</form>
</body>
</html>