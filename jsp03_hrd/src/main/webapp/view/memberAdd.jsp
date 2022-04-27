<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

//메시지 창 띄우기
alert('<%=request.getParameter("msg")%>')

	function joinCheck() {
		var custname = frmJoin.custname
		var phone = frmJoin.phone
		var address = frmJoin.address
		var joindate = frmJoin.joindate
		var grade = frmJoin.grade
		var city = frmJoin.city
		
		if(custname.value ==''){
			alert('회원성명을 입력해주세요.');
			custname.focus();
		}
		else if(phone.value ==''){
			alert('전화번호를 입력해주세요.');
			phone.focus();
		}
		else if(address.value ==''){
			alert('주소를 입력해주세요.');
			address.focus();
		}
		else if(joindate.value ==''){
			alert('가입일자를 입력해주세요.');
			joindate.focus();
		}
		else if(grade.value ==''){
			alert('회원등급을 입력해주세요.');
			grade.focus();
		}
		else if(city.value ==''){
			alert('도시코드를 입력해주세요.');
			city.focus();
		}else {
			frmJoin.action='/jsp03_hrd/member/join';
			frmJoin.method='post';
			frmJoin.submit();
		}
		
		
	}

</script>

</head>
<body>
<%@include file="header.jsp" %>
	<section>
		<h2>홈쇼핑 회원 등록</h2>
		<form  name="frmJoin">
			<table border="1">
			<tr>
			<td>회원번호(자동발생) <input type="number" name ="custno" readonly> </td>
			</tr>
			<tr>
			<td>회원성명 <input type="text" name ="custname"> </td>
			</tr>
			<tr>
			<td>회원전화 <input type="text" name ="phone"> </td>
			</tr>
			<tr>
			<td>회원주소 <input type="text" name ="address"> </td>
			</tr>
			<tr>
			<td>가입일자 <input type="date" name ="joindate"> </td>
			</tr>
			<tr>
			<td>고객등급 
			<select name="grade">
				<option value="A">A:VIP</option>
				<option value="B">B:일반</option>
				<option value="C">C:직원</option>
			</select> </td>
			</tr>
			<tr>
			<td>도시코드 <input type="text" name ="city"> </td>
			</tr>
			<tr>
			<td colspan="2"><button  type="button" onclick="joinCheck()" >가입</button>
			<button>조회</button></td>
			</tr>
		
			
			</table>
		</form>
		
		
	</section>
	<%@include file="footer.jsp" %>
</body>
</html>