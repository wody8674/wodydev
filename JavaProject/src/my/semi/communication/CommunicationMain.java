package my.semi.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 데이터를 입력받아 byte배열로 변환하는 과정
 * @author Jeong Jae Yo
 * @since 1.7
 * @see my.semi.common.ChangeData
 */
public class CommunicationMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ChangeData changeData = new ChangeData();
		BufferedReader bufferedReader = null;
		String inputData = "";

		while (!inputData.equals("0")) {
			
			System.out.println("데이터를 입력하세요(숫자만) !!!   숫자 0을 입력하면 종료됩니다. ");
			
			// 키보드로부터 데이터를 입력 받음
			try {
				bufferedReader = new BufferedReader( new InputStreamReader(System.in));
				inputData = bufferedReader.readLine();
				
				
			} catch (IOException e1) {
				System.out.println(e1.toString());
			}
			
			// 종료 키워드를 입력하였을 경우 - '0'
			if (inputData.equals("0")) {
				System.out.println("종료합니다.");
				bufferedReader = null;
				break;
			}
			
			// 입력받은 숫자를 통해 변환 시작
			try {
				byte[] byteData = changeData.intToByte(Integer.parseInt(inputData));
				int intData = changeData.byteToInt(byteData);
			} catch (NumberFormatException ne) {
				System.out.println(ne.toString());
				System.out.println("숫자가 아니거나 너무 큽니다.");
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				bufferedReader = null;
			}
		}
	}
}