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
 * CRC데이터를 로드하여 값을 메모리에 저장한다.
 * @author Jeong Jae Yo
 * @since 1.7
 */
public class CRCTable {

	/* 로그를 위한 클래스 */
	private Logger logger = Logger.getLogger(getClass()); 
	
	/** CRC 테이블 데이터를 저장할 Map */
	private static Map<Byte, Byte> crcMap = null;
	
	/**
	 * CRC-8 테이블 객체가 없는 경우 <br> 
	 * 테이블 객체 생성
	 */
	public CRCTable() {
		
		// crcMap 객체가 null인지 확인 후 null인 경우 데이터를 로딩한다. 
		if (CRCTable.crcMap == null) {
			try {
				/* CRC 테이블 데이터를 담기 위한 Map 객체 생성 */
				// HashTable과 동일한 기능을 하는 동기화 지원하는 HashMap 객체 생성..
				// 사실상 데이터를 조회만 하고 수정및 추가하는 부분이 없기 때문에 동기화가 필요하진 않다.
				CRCTable.crcMap = Collections.synchronizedMap(new HashMap<Byte, Byte>());
				logger.info("CRC_MAP LOADING...");
				
				loadingCrcTable();
			} catch (Exception e) {
				logger.error(e.toString());
			}
		}
	}
	
	/**
	 * CRC 테이블 데이터를 로딩한다.
	 */
	private void loadingCrcTable() {
		
		logger.debug("[loadingCrcTable START]========================================================================================================================");
		
		/* crc리소스 파일을 불러온다. */
		// 실제 데이터가 아닌 파일 PATH
		File crcFile = new File(this.getClass().getResource("").getPath()+"crc-8_table-kodasys.txt");
		
		// 파일이 있는지 조사함
		if (!crcFile.exists()) {
			logger.error("없는 파일입니다.");
			return;
		}
		
		// 파일 데이터 길이 조사
		if (crcFile.length() == 0) {
			logger.error("데이터가 없습니다.");
			return;
		}

		/* 파일 데이터를 담을 변수 */
		StringBuilder crcStrBuilder = new StringBuilder();
		
		//File Read START=============================================================================//
		try {
			/* 파일을 스트림으로(문자단위) 읽어들임 */
			FileReader crcFileReader = new FileReader(crcFile);
			
			/* 한 문자를 담을 변수 */
			int iCrcData = 0;
			
			// 한문자씩 읽어서 데이터를 담는다.
			// 데이터를 char로 캐스팅하여 문자로 변환한다.
			// read() 메서드는 성공시 해당 캐릭터 숫자 실패시 -1 을 반환한다.
			while ((iCrcData=crcFileReader.read()) != -1) {
				crcStrBuilder.append((char)iCrcData);
			}
			
			// FileReader 종료
			crcFileReader.close();
			
		} catch (FileNotFoundException e) {
			logger.error("파일이 잘못되었습니다.");
			logger.error(e.toString());
		} catch (IOException e) {
			logger.error("문자를 읽을 수 없습니다.");
			logger.error(e.toString());
		}
		//File Read END=============================================================================//
		
		
		//Data Setting START=============================================================================//
		
		/* CRC 데이터를 엔터 기준 배열 변수 */
		String[] arryCrcData = crcStrBuilder.toString().split("\\n"); // 엔터로 데이터를 자름
		
		/* 라인별로 다시 split작업 결과 담을 변수 */
		String[] arryLineByData = {};
		
		/* Map index */
		int bIndex = 0;
		
		// 자른 데이터를 ', '기준으로 다시한번 자름
		int arryCrcDataLen = arryCrcData.length;
		for (int i=0; i<arryCrcDataLen; i++) {
			
			arryLineByData = arryCrcData[i].split(", "); // ', ' 기준으로 데이터를 자름
			
			// 데이터를 자른 후 마지막 데이터는 없는 데이터이기에 실제 길이에서 -1 만큼만 데이터 길이 추출
			int arryLineByDataLen = arryLineByData.length-1;
			for (int j=0; j<arryLineByDataLen; j++) {
				
				// index 데이터와 추출된 데이터를 byte타입으로 변경하여 데이터 저장
				// index 값은 1씩 증가
				// 데이터가 int형으로 변환 시 자동캐스팅에 의해 변할 수 있음으로 int형에서 &연산 후 강제 캐스팅함
				CRCTable.crcMap.put((byte) ((bIndex++)&0xFF), (byte) ((Integer.parseInt(arryLineByData[j].trim().replace(",", "").replace("0x", ""), 16))&0xFF));
			}
		}
		//Data Setting END=============================================================================//
		
		logger.debug("[loadingCrcTable END]========================================================================================================================");
	}
	
	/**
	 * index값을 넘겨서 데이터 조회
	 * @param index 테이블의 index값 
	 * @return String 테이블에서 조회한 코드 반환
	 * @throws Exception 
	 */
	public String getCrcCode(byte index) {
		
		/* 공통 함수 모듈 */
		CommModule cmmModule = new CommModule();
		
		/* 결과 데이터 */
		String strResult = ""; 

		// 데이터를 추출하여 binary문자열로 반환
		try {
			strResult = cmmModule.displayIntNoSpace(Integer.toBinaryString(CRCTable.crcMap.get(index)&0xFF), "0", 8);
		} catch (Exception e) {
			strResult = "00000000";
			logger.error(e.toString());
		}
		
		return strResult;
	}
	
	/**
	 * index값을 넘겨서 데이터 조회
	 * @param index 테이블의 index값 
	 * @return String 테이블에서 조회한 코드 반환
	 * @throws Exception 
	 */
	public String getCrcCode(int index) throws Exception {
		return getCrcCode((byte) (index&0xFF));
	}
	
	/**
	 * index값을 넘겨서 데이터 조회
	 * @param index 테이블의 index값 
	 * @return String 테이블에서 조회한 코드 반환
	 * @throws Exception 
	 * @throws NumberFormatException 
	 */
	public String getCrcCode(String index) throws NumberFormatException, Exception {
		return getCrcCode((byte) (Integer.parseInt(index, 2)&0xFF));
	}
	
	/**
	 * Map 객체 반환
	 * @return Map CRC테이블 객체 바환
	 */
	public static Map<Byte, Byte> getCrcMap() {
		return crcMap;
	}
	
	// 임시
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
