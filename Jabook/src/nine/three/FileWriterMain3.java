package nine.three;

import java.io.FileWriter;
import java.io.IOException;

/**
 * ������ ������ �κп� ���ٿ��ֱ�
 * @author wody
 *
 */
public class FileWriterMain3 {
	public static void main(String[] args) throws IOException {
		String str = new String("New Hello World!");
		FileWriter fos = new FileWriter("writer2.dat", true);
		fos.write(str);
		fos.close();
		System.out.println("writer2.dat�� ���ٿ��ֱ� �Ϸ�");
	}
}
