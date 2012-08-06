package jabook.five.first;

import java.util.Vector;

public class Department {
	private Vector empVector = new Vector();
	
	public void addEmployee(Permanent p){ 
		this.empVector.add(p);
	}
	
	public void showEmployee(){
		for(int i=0; i<empVector.size(); i++){
			Permanent p = (Permanent)empVector.elementAt(i); 
			System.out.println(p.getName() + ":" + p.getPay());
		}
	}

}
