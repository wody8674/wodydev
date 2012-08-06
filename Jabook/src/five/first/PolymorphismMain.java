package five.first;

public class PolymorphismMain {
	public static void main(String[] args){
		Department depart = new Department(); 
		depart.addEmployee(new Permanent("KIM", 1000)); 
		depart.addEmployee(new Permanent("LEE", 1500)); 
		depart.addEmployee(new Permanent("JUN", 2000)); 
		depart.showEmployee();
	}
}
