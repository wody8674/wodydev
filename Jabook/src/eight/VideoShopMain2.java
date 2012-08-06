package eight;

import java.util.Vector;

class VideoShop_1 {
	private Vector buffer = new Vector();

	public VideoShop_1() {
		buffer.addElement("은하철도999-0");
		buffer.addElement("은하철도999-1");
		buffer.addElement("은하철도999-2");
		buffer.addElement("은하철도999-3");
	}

	public synchronized String lendVideo() {
		String v = (String) this.buffer.remove(buffer.size() - 1);
		return v;
	}

	public synchronized void returnVideo(String video) {
		this.buffer.addElement(video);
	}
}

class Person_1 extends Thread {
	public void run() {
		try {
			String v = VideoShopMain2.vShop.lendVideo();
			
			System.out.println(this.getName() + ":" + v + " 대여");
			System.out.println(this.getName() + ":" + v + " 보는중");
			
			this.sleep(5000);
			
			System.out.println(this.getName() + ":" + v + " 반납");
			
			VideoShopMain2.vShop.returnVideo(v);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class VideoShopMain2 {
	public static VideoShop_1 vShop = new VideoShop_1();

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Person_1 p1 = new Person_1();
		Person_1 p2 = new Person_1();
		Person_1 p3 = new Person_1();
		Person_1 p4 = new Person_1();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		System.out.println("프로그램 종료");
	}
}
