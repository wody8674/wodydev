package eight;

class ControlThread extends Thread {
	
	// 모든 스레드의 종료를 제어하는 플래그
	public static boolean all_exit = false;
	
	// 스레드의 종료를 제어하는 플래그
	private boolean flag = false; 

	public void run() {
		int count = 0;
		
		System.out.println(this.getName() + "시작");
		
		// flag나 all_exit 둘 중 하나만 true이면 while문이 끝난다.
		while (!flag && !all_exit) {
			try {
				// 작업
				this.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println(this.getName() + "종료");
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}

public class ControlThreadMain {
	public static void main(String args[]) throws Exception {
		System.out.println("작업시작");
		
		ControlThread a = new ControlThread();
		ControlThread b = new ControlThread();
		ControlThread c = new ControlThread();
		
		a.start();
		b.start();
		c.start();
		
		Thread.sleep(100);
		
		int i;
		
		System.out.print("종료할 스레드를 입력하시오! A, B, C, M?\n");
		
		while (true) {
			i = System.in.read();
			
			if (i == 'A') {
				a.setFlag(true);
			} else if (i == 'B') {
				b.setFlag(true);
			} else if (i == 'C') {
				c.setFlag(true);
			} else if (i == 'M') {
				
				// 모든 스레드를 종료시킨다.
				ControlThread.all_exit = true;
				System.out.println("main종료");
				break;
			}
		}
	}
}