package jabook.seven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NeedCatchMain {
	public static void main(String args[]) {
		System.out.println("���α׷� ����");
		
		try {
			FileReader f = new FileReader("NeedCatchMain.java");
			// ...���� ����� �۾�
			f.close();// ���� �ݱ�
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		System.out.println("���α׷� ����");
	}

}
