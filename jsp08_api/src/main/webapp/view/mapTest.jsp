<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>간단한 지도 표시하기</title>
    <script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=8v1ski8n6m"></script>
<script>
	function mapMake() {
		var mapOptions = {
			    center: new naver.maps.LatLng(37.3595704, 127.105399), // LatLng () 안의 값 변수로 받으면 될듯
			    zoom: 15
			};
			
			var map = new naver.maps.Map('map', mapOptions);
			
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(37.3595704, 127.105399), //위에꺼를 그대로 받으면 마커표시 됨
			    map: map
			});
	}

		

</script>
</head>
<body onload="mapView()">
<div id="map" style="width:100%;height:400px;"></div>


</body>
</html>