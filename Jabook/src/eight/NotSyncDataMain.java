package jabook.eight;

class Data {
	public int i = 0;
}

class Tom extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) {
			NotSyncDataMain.data.i++;
		}
		System.out.println("Tom :" + NotSyncDataMain.data.i);
	}
}

class Jane extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) {
			NotSyncDataMain.data.i++;
		}
		System.out.println("Jane:" + NotSyncDataMain.data.i);
	}
}

public class NotSyncDataMain {
	public static Data data = new Data();

	public static void main(String[] args) {
		System.out.println("main 시작");
		
		Tom t = new Tom();
		Jane j = new Jane();
		
		t.start();
		j.start();
		
		System.out.println("main 종료");
	}
}
