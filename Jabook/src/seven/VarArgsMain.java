package seven;

import java.util.Vector;

public class VarArgsMain {
	public static void display(Vector v) {
		for (Object s : v) {
			System.out.println("컬렉션형태:" + s);
		}
	}
}
