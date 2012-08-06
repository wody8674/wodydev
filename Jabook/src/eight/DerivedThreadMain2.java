package jabook.eight;

/**
 * Thread를 상속하는 두 개의 스레드를 생성한 후 실행시키기(Thread 상속) 
 */
public class DerivedThreadMain2 {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		DerivedThread d1 = new DerivedThread();
		DerivedThread d2 = new DerivedThread();
		
		d1.start();
		d2.start();
		
		System.out.println("프로그램 종료");
	}
}
