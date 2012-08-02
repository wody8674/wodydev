package nine.three;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter로 문자 기록하기
 * @author wody
 *
 */
public class FileWriterMain {
	public static void main(String[] args) throws IOException {
		FileWriter fos = new FileWriter("writer.dat");
		fos.write(72);
		fos.write(101);
		fos.write(108);
		fos.write(108);
		fos.write(111);
		fos.close();
		System.out.println("writer.dat 파일 기록 완료");
	}
}
