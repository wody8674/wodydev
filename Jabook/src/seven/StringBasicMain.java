package jabook.seven;

public class StringBasicMain {
	public static void main(String[] args) {
		
		// ���ڿ��� �����ϴ� ��� I
		String str1 = "Hello World!";
		String str2 = "Hello World!";
		System.out.println("str1==str2 : " + (str1 == str2));
		
		// ���ڿ� �����ϴ� ��� II
		String ntr1 = new String("Hello World!");
		String ntr2 = new String("Hello World!");
		System.out.println("ntr1==ntr2 : " + (ntr1 == ntr2));
		
		// ���ڿ� �����ϱ�
		String ntr3 = "Hello" + 100 + "World!" + "���ο� ���ڿ�";
		System.out.println(ntr3);
		
		// ���ڿ� ���� ����������(Escape) ������ ���
		String myString = "c:\\javasrc\\chap07";
		System.out.println("���������������� ��� : " + myString);
	}
}
