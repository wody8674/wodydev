package eight;

class Bank {
	private int money = 10000; // ���� �ܾ�

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

class Park extends Thread {
	public void run() {
//		synchronized (NotSyncMain.myBank) {
			NotSyncMain.myBank.saveMoney(3000);
			System.out.println("saveMoney(3000):" + NotSyncMain.myBank.getMoney());
//		}
	}
}

class ParkWife extends Thread {
	public void run() {
//		synchronized (NotSyncMain.myBank) {
			NotSyncMain.myBank.minusMoney(1000);
			System.out.println("minusMoney(1000):" + NotSyncMain.myBank.getMoney());
//		}
	}
}

public class NotSyncMain {
	public static Bank myBank = new Bank();

	public static void main(String[] args) throws Exception {
		System.out.println("����:" + myBank.getMoney());
		
		Park p = new Park();
		ParkWife w = new ParkWife();
		
		p.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		w.start();
	}
}




