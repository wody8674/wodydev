package nine.two;

import java.io.File;
import java.io.IOException;

public class FileDeleteMain {
	public static void main(String[] args) throws IOException {
		File f = new File("NewFolder");
		if (f.exists()) {
			f.delete();
			System.out.println("NewFolder ���͸��� ���� �Ϸ�");
		}
	}
}
