var oSeoulCityPoint = new nhn.api.map.LatLng(37.5675451, 126.9773356);
var defaultLevel = 10;
nhn.api.map.setDefaultPoint('LatLng');
var oMap = new nhn.api.map.Map(document.getElementById('mapDiv'), { 
				point : oSeoulCityPoint,
				zoom : defaultLevel,
				enableWheelZoom : true,
				enableDragPan : true,
				enableDblClickZoom : false,
				mapMode : 0,
				activateTrafficMap : false,
				activateBicycleMap : false,
				minMaxLevel : [ 1, 14 ],
				size : new nhn.api.map.Size(1200, 700)		});
var oSlider = new nhn.api.map.ZoomControl();
oMap.addControl(oSlider);
oSlider.setPosition({
	top : 10,
	left : 10
});

var oSize = new nhn.api.map.Size(28, 37);
var oOffset = new nhn.api.map.Size(14, 37);
var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset); // 마커


/*
 * 조회 된 자표를 맵에 표시 함수
 */		
function setPoiPoint(pointData) {
	
	var len = pointData.result.length; //결과 데이터 길이
	
	for (var i=0; i<len; i++) {
		
		if (pointData.result[i].code == "TRUE") {
			
			var point = new nhn.api.map.LatLng(pointData.result[i].y, pointData.result[i].x);
			nhn.api.map.setDefaultPoint('LatLng');
			var oLabel1 = new nhn.api.map.MarkerLabel(); 
			oMap.addOverlay(oLabel1);
			
			var marker = new nhn.api.map.Marker(oIcon, {title : pointData.result[i].poi_nm + "("+pointData.result[i].poi_id+")"});
			marker.setPoint(point);
			oMap.addOverlay(marker);
			
			oLabel1.setVisible(true, marker); // 마커 라벨 보이기
		}
	}
}

/*
 * 리스트 클릭 시 지도 이동
 */
function setPoiCenter(x, y) {
	var point = new nhn.api.map.LatLng(y, x);
	oMap.setCenter(point, {
		useEffect: true,
		centerMark: false
	});
	
}



