package my.semi.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * �����͸� �Է¹޾� byte�迭�� ��ȯ�ϴ� ����
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
			
			System.out.println("�����͸� �Է��ϼ���(���ڸ�) !!!   ���� 0�� �Է��ϸ� ����˴ϴ�. ");
			
			// Ű����κ��� �����͸� �Է� ����
			try {
				bufferedReader = new BufferedReader( new InputStreamReader(System.in));
				inputData = bufferedReader.readLine();
				
				
			} catch (IOException e1) {
				System.out.println(e1.toString());
			}
			
			// ���� Ű���带 �Է��Ͽ��� ��� - '0'
			if (inputData.equals("0")) {
				System.out.println("�����մϴ�.");
				bufferedReader = null;
				break;
			}
			
			// �Է¹��� ���ڸ� ���� ��ȯ ����
			try {
				byte[] byteData = changeData.intToByte(Integer.parseInt(inputData));
				int intData = changeData.byteToInt(byteData);
			} catch (NumberFormatException ne) {
				System.out.println(ne.toString());
				System.out.println("���ڰ� �ƴϰų� �ʹ� Ů�ϴ�.");
			} catch (Exception e) {
				System.out.println(e.toString());
			} finally {
				bufferedReader = null;
			}
		}
	}
}