package jabook.six;

import java.util.Enumeration;
import java.util.Vector;

public class EnumVectorMain {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		// vector�� ������ 4�� ����
		v.addElement(new String("������"));
		v.addElement(new String("�۾���"));
		v.addElement(new String("������"));
		v.addElement(new String("���Ƹ�"));
		
		// Enumeration�� �̿��� ������ ���
		Enumeration<String> en = v.elements();
		
		while (en.hasMoreElements()) { // Vector�� �����Ͱ� �����ϴ��� �˻�
			// Vector���� ������ ����(�ٿ�ĳ���� �ʿ�)
			String temp = en.nextElement();
			System.out.println(temp);
		}
	}
}
