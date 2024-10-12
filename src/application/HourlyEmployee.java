package application;

public class HourlyEmployee extends Employee {
	
	private double wage;
	private double hours;

	public HourlyEmployee() {
		
	}
	public HourlyEmployee(String firstName,String lastName,String socialSecurityNumber,double wage,double hours) {
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setSocialSecuritynumber(socialSecurityNumber);
		this.wage = wage;
		this.hours = hours;
	}
	
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		if(wage>=0) {
			this.wage = wage;
		}
		else {
			System.out.println("This value is invalid");
			System.exit(0);
		}
	}
	
	public double getHours() {
		return hours;
	}
	public void setHours(double hours) {
		if(hours>=0 && hours<168) {
			this.hours = hours;
		}
		else {
			System.out.println("This value is invalid");
			System.exit(0);
		}
	}
	
	@Override
	public double getPaymentAmount() {
		if(hours<=40) {
			return wage * hours;
		}
		else if(hours>40) {
			return (40 * wage) + (hours - 40) * wage * 1.5;
		}
		else {
			return -10;
		}
	}
	
	@Override
	public String toString() {
		return "hourly " + super.toString() + " " + wage + " " +  hours;
	}
}