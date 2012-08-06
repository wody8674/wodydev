package jabook.eight;

import java.util.Vector;

class VideoShop {
	private Vector buffer = new Vector();

	public VideoShop() {
		buffer.addElement("은하철도999-0");
		buffer.addElement("은하철도999-1");
		buffer.addElement("은하철도999-2");
		buffer.addElement("은하철도999-3");
	}

	public synchronized String lendVideo() {
		if (buffer.size() > 0) {
			String v = (String) this.buffer.remove(buffer.size() - 1);
			return v;
		} else {
			return null;
		}
	}

	public synchronized void returnVideo(String video) {
		this.buffer.addElement(video);
	}
}

class Person extends Thread {
	public void run() {
		String v = VideoShopMain3.vShop.lendVideo();
		if (v == null) {
			System.out.println(this.getName() + "비디오가 없군요. 안봅니다.");
			return;
		}
		try {
			System.out.println(this.getName() + ":" + v + " 대여");
			System.out.println(this.getName() + ":" + v + " 보는중\n");
			
			this.sleep(5000);
			
			System.out.println(this.getName() + ":" + v + " 반납");
			
			VideoShopMain3.vShop.returnVideo(v);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class VideoShopMain3 {
	public static VideoShop vShop = new VideoShop();

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		Person p5 = new Person();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		System.out.println("프로그램 종료");
	}
}
