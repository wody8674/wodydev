package eight;

import java.util.Vector;

class VideoShop {
	private Vector buffer = new Vector();

	public VideoShop() {
		buffer.addElement("����ö��999-0");
		buffer.addElement("����ö��999-1");
		buffer.addElement("����ö��999-2");
		buffer.addElement("����ö��999-3");
	}

	public String lendVideo() {
		String v = (String) this.buffer.remove(buffer.size() - 1);
		return v;
	}

	public void returnVideo(String video) {
		this.buffer.addElement(video);
	}
}

class Person extends Thread {
	public void run() {
		synchronized (VideoShopMain.vShop) {
			// 5�ʵ��� VideoShopMain.vShop�� ��(Lock)�� �ɸ��� �ȴ�.
			try {
				String v = VideoShopMain.vShop.lendVideo();
				
				System.out.println(this.getName() + ":" + v + " �뿩");
				System.out.println(this.getName() + ":" + v + " ������");
				
				this.sleep(5000);
				
				System.out.println(this.getName() + ":" + v + " �ݳ�");
				
				VideoShopMain.vShop.returnVideo(v);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class VideoShopMain {
	public static VideoShop vShop = new VideoShop();

	public static void main(String[] args) {
		System.out.println("���α׷� ����");
		
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		Person p4 = new Person();
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		System.out.println("���α׷� ����");
	}
}
