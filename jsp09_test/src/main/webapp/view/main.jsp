<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function listCheck() {
		
	}
</script>
</head>
<body>
	<h2>한국환경공단_에어코리아_미세먼지 경보 발령 현황</h2>
	<form action="${path}/pasing.air">
		<fieldset>
			<legend>파싱</legend>
			<input type="number" name="year">
			<button>파싱</button>
		</fieldset>
	</form>
	
	<hr>
	<form action="${path}/list.air">
	<input type="text" name="districtname">
	<button >조회</button>
	</form>
	
	<hr>
	<%-- ${alist} --%>
	
	
	<c:forEach var="dust" items="${alist}">
		<table border="1">
			<tr>
				<th>순번</th>
				<td colspan="3">${dust.SN}</td>
			</tr>
			<tr>
				<th>지역명</th>
				<td>${dust.DISTRICTNAME}</td>
				<th>권역명</th>
				<td>${dust.MOVENAME}</td>
			</tr>
			<tr>
				<th>항목명</th>
				<td>${dust.ITEMCODE}</td>
				<th>경보단계</th>
				<td>${dust.ISSUEGBN}</td>
			</tr>
			<tr>
				<th>발령일</th>
				<td>${dust.ISSUEDATE} </td>
				<th>발령농도</th>
				<td>${dust.ISSUEVAL}</td>
			</tr>
			<tr>
				<th>해제일</th>
				<td>${dust.CLEARDATE} </td>
				<th>발령농도</th>
				<td>${dust.CLEARVAL}</td>
			</tr>
		</table>
	
	</c:forEach>
	

	
	
</body>
</html>