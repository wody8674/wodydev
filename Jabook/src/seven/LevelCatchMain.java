package jabook.seven;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LevelCatchMain {
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("LevelCatchMain.java");
			String s = null;
			System.out.println(s.toString()); // NullPointerException ¹ß»ý
		} catch (FileNotFoundException e1) {
			System.out.println("FileNotFoundException:" + e1);
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("ArrayIndexOutOfBoundsException:" + e2);
		} catch (Exception e3) {
			System.out.println("Exception:" + e3);
		}
	}
}
