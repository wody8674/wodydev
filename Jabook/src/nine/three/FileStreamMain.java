package nine.three;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream���� ������ ����ϱ�
 * @author wody
 *
 */
public class FileStreamMain {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("a.dat");
		
		fos.write(72);
		fos.write(101);
		fos.write(108);
		fos.write(108);
		fos.write(111);
		fos.close();
		
		System.out.println("a.dat ���� ��ϿϷ�");
	}
}
