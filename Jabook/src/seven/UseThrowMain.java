package seven;

public class UseThrowMain {
	public static void main(String args[]) {
		try {
			throw new Exception("�̰��� ���� �޽���");
		} catch (Exception e) {
			System.out.println("--Exception �߻�����--");
			System.out.println("����:e.getMessage(): " + e.getMessage());
			System.out.println("����:e.toString(): " + e.toString());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("finally: �ᱹ�̸��� ���±���");
		}
	}
}
