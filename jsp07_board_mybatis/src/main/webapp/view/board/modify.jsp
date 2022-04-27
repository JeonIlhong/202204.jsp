<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>수정</h2>
<form action="${path}/board/modify" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>번호</th>
				<td> <input type="text" name="bnum" value="${board.bnum}" readonly> </td>
			</tr>		
			<tr>
				<th>작성자id</th>
				<td> <input type="text" name="userid" value="${board.userid}"> </td>
			</tr>
			<tr>
				<th>제목</th>
				<td> <input type="text" name="subject" value="${board.subject}"> </td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea name="content" rows="5" cols="25">${board.content}</textarea> </td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
				<c:forEach var="boardfile" items="${bflist}">
					${boardfile.filename} <input type="checkbox" name="removefile" value="${boardfile.bfnum}">삭제 <br>
				</c:forEach>
					<input type="file" name="file1"> <br>
					<input type="file" name="file2"> <br>
					<input type="file" name="file3"> <br>
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>수정</button>
					<button type="reset">취소</button>
				</td>
			</tr>
			
		</table>
	
	</form>	
</body>
</html>