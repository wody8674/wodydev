package jabook.six;

import java.util.Enumeration;
import java.util.Vector;

public class EnumVectorMain {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		
		// vector에 데이터 4개 삽입
		v.addElement(new String("망아지"));
		v.addElement(new String("송아지"));
		v.addElement(new String("강아지"));
		v.addElement(new String("병아리"));
		
		// Enumeration을 이용한 데이터 출력
		Enumeration<String> en = v.elements();
		
		while (en.hasMoreElements()) { // Vector에 데이터가 존재하는지 검사
			// Vector에서 데이터 추출(다운캐스팅 필요)
			String temp = en.nextElement();
			System.out.println(temp);
		}
	}
}
