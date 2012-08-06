package jabook.seven;

public class TryCatchMain {
	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println(e.toString() + " 에러가 발생했습니다");
			System.out.println("에러처리 루틴 실행");
		}
		System.out.println("프로그램의 종료");
	}
}
