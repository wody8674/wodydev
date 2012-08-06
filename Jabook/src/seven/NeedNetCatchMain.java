package seven;

import java.net.MalformedURLException;
import java.net.URL;

public class NeedNetCatchMain {
	public static void main(String args[]) {
		System.out.println("프로그램 시작");
		
		try {
			URL url = new URL("http://www.yahoo.co.kr");
			System.out.println("URL:" + url.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally: 결국이리로 오는군요");
		}
		
		System.out.println("프로그램 종료");
	}
}
