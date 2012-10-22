$(document).ready(function() {
	// 버튼 클릭시 서버에 데이터 요청(함수 등록)
	$("#submitBtn").click(submit);
	
	$("#searchList").html("");
	
});


// 데이터 요청을 위한 메서드
function submit() {

	var poiNmList = $("#searchList").html();
	poiNmList = $.trim(poiNmList);
	$("div#jsonDataLoading").show();
	
	$.ajax({
		type: "POST",
		url: "poiSearch.jsp",
		cache: false,
		format: "text",
		data: "requestPoiList="+poiNmList,
		success: function(msg) {
			callBack(msg, "success");
			$("div#jsonDataLoading").hide();
		},
		error: function(msg) {
			alert("error : "+msg);
			$("div#jsonDataLoading").hide();
		}
	});
}

// 전달할 데이터를 파싱
function dataParse() {

}

// 결과
function callBack(retDt, result) {
	
	var data = eval('('+retDt+')'); // json형태의 문자열을 객체화 
	var $tbody = $("#tBody"); // 테이블
	
	if (result == "success") {
		
		if (data.status == "1") {
			
			$tbody.html(""); // 안의 모든 데이터 삭제
			var len = data.result.length; //결과 데이터 길이
			
			for (var i=0; i<len; i++) {
				
				var classnm = "tr_true";
				if (data.result[i].code == "FALSE") {
					classnm = "tr_false";
				}
				
				var retTab = "";
				retTab += "<tr class='"+classnm+"'>";
				retTab += "	<td id='poi_id' class='poi_tab'>" + data.result[i].poi_id + "<input type='hidden' id='viewFlag' value='0'>" + "</td>";
				retTab += "	<td id='poi_nm' class='poi_tab'>" + data.result[i].poi_nm + "</td>";
				retTab += "	<td id='poi_x' class='poi_tab'>" + data.result[i].x + "</td>";
				retTab += "	<td id='poi_y' class='poi_tab'>" + data.result[i].y + "</td>";
				retTab += "	<td id='poi_addr' class='poi_tab'>" + data.result[i].zip_cd + " " + data.result[i].addr + "</td>";
				retTab += "</tr>";
				
				$tbody.append(retTab);
			}

			setPoiPoint(data);
		}
	}
	
	var $list = $("#tBody tr");
	//var clickChk = $("#tBody tr #viewFlag").val();
	
	// 마우스가 리스트를 지나다닐 때 푸른색으로 표시
	// 만약 선택된 리스트가 있다면 마우스가 올라가있을 때 푸른색 마우스가 떠나면 녹색으로 표시
	$list.hover(
		function() {
			$(this).css("background-color","#c1ebff");
		}, 
		function() {
			if ($(this).children("td#poi_id").children("#viewFlag").val() == 0) {
				$(this).css("background-color","white");
			} else {
				$(this).css("background-color","#c1eb00");
			}
		}
	);
	
	// 마우스로 리스트를 클릭하여 맵 이동하고 선택된 리스트에 하이라이트를 준다.
	// 클릭 여부는 input의 viewFlag 의 값에 결정
	// 0 : 선택 안됨
	// 1 : 선택 됨
	$list.click(function() {
		
		$(this).parent().children("tr").each(function(i) {
			$(this).css("background-color","white");
			$(this).children("td#poi_id").children("#viewFlag").attr("value", "0");
		});
		
		$(this).css("background-color","#c1eb00");
		$(this).children("td#poi_id").children("#viewFlag").attr("value", "1");
		
		var x = $(this).children("#poi_x").html();
		var y = $(this).children("#poi_y").html();

		if (x == "0.0" || y == "0.0") {
			alert("이동할 수 없습니다.");
		} else {
			setPoiCenter(x, y);
		}
	});
	
	
}

