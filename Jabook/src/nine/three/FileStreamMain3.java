package nine.three;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 존재하는 파일의 끝에 덧붙여쓰기
 * @author wody
 *
 */
public class FileStreamMain3 {
	public static void main(String[] args) throws IOException {
		File f = new File("a.dat");
		
		if (f.exists()) {
			FileOutputStream fos = new FileOutputStream("a.dat", true);
			byte[] b = new byte[] { 72, 101, 108, 108, 111 };
			fos.write(b);
			fos.close();
			System.out.println("a.dat 파일의 끝부분에 데이터 추가하기 완료");
		}
	}
}
