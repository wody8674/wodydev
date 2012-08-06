package my.semi.communication;

import org.apache.log4j.Logger;

import my.semi.common.CommModule;

/**
 * int���� byte�迭�� byte�迭�� int������ ��ȯ�ϴ� Ŭ����
 * @author Jeong Jae Yo
 * @since 1.7
 * @see my.semi.common.CommModule
 */
public class ChangeData {

	/* �α׸� ���� Ŭ���� */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * int�� �����͸� byte�迭�� ��ȯ
	 * @param iData ��ȯ �� int�� ������
	 * @return ��ȯ �� byte[] ������
	 * @throws Exception 
	 */
	public byte[] intToByte(int iData) throws Exception {

		/* �ּ����� ������ ǥ�� �� */
		CommModule comModule = new CommModule();

		logger.info("");
		logger.info("[intToByte START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("iData : " + iData);
		logger.debug("Parameter data End : -----------------------------");
		logger.info("���� ������ : " + iData);
		logger.info("���� ������ (2����) : " + comModule.displayInt((Integer.toBinaryString(iData)), "0"));

		/* ����Ʈ ������ �ϱ� ���� �ʱⰪ */
		int shiftData = 24;

		/* byte�迭 �ʱ�ȭ */
		byte[] arrByteData = new byte[4];
		
		logger.info("");
		logger.info("[change start] ----------");

		// ���� �迭�� �濡 int ������ �Ľ��۾�
		int arrByteDataLen = arrByteData.length;
		for (int i = 0; i < arrByteDataLen; i++) {

			logger.info("");
			logger.info("[working " + i + " START]");
			logger.info("   iData >> shiftData : "+comModule.displayInt(iData, "0")+" >> "+shiftData+" = " +comModule.displayInt(iData >> shiftData, "0"));
			logger.info("   (iData >> shiftData) & 0xff : " + comModule.displayInt(iData >> shiftData, "0") +" & "+comModule.displayInt(0xff, "0") +" = "+comModule.displayInt((iData >> shiftData) & 0xff, "0"));
			
			// ����Ʈ �������� ������ �����͸� ���� ���������� �̵���Ű�� AND�������� ������ ���� (���� �� 8bit�� �����ϱ� ���� ����)
			arrByteData[i] = (byte)((iData >> shiftData)&0xff);
			logger.debug("arrByteData[" + i + "] : " + arrByteData[i]);
			
			// ���� ����Ʈ ������ ���� -8
			shiftData -= 8;
			logger.debug("shiftData : " + shiftData);

			logger.info("   arrByteData["+i+"] : " + comModule.displayInt(arrByteData[i]&0xff, "0", 8));
			logger.info("[working " + i + " END]");
		}

		logger.info("[change end] ----------");

		logger.info("");
		logger.info("[RESULT]");
		for (int i=0; i<arrByteDataLen; i++) {
			logger.info("   arrByteData["+i+"] : " + arrByteData[i]);
			logger.info("   arrByteData["+i+"] : " + comModule.displayInt(arrByteData[i]&0xff, "0", 8));
		}
		
		logger.info("");
		logger.info("[intToByte END]========================================================================================================================");

		return arrByteData;
	}

	/**
	 * byte�迭�� int�� �����ͷ� ��ȯ
	 * @param arrByteData ��ȯ �� byte�迭 ������
	 * @return ��ȯ �� int�� ������
	 * @throws Exception 
	 */
	public int byteToInt(byte[] arrByteData) throws Exception {

		/* �ּ����� ������ ǥ�� �� */
		CommModule comModule = new CommModule();
		
		logger.info("");
		logger.info("[byteToInt START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("arrByteData : " + comModule.strTobinary(new String(arrByteData)));
		logger.debug("Parameter data End : -----------------------------");
		logger.info("byte size : " + arrByteData.length);

		/* ��ȯ �� ����� */
		int iResult = 0;
		
		/* ����Ʈ ������ �ϱ� ���� �ʱⰪ */
		int shiftData = arrByteData.length*8-8;
		
		/* �۾��� ���� (�迭 INDEX) */
		int workIndex = 0;
		
		logger.info("");
		logger.info("[change start] ----------");

		// ���� �迭�� �� ��ŭ �ݺ��Ͽ� �۾��Ѵ�.
		for (byte loc_data : arrByteData) {
			
			logger.info("");
			logger.info("[working " + workIndex + " START]");
			logger.info("   arrByteData["+workIndex+"] : " + comModule.displayInt(arrByteData[workIndex]&0xff, "0", 8));
			logger.info("   loc_data & 0xff : " +comModule.displayInt(loc_data) +" & "+comModule.displayInt(0xff) + " = " + comModule.displayInt((loc_data & 0xff)));
			logger.info("   (loc_data & 0xff) << shiftData : " +comModule.displayInt((loc_data & 0xff))+ " << " +shiftData+ " = " + comModule.displayInt((loc_data & 0xff) << shiftData));
			
			// AND�������� �����͸� �ɷ����� ����Ʈ�������� ��ġ�� �����Ͽ� ���� ���Ѵ�. (����������)
			iResult += (loc_data & 0xff) << shiftData;
			logger.debug("iResult : " + iResult);
			
			// ���� ����Ʈ ������ ���� -8
			shiftData -= 8;
			logger.debug("shiftData : " + shiftData);
			
			// index + 1
			workIndex += 1;
			logger.debug("workIndex : " + workIndex);

			logger.info("   �߰���� : " + comModule.displayInt(iResult));
			logger.info("[working " + workIndex + " START]");
		}

		logger.info("[change end] ----------");
		
		logger.info("");
		logger.info("[RESULT]");
		logger.info("   binary data : " + comModule.displayInt(iResult));
		logger.info("   result data : " + iResult);
		
		logger.info("");
		logger.info("[byteToInt END]========================================================================================================================");
		logger.info("");
		
		return iResult;
	}

}
