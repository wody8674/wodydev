package jabook.eight;

class Bank_1 {
	private int money = 10000; // 예금 잔액

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public synchronized void saveMoney(int save) {
		int m = this.getMoney();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setMoney(m + save);
	}

	public void minusMoney(int minus) {
		synchronized (this) {
			int m = this.money;
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.setMoney(m - minus);
		}
	}
}

class Park_1 extends Thread {
	public void run() {
		SyncMain.myBank.saveMoney(3000);
		System.out.println("saveMoney(3000):" + SyncMain.myBank.getMoney());
	}
}

class ParkWife_1 extends Thread {
	public void run() {
		SyncMain.myBank.minusMoney(1000);
		System.out.println("minusMoney(3000):" + SyncMain.myBank.getMoney());
	}
}

public class SyncMain {
	public static Bank myBank = new Bank();

	public static void main(String[] args) throws Exception {
		System.out.println("원금:" + myBank.getMoney());
		
		Park_1 p = new Park_1();
		ParkWife_1 w = new ParkWife_1();
		
		p.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		w.start();
	}
}
