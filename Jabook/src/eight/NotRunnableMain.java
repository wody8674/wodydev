package eight;

public class NotRunnableMain {
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		
		System.out.println("프로그램 시작");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
		System.out.println("시간: " + (System.currentTimeMillis() - current));
	}
}
