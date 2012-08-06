package jabook.seven;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class LevelErrorMain {
	public static void main(String[] args) {
		try {
			FileReader f = new FileReader("LevelErrorMain.java");
			String s = null;
			System.out.println(s.toString()); // NullPointerException ¹ß»ý
		} catch (FileNotFoundException e1) {
			System.out.println("FileNotFoundException:" + e1);
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("ArrayIndexOutOfBoundsException:" + e2);
		}
	}
}
