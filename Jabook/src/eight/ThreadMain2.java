package eight;

/**
 * 
 * �� ���� �����带 ������ �� �����ϴ� ��(Runnable ����)
 *
 */
public class ThreadMain2 {
	public static void main(String[] args) {
		
		System.out.println("���α׷� ����");
		
		// 1. Runnable�� �����ϴ� ��ü �����
		Top t = new Top();
		
		// 2. Runnable�� ������ �� ��¥ ������ �����
		Thread thd1 = new Thread(t);
		Thread thd2 = new Thread(t);
		
		// 3. ������ ���� ��Ű��
		thd1.start();
		thd2.start();
		
		System.out.println("���α׷� ����");
	}
}

