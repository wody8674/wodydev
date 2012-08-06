package six;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetMain {
	public static void main(String args[]) {
		Set<String> set = new HashSet<String>();
		set.add(new String("���"));
		set.add(new String("ȫ�浿"));
		set.add(new String("������"));
		set.add(new String("�̵���"));
		set.add(new String("�����"));
		
		System.out.println("HashSet : " + set);
		
		TreeSet<String> ts = new TreeSet<String>();
		ts.addAll(set);
		
		System.out.println("TreeSet : " + ts);
		
		List list = new ArrayList();
		list.add("�����");
		list.add("��û��");
		list.add("����");
		list.add("ȫ�浿");
		
		System.out.println("LIST : "+list);
		
		TreeSet<String> t_list = new TreeSet<String>();
		t_list.addAll(t_list);
		
		System.out.println("T_LIST : "+t_list);
		
	}
}
