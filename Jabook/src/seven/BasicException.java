package jabook.seven;

public class BasicException {
	public static void main(String args[]) {
		try {
			int[] ar = new int[] { 0, 100, 200, 300 };

			// ���Ƿ� �������� : �迭�� ������ ������� �Ѵ�.
			for (int i = 0; i < ar.length + 1; i++) {
				System.out.println("ar[" + i + "]=" + ar[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.toString(): " + e.toString());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("finally: �ᱹ�̸��� ���±���");
		}
	}
}
