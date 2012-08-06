package jabook.seven;

public class StringBufferSpeedMain {
	public static void main(String[] args) {
		long startTime = 0L;
		long elapsedTime = 0L;
		
		// 1. String���� ���ڿ� ������� �ӵ� ����
		String str1 = "";
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 50000; i++) {
			str1 += "H"; // ���ο� ���ڿ� �����ϱ�
		}
		
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("String ���ڿ������:" + elapsedTime);
		
		// 2. StringBuffer�� ���ڿ� ������� �ӵ� ����
		StringBuffer sb = new StringBuffer();
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 50000; i++) {
			sb.append("H"); // ���ο� ���ڿ� �߰��ϱ�
		}
		
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("StringBuffer ���ڿ������:" + elapsedTime);
	}
}
