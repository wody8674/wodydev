package jabook.six;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {
	public static void main(String args[]) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("ȫ�浿", new Integer(1));
		map.put("���", new Integer(2));
		map.put("�̵���", new Integer(3));
		map.put("������", new Integer(4));
		map.put("�����", new Integer(5));

		System.out.println("HashMap : " + map);

		Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
		sortedMap.putAll(map);

		System.out.println("TreeMap : " + sortedMap);
	}

}
