package jabook.five.first;

public class Permanent {
	private String name;
	private int salary;
	
	public Permanent(String name, int salary){ 
		this.name = name;
		this.salary = salary;
	}
	
	public String getName(){ 
		return this.name;
	}
	
	public int getPay(){ 
		return this.salary;
	}

}
