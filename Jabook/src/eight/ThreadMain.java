package jabook.eight;

/** 
* Runnable�� �����ؼ� ����� ������(�����带 �����ϴ� ���) 
*/
public class ThreadMain {
	public static void main(String[] args) {
		
		System.out.println("���α׷� ����");
		
		Top t = new Top();
		
		Thread thd = new Thread(t);
		thd.start();
		
		System.out.println("���α׷� ����");
	}
}

class Top implements Runnable {
	public void run() {
		for (int i = 0; i < 50; i++)
			System.out.print(i + "\t");
	}
}
