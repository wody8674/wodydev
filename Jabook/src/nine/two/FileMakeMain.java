package nine.two;

import java.io.File;
import java.io.IOException;

public class FileMakeMain {
	public static void main(String[] args) throws IOException {
		File f = new File("NewFolder");
		if (!f.exists()) {
			f.mkdir();
			System.out.println("NewFolder 디렉터리를 생성 완료");
		}
	}
}
