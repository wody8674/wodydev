package nine.two;

import java.io.IOException;

/**
 * System.in을 테스트하기 위한 예제
 * @author wody
 *
 */
public class SystemInMain {
	public static void main(String[] args) throws IOException {
		System.out.print("엔터를 누르세요");
		int i = System.in.read();
		System.out.println(i);
	}
}
