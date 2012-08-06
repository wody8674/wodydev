package jabook.six;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class IteratorMain {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		// Vector에 객체 삽입
		v.addElement(new String("망아지"));
		v.addElement(new String("송아지"));
		v.addElement(new String("강아지"));
		v.addElement(new String("병아리"));
		
		// Iterator를 이용한 데이터 출력
		Iterator<String> iter = v.iterator();
		
		while (iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);
		}
		
		System.out.println();
		
		Hashtable<String, String> h = new Hashtable<String, String>();
		
		// Hashtable에 객체 삽입
		h.put("1", new String("홍길동"));
		h.put("2", new String("안녕하세요"));
		h.put("3", new String("02-1111-2222"));
		h.put("4", new String("017-777-9999"));
		
		// Iterator를 이용한 데이터 출력
		Iterator<String> iter2 = h.values().iterator();
		
		while (iter2.hasNext()) {
			String temp = iter2.next();
			System.out.println(temp);
		}
	}
}
