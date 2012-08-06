package jabook.seven;

public class StringBuilderSpeedMain {
	public static void main(String[] args) {
		long startTime = 0L;
		long elapsedTime = 0L;
		
		// 1. ����ȭ�� �����Ǵ� StringBuffer�� �ӵ�����
		StringBuffer sb = new StringBuffer();
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			sb.append("H"); // ���ο� ���ڿ� �߰��ϱ�
		}
		
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("StringBuffer ���ڿ������:" + elapsedTime);
		
		// 2. ����ȭ�� �������� �ʴ� StringBuilder�� �ӵ� ����
		StringBuilder sbr = new StringBuilder();
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < 500000; i++) {
			sbr.append("H"); // ���ο� ���ڿ� �߰��ϱ�
		}
		
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("StringBuilder ���ڿ������:" + elapsedTime);
	}
}
