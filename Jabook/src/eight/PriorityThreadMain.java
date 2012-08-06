package eight;

class PriorityThread extends Thread {
	public void run() {
		int i = 0;
		
		System.out.println(this.getName() + " [우선권:" + this.getPriority() + "] 시작\t");
		
		while (i < 20000) {
			i = i + 1;
			
			try {
				this.sleep(1);
//				System.out.print(this.getPriority()+"-\r");
//				System.out.print(this.getPriority()+"+\r");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		System.out.println(this.getName() + " [우선권:" + this.getPriority() + "] 종료\t");
	}
}

public class PriorityThreadMain {
	public static void main(String[] args) {
		System.out.println("Main메서드 시작");
		
		PriorityThread[] p = new PriorityThread[10];
		
		for (int i = 0; i < 10; i++) {
			// for(int i=Thread.MIN_PRIORITY; i<=Thread.MAX_PRIORITY; i++){
			p[i] = new PriorityThread();
			p[i].setPriority(i + 1);
			p[i].setName("Thread-" + (i + 1));
		}
		
		for (int i = 0; i < 10; i++) {
			p[i].start();
		}
		
		System.out.println("Main메서드종료");
	}
}
