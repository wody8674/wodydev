package jabook.eight;

/** 
* Runnable을 구현해서 만드는 스레드(스레드를 생성하는 방법) 
*/
public class ThreadMain {
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		Top t = new Top();
		
		Thread thd = new Thread(t);
		thd.start();
		
		System.out.println("프로그램 종료");
	}
}

class Top implements Runnable {
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.print(i + "\t");
	}
}
