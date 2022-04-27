<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	if('${param.msg}' !=''){
		alert('${param.msg}')
		
	}
	
	function valueCheck (e){
		e.preventDefault(); //기본이벤트 제거
		//유효성 체크
		const startDt = frmList.startDt;
		const endDt = frmList.endDt;
		console.log(startDt);
		console.log(endDt);
		if (startDt.value==''){
			alert('시작날짜를 입력해 주세요!');
			startDt.focus();
			return false;
		}else if (endDt.value==''){
			alert('종료날짜를 입력해 주세요!');
			endDt.focus();
			return false;
		}
	return true;//유효성체크 성공
	}
	
	
	//조회
	function listCheck(e) {
		e.preventDefault(); //기본이벤트 제거
	 	if(valueCheck()){
			frmList.action = '${path}/list.covid';
			frmList.submit();
		}
		
	}

	//파싱후 db저장
	function pasingSave(e){
		e.preventDefault(); //기본이벤트 제거
		//유효성 체크
		if(valueCheck()){
			frmList.action = '${path}/dbsave.covid';
			frmList.submit();
		}
	}
</script>
</head>
<body>
	<h2>코로나 확진자 현황</h2>
	<form  name = "frmList" action="${path}/list.covid">
		기간 <input type="date" name="startDt" value="${param.startDt}"> ~
			<input type="date" name="endDt" value="${param.endDt}">
		<button>조회</button>
		<button onclick="pasingSave(event)">db저장</button>
	
	</form>
 	
	
	<hr>
	<%-- ${clist} --%>

	<table border="1">
			<tr>
				<th>게시물번호</th>
				<th>기준일</th>
				<th>기준시간</th>
				<th>확진자수</th>
				<th>사망자수</th>
				<th>등록일시분초</th>
				<th>수정일시분초</th>
			</tr>
		
		
	
		<c:forEach var="covid" items="${clist}">
			<tr>
				<td>${covid.seq}</td>
				<td>${covid.stateDt}</td>
				<td>${covid.stateTime}</td>
				<td>${covid.decideCnt}</td>
				<td>${covid.deathCnt}</td>
				<td>${covid.createDt}</td>
				<td>${covid.updateDt}</td>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>