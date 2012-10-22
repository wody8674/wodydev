<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
{ "result" :
<%

// 조회 데이터를 담을 객체
List poiList = new ArrayList();

String reqPoiNmList = request.getParameter("requestPoiList");

StringBuffer poiBuf = new StringBuffer(reqPoiNmList);


//String[] poiNmList = reqPoiNmList.


%>

<%! // 메서드 영역

private String replace(String str, String rstr) {
	
	// 1.3버전에서는 replace메서드에 스트링이 지원이 안되고 공백 치환이 안되기에
	// 아래와 같이 처리함
	StringBuffer strBuf = new StringBuffer(str);
	
	int index = str.lastIndexOf(rstr); // 결과가 없으면 -1 반환
	while (index >= 0) {
		str = strBuf.deleteCharAt(index).toString();
		index = str.lastIndexOf(rstr);
	}
	
	return strBuf.toString();
}


private String[] split(String str, String c) {
	
	int findex = str.lastIndexOf(c)+1; // 검색 시작 인덱스
	int lindex = str.length(); // 검색 마지막 인덱스
	
	StringBuffer strBuf = new StringBuffer(str);
	
	List retList = new ArrayList();
	String[] retData = {}; // 결과 데이터
	

	while (findex > 0) {
		
		if (findex != lindex) {
			String substr = strBuf.substring(findex);// 데이터 추출
			
			if (substr.trim().length() > 0) { // 데이터가 없으면 넣지 않는다.
				retList.add(substr);
			}
		}
		
		strBuf.delete(findex-1, lindex);
		
		
		lindex = findex;
		findex = strBuf.toString().lastIndexOf(c)+1;
	}
	
	if (strBuf.toString().trim().length() > 0) {
		retList.add(strBuf.toString()); // 마지막에 남은 데이터 추가
	}
	
	int len = retList.size();
	retData = new String[len];

	for (int i=len; i>0; i--) {
		retData[i-1] = (String) retList.get(len-i);
	}
	
	return retData;
}

private String[] split(StringBuffer strBuf, String c) {
	
	int findex = strBuf.lastIndexOf(c)+1; // 검색 시작 인덱스
	int lindex = strBuf.length(); // 검색 마지막 인덱스
	
	List retList = new ArrayList();
	String[] retData = {}; // 결과 데이터
	

	while (findex > 0) {
		
		if (findex != lindex) {
			String substr = strBuf.substring(findex);// 데이터 추출
			
			if (substr.trim().length() > 0) { // 데이터가 없으면 넣지 않는다.
				retList.add(substr);
			}
		}
		
		strBuf.delete(findex-1, lindex);
		
		
		lindex = findex;
		findex = strBuf.lastIndexOf(c)+1;
	}
	
	if (strBuf.toString().trim().length() > 0) {
		retList.add(strBuf.toString()); // 마지막에 남은 데이터 추가
	}
	
	int len = retList.size();
	retData = new String[len];

	for (int i=len; i>0; i--) {
		retData[i-1] = (String) retList.get(len-i);
	}
	
	return retData;
}

/*
private String[] split(StringBuffer strBuf, String c) {
	
	int findex = strBuf.lastIndexOf(c)+1; // 검색 시작 인덱스
	int lindex = strBuf.length(); // 검색 마지막 인덱스
	
	List retList = new ArrayList();
	String[] retData = {}; // 결과 데이터
	

	while (findex > 0) {
		
		if (findex != lindex) {
			String substr = strBuf.substring(findex);// 데이터 추출
			
			if (substr.trim().length() > 0) { // 데이터가 없으면 넣지 않는다.
				retList.add(substr);
			}
		}
		
		strBuf.delete(findex-1, lindex);
		
		
		lindex = findex;
		findex = strBuf.lastIndexOf(c)+1;
	}
	
	if (strBuf.toString().trim().length() > 0) {
		retList.add(strBuf.toString()); // 마지막에 남은 데이터 추가
	}
	
	int len = retList.size();
	retData = new String[len];

	for (int i=len; i>0; i--) {
		retData[i-1] = (String) retList.get(len-i);
	}
	
	return retData;
}
*/
%>
}
