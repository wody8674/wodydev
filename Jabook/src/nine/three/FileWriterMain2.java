package nine.three;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter�� ���ڿ��� ���ڹ迭 ����ϱ�
 * @author wody
 *
 */
public class FileWriterMain2 {
	public static void main(String[] args) throws IOException {
		char[] content = new char[] { 72, 101, 108, 108, 111 };
		String str = new String("Hello World!");
		FileWriter fos = new FileWriter("writer2.dat");
		fos.write(content); // ���ڹ迭�� ���
		fos.write(str); // ���ڿ��� ���
		fos.close();
		System.out.println("writer2.dat ���� ��� �Ϸ�");
	}
}
