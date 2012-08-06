package jabook.seven;

enum SignFlag {
	black, yellow, green, blue, red
};

public class EnumMain {
	public static void main(String[] args) {
		for (SignFlag f : SignFlag.values()) {
			System.out.print(f + " : ");
			System.out.print(f.name() + " : ");
			System.out.println(f.ordinal());
		}
	}
}
