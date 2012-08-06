package jabook.seven;

public class StringBasicMain {
	public static void main(String[] args) {
		
		// 문자열을 생성하는 방법 I
		String str1 = "Hello World!";
		String str2 = "Hello World!";
		System.out.println("str1==str2 : " + (str1 == str2));
		
		// 문자열 생성하는 방법 II
		String ntr1 = new String("Hello World!");
		String ntr2 = new String("Hello World!");
		System.out.println("ntr1==ntr2 : " + (ntr1 == ntr2));
		
		// 문자열 결합하기
		String ntr3 = "Hello" + 100 + "World!" + "새로운 문자열";
		System.out.println(ntr3);
		
		// 문자열 내에 에스케이프(Escape) 문자의 사용
		String myString = "c:\\javasrc\\chap07";
		System.out.println("에스케이프문자의 사용 : " + myString);
	}
}
