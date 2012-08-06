package jabook.eight;

import java.awt.Frame;

class SoloFrame extends Frame {
	public SoloFrame() {
		SoloThread t = new SoloThread(this);
		t.start();
	}
}

class SoloThread extends Thread {
	private Frame f = null;

	public SoloThread(Frame f) {
		this.f = f;// SoloFrame�� ������ ì�ܵα�
	}

	public void run() {
		int i = 0;
		
		System.out.println("������ ����!");
		
		while (i < 20) {
			System.out.print(i + "\t");
			
			f.setTitle("������ ������" + i++);
			
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		
		System.out.println("������ ����!");
	}
}

public class SoloFrameMain {
	public static void main(String args[]) {
		SoloFrame s = new SoloFrame();
		s.setSize(300, 100);
		s.setVisible(true);
	}
}
