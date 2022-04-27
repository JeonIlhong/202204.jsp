<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 주말과제 -->
	
	아이디,비밀번호,이메일,이름,성별(radio),가입경로(select),
	알바가능시간대(checkbox): 오전,오후,저녁,새벽(다수 선택 가능)
	
	버튼을 눌렀을 때 결과창에 가입정보 출력 
	<h2>회원가입</h2>
	
<form action="20220325_10_result.jsp" method="post">
	<fieldset>
	<legend>기본정보</legend>
		아이디: <input type="text" name="userid"> <br>
		비밀번호: <input type="password" name="userpasswd"> <br>
		이메일: <input type="email" name="email"> <br>
		이름: <input type="text" name="username"> <br>
	</fieldset>
	
	
	<fieldset>
		<legend>성별</legend>
		남<input type="radio" name="gender" value="남성">
		여<input type="radio" name="gender" value="여성">
		
		
	</fieldset>
		
	<fieldset>
		<legend>가입경로</legend>
		<select name="reason">
			<option value="인터넷 광고">인터넷 광고</option>
			<option value="홍보문자">홍보문자</option>
			<option value="지인의 소개">지인의 소개</option>
			<option value="TV광고">TV광고</option>
		
		</select>
	</fieldset>	
	
	<fieldset>
		<legend>알바 가능 시간대(복수선택가능)</legend>
		<input type="checkbox" name="time" value="오전">오전
		<input type="checkbox" name="time" value="오후">오후
		<input type="checkbox" name="time" value="야간">야간
	</fieldset>
		
		<button>가입</button>
		<button type="reset">취소</button>
</form>

</body>
</html>