$(document).ready(function() {
	// ��ư Ŭ���� ������ ������ ��û(�Լ� ���)
	$("#submitBtn").click(submit);
	
	$("#searchList").html("");
	
});


// ������ ��û�� ���� �޼���
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

// ������ �����͸� �Ľ�
function dataParse() {

}

// ���
function callBack(retDt, result) {
	
	var data = eval('('+retDt+')'); // json������ ���ڿ��� ��üȭ 
	var $tbody = $("#tBody"); // ���̺�
	
	if (result == "success") {
		
		if (data.status == "1") {
			
			$tbody.html(""); // ���� ��� ������ ����
			var len = data.result.length; //��� ������ ����
			
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
	
	// ���콺�� ����Ʈ�� �����ٴ� �� Ǫ�������� ǥ��
	// ���� ���õ� ����Ʈ�� �ִٸ� ���콺�� �ö����� �� Ǫ���� ���콺�� ������ ������� ǥ��
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
	
	// ���콺�� ����Ʈ�� Ŭ���Ͽ� �� �̵��ϰ� ���õ� ����Ʈ�� ���̶���Ʈ�� �ش�.
	// Ŭ�� ���δ� input�� viewFlag �� ���� ����
	// 0 : ���� �ȵ�
	// 1 : ���� ��
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
			alert("�̵��� �� �����ϴ�.");
		} else {
			setPoiCenter(x, y);
		}
	});
	
	
}

