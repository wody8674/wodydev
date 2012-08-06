package seven;

import java.util.Vector;

public class VarArgsMain3 {
	public static void display(Vector v) {
		for (Object s : v) {
			System.out.println("�÷�������:" + s);
		}
	}

	public static void display(String... strs) {
		for (String s : strs) {
			System.out.println("�����迭����:" + s);
		}
	}

	public static void main(String[] args) {
		// 1. �÷����� �̿��� �Ű�����
		Vector vec = new Vector();
		vec.add("Hello");
		vec.add("World");
		vec.add("Korea");
		VarArgsMain3.display(vec);
		
		// 2. �����迭�� �̿��� �Ű�����
		VarArgsMain3.display("Hello", "World", "Korea");
	}
}
