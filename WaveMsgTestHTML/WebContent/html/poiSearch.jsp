{ "result" : 
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@page import="hts.gis.poi.*"%>

<%
// ��ȸ �����͸� ���� ��ü
List poiList = new ArrayList();

String reqPoiNmList = request.getParameter("requestPoiList");
System.out.println(reqPoiNmList);

//reqPoiNmList = reqPoiNmList.replace('\n', ',');
//System.out.println(reqPoiNmList);

poiList = splitToList(reqPoiNmList, "\n");
System.out.println(poiList);

POIDetailInfo detail = null;
POIDetailInfoCollection collection = null;

POIMakerBean poiMaker = new POIMakerBean();
collection = poiMaker.searchPoiNameList(poiList);


if (collection != null) {
	detail = collection.get(0);
%>
	[{
		"poi_id" : "<%= detail.getID() %>",
		"poi_nm" : "<%= detail.getName().trim() %>",
		"x" : "<%= detail.getDisplayX() %>",
		"y" : "<%= detail.getDisplayY() %>",
		"addr" : "<%= detail.getAddress().trim() %>",
		"zip_cd" : "<%= detail.getEtcAddress() %>",
		"code" : "<%= detail.getClassCode().trim() %>",
	}
	
<%
	int collectionLen = collection.getCount();
	for (int i=1; i<collectionLen; i++) {
		detail = collection.get(i);
%>
		,{
		"poi_id" : "<%= detail.getID() %>",
		"poi_nm" : "<%= detail.getName().trim() %>",
		"x" : "<%= detail.getDisplayX() %>",
		"y" : "<%= detail.getDisplayY() %>",
		"addr" : "<%= detail.getAddress().trim() %>",
		"zip_cd" : "<%= detail.getEtcAddress() %>",
		"code" : "<%= detail.getClassCode().trim() %>",
		}
<%
	}
%>
	], "status" : "1" }
<%
} else {
%>
	"null", "status" : "0" }
<% 
}
%>


<%! // �޼��� ����

private String replaceSpace(String str, String rstr) {
	
	// 1.3���������� replace�޼��忡 ��Ʈ���� ������ �ȵǰ� ���� ġȯ�� �ȵǱ⿡
	// �Ʒ��� ���� ó����
	StringBuffer strBuf = new StringBuffer(str);
	
	int index = str.lastIndexOf(rstr); // ����� ������ -1 ��ȯ
	while (index >= 0) {
		str = strBuf.deleteCharAt(index).toString();
		index = str.lastIndexOf(rstr);
	}
	
	return strBuf.toString();
}


private List splitToList(String str, String c) {
	
	int findex = str.lastIndexOf(c)+1; // �˻� ���� �ε���
	int lindex = str.length(); // �˻� ������ �ε���
	
	StringBuffer strBuf = new StringBuffer(str);
	
	List retList = new ArrayList();
	String[] retData = {}; // ��� ������
	

	while (findex > 0) {
		
		if (findex != lindex) {
			String substr = strBuf.substring(findex);// ������ ����
			
			if (substr.trim().length() > 0) { // �����Ͱ� ������ ���� �ʴ´�.
				retList.add(substr);
			}
		}
		
		strBuf.delete(findex-1, lindex);
		
		
		lindex = findex;
		findex = strBuf.toString().lastIndexOf(c)+1;
	}
	
	if (strBuf.toString().trim().length() > 0) {
		retList.add(strBuf.toString()); // �������� ���� ������ �߰�
	}
	
	//int len = retList.size();
	//retData = new String[len];

	//for (int i=len; i>0; i--) {
		//retData[i-1] = (String) retList.get(len-i);
	//}
	
	return retList;
}

private String[] split(StringBuffer strBuf, String c) {
	
	int findex = strBuf.lastIndexOf(c)+1; // �˻� ���� �ε���
	int lindex = strBuf.length(); // �˻� ������ �ε���
	
	List retList = new ArrayList();
	String[] retData = {}; // ��� ������
	

	while (findex > 0) {
		
		if (findex != lindex) {
			String substr = strBuf.substring(findex);// ������ ����
			
			if (substr.trim().length() > 0) { // �����Ͱ� ������ ���� �ʴ´�.
				retList.add(substr);
			}
		}
		
		strBuf.delete(findex-1, lindex);
		
		
		lindex = findex;
		findex = strBuf.lastIndexOf(c)+1;
	}
	
	if (strBuf.toString().trim().length() > 0) {
		retList.add(strBuf.toString()); // �������� ���� ������ �߰�
	}
	
	int len = retList.size();
	retData = new String[len];

	for (int i=len; i>0; i--) {
		retData[i-1] = (String) retList.get(len-i);
	}
	
	return retData;
}

%>

