package eight;

public class NotRunnableMain {
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		
		System.out.println("���α׷� ����");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("���α׷� ����");
		System.out.println("�ð�: " + (System.currentTimeMillis() - current));
	}
}
