package jabook.seven;

public class TryCatchMain {
	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println(e.toString() + " ������ �߻��߽��ϴ�");
			System.out.println("����ó�� ��ƾ ����");
		}
		System.out.println("���α׷��� ����");
	}
}
