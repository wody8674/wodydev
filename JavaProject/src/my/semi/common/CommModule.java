package my.semi.common;

import org.apache.log4j.Logger;

/**
 * 로그 생성 시 화면에 출력할 형태를 만드는 클래스
 * @author Jeong Jae Yo
 * @since 1.7
 */
public class CommModule {

	/* 로그를 위한 클래스 */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param strIntData 변형할 데이터
	 * @param padData 채울 데이터
	 * @param size 채울 크기
	 * @param padType L:왼쪽으로 채움, R:오른쪽으로 채움
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
		
		/* int형 데이터의 나머지 크기 (채울 크기) */
		int dataSize = size - strIntData.length();
		logger.debug("dataSize : " + dataSize);
		
		/* 데이터를 채울 공간 */
		StringBuilder strBuilder = new StringBuilder();

		// 들어온 데이터의 앞에 int형의 크기(최대 32bit) 만큼 채울 데이터 생성
		for (int i = 0; i < dataSize; i++) {
			strBuilder.append(padData);
		}
		logger.debug("strBuilder : " + strBuilder.toString());

		// 완성된 데이터 생성
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

		// int형태를 확인하기 위해 띄어쓰기를 적용하여 반환함
		return formatInt(strIntData, size);
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param strIntData 변형할 데이터
	 * @param padData 채울 데이터
	 * @param size 채울 크기
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData, String padData, int size) throws Exception {
		return displayInt(strIntData, padData, 32, "L");
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param intData 변형할 데이터
	 * @param padData 채울 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(int intData, String padData) throws Exception {
		return displayInt(Integer.toBinaryString(intData), padData, 32);
	}

	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param intData 변형할 데이터
	 * @param padData 채울 데이터
	 * @param size 채울 크기
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(int intData, String padData, int size) throws Exception {
		return displayInt(Integer.toBinaryString(intData), padData, size);
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param intData 변형할 데이터
	 * @param padData 채울 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData, String padData) throws Exception {
		return displayInt(strIntData, padData, 32);
	}

	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param intData 변형할 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(int intData) throws Exception {
		return displayInt(Integer.toBinaryString(intData), "0", 32);
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * @param strIntData 변형할 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayInt(String strIntData) throws Exception {
		return displayInt(strIntData, "0", 32);
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드 
	 * byte별 구분 없음(띄어쓰기)
	 * @param strIntData 변형할 데이터
	 * @param padData 채울 데이터
	 * @param size 채울 크기
	 * @param padType L:왼쪽으로 채움, R:오른쪽으로 채움
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
		
		/* int형 데이터의 나머지 크기 (채울 크기) */
		int dataSize = size - strIntData.length();
		logger.debug("dataSize : " + dataSize);

		/* 데이터를 채울 공간 */
		StringBuilder strBuilder = new StringBuilder();

		// 들어온 데이터의 앞에 int형의 크기(최대 size bit) 만큼 채울 데이터 생성
		for (int i = 0; i < dataSize; i++) {
			strBuilder.append(padData);
		}
		logger.debug("strBuilder : " + strBuilder.toString());

		// 완성된 데이터
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
		
		// int형태를 확인하기 위해 띄어쓰기를 적용하여 반환함
		return strIntData;
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드 
	 * byte별 구분 없음(띄어쓰기)
	 * @param strIntData 변형할 데이터
	 * @param padData 채울 데이터
	 * @param size 채울 크기
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData, String padData, int size) throws Exception {
		return displayIntNoSpace(strIntData, padData, size, "L");
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * byte별 구분 없음(띄어쓰기)
	 * @param intData 변형할 데이터
	 * @param padData 채울 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(int intData, String padData) throws Exception {
		return displayIntNoSpace(Integer.toBinaryString(intData), padData, 32);
	}

	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * byte별 구분 없음(띄어쓰기)
	 * @param intData 변형할 데이터
	 * @param padData 채울 데이터
	 * @param size 채울 크기
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(int intData, String padData, int size) throws Exception {
		return displayIntNoSpace(Integer.toBinaryString(intData), padData, size);
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * byte별 구분 없음(띄어쓰기)
	 * @param intData 변형할 데이터
	 * @param padData 채울 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData, String padData) throws Exception {
		return displayIntNoSpace(strIntData, padData, 32);
	}

	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * byte별 구분 없음(띄어쓰기)
	 * @param intData 변형할 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(int intData) throws Exception {
		return displayIntNoSpace(Integer.toBinaryString(intData), "0", 32);
	}
	
	/**
	 * int형 데이터크기만큼 채우는 메서드
	 * byte별 구분 없음(띄어쓰기)
	 * @param strIntData 변형할 데이터
	 * @return String
	 * @throws Exception 
	 */
	public String displayIntNoSpace(String strIntData) throws Exception {
		return displayIntNoSpace(strIntData, "0", 32);
	}
	
	/**
	 * 데이터가 1부터 시작하도록 앞의 0 삭제
	 * @param dataString 원본 데이터
	 * @return String 앞의 0이 제거된 String 데이터
	 */
	public String delFrontZero(String dataString) {
		
		logger.debug("[delFrontZero START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* String 데이터를 편집하기 위해 StringBuilder객체 생성 */
		StringBuilder strBuilder = new StringBuilder(dataString);

		// 데이터 하나씩 확인하면서 앞의 0 제거
		int strLen = strBuilder.length();
		logger.debug("strLen : " + strLen);
		for (int i=0; i<strLen; i++) {
			
			// 첫 데이터부터 0인지 확인하여 삭제하고 만약 1이 나오면 그대로 중지
			if (strBuilder.charAt(i) == '0') {
				strBuilder.deleteCharAt(i); // 해당 index의 데이터 삭제
			} else {
				break; // 첫번째 bit가 1인 경우 루프문을 빠져나옴
			}
		}
		
		logger.debug("RESULT : " + strBuilder.toString());
		logger.debug("[delFrontZero END]========================================================================================================================");
		
		return strBuilder.toString();
	}
	
	/**
	 * 데이터가 1부터 시작하도록 앞의 0 삭제
	 * @param dataString 원본 데이터
	 * @return int 제거된 0의 Count값 
	 */
	public int delFrontZero(StringBuilder dataString) {

		logger.debug("[delFrontZero START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("dataString : " + dataString);
		logger.debug("Parameter data End : -----------------------------");
		
		/* 삭제된 0의 숫자를 기록하기 위한 변수 */
		int i = 0;
		
		// 데이터 하나씩 확인하면서 앞의 0 제거
		int strLen = dataString.length();
		logger.debug("strLen : " + strLen);
		for (i=0; i<strLen; i++) {
			
			// 첫 데이터부터 0인지 확인하여 삭제하고 만약 1이 나오면 그대로 중지
			if (dataString.charAt(i) == '0') {
				dataString.deleteCharAt(i); // 해당 index의 데이터 삭제
			} else {
				break; // 첫번째 bit가 1인 경우 루프문을 빠져나옴
			}
		}
		
		logger.debug("RESULT : " + (i-1));
		logger.debug("[delFrontZero END]========================================================================================================================");
		
		return i-1;
	}
	
	
	/**
	 * 1byte 단위로 띄어쓰기
	 * @param strIntData 변형할 데이터
	 * @param size 전체 데이터의 크기
	 * @return String
	 * @throws Exception 
	 */
	public String formatInt(String strIntData, int size) throws Exception {
		
		logger.debug("[formatInt START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("strIntData : " + strIntData);
		logger.debug("size : " + size);
		logger.debug("Parameter data End : -----------------------------");
		
		// byte단위로 띄어쓰기를 해야하기 때문에 8의 배수가 아니면 에러처리
		logger.debug("size%8 : " + size%8);
		if (size%8 != 0) throw new Exception("size는 byte크기 단위여야 합니다. (8의 배수)");
		
		/* 띄어쓰기를 몇번해야 하는지를 위한 값 추출 (size로부터) */
		int roofSize = size/8;
		logger.debug("roofSize : " + roofSize);
		
		/* 받은 문자열(bit데이터)을 byte단위로 잘라서 띄어쓰기가 적용된 문자열을 담을 객체 */
		StringBuilder strBuilder = new StringBuilder();
		
		// 첫번 째 데이터 세팅
		strBuilder.append(strIntData.substring(0, 8));
		
		// 나머지 부분은 앞에 빈 공간으로 채운다.
		for (int i = 1; i < roofSize; i++) {
			strBuilder.append(" " + strIntData.substring(i * 8, (i + 1) * 8));
		}

		logger.debug("RESULT : " + strBuilder.toString());
		logger.debug("[formatInt END]========================================================================================================================");
		
		return strBuilder.toString();
	}
	
	/**
	 * 문자열을 binary문자열로 변환
	 * @param strData 변환할 데이터
	 * @return String 생성된 binary 문자열
	 * @throws Exception 
	 */
	public String strTobinary(String strData) throws Exception {
		
		logger.debug("[strTobinary START]========================================================================================================================");
		
		logger.debug("Parameter data : -----------------------------");
		logger.debug("strData : " + strData);
		logger.debug("Parameter data End : -----------------------------");
		
		/* 문자열을 byte배열로 변환 */
		byte[] bData = strData.getBytes();
		
		/* binary문자열 생성 공간 */
		StringBuilder strByteBuiler = new StringBuilder();
		
		// binary 문자열을 모두 연결한다.
		for (int iData : bData) {
			strByteBuiler.append(displayIntNoSpace(Integer.toBinaryString(iData&0xFF), "0", 8));
		}
		
		logger.debug("RESULT : " + strByteBuiler.toString());
		logger.debug("[formatInt END]========================================================================================================================");
		
		return strByteBuiler.toString();
	}
}
