package eight;

import java.awt.Frame;

public class RunnableFrameMain {
	public static void main(String args[]) {
		RunnableFrame r = new RunnableFrame();
		r.setSize(300, 100);
		r.setVisible(true);
	}
}

class RunnableFrame extends Frame implements Runnable {
	
	public RunnableFrame() {
		new Thread(this).start();
	}

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
