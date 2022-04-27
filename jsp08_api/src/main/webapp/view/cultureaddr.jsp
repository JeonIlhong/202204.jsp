<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=8v1ski8n6m"></script>
<script>
	function mapMake() {
		//geomap이 null일 경우
		if ('${geomap}'=='') {
			document.getElementById('map').innerHTML = '지도 정보가 없습니다.';
			var x = 0;
			var y = 0;
			return;
		}else {
			var x = '${geomap.x}';
			var y = '${geomap.y}';
		}
		
		
		var mapOptions = {
			    center: new naver.maps.LatLng(${geomap.y}, ${geomap.x}), // LatLng () 안의 값 변수로 받으면 될듯
			    zoom: 15
			};
			
			var map = new naver.maps.Map('map', mapOptions);
			
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(${geomap.y}, ${geomap.x}), //위에꺼를 그대로 받으면 마커표시 됨
			    map: map
			});
	}

		

</script>
</head>
<body onload="mapMake()">
	<h2>서울시 문화위치정보 명칭 검색</h2>
	<form action="${path}/addr.culture">
		명칭 <input type="text" name="name" value="${param.name}">
		<button>검색</button>
		
	</form>
	
	<hr>
		<%-- ${cmap} --%>
	<table border="1">
		<tr>
			<th>FAC코드</th>
			<td>${cmap.FAC_CODE}</td>
		</tr>
		<tr>
			<th>제목코드</th>
			<td>${cmap.SUBJCODE}</td>
		</tr>
		<tr>
			<th>FAC이름</th>
			<td>${cmap.FAC_NAME}</td>
		</tr>
		<tr>
			<th>코드분류</th>
			<td>${cmap.CODENAME}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${cmap.ADDR}</td>
		</tr>
		
	
	</table>
		
		<hr>
		
		
	<!-- 지도표시위치 -->	
	<div id="map" style="width:70%;height:300px; margin:auto"></div>	
</body>
</html>