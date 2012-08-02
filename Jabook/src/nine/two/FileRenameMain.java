package nine.two;

import java.io.File;
import java.io.IOException;

public class FileRenameMain {
	public static void main(String[] args) throws IOException {
		File f = new File("FileRenameMain.class");
		File t = new File("FileRenameMain_backup.class");
		
		if (f.exists()) {
			f.renameTo(t);
			System.out.println("이름바꾸기 완료");
			System.out.print("FileRenameMain.class->");
			System.out.println("FileRenameMain_backup.class");
		}
	}
}
