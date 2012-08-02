package nine.two;

import java.io.IOException;

/**
 * 2개의 문자를 읽어 내는 System.in
 * @author wody
 *
 */
public class SystemInMain2 {
	public static void main(String[] args) throws IOException {
		System.out.print("엔터를 누르세요");
		int i = System.in.read();
		System.out.println(i);
		i = System.in.read();
		System.out.println(i);
	}
}
