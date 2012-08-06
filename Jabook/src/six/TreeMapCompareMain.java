package six;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapCompareMain {
	public static void main(String[] args) {
		TreeMap<ScoreMap, String> tset = new TreeMap<ScoreMap, String>(
				new MyComparatorMap<ScoreMap>());
		tset.put(new ScoreMap(21, 22), "홍길동1");
		tset.put(new ScoreMap(61, 62), "홍길동2");
		tset.put(new ScoreMap(81, 82), "홍길동3");
		tset.put(new ScoreMap(11, 12), "홍길동4");
		tset.put(new ScoreMap(31, 32), "홍길동5");
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
		return "국어:" + korea + " 수학:" + math;
	}
}

class MyComparatorMap<T> implements Comparator<T> {
	public int compare(T o1, T o2) {
		ScoreMap s1 = (ScoreMap) o1;
		ScoreMap s2 = (ScoreMap) o2;
		int r = s1.getSum() - s2.getSum();
		if (r > 0) {
			return 1; // 오름차순 정렬
		} else if (r == 0) {
			return 0;
		} else {
			return -1; // 내림차운 정렬
		}
	}
}
