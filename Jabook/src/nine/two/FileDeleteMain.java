package nine.two;

import java.io.File;
import java.io.IOException;

public class FileDeleteMain {
	public static void main(String[] args) throws IOException {
		File f = new File("NewFolder");
		if (f.exists()) {
			f.delete();
			System.out.println("NewFolder 디렉터리를 삭제 완료");
		}
	}
}
