package nine.two;

import java.io.IOException;

/**
 * 2���� ���ڸ� �о� ���� System.in
 * @author wody
 *
 */
public class SystemInMain2 {
	public static void main(String[] args) throws IOException {
		System.out.print("���͸� ��������");
		int i = System.in.read();
		System.out.println(i);
		i = System.in.read();
		System.out.println(i);
	}
}
