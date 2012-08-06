package six;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapCompareMain {
	public static void main(String[] args) {
		TreeMap<ScoreMap, String> tset = new TreeMap<ScoreMap, String>(
				new MyComparatorMap<ScoreMap>());
		tset.put(new ScoreMap(21, 22), "ȫ�浿1");
		tset.put(new ScoreMap(61, 62), "ȫ�浿2");
		tset.put(new ScoreMap(81, 82), "ȫ�浿3");
		tset.put(new ScoreMap(11, 12), "ȫ�浿4");
		tset.put(new ScoreMap(31, 32), "ȫ�浿5");
		System.out.println("TreeMap Sorting Example : " + tset);
	}

}

class ScoreMap {
	private int korea = 0;
	private int math = 0;

	public ScoreMap(int korea, int math) {
		this.korea = korea;
		this.math = math;
	}

	public int getSum() {
		return this.korea + this.math;
	}

	public String toString() {
		return "����:" + korea + " ����:" + math;
	}
}

class MyComparatorMap<T> implements Comparator<T> {
	public int compare(T o1, T o2) {
		ScoreMap s1 = (ScoreMap) o1;
		ScoreMap s2 = (ScoreMap) o2;
		int r = s1.getSum() - s2.getSum();
		if (r > 0) {
			return 1; // �������� ����
		} else if (r == 0) {
			return 0;
		} else {
			return -1; // �������� ����
		}
	}
}
