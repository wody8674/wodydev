package jabook.five.second;

public class Permanent extends Employee {
	private int salary;
	
	public Permanent(String name, int salary){ 
		super(name);
		this.salary = salary;
	}
	
	@Override
	public int getPay() { 
		return this.salary;
	}

}
