package nine.three;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ϳ��� �迭�� ���Ͽ� �����ϴ� ��� ������ �о��
 * @author wody
 *
 */
public class FileStreamMain6 {
	public static void main(String[] args) throws IOException {
		
		// 1. ���� ������ �˾Ƴ���
		File f = new File("FileStreamMain6.java");
		int fileSize = (int) f.length();
		System.out.println("������ ������:" + fileSize);
		
		// 2. ���� ����� �ش��ϴ� �迭 �����
		byte[] b = new byte[fileSize];
		
		// 3. ��Ʈ���� �̿��ؼ� �迭�� ������ ä���
		FileInputStream fis = new FileInputStream("FileStreamMain6.java");
		
		int pos = 0;
		int size = 10;
		int temp;
		
		while ((size = fis.read(b, pos, size)) > 0) {
			pos += size;
			temp = b.length - pos;
			if (temp < 10) {
				size = temp;
			}
		}
		
		fis.close();
		
		System.out.println("���� ����Ʈ��:" + pos);
		
		// 4. �迭�� ��°�� ���Ͽ� ����ϱ�
		FileOutputStream fos = new FileOutputStream("test.txt");
		fos.write(b);
		fos.close();
	}
}
