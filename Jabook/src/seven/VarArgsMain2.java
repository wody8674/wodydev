package seven;

public class VarArgsMain2 {
	public static void display(String... strs) {
		for (String s : strs) {
			System.out.println("가변인수형태:" + s);
		}
	}
}
