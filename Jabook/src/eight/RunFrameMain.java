package jabook.eight;

import java.awt.Frame;

/**
 * Frame�� ��Ӱ� Runnable�� ���� 
 * Thread�� ������� ���ϴ� ��� Runnable�� ���� 
 *
 */

public class RunFrameMain {
	public static void main(String args[]) {
		
		RunFrame r = new RunFrame();
		r.setSize(300, 100);
		r.setVisible(true);
		
		Thread t = new Thread(r);
		t.start();
	}
}

class RunFrame extends Frame implements Runnable {
	public void run() {
		int i = 0;
		
		System.out.println("������ ����!");
		
		while (i < 20) {
			
			System.out.print(i + "\t");
			
			this.setTitle("������ ������" + i++);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
		System.out.println("������ ����!");
	}
}
