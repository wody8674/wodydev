package my.semi.crc;

import org.apache.log4j.Logger;

import my.semi.common.CommModule;

/**
 * CRC-8 변환
 * @author Jeong Jae Yo
 * @since 1.7
 *
 */
public class CRCMaker {

	/* 로그를 위한 클래스 */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/* 공통 함수 모듈 */
	CommModule comModule = new CommModule();

	/**
	 * CRC-8 코드 추출 
	 * @param dataString 코드 추출할 데이터 (body)
	 * @param type 0:직접 계산법, 1:테이블 참조법 
	 * @param redix 2:dataString이 2진수, 10:dataString이 10진수, 기타:byte배열로 변환 후 binary문자열로 계산
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeCrcCode(String dataString, int type, int redix) throws Exception {
		
		logger.debug("[makeCrcCode START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("type : " + type);
		logger.debug("redix : " + redix);
		logger.debug("Parameter data End : -----------------------------");
		
		/* CRC 코드 */
		String crcCode = "";
		
		// 2진수일 경우 바로 계산
		// 10진수일 경우 binary로 변환 후 계산
		// 기타일 경우 String을 byte배열로 변환 후 binary 문자열로 변환
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
		
		// type이 1이면 테이블 찹조법으로 그 외의 값은 직접 계산법으로 구한다.  
		switch (type) {
		case 1:
			crcCode = makeTableCal(dataString); // 테이블 참조법
			break;
		default:
			crcCode = makeDirectCal(dataString); // 직접 계산법
			break;
		}
		
		logger.debug("RESULT : " + crcCode);
		logger.debug("[makeCrcCode END]========================================================================================================================");
		
		return crcCode;
	}
	
	/**
	 * CRC-8 코드 추출 
	 * @param dataString 코드 추출할 데이터 (body)
	 * @param type 0:직접 계산법, 1:테이블 참조법 
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeCrcCode(String dataString, int type) throws Exception {
		return makeCrcCode(dataString, type, 0);
	}
	
	/**
	 * CRC-8 코드 추출 
	 * 기본으로 직접 계산법으로 계산
	 * @param dataString 코드 추출할 데이터 (body)
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeCrcCode(String dataString) throws Exception {
		return makeCrcCode(dataString, 0);
	}
	
	/**
	 * CRC-8 코드 추출 
	 * @param dataString 코드 추출할 데이터 (body)
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeCrcCode(int dataString) throws Exception {
		return makeCrcCode(Integer.toBinaryString(dataString), 0, 2);
	}
	
	/**
	 * CRC-8 코드 추출 
	 * @param dataString 코드 추출할 데이터 (body)
	 * @param type 0:직접 계산법, 1:테이블 참조법 
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeCrcCode(int dataString, int type) throws Exception {
		return makeCrcCode(Integer.toBinaryString(dataString), type, 2);
	}
	
	/**
	 * CRC-8 코드 추출 
	 * @param dataString 코드 추출할 데이터 (body)
	 * @param type 0:직접 계산법, 1:테이블 참조법 
	 * @return String CRC코드
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String makeCrcCode(String dataString, String type) throws NumberFormatException, Exception {
		return makeCrcCode(dataString, Integer.parseInt(type));
	}
	
	/**
	 * CRC-8 코드 추출 
	 * @param dataString 코드 추출할 데이터 (body)
	 * @param type 0:직접 계산법, 1:테이블 참조법 
	 * @param redix 2:dataString이 2진수, 10:dataString이 10진수, 기타:byte배열로 변환 후 binary문자열로 계산
	 * @return String CRC코드
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String makeCrcCode(int dataString, int type, int redix) throws NumberFormatException, Exception {
		return makeCrcCode(Integer.toBinaryString(dataString), type, redix);
	}
	
	/**
	 * 직접 계산법으로 구한 CRC코드
	 * @param dataString 코드 추출할 데이터 (body)
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeDirectCal(String dataString) throws Exception {
		
		logger.info("");
		logger.info("[makeDirectCal START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* 계산 할 다항식 표현 C(x) = x^8 + x^2 + x + 1 = 100000111 */
		String polynomial = "100000111";
		
		/* 들어온 전체 데이터의 총 길이 */
		int dataStringLength = dataString.length();
		logger.debug("dataStringLength : " + dataStringLength);
		
		/* 8byte에 맞췄을 때 총 길이 */
		int dataStrFulSize = 0;
		
		// 길이를 8의 배수로 맞추기 위한 로직
		if (dataStringLength%8 == 0) {
			dataStrFulSize = dataStringLength; // 나머지가 0일 경우 추가 데이터 없이 진행
		} else {
			dataStrFulSize = dataStringLength+(8-(dataStringLength%8)); // 나머지가 0이 아닐 경우
		}
		logger.debug("dataStrFulSize : " + dataStrFulSize);

		logger.info("  자료비트 : " + comModule.formatInt(dataString, dataStrFulSize));
		
		// 데이터를 8bit 단위로 길이 마춤
		dataString = comModule.displayIntNoSpace(dataString, "0", dataStrFulSize);
		logger.debug("dataString : " + dataString);
		
		/* 결과를 담을 데이터 */ 
		String resultData = dataString + "00000000"; // 데이터에 CRC코드가 들어갈 8bit zero데이터로 공간 확보
		logger.debug("resultData : " + resultData);
		
		logger.info("  직접 계산법을 위한 변환 : " + comModule.formatInt(resultData, dataStrFulSize+8));
		logger.info("");
		
		/* 계산을 위해 앞에 9bit 잘라서 담을 공간 */
		String resultCalData = "";
		
		/* 스트링 제어를 위한 StringBuilder 선언 */
		StringBuilder strTempBuilder = new StringBuilder(resultData);
		
		// 결과 값의 길이가 8보다 크면 계산중지
		// 8보다 작은 값이 CRC코드가 된다.
		while (resultData.length() > 8) {
			
			/* 로그에서 데이터 위치를 잡기 위해 길이를 구함 */
			int strDataLen = strTempBuilder.length();
			logger.debug("strDataLen : " + strDataLen);
			
			// 데이터의 첫 비트가 0일 경우 1이 나올때 까지 모두 삭제
			comModule.delFrontZero(strTempBuilder);
			
			// 앞의 9자리 데이터를 잘라내는 과정
			resultCalData = strTempBuilder.substring(0, 9);
			strTempBuilder.delete(0, 9); // 데이터를 삭제함으로써 잘라내는 효과
			logger.debug("resultCalData : " + resultCalData);
			
			logger.info("  " + resultCalData+strTempBuilder.toString());
			logger.info("  " + polynomial);
			logger.info("  -----------------------------------------");
			
			// 앞의 데이터 xor연산 수행
			// 연산하면서 자동으로 앞의 0데이터는 삭제됨
			resultCalData = Integer.toBinaryString((Integer.parseInt(resultCalData, 2)&0xFF)^(Integer.parseInt(polynomial, 2)&0xFF));
			logger.debug("resultCalData : " + resultCalData);
			
			// 계산된 부분을 다시 이어붙임
			resultData = strTempBuilder.insert(0, resultCalData).toString();
			logger.debug("resultData : " + resultData);
			
			logger.info("  " + comModule.displayIntNoSpace(resultData, "0", strDataLen));
			logger.info("");
			
		}
		
		logger.info("");
		logger.info("[makeDirectCal END]========================================================================================================================");
		
		// 8bit 자리수를 마춘 후 반환
		return comModule.displayIntNoSpace(resultData, "0", 8);
	}
	
	/**
	 * 테이블 참조법으로 구한 CRC코드
	 * @param dataString 코드 추출할 데이터 (body)
	 * @return String CRC코드
	 * @throws Exception 
	 */
	public String makeTableCal(String dataString) throws Exception {
		
		logger.info("");
		logger.info("[makeTableCal START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* CRC 테이블 검색 객체 */
		CRCTable crcTable = new CRCTable();
		
		/* 테이블 참조법에 의한 첫 index값 설정 = 00000000 */
		String tableIndex = "00000000";
		
		/* 들어온 전체 데이터의 총 길이 */
		int dataStringLength = dataString.length();
		logger.debug("dataStringLength : " + dataStringLength);
		
		/* 8byte에 맞췄을 때 총 길이 */
		int dataStrFulSize = dataStringLength+(8-(dataStringLength%8));
		if (dataStringLength%8 == 0) dataStrFulSize = dataStringLength; // 데이터의 길이가 8의 배수일 경우
		logger.debug("dataStrFulSize : " + dataStrFulSize);
		
		logger.info("  자료비트 : " + comModule.formatInt(dataString, dataStrFulSize));
		logger.info("");
		
		// 데이터를 8bit 단위로 길이 맞춤
		dataString = comModule.displayIntNoSpace(dataString, "0", dataStrFulSize);
		
		/* 스트링 제어를 위한 StringBuilder 선언 */
		StringBuilder strTempBuilder = new StringBuilder(dataString);
		
		/* 계산을 위해 앞에 9bit 잘라서 담을 공간 */
		String resultCalData = "";
		
		// 앞에서 부터 byte 단위로 잘라서 index 데이터 추출 후 CRC 테이블에서 검색
		while (strTempBuilder.length() >= 8) {
			
			// 앞의 8자리 데이터를 잘라내는 과정
			resultCalData = strTempBuilder.substring(0, 8);
			strTempBuilder.delete(0, 8); // 데이터를 삭제함으로써 잘라내는 효과
			logger.debug("resultCalData : " + resultCalData);
			
			logger.info("");
			logger.info("  " + resultCalData+strTempBuilder.toString());
			logger.info("  " + tableIndex);
			logger.info("  -----------------------------------------");
			
			// 앞의 데이터 xor연산 수행
			// 연산하면서 자동으로 앞의 0데이터는 삭제됨
			tableIndex = Integer.toBinaryString((Integer.parseInt(resultCalData, 2)&0xFF)^(Integer.parseInt(tableIndex, 2)&0xFF));
			logger.debug("tableIndex : " + tableIndex);
			
			logger.info("  " + comModule.displayIntNoSpace(tableIndex, "0", 8));
			logger.info("");
			logger.info("  테이블 조회 : " + comModule.displayIntNoSpace(tableIndex, "0", 8) + " -> ");
			
			// CRC 테이블에서 데이터 조회
			tableIndex = crcTable.getCrcCode(tableIndex);
			logger.debug("tableIndex : " + tableIndex);
			
			logger.info("  테이블 결과 : " + comModule.displayIntNoSpace(tableIndex, "0", 8));
		}
		
		logger.info("  [RESULT] : " + tableIndex);
		
		logger.info("");
		logger.info("[makeTableCal END]========================================================================================================================");
		
		return comModule.displayIntNoSpace(tableIndex, "0", 8);
	}
	
	/**
	 * 데이터 오류 체크 (CRC)
	 * @param checkData 검사할 데이터
	 * @param checkType 0 : 직접 계산법, 1 : 테이블 참조법
	 * @return int 0 : Success, -1 : Fail
	 */
	public int checkPacketError(String checkData, String checkType, int errorGeneratedCode) {
		
		logger.info("");
		logger.info("[checkPacketError START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("checkData : " + checkData);
		logger.debug("checkType : " + checkType);
		logger.debug("Parameter data End : -----------------------------");
		logger.info("   입력받은 데이터 : " + checkData);
		
		int iResult = -1;
		
		/* 데이터체크를 위해 StringBuilder 객체 생성 */
		StringBuilder strChkBuilder = new StringBuilder(checkData);
		
		/* 데이터에서 CRC코드 추출 */
		String chkDataCrcCode = strChkBuilder.substring(strChkBuilder.length()-8);
		logger.debug("chkDataCrcCode : " + chkDataCrcCode);
		
		logger.info("   추출된 CRC코드 : " + chkDataCrcCode);
		
		// CRC 코드 제거
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
		
		// 데이터를 체크하여 결과 반환
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
	 * 데이터 오류 체크 (CRC) <br>
	 * 기본으로 직접 계산법으로 데이터 체크
	 * @param checkData 검사할 데이터 
	 * @return int 0 : Success, -1 : Fail
	 */
	public int checkPacketError(String checkData) {
		return checkPacketError(checkData, "0", 0);
	}
	
	
	public static void main(String[] arg) throws Exception {
//		CRCMaker crcMaker = new CRCMaker();
//		logger.info(crcMaker.makeCrcCode("100000000000000110100011", 0, 2));
		
//		logger.info(crcMaker.makeCrcCode("그래서 어쩌라는 거냐!!", 1));
		
//		logger.info(crcMaker.checkPacketError("1111111100000000"));
	}
}
