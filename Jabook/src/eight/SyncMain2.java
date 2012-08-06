package jabook.eight;

class Bank_2 {
	private int money = 10000; // 예금 잔액

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void saveMoney(int save) {
		int m = this.getMoney();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.setMoney(m + save);
	}

	public void minusMoney(int minus) {
		int m = this.money;
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.setMoney(m - minus);
	}
}

class Park_2 extends Thread {
	public void run() {
		synchronized (SyncMain2.myBank) {
			SyncMain2.myBank.saveMoney(3000);
		}
		
		System.out.println("saveMoney(3000):" + SyncMain2.myBank.getMoney());
	}
}

class ParkWife_2 extends Thread {
	public void run() {
		synchronized (SyncMain2.myBank) {
			SyncMain2.myBank.minusMoney(1000);
		}
		
		System.out.println("minusMoney(3000):" + SyncMain2.myBank.getMoney());
	}
}

public class SyncMain2 {
	public static Bank_2 myBank = new Bank_2();

	public static void main(String[] args) throws Exception {
		System.out.println("원금:" + myBank.getMoney());
		
		Park_2 p = new Park_2();
		ParkWife_2 w = new ParkWife_2();
		
		p.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		w.start();
	}
}
