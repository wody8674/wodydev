package nine.three;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 하나의 배열로 파일에 존재하는 모든 데이터 읽어내기
 * @author wody
 *
 */
public class FileStreamMain6 {
	public static void main(String[] args) throws IOException {
		
		// 1. 파일 사이즈 알아내기
		File f = new File("FileStreamMain6.java");
		int fileSize = (int) f.length();
		System.out.println("파일의 사이즈:" + fileSize);
		
		// 2. 파일 사이즈에 해당하는 배열 만들기
		byte[] b = new byte[fileSize];
		
		// 3. 스트림을 이용해서 배열에 데이터 채우기
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
		
		System.out.println("읽은 바이트수:" + pos);
		
		// 4. 배열을 통째로 파일에 기록하기
		FileOutputStream fos = new FileOutputStream("test.txt");
		fos.write(b);
		fos.close();
	}
}
