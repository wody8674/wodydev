package six;

import java.util.Enumeration;
import java.util.Hashtable;

public class EnumHashtableMain {
	public static void main(String[] args) {
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		h.put("1", new String("ȫ�浿"));
		h.put("2", new String("�ȳ��ϼ���"));
		h.put("3", new String("02-1111-2222"));
		h.put("4", new String("017-777-9999"));
		
		Enumeration<String> en = h.elements();
		
		while (en.hasMoreElements()) { // ������ ���� ���� Ȯ��
			// ������ ���(�ٿ�ĳ���� �ʿ�)
			String temp = en.nextElement();
			System.out.println(temp);
		}
		
		Enumeration<String> en2 = h.keys();
		
		while (en2.hasMoreElements()) { // ������ ���� ���� Ȯ��
			String temp = en2.nextElement();
			System.out.println(temp);
		}
	}
}
