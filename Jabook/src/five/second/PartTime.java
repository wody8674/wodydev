package jabook.five.second;

public class PartTime extends Employee {
	private int salary;
	private int time;
	
	public PartTime(String name, int time, int salary) {
		super(name);
		this.time = time;
		this.salary = salary;
	}

	@Override
	public int getPay() {
		return this.salary*this.time;
	}

}
