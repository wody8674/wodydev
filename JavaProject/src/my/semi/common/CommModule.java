package my.semi.common;

import org.apache.log4j.Logger;

/**
 * �α� ���� �� ȭ�鿡 ����� ���¸� ����� Ŭ����
 * @author Jeong Jae Yo
 * @since 1.7
 */
public class CommModule {

	/* �α׸� ���� Ŭ���� */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param strIntData ������ ������
	 * @param padData ä�� ������
	 * @param size ä�� ũ��
	 * @param padType L:�������� ä��, R:���������� ä��
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData, String padData, int size, String padType) throws Exception {

		logger.debug("[displayInt START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("strIntData : " + strIntData);
		logger.debug("padData : " + padData);
		logger.debug("size : " + size);
		logger.debug("padType : " + padType);
		logger.debug("Parameter data End : -----------------------------");
		
		/* int�� �������� ������ ũ�� (ä�� ũ��) */
		int dataSize = size - strIntData.length();
		logger.debug("dataSize : " + dataSize);
		
		/* �����͸� ä�� ���� */
		StringBuilder strBuilder = new StringBuilder();

		// ���� �������� �տ� int���� ũ��(�ִ� 32bit) ��ŭ ä�� ������ ����
		for (int i = 0; i < dataSize; i++) {
			strBuilder.append(padData);
		}
		logger.debug("strBuilder : " + strBuilder.toString());

		// �ϼ��� ������ ����
		switch (padType) {
		case "R":
			strIntData = strIntData + strBuilder.toString();
			logger.debug("strIntData : " + strIntData);
			break;
		default:
			strIntData = strBuilder.toString() + strIntData;
			logger.debug("strIntData : " + strIntData);
			break;
		}
		
		logger.debug("RESULT : " + formatInt(strIntData, size));
		logger.debug("[displayInt END]========================================================================================================================");

		// int���¸� Ȯ���ϱ� ���� ���⸦ �����Ͽ� ��ȯ��
		return formatInt(strIntData, size);
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param strIntData ������ ������
	 * @param padData ä�� ������
	 * @param size ä�� ũ��
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData, String padData, int size) throws Exception {
		return displayInt(strIntData, padData, 32, "L");
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param intData ������ ������
	 * @param padData ä�� ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(int intData, String padData) throws Exception {
		return displayInt(Integer.toBinaryString(intData), padData, 32);
	}

	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param intData ������ ������
	 * @param padData ä�� ������
	 * @param size ä�� ũ��
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(int intData, String padData, int size) throws Exception {
		return displayInt(Integer.toBinaryString(intData), padData, size);
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param intData ������ ������
	 * @param padData ä�� ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData, String padData) throws Exception {
		return displayInt(strIntData, padData, 32);
	}

	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param intData ������ ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(int intData) throws Exception {
		return displayInt(Integer.toBinaryString(intData), "0", 32);
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * @param strIntData ������ ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData) throws Exception {
		return displayInt(strIntData, "0", 32);
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼��� 
	 * byte�� ���� ����(����)
	 * @param strIntData ������ ������
	 * @param padData ä�� ������
	 * @param size ä�� ũ��
	 * @param padType L:�������� ä��, R:���������� ä��
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData, String padData, int size, String padType) throws Exception {

		
		logger.debug("[displayIntNoSpace START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("strIntData : " + strIntData);
		logger.debug("padData : " + padData);
		logger.debug("size : " + size);
		logger.debug("padType : " + padType);
		logger.debug("Parameter data End : -----------------------------");
		
		/* int�� �������� ������ ũ�� (ä�� ũ��) */
		int dataSize = size - strIntData.length();
		logger.debug("dataSize : " + dataSize);

		/* �����͸� ä�� ���� */
		StringBuilder strBuilder = new StringBuilder();

		// ���� �������� �տ� int���� ũ��(�ִ� size bit) ��ŭ ä�� ������ ����
		for (int i = 0; i < dataSize; i++) {
			strBuilder.append(padData);
		}
		logger.debug("strBuilder : " + strBuilder.toString());

		// �ϼ��� ������
		switch (padType) {
		case "R":
			strIntData = strIntData + strBuilder.toString();
			logger.debug("strIntData : " + strIntData);
			break;
		default:
			strIntData = strBuilder.toString() + strIntData;
			logger.debug("strIntData : " + strIntData);
			break;
		}

		logger.debug("RESULT : " + strIntData);
		logger.debug("[displayIntNoSpace END]========================================================================================================================");
		
		// int���¸� Ȯ���ϱ� ���� ���⸦ �����Ͽ� ��ȯ��
		return strIntData;
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼��� 
	 * byte�� ���� ����(����)
	 * @param strIntData ������ ������
	 * @param padData ä�� ������
	 * @param size ä�� ũ��
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData, String padData, int size) throws Exception {
		return displayIntNoSpace(strIntData, padData, size, "L");
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * byte�� ���� ����(����)
	 * @param intData ������ ������
	 * @param padData ä�� ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(int intData, String padData) throws Exception {
		return displayIntNoSpace(Integer.toBinaryString(intData), padData, 32);
	}

	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * byte�� ���� ����(����)
	 * @param intData ������ ������
	 * @param padData ä�� ������
	 * @param size ä�� ũ��
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(int intData, String padData, int size) throws Exception {
		return displayIntNoSpace(Integer.toBinaryString(intData), padData, size);
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * byte�� ���� ����(����)
	 * @param intData ������ ������
	 * @param padData ä�� ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData, String padData) throws Exception {
		return displayIntNoSpace(strIntData, padData, 32);
	}

	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * byte�� ���� ����(����)
	 * @param intData ������ ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(int intData) throws Exception {
		return displayIntNoSpace(Integer.toBinaryString(intData), "0", 32);
	}
	
	/**
	 * int�� ������ũ�⸸ŭ ä��� �޼���
	 * byte�� ���� ����(����)
	 * @param strIntData ������ ������
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData) throws Exception {
		return displayIntNoSpace(strIntData, "0", 32);
	}
	
	/**
	 * �����Ͱ� 1���� �����ϵ��� ���� 0 ����
	 * @param dataString ���� ������
	 * @return String ���� 0�� ���ŵ� String ������
	 */
	public String delFrontZero(String dataString) {
		
		logger.debug("[delFrontZero START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* String �����͸� �����ϱ� ���� StringBuilder��ü ���� */
		StringBuilder strBuilder = new StringBuilder(dataString);

		// ������ �ϳ��� Ȯ���ϸ鼭 ���� 0 ����
		int strLen = strBuilder.length();
		logger.debug("strLen : " + strLen);
		for (int i=0; i<strLen; i++) {
			
			// ù �����ͺ��� 0���� Ȯ���Ͽ� �����ϰ� ���� 1�� ������ �״�� ����
			if (strBuilder.charAt(i) == '0') {
				strBuilder.deleteCharAt(i); // �ش� index�� ������ ����
			} else {
				break; // ù��° bit�� 1�� ��� �������� ��������
			}
		}
		
		logger.debug("RESULT : " + strBuilder.toString());
		logger.debug("[delFrontZero END]========================================================================================================================");
		
		return strBuilder.toString();
	}
	
	/**
	 * �����Ͱ� 1���� �����ϵ��� ���� 0 ����
	 * @param dataString ���� ������
	 * @return int ���ŵ� 0�� Count�� 
	 */
	public int delFrontZero(StringBuilder dataString) {

		logger.debug("[delFrontZero START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* ������ 0�� ���ڸ� ����ϱ� ���� ���� */
		int i = 0;
		
		// ������ �ϳ��� Ȯ���ϸ鼭 ���� 0 ����
		int strLen = dataString.length();
		logger.debug("strLen : " + strLen);
		for (i=0; i<strLen; i++) {
			
			// ù �����ͺ��� 0���� Ȯ���Ͽ� �����ϰ� ���� 1�� ������ �״�� ����
			if (dataString.charAt(i) == '0') {
				dataString.deleteCharAt(i); // �ش� index�� ������ ����
			} else {
				break; // ù��° bit�� 1�� ��� �������� ��������
			}
		}
		
		logger.debug("RESULT : " + (i-1));
		logger.debug("[delFrontZero END]========================================================================================================================");
		
		return i-1;
	}
	
	
	/**
	 * 1byte ������ ����
	 * @param strIntData ������ ������
	 * @param size ��ü �������� ũ��
	 * @return String
	 * @throws Exception 
	 */
	public String formatInt(String strIntData, int size) throws Exception {
		
		logger.debug("[formatInt START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("strIntData : " + strIntData);
		logger.debug("size : " + size);
		logger.debug("Parameter data End : -----------------------------");
		
		// byte������ ���⸦ �ؾ��ϱ� ������ 8�� ����� �ƴϸ� ����ó��
		logger.debug("size%8 : " + size%8);
		if (size%8 != 0) throw new Exception("size�� byteũ�� �������� �մϴ�. (8�� ���)");
		
		/* ���⸦ ����ؾ� �ϴ����� ���� �� ���� (size�κ���) */
		int roofSize = size/8;
		logger.debug("roofSize : " + roofSize);
		
		/* ���� ���ڿ�(bit������)�� byte������ �߶� ���Ⱑ ����� ���ڿ��� ���� ��ü */
		StringBuilder strBuilder = new StringBuilder();
		
		// ù�� ° ������ ����
		strBuilder.append(strIntData.substring(0, 8));
		
		// ������ �κ��� �տ� �� �������� ä���.
		for (int i = 1; i < roofSize; i++) {
			strBuilder.append(" " + strIntData.substring(i * 8, (i + 1) * 8));
		}

		logger.debug("RESULT : " + strBuilder.toString());
		logger.debug("[formatInt END]========================================================================================================================");
		
		return strBuilder.toString();
	}
	
	/**
	 * ���ڿ��� binary���ڿ��� ��ȯ
	 * @param strData ��ȯ�� ������
	 * @return String ������ binary ���ڿ�
	 * @throws Exception 
	 */
	public String strTobinary(String strData) throws Exception {
		
		logger.debug("[strTobinary START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("strData : " + strData);
		logger.debug("Parameter data End : -----------------------------");
		
		/* ���ڿ��� byte�迭�� ��ȯ */
		byte[] bData = strData.getBytes();
		
		/* binary���ڿ� ���� ���� */
		StringBuilder strByteBuiler = new StringBuilder();
		
		// binary ���ڿ��� ��� �����Ѵ�.
		for (int iData : bData) {
			strByteBuiler.append(displayIntNoSpace(Integer.toBinaryString(iData&0xFF), "0", 8));
		}
		
		logger.debug("RESULT : " + strByteBuiler.toString());
		logger.debug("[formatInt END]========================================================================================================================");
		
		return strByteBuiler.toString();
	}
}
