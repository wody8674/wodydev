package jabook.eight;

class TerminateThread extends Thread {
	
	// �������� ���Ḧ �����ϴ� �÷���
	private boolean flag = false;

	public void run() {
		int count = 0;
		
		System.out.println(this.getName() + "����");
		
		while (!flag) {
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

public class TerminateThreadMain {
	public static void main(String args[]) throws Exception {
		System.out.println("�۾�����");
		
		TerminateThread a = new TerminateThread();
		TerminateThread b = new TerminateThread();
		TerminateThread c = new TerminateThread();
		
		a.start();
		b.start();
		c.start();
		
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
				a.setFlag(true);
				b.setFlag(true);
				c.setFlag(true);
				
				System.out.println("main����");
				break;
			}
		}
	}
}
