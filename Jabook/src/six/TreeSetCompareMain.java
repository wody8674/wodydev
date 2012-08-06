package jabook.six;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetCompareMain {
	public static void main(String[] args) {
		TreeSet<Score> tset = new TreeSet<Score>(new MyComparator<Score>());
		
		tset.add(new Score(21, 22));
		tset.add(new Score(61, 62));
		tset.add(new Score(81, 82));
		tset.add(new Score(11, 12));
		tset.add(new Score(31, 32));
		
		System.out.println("TreeSet Sorting Example : " + tset);
	}
}

class Score {
	private int korea = 0;
	private int math = 0;

	public Score(int korea, int math) {
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

class MyComparator<T> implements Comparator<T> {
	public int compare(T o1, T o2) {
		Score s1 = (Score) o1;
		Score s2 = (Score) o2;
		
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
