package nine.three;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader를 이용해서 파일 읽기
 * @author wody
 *
 */
public class FileReaderMain {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("writer.dat");
		
		int i;
		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}
		
		fr.close();
	}
}
