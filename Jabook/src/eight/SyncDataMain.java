package jabook.eight;

class Data_1 {
	public int i = 0;
}

class Tom_1 extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) {
			synchronized (SyncDataMain.data) {
				SyncDataMain.data.i++;
			}
		}
		System.out.println("Tom :" + SyncDataMain.data.i);
	}
}

class Jane_1 extends Thread {
	public void run() {
		for (int i = 0; i < 100000; i++) {
			synchronized (SyncDataMain.data) {
				SyncDataMain.data.i++;
			}
		}
		System.out.println("Jane:" + SyncDataMain.data.i);
	}
}

public class SyncDataMain {
	public static Data_1 data = new Data_1();

	public static void main(String[] args) {
		System.out.println("동기화 보장 예제 시작");
		Tom_1 t = new Tom_1();
		Jane_1 j = new Jane_1();
		t.start();
		j.start();
		System.out.println("동기화 보장 예제 종료");
	}
}
