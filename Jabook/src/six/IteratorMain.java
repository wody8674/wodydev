package jabook.six;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class IteratorMain {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		// Vector�� ��ü ����
		v.addElement(new String("������"));
		v.addElement(new String("�۾���"));
		v.addElement(new String("������"));
		v.addElement(new String("���Ƹ�"));
		
		// Iterator�� �̿��� ������ ���
		Iterator<String> iter = v.iterator();
		
		while (iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);
		}
		
		System.out.println();
		
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		// Hashtable�� ��ü ����
		h.put("1", new String("ȫ�浿"));
		h.put("2", new String("�ȳ��ϼ���"));
		h.put("3", new String("02-1111-2222"));
		h.put("4", new String("017-777-9999"));
		
		// Iterator�� �̿��� ������ ���
		Iterator<String> iter2 = h.values().iterator();
		
		while (iter2.hasNext()) {
			String temp = iter2.next();
			System.out.println(temp);
		}
	}
}
