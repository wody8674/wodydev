package nine.three;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream�� �̿��ؼ� ���� �б�
 * @author wody
 * 
 */
public class FileStreamMain4 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("a.dat");
		
		int i;
		while ((i = fis.read()) != -1) {
			System.out.print((char) i);
		}
		
		fis.close();
	}
}
