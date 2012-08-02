package nine.two;

import java.io.File;

/**
 * File 클래스의 listFiles() - 디렉터리 목록 보기
 * @author wody
 *
 */
public class FileListMain {
	public static void main(String[] args) {
		File f = new File("c:\\");
		File[] fs = f.listFiles();
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getName());
		}
	}
}
