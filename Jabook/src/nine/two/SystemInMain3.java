package nine.two;

import java.io.IOException;

/**
 * �� ������ �о�� System.in
 * @author wody
 *
 */
public class SystemInMain3 {
	public static void main(String[] args) throws IOException {
		System.out.print("���ڸ� �Է��� �� ���͸� ��������? ");
		
		int i;
		while ((i = System.in.read()) != '\n') {
			System.out.println((char) i + ":" + i);
		}
	}
}
