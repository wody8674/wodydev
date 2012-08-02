package nine.three;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream으로 데이터 기록하기 II
 * @author wody
 *
 */
public class FileStreamMain2 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("a1.dat");
		byte[] b = new byte[] { 72, 101, 108, 108, 111 };
		fos.write(b);
		fos.close();
		System.out.println("a1.dat 파일 기록완료");
	}
}
