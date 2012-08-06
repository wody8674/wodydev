package my.semi.crc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import my.semi.common.CommModule;

public class CRCMain {

	public static void main(String[] arg) {
		
		CRCMaker crcMk = new CRCMaker();
		CommModule cmmModule = new CommModule();
		
		BufferedReader bufferedReadData = null;
		BufferedReader bufferedReadType = null;
		
		String inputData = "";
		String inputType = "";
		String crcCode = "";
		
		int iChkResult = -1;
		
		while (!inputData.equals("0")) {
			
			System.out.println("�����͸� �Է��ϼ��� !!! ���� 0�� �Է��ϸ� ����˴ϴ�. ");
			
			// Ű����κ��� �����͸� �Է� ����
			try {
				bufferedReadData = new BufferedReader( new InputStreamReader(System.in));
				inputData = bufferedReadData.readLine();
			} catch (IOException e1) {
				System.out.println(e1.toString());
			}
			
			// ���� Ű���带 �Է��Ͽ��� ��� - '0'
			if (inputData.equals("0")) {
				System.out.println("�����մϴ�.");
				bufferedReadData = null;
				break;
			}
			
			// ������ �Է� �� �ڵ� ����
			while (!inputType.equals("0") && !inputType.equals("1") && !inputType.equals("2")) {

				System.out.println("CRC �ڵ� ���� ����� �����ϼ���");
				System.out.println("0 : ���� ����");
				System.out.println("1 : ���̺� ������");
				System.out.println("2 : ������ ���Է�");
				
				try {
					bufferedReadType = new BufferedReader( new InputStreamReader(System.in));
					inputType = bufferedReadType.readLine();
					
					switch (inputType) {
					case "0":
						crcCode = crcMk.makeCrcCode(inputData);
						break;
					case "1":
						crcCode = crcMk.makeCrcCode(inputData, 1);
						break;
					case "2":
						break;
					default:
						System.out.println("�߸� �ԷµǾ����ϴ�. �ٽ� �Է��� �ּ���");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			
			// �ϼ��� ���ڿ� ������ üũ
			try {
				if (inputType.equals("0") || inputType.equals("1")) {
					inputData = cmmModule.strTobinary(inputData) + crcCode;
					
					System.out.println("�ϼ��� ������ : " + inputData);
					
					// �����͸� üũ�Ѵ�.
					// ������ �Ķ���ʹ� ���̳ʸ������Ϳ� �����߻� ���� �ڵ�
					// 0 : ����, 1 : ���� �߻�
					iChkResult = crcMk.checkPacketError(inputData, inputType, 1);
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			if (iChkResult == 0) {
				System.out.println("Check Successed");
			} else {
				System.out.println("Check Failed");
			}
		}
	}
}
