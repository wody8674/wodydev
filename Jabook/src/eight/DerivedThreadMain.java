package eight;

/**
 * Thread를 상속하는 스레드 만들기(Thread 상속) 
 */
public class DerivedThreadMain {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		DerivedThread d = new DerivedThread();
		d.start();
		
		System.out.println("프로그램 종료");
	}
}

class DerivedThread extends Thread {
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.print(i + "\t");
	}
}
