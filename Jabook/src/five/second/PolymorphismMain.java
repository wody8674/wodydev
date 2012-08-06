package five.second;


public class PolymorphismMain {
	public static void main(String[] args) {
		Department depart = new Department();

		depart.addEmployee(new Permanent("KIM", 1000));
		depart.addEmployee(new Permanent("LEE", 1500));
		depart.addEmployee(new Permanent("JUN", 2000));

		depart.addEmployee(new PartTime("PARK", 8, 200));
		depart.addEmployee(new PartTime("PARK", 10, 200));
		depart.addEmployee(new PartTime("PARK", 4, 200));

		depart.showEmployee();

		int[] source = new int[] { 5, 4, 6, 9, 7, 9 };
		int[] target = source.clone(); // clone()을 이용한 메모리 복사

	}
}

