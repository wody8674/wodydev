package jabook.seven;

public class TryCatchFinallyMain {
	public static void main(String[] args) {
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println(e.toString() + " ������ �߻��߽��ϴ�");
			System.out.println("����ó�� ��ƾ ����");
		} finally {
			// ������ ���� ���� �ʵ� ������ ����Ǵ� ���
			System.out.println("finally ���� ����");
		}
		System.out.println("���α׷��� ����");
	}
}
