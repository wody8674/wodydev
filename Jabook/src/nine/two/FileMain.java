package nine.two;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;

/**
 * 파일의 정보를 출력하는 예제
 * @author wody
 *
 */
public class FileMain {
	public static void main(String[] args) throws MalformedURLException {
		File f = new File("FileMain.java");
		PrintStream out = System.out;
		out.println("isFile(): " + f.isFile()); // 파일인지 아닌지
		out.println("isDirectory(): " + f.isDirectory()); // 디렉터리인지 아닌지
		out.println("isHidden(): " + f.isHidden()); // 숨김파일인지
		out.println("lastModified(): " + f.lastModified()); // 마지막에 수정된 날짜
		out.println("canRead(): " + f.canRead()); // 읽기 속성을 가진 파일인지
		out.println("canWrite(): " + f.canWrite()); // 쓰기 속성을 가진 파일인지
		out.println("getPath(): " + f.getPath()); // 상대 경로
		out.println("getAbsolutePath(): " + f.getAbsolutePath()); // 절대 경로
		out.println("getName(): " + f.getName()); // 디렉터리 또는 파일의 이름
		out.println("toURL(): " + f.toURL()); // URL형식의 경로
		out.println("exists(): " + f.exists()); // 파일이 존재하는지
		out.println("length(): " + f.length()); // 파일의 길이
	}
}
