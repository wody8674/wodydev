package nine.three;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter에 문자열과 문자배열 기록하기
 * @author wody
 *
 */
public class FileWriterMain2 {
	public static void main(String[] args) throws IOException {
		char[] content = new char[] { 72, 101, 108, 108, 111 };
		String str = new String("Hello World!");
		FileWriter fos = new FileWriter("writer2.dat");
		fos.write(content); // 문자배열의 기록
		fos.write(str); // 문자열의 기록
		fos.close();
		System.out.println("writer2.dat 파일 기록 완료");
	}
}
