package seven;

import java.net.MalformedURLException;
import java.net.URL;

public class NeedNetCatchMain {
	public static void main(String args[]) {
		System.out.println("���α׷� ����");
		
		try {
			URL url = new URL("http://www.yahoo.co.kr");
			System.out.println("URL:" + url.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally: �ᱹ�̸��� ���±���");
		}
		
		System.out.println("���α׷� ����");
	}
}
