package my.semi.crc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import my.semi.common.CommModule;

import org.apache.log4j.Logger;

/**
 * CRC�����͸� �ε��Ͽ� ���� �޸𸮿� �����Ѵ�.
 * @author Jeong Jae Yo
 * @since 1.7
 */
public class CRCTable {

	/* �α׸� ���� Ŭ���� */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/** CRC ���̺� �����͸� ������ Map */
	private static Map<Byte, Byte> crcMap = null;
	
	/**
	 * CRC-8 ���̺� ��ü�� ���� ��� <br> 
	 * ���̺� ��ü ����
	 */
	public CRCTable() {
		
		// crcMap ��ü�� null���� Ȯ�� �� null�� ��� �����͸� �ε��Ѵ�. 
		if (CRCTable.crcMap == null) {
			try {
				/* CRC ���̺� �����͸� ��� ���� Map ��ü ���� */
				// HashTable�� ������ ����� �ϴ� ����ȭ �����ϴ� HashMap ��ü ����..
				// ��ǻ� �����͸� ��ȸ�� �ϰ� ������ �߰��ϴ� �κ��� ���� ������ ����ȭ�� �ʿ����� �ʴ�.
				CRCTable.crcMap = Collections.synchronizedMap(new HashMap<Byte, Byte>());
				logger.info("CRC_MAP LOADING...");
				
				loadingCrcTable();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}
	
	/**
	 * CRC ���̺� �����͸� �ε��Ѵ�.
	 */
	private void loadingCrcTable() {
		
		logger.debug("[loadingCrcTable START]========================================================================================================================");
		
		/* crc���ҽ� ������ �ҷ��´�. */
		// ���� �����Ͱ� �ƴ� ���� PATH
		File crcFile = new File(this.getClass().getResource("").getPath()+"crc-8_table-kodasys.txt");
		
		// ������ �ִ��� ������
		if (!crcFile.exists()) {
			logger.error("���� �����Դϴ�.");
			return;
		}
		
		// ���� ������ ���� ����
		if (crcFile.length() == 0) {
			logger.error("�����Ͱ� �����ϴ�.");
			return;
		}

		/* ���� �����͸� ���� ���� */
		StringBuilder crcStrBuilder = new StringBuilder();
		
		//File Read START=============================================================================//
		try {
			/* ������ ��Ʈ������(���ڴ���) �о���� */
			FileReader crcFileReader = new FileReader(crcFile);
			
			/* �� ���ڸ� ���� ���� */
			int iCrcData = 0;
			
			// �ѹ��ھ� �о �����͸� ��´�.
			// �����͸� char�� ĳ�����Ͽ� ���ڷ� ��ȯ�Ѵ�.
			// read() �޼���� ������ �ش� ĳ���� ���� ���н� -1 �� ��ȯ�Ѵ�.
			while ((iCrcData=crcFileReader.read()) != -1) {
				crcStrBuilder.append((char)iCrcData);
			}
			
			// FileReader ����
			crcFileReader.close();
			
		} catch (FileNotFoundException e) {
			logger.error("������ �߸��Ǿ����ϴ�.");
			logger.error(e.toString());
		} catch (IOException e) {
			logger.error("���ڸ� ���� �� �����ϴ�.");
			logger.error(e.toString());
		}
		//File Read END=============================================================================//
		
		
		//Data Setting START=============================================================================//
		
		/* CRC �����͸� ���� ���� �迭 ���� */
		String[] arryCrcData = crcStrBuilder.toString().split("\\n"); // ���ͷ� �����͸� �ڸ�
		
		/* ���κ��� �ٽ� split�۾� ��� ���� ���� */
		String[] arryLineByData = {};
		
		/* Map index */
		int bIndex = 0;
		
		// �ڸ� �����͸� ', '�������� �ٽ��ѹ� �ڸ�
		int arryCrcDataLen = arryCrcData.length;
		for (int i=0; i<arryCrcDataLen; i++) {
			
			arryLineByData = arryCrcData[i].split(", "); // ', ' �������� �����͸� �ڸ�
			
			// �����͸� �ڸ� �� ������ �����ʹ� ���� �������̱⿡ ���� ���̿��� -1 ��ŭ�� ������ ���� ����
			int arryLineByDataLen = arryLineByData.length-1;
			for (int j=0; j<arryLineByDataLen; j++) {
				
				// index �����Ϳ� ����� �����͸� byteŸ������ �����Ͽ� ������ ����
				// index ���� 1�� ����
				// �����Ͱ� int������ ��ȯ �� �ڵ�ĳ���ÿ� ���� ���� �� �������� int������ &���� �� ���� ĳ������
				CRCTable.crcMap.put((byte) ((bIndex++)&0xFF), (byte) ((Integer.parseInt(arryLineByData[j].trim().replace(",", "").replace("0x", ""), 16))&0xFF));
			}
		}
		//Data Setting END=============================================================================//
		
		logger.debug("[loadingCrcTable END]========================================================================================================================");
	}
	
	/**
	 * index���� �Ѱܼ� ������ ��ȸ
	 * @param index ���̺��� index�� 
	 * @return String ���̺��� ��ȸ�� �ڵ� ��ȯ
	 * @throws Exception 
	 */
	public String getCrcCode(byte index) {
		
		/* ���� �Լ� ��� */
		CommModule cmmModule = new CommModule();
		
		/* ��� ������ */
		String strResult = ""; 

		// �����͸� �����Ͽ� binary���ڿ��� ��ȯ
		try {
			strResult = cmmModule.displayIntNoSpace(Integer.toBinaryString(CRCTable.crcMap.get(index)&0xFF), "0", 8);
		} catch (Exception e) {
			strResult = "00000000";
			logger.error(e.toString());
		}
		
		return strResult;
	}
	
	/**
	 * index���� �Ѱܼ� ������ ��ȸ
	 * @param index ���̺��� index�� 
	 * @return String ���̺��� ��ȸ�� �ڵ� ��ȯ
	 * @throws Exception 
	 */
	public String getCrcCode(int index) throws Exception {
		return getCrcCode((byte) (index&0xFF));
	}
	
	/**
	 * index���� �Ѱܼ� ������ ��ȸ
	 * @param index ���̺��� index�� 
	 * @return String ���̺��� ��ȸ�� �ڵ� ��ȯ
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String getCrcCode(String index) throws NumberFormatException, Exception {
		return getCrcCode((byte) (Integer.parseInt(index, 2)&0xFF));
	}
	
	/**
	 * Map ��ü ��ȯ
	 * @return Map CRC���̺� ��ü ��ȯ
	 */
	public static Map<Byte, Byte> getCrcMap() {
		return crcMap;
	}
	
	// �ӽ�
//	public static void main(String[] arg) throws Exception {
//		
//		CRCTable ctcTable = new CRCTable();
//		ctcTable.loadingCrcTable();
//		Map<Byte, Byte> crcMap = ctcTable.getCrcMap();
//		
//		logger.info(ctcTable.getCrcCode(24));
//		logger.info(crcMap.toString());
//		
//	}
}
