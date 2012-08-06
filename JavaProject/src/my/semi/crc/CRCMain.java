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
			
			System.out.println("데이터를 입력하세요 !!! 숫자 0을 입력하면 종료됩니다. ");
			
			// 키보드로부터 데이터를 입력 받음
			try {
				bufferedReadData = new BufferedReader( new InputStreamReader(System.in));
				inputData = bufferedReadData.readLine();
			} catch (IOException e1) {
				System.out.println(e1.toString());
			}
			
			// 종료 키워드를 입력하였을 경우 - '0'
			if (inputData.equals("0")) {
				System.out.println("종료합니다.");
				bufferedReadData = null;
				break;
			}
			
			// 데이터 입력 후 코드 생성
			while (!inputType.equals("0") && !inputType.equals("1") && !inputType.equals("2")) {

				System.out.println("CRC 코드 생성 방법을 선택하세요");
				System.out.println("0 : 직접 계산법");
				System.out.println("1 : 테이블 참조법");
				System.out.println("2 : 데이터 재입력");
				
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
						System.out.println("잘못 입력되었습니다. 다시 입력해 주세요");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
			
			// 완성된 문자열 생성과 체크
			try {
				if (inputType.equals("0") || inputType.equals("1")) {
					inputData = cmmModule.strTobinary(inputData) + crcCode;
					
					System.out.println("완성된 데이터 : " + inputData);
					
					// 데이터를 체크한다.
					// 마지막 파라미터는 바이너리데이터에 에러발생 여부 코드
					// 0 : 정상, 1 : 에러 발생
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
