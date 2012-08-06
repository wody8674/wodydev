package jabook.seven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NeedCatchMain {
	public static void main(String args[]) {
		System.out.println("프로그램 시작");
		
		try {
			FileReader f = new FileReader("NeedCatchMain.java");
			// ...파일 입출력 작업
			f.close();// 파일 닫기
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	}

}
