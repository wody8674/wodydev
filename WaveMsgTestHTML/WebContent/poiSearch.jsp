<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
{ "result" :
<%

// ��ȸ �����͸� ���� ��ü
List poiList = new ArrayList();

String reqPoiNmList = request.getParameter("requestPoiList");

StringBuffer poiBuf = new StringBuffer(reqPoiNmList);


//String[] poiNmList = reqPoiNmList.


%>

<%! // �޼��� ����

private String replace(String str, String rstr) {
	
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


private String[] split(String str, String c) {
	
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
	
	int len = retList.size();
	retData = new String[len];

	for (int i=len; i>0; i--) {
		retData[i-1] = (String) retList.get(len-i);
	}
	
	return retData;
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

/*
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
*/
%>
}
