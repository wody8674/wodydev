package my.semi.communication;

import org.apache.log4j.Logger;

import my.semi.common.CommModule;

/**
 * int형을 byte배열로 byte배열을 int형으로 변환하는 클래스
 * @author Jeong Jae Yo
 * @since 1.7
 * @see my.semi.common.CommModule
 */
public class ChangeData {

	/* 로그를 위한 클래스 */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/**
	 * int형 데이터를 byte배열로 변환
	 * @param iData 변환 할 int형 데이터
	 * @return 변환 된 byte[] 데이터
	 * @throws Exception 
	 */
	public byte[] intToByte(int iData) throws Exception {

		/* 주석에서 데이터 표현 용 */
		CommModule comModule = new CommModule();

		logger.info("");
		logger.info("[intToByte START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("iData : " + iData);
		logger.debug("Parameter data End : -----------------------------");
		logger.info("받은 데이터 : " + iData);
		logger.info("받은 데이터 (2진수) : " + comModule.displayInt((Integer.toBinaryString(iData)), "0"));

		/* 쉬프트 연산을 하기 위한 초기값 */
		int shiftData = 24;

		/* byte배열 초기화 */
		byte[] arrByteData = new byte[4];
		
		logger.info("");
		logger.info("[change start] ----------");

		// 각각 배열의 방에 int 데이터 파싱작업
		int arrByteDataLen = arrByteData.length;
		for (int i = 0; i < arrByteDataLen; i++) {

			logger.info("");
			logger.info("[working " + i + " START]");
			logger.info("   iData >> shiftData : "+comModule.displayInt(iData, "0")+" >> "+shiftData+" = " +comModule.displayInt(iData >> shiftData, "0"));
			logger.info("   (iData >> shiftData) & 0xff : " + comModule.displayInt(iData >> shiftData, "0") +" & "+comModule.displayInt(0xff, "0") +" = "+comModule.displayInt((iData >> shiftData) & 0xff, "0"));
			
			// 쉬프트 연산으로 추출할 데이터를 제일 오른쪽으로 이동시키고 AND연산으로 데이터 추출 (제일 끝 8bit만 추출하기 위한 연산)
			arrByteData[i] = (byte)((iData >> shiftData)&0xff);
			logger.debug("arrByteData[" + i + "] : " + arrByteData[i]);
			
			// 다음 쉬프트 연산을 위해 -8
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
	 * byte배열을 int형 데이터로 변환
	 * @param arrByteData 변환 할 byte배열 데이터
	 * @return 변환 된 int형 데이터
	 * @throws Exception 
	 */
	public int byteToInt(byte[] arrByteData) throws Exception {

		/* 주석에서 데이터 표현 용 */
		CommModule comModule = new CommModule();
		
		logger.info("");
		logger.info("[byteToInt START]========================================================================================================================");
		logger.debug("Parameter data : -----------------------------");
		logger.debug("arrByteData : " + comModule.strTobinary(new String(arrByteData)));
		logger.debug("Parameter data End : -----------------------------");
		logger.info("byte size : " + arrByteData.length);

		/* 변환 된 결과값 */
		int iResult = 0;
		
		/* 쉬프트 연산을 하기 위한 초기값 */
		int shiftData = arrByteData.length*8-8;
		
		/* 작업의 차수 (배열 INDEX) */
		int workIndex = 0;
		
		logger.info("");
		logger.info("[change start] ----------");

		// 들어온 배열의 수 만큼 반복하여 작업한다.
		for (byte loc_data : arrByteData) {
			
			logger.info("");
			logger.info("[working " + workIndex + " START]");
			logger.info("   arrByteData["+workIndex+"] : " + comModule.displayInt(arrByteData[workIndex]&0xff, "0", 8));
			logger.info("   loc_data & 0xff : " +comModule.displayInt(loc_data) +" & "+comModule.displayInt(0xff) + " = " + comModule.displayInt((loc_data & 0xff)));
			logger.info("   (loc_data & 0xff) << shiftData : " +comModule.displayInt((loc_data & 0xff))+ " << " +shiftData+ " = " + comModule.displayInt((loc_data & 0xff) << shiftData));
			
			// AND연산으로 데이터를 걸러내고 쉬프트연산으로 위치를 변경하여 값을 더한다. (순차적으로)
			iResult += (loc_data & 0xff) << shiftData;
			logger.debug("iResult : " + iResult);
			
			// 다음 쉬프트 연산을 위해 -8
			shiftData -= 8;
			logger.debug("shiftData : " + shiftData);
			
			// index + 1
			workIndex += 1;
			logger.debug("workIndex : " + workIndex);

			logger.info("   중간결과 : " + comModule.displayInt(iResult));
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
