package nine.two;

import java.io.File;
import java.io.IOException;

/**
 * ���� ���͸��� ���� ���͸��� ��� ���
 * @author wody
 *
 */
public class CurrentDirMain {
	public static void main(String args[]) throws IOException {
		File dir1 = new File(".");
		File dir2 = new File("..");
		
		// AbsolutePath
		System.out.println("AbsolutePath");
		System.out.println("Current dir-> " + dir1.getAbsolutePath());
		System.out.println("Parent dir-> " + dir2.getAbsolutePath());
		
		// CanonicalPath
		System.out.println("CanonicalPath");
		System.out.println("Current dir-> " + dir1.getCanonicalPath());
		System.out.println("Parent dir-> " + dir2.getCanonicalPath());
		
		// ����������
		File dir3 = new File("c:\\");
		System.out.println("c:\\ -> " + dir3.getAbsolutePath());
	}
}
