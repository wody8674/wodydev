package eight;

class ControlThread extends Thread {
	
	// ��� �������� ���Ḧ �����ϴ� �÷���
	public static boolean all_exit = false;
	
	// �������� ���Ḧ �����ϴ� �÷���
	private boolean flag = false; 

	public void run() {
		int count = 0;
		
		System.out.println(this.getName() + "����");
		
		// flag�� all_exit �� �� �ϳ��� true�̸� while���� ������.
		while (!flag && !all_exit) {
			try {
				// �۾�
				this.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println(this.getName() + "����");
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

public class ControlThreadMain {
	public static void main(String args[]) throws Exception {
		System.out.println("�۾�����");
		
		ControlThread a = new ControlThread();
		ControlThread b = new ControlThread();
		ControlThread c = new ControlThread();
		
		a.start();
		b.start();
		c.start();
		
		Thread.sleep(100);
		
		int i;
		
		System.out.print("������ �����带 �Է��Ͻÿ�! A, B, C, M?\n");
		
		while (true) {
			i = System.in.read();
			
			if (i == 'A') {
				a.setFlag(true);
			} else if (i == 'B') {
				b.setFlag(true);
			} else if (i == 'C') {
				c.setFlag(true);
			} else if (i == 'M') {
				
				// ��� �����带 �����Ų��.
				ControlThread.all_exit = true;
				System.out.println("main����");
				break;
			}
		}
	}
}