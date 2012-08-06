package seven;

public class StringFormattingMain {
	public static void main(String[] args) {
		// 1. Formating의 예
		
		String s1 = String.format("%s %d %f %o %h", "Hello", 100, 3.14F, 100, 100);
		
		// 2. 숫자 포매팅의 예
		String s2 = String.format("%,d", 10000000);
		String s3 = String.format("%.3f", 42.000000);
		String s4 = String.format("%,.2f ", 12345.678901);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}
}
