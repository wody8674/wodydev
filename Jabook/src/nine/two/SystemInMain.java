package nine.two;

import java.io.IOException;

/**
 * System.in�� �׽�Ʈ�ϱ� ���� ����
 * @author wody
 *
 */
public class SystemInMain {
	public static void main(String[] args) throws IOException {
		System.out.print("���͸� ��������");
		int i = System.in.read();
		System.out.println(i);
	}
}
