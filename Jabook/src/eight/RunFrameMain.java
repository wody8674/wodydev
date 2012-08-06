package jabook.eight;

import java.awt.Frame;

/**
 * Frame의 상속과 Runnable의 구현 
 * Thread를 상속하지 못하는 경우 Runnable로 구현 
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
		
		System.out.println("스레드 시작!");
		
		while (i < 20) {
			
			System.out.print(i + "\t");
			
			this.setTitle("스레드 동작중" + i++);
			
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
		System.out.println("스레드 종료!");
	}
}
