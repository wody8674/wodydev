package nine.three;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream의 read(byte[] b)
 * FileInputStream을 이용한 여러 바이트 읽기
 * @author wody
 *
 */
public class FileStreamMain5 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("FileStreamMain5.java");
		
		int count;
		byte[] b = new byte[10];
		
		while ((count = fis.read(b)) != -1) {
			for (int i = 0; i < count; i++) {
				System.out.print((char) b[i]);
			}
		}
		
		fis.close();
	}
}
