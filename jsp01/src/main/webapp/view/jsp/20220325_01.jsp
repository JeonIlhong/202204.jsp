<!-- page 지시자 : jsp페이지의 속성 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#plus{
		color:green;
	}
	
	#minus{
		color:red;
	}
</style>

<script type="text/javascript">
	//alert('반가워! jsp');
</script>
</head>
<body>
	<h2>스크립틀릿</h2>
	<%
		/* 스크립틀릿은 자바로 동적인 웹페이지 구현 */
		/* System.out.println("헬로우 jsp"); */
		/* 톰캣(컨테이너) 이 자동으로 자바코드는 클래스(메소드)로 변환후 해석 +html 결합 후 
		응답을 보낸다. */
	
		//자바에서 dom을 다루기위한 내장객체
		out.println("dom에 출력 <br>");
		out.println("out객체는 dom을 다룰 수 있습니다<br>");
		out.println("<hr>");
		
		for(int i=1;i<11;i++){
			/* System.out.println(i); */
			out.print(i+"<br>");
		}
		
		out.println("<hr>");
		
		// 양수 음수 출력
		int a = 10;
		
		if(a<0){
			out.print("<span id='minus'>음수</span>");
		}else if(a==0){
			out.print("0");
		}else{
			out.print("<span id='plus'>양수</span>");
		}
		//조건문 ?이 참일때:거짓일때;
		String s = a>0?"양수":"음수";	
		
		
		
	%>

</body>
</html>