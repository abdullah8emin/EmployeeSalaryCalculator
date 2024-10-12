package application;

public class SalariedEmployee extends Employee {

	private double weeklySalary;
	
	public SalariedEmployee() {
		
	}
	public SalariedEmployee(String firstName,String lastName,String socialSecurityNumber,double weeklySalary) {
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setSocialSecuritynumber(socialSecurityNumber);
		this.weeklySalary = weeklySalary;
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}
	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary>0) {
			this.weeklySalary = weeklySalary;						
		}
		else {
			System.out.println("This value is unvalid");
			System.exit(0);
		}
	}
	
	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}
	
	@Override
	public String toString() {
		return "salaried " + super.toString() + " " + weeklySalary;
	}

}
