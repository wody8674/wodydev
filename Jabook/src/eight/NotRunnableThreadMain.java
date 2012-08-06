package jabook.eight;

class NotRunnableThread extends Thread {
	public void run() {
		int i = 0;
		
		while (i < 10) {
			System.out.println(i + "ȸ:" + System.currentTimeMillis() + "\t");
			
			i = i + 1;
			
			try {
				this.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

public class NotRunnableThreadMain {
	public static void main(String args[]) {
		NotRunnableThread s = new NotRunnableThread();
		s.start();
	}
}
