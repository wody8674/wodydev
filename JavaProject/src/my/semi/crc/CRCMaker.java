package my.semi.crc;

import org.apache.log4j.Logger;

import my.semi.common.CommModule;

/**
 * CRC-8 ��ȯ
 * @author Jeong Jae Yo
 * @since 1.7
 *
 */
public class CRCMaker {

	/* �α׸� ���� Ŭ���� */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/* ���� �Լ� ��� */
	CommModule comModule = new CommModule();

	/**
	 * CRC-8 �ڵ� ���� 
	 * @param dataString �ڵ� ������ ������ (body)
	 * @param type 0:���� ����, 1:���̺� ������ 
	 * @param redix 2:dataString�� 2����, 10:dataString�� 10����, ��Ÿ:byte�迭�� ��ȯ �� binary���ڿ��� ���
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeCrcCode(String dataString, int type, int redix) throws Exception {
		
		logger.debug("[makeCrcCode START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("type : " + type);
		logger.debug("redix : " + redix);
		logger.debug("Parameter data End : -----------------------------");
		
		/* CRC �ڵ� */
		String crcCode = "";
		
		// 2������ ��� �ٷ� ���
		// 10������ ��� binary�� ��ȯ �� ���
		// ��Ÿ�� ��� String�� byte�迭�� ��ȯ �� binary ���ڿ��� ��ȯ
		switch (redix) {
		case 2:
			break;
		case 10:
			dataString = Integer.toBinaryString(Integer.parseInt(dataString));
			break;
		default:
			dataString = comModule.strTobinary(dataString); 
			break;
		}
		
		// type�� 1�̸� ���̺� ���������� �� ���� ���� ���� �������� ���Ѵ�.  
		switch (type) {
		case 1:
			crcCode = makeTableCal(dataString); // ���̺� ������
			break;
		default:
			crcCode = makeDirectCal(dataString); // ���� ����
			break;
		}
		
		logger.debug("RESULT : " + crcCode);
		logger.debug("[makeCrcCode END]========================================================================================================================");
		
		return crcCode;
	}
	
	/**
	 * CRC-8 �ڵ� ���� 
	 * @param dataString �ڵ� ������ ������ (body)
	 * @param type 0:���� ����, 1:���̺� ������ 
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeCrcCode(String dataString, int type) throws Exception {
		return makeCrcCode(dataString, type, 0);
	}
	
	/**
	 * CRC-8 �ڵ� ���� 
	 * �⺻���� ���� �������� ���
	 * @param dataString �ڵ� ������ ������ (body)
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeCrcCode(String dataString) throws Exception {
		return makeCrcCode(dataString, 0);
	}
	
	/**
	 * CRC-8 �ڵ� ���� 
	 * @param dataString �ڵ� ������ ������ (body)
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeCrcCode(int dataString) throws Exception {
		return makeCrcCode(Integer.toBinaryString(dataString), 0, 2);
	}
	
	/**
	 * CRC-8 �ڵ� ���� 
	 * @param dataString �ڵ� ������ ������ (body)
	 * @param type 0:���� ����, 1:���̺� ������ 
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeCrcCode(int dataString, int type) throws Exception {
		return makeCrcCode(Integer.toBinaryString(dataString), type, 2);
	}
	
	/**
	 * CRC-8 �ڵ� ���� 
	 * @param dataString �ڵ� ������ ������ (body)
	 * @param type 0:���� ����, 1:���̺� ������ 
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String makeCrcCode(String dataString, String type) throws NumberFormatException, Exception {
		return makeCrcCode(dataString, Integer.parseInt(type));
	}
	
	/**
	 * CRC-8 �ڵ� ���� 
	 * @param dataString �ڵ� ������ ������ (body)
	 * @param type 0:���� ����, 1:���̺� ������ 
	 * @param redix 2:dataString�� 2����, 10:dataString�� 10����, ��Ÿ:byte�迭�� ��ȯ �� binary���ڿ��� ���
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String makeCrcCode(int dataString, int type, int redix) throws NumberFormatException, Exception {
		return makeCrcCode(Integer.toBinaryString(dataString), type, redix);
	}
	
	/**
	 * ���� �������� ���� CRC�ڵ�
	 * @param dataString �ڵ� ������ ������ (body)
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeDirectCal(String dataString) throws Exception {
		
		logger.info("");
		logger.info("[makeDirectCal START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* ��� �� ���׽� ǥ�� C(x) = x^8 + x^2 + x + 1 = 100000111 */
		String polynomial = "100000111";
		
		/* ���� ��ü �������� �� ���� */
		int dataStringLength = dataString.length();
		logger.debug("dataStringLength : " + dataStringLength);
		
		/* 8byte�� ������ �� �� ���� */
		int dataStrFulSize = 0;
		
		// ���̸� 8�� ����� ���߱� ���� ����
		if (dataStringLength%8 == 0) {
			dataStrFulSize = dataStringLength; // �������� 0�� ��� �߰� ������ ���� ����
		} else {
			dataStrFulSize = dataStringLength+(8-(dataStringLength%8)); // �������� 0�� �ƴ� ���
		}
		logger.debug("dataStrFulSize : " + dataStrFulSize);

		logger.info("  �ڷ��Ʈ : " + comModule.formatInt(dataString, dataStrFulSize));
		
		// �����͸� 8bit ������ ���� ����
		dataString = comModule.displayIntNoSpace(dataString, "0", dataStrFulSize);
		logger.debug("dataString : " + dataString);
		
		/* ����� ���� ������ */ 
		String resultData = dataString + "00000000"; // �����Ϳ� CRC�ڵ尡 �� 8bit zero�����ͷ� ���� Ȯ��
		logger.debug("resultData : " + resultData);
		
		logger.info("  ���� ������ ���� ��ȯ : " + comModule.formatInt(resultData, dataStrFulSize+8));
		logger.info("");
		
		/* ����� ���� �տ� 9bit �߶� ���� ���� */
		String resultCalData = "";
		
		/* ��Ʈ�� ��� ���� StringBuilder ���� */
		StringBuilder strTempBuilder = new StringBuilder(resultData);
		
		// ��� ���� ���̰� 8���� ũ�� �������
		// 8���� ���� ���� CRC�ڵ尡 �ȴ�.
		while (resultData.length() > 8) {
			
			/* �α׿��� ������ ��ġ�� ��� ���� ���̸� ���� */
			int strDataLen = strTempBuilder.length();
			logger.debug("strDataLen : " + strDataLen);
			
			// �������� ù ��Ʈ�� 0�� ��� 1�� ���ö� ���� ��� ����
			comModule.delFrontZero(strTempBuilder);
			
			// ���� 9�ڸ� �����͸� �߶󳻴� ����
			resultCalData = strTempBuilder.substring(0, 9);
			strTempBuilder.delete(0, 9); // �����͸� ���������ν� �߶󳻴� ȿ��
			logger.debug("resultCalData : " + resultCalData);
			
			logger.info("  " + resultCalData+strTempBuilder.toString());
			logger.info("  " + polynomial);
			logger.info("  -----------------------------------------");
			
			// ���� ������ xor���� ����
			// �����ϸ鼭 �ڵ����� ���� 0�����ʹ� ������
			resultCalData = Integer.toBinaryString((Integer.parseInt(resultCalData, 2)&0xFF)^(Integer.parseInt(polynomial, 2)&0xFF));
			logger.debug("resultCalData : " + resultCalData);
			
			// ���� �κ��� �ٽ� �̾����
			resultData = strTempBuilder.insert(0, resultCalData).toString();
			logger.debug("resultData : " + resultData);
			
			logger.info("  " + comModule.displayIntNoSpace(resultData, "0", strDataLen));
			logger.info("");
			
		}
		
		logger.info("");
		logger.info("[makeDirectCal END]========================================================================================================================");
		
		// 8bit �ڸ����� ���� �� ��ȯ
		return comModule.displayIntNoSpace(resultData, "0", 8);
	}
	
	/**
	 * ���̺� ���������� ���� CRC�ڵ�
	 * @param dataString �ڵ� ������ ������ (body)
	 * @return String CRC�ڵ�
	 * @throws Exception 
	 */
	public String makeTableCal(String dataString) throws Exception {
		
		logger.info("");
		logger.info("[makeTableCal START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* CRC ���̺� �˻� ��ü */
		CRCTable crcTable = new CRCTable();
		
		/* ���̺� �������� ���� ù index�� ���� = 00000000 */
		String tableIndex = "00000000";
		
		/* ���� ��ü �������� �� ���� */
		int dataStringLength = dataString.length();
		logger.debug("dataStringLength : " + dataStringLength);
		
		/* 8byte�� ������ �� �� ���� */
		int dataStrFulSize = dataStringLength+(8-(dataStringLength%8));
		if (dataStringLength%8 == 0) dataStrFulSize = dataStringLength; // �������� ���̰� 8�� ����� ���
		logger.debug("dataStrFulSize : " + dataStrFulSize);
		
		logger.info("  �ڷ��Ʈ : " + comModule.formatInt(dataString, dataStrFulSize));
		logger.info("");
		
		// �����͸� 8bit ������ ���� ����
		dataString = comModule.displayIntNoSpace(dataString, "0", dataStrFulSize);
		
		/* ��Ʈ�� ��� ���� StringBuilder ���� */
		StringBuilder strTempBuilder = new StringBuilder(dataString);
		
		/* ����� ���� �տ� 9bit �߶� ���� ���� */
		String resultCalData = "";
		
		// �տ��� ���� byte ������ �߶� index ������ ���� �� CRC ���̺��� �˻�
		while (strTempBuilder.length() >= 8) {
			
			// ���� 8�ڸ� �����͸� �߶󳻴� ����
			resultCalData = strTempBuilder.substring(0, 8);
			strTempBuilder.delete(0, 8); // �����͸� ���������ν� �߶󳻴� ȿ��
			logger.debug("resultCalData : " + resultCalData);
			
			logger.info("");
			logger.info("  " + resultCalData+strTempBuilder.toString());
			logger.info("  " + tableIndex);
			logger.info("  -----------------------------------------");
			
			// ���� ������ xor���� ����
			// �����ϸ鼭 �ڵ����� ���� 0�����ʹ� ������
			tableIndex = Integer.toBinaryString((Integer.parseInt(resultCalData, 2)&0xFF)^(Integer.parseInt(tableIndex, 2)&0xFF));
			logger.debug("tableIndex : " + tableIndex);
			
			logger.info("  " + comModule.displayIntNoSpace(tableIndex, "0", 8));
			logger.info("");
			logger.info("  ���̺� ��ȸ : " + comModule.displayIntNoSpace(tableIndex, "0", 8) + " -> ");
			
			// CRC ���̺��� ������ ��ȸ
			tableIndex = crcTable.getCrcCode(tableIndex);
			logger.debug("tableIndex : " + tableIndex);
			
			logger.info("  ���̺� ��� : " + comModule.displayIntNoSpace(tableIndex, "0", 8));
		}
		
		logger.info("  [RESULT] : " + tableIndex);
		
		logger.info("");
		logger.info("[makeTableCal END]========================================================================================================================");
		
		return comModule.displayIntNoSpace(tableIndex, "0", 8);
	}
	
	/**
	 * ������ ���� üũ (CRC)
	 * @param checkData �˻��� ������
	 * @param checkType 0 : ���� ����, 1 : ���̺� ������
	 * @return int 0 : Success, -1 : Fail
	 */
	public int checkPacketError(String checkData, String checkType, int errorGeneratedCode) {
		
		logger.info("");
		logger.info("[checkPacketError START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("checkData : " + checkData);
		logger.debug("checkType : " + checkType);
		logger.debug("Parameter data End : -----------------------------");
		logger.info("   �Է¹��� ������ : " + checkData);
		
		int iResult = -1;
		
		/* ������üũ�� ���� StringBuilder ��ü ���� */
		StringBuilder strChkBuilder = new StringBuilder(checkData);
		
		/* �����Ϳ��� CRC�ڵ� ���� */
		String chkDataCrcCode = strChkBuilder.substring(strChkBuilder.length()-8);
		logger.debug("chkDataCrcCode : " + chkDataCrcCode);
		
		logger.info("   ����� CRC�ڵ� : " + chkDataCrcCode);
		
		// CRC �ڵ� ����
		strChkBuilder.delete(strChkBuilder.length()-8, strChkBuilder.length());
		logger.debug("strChkBuilder : " + strChkBuilder.toString());
		
		if (errorGeneratedCode == 1) {
			
			char lastChar = strChkBuilder.charAt(0);
			
			if (lastChar == '1') {
				strChkBuilder.deleteCharAt(0).append('0');
			} else {
				strChkBuilder.deleteCharAt(0).append('1');
			}
		}
		
		// �����͸� üũ�Ͽ� ��� ��ȯ
		try {
			if (makeCrcCode(strChkBuilder.toString(), Integer.parseInt(checkType), 2).equals(chkDataCrcCode)) {
				iResult = 0;
			}
			logger.debug("iResult : " + iResult);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		
		logger.info("");
		logger.info("[checkPacketError END]========================================================================================================================");
		
		
		return iResult;
	}
	
	/**
	 * ������ ���� üũ (CRC) <br>
	 * �⺻���� ���� �������� ������ üũ
	 * @param checkData �˻��� ������ 
	 * @return int 0 : Success, -1 : Fail
	 */
	public int checkPacketError(String checkData) {
		return checkPacketError(checkData, "0", 0);
	}
	
	
	public static void main(String[] arg) throws Exception {
//		CRCMaker crcMaker = new CRCMaker();
//		logger.info(crcMaker.makeCrcCode("100000000000000110100011", 0, 2));
		
//		logger.info(crcMaker.makeCrcCode("�׷��� ��¼��� �ų�!!", 1));
		
//		logger.info(crcMaker.checkPacketError("1111111100000000"));
	}
}
