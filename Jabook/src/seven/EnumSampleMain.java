package jabook.seven;

enum PaintStyle {
	DASH, DB_DASH, DOT, DB_DOT
};

public class EnumSampleMain {
	public static void main(String[] args) {

		PaintStyle ps = PaintStyle.DB_DASH;

		switch (ps) {
		case DASH:
			System.out.println("---------------");
			break;
		case DB_DASH:
			System.out.println("================");
			break;
		case DOT:
			System.out.println("................");
			break;
		case DB_DOT:
			System.out.println("::::::::::::::::::::");
			break;
		default:
			break;
		}
	}
}
