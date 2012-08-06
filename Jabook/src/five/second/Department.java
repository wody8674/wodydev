package jabook.five.second;

import java.util.Vector;

public class Department {
	private Vector empVector = new Vector();
	
	public void addEmployee(Employee p){ 
		this.empVector.add(p);
	}
	
	public void showEmployee(){
		for(int i=0; i<empVector.size(); i++){
			Employee p = (Employee)empVector.elementAt(i); 
			System.out.println(p.getName() + ":" + p.getPay());
		}
	}

}
