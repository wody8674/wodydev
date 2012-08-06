package seven;

import java.util.Vector;

public class VarArgsMain3 {
	public static void display(Vector v) {
		for (Object s : v) {
			System.out.println("컬렉션형태:" + s);
		}
	}

	public static void display(String... strs) {
		for (String s : strs) {
			System.out.println("가변배열형태:" + s);
		}
	}

	public static void main(String[] args) {
		// 1. 컬렉션을 이용한 매개변수
		Vector vec = new Vector();
		vec.add("Hello");
		vec.add("World");
		vec.add("Korea");
		VarArgsMain3.display(vec);
		
		// 2. 가변배열을 이용한 매개변수
		VarArgsMain3.display("Hello", "World", "Korea");
	}
}
