package application;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	
	private double baseSalary;
	
	public BasePlusCommissionEmployee() {
		baseSalary = 300;
	}
	public BasePlusCommissionEmployee(String firstName,String lastName,String socialSecurityNumber,double grossSales, double commissionRates,double baseSalary) {
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setSocialSecuritynumber(socialSecurityNumber);
		super.setGrossSales(grossSales);
		super.setCommissionRates(commissionRates);
		this.baseSalary = baseSalary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		if(baseSalary >= 0) {
			this.baseSalary = baseSalary;			
		}
		else {
			System.out.println("This value is invalid");
			System.exit(0);
		}
	}
	
	@Override
	public double getPaymentAmount() {
		return baseSalary + (super.getCommissionRates() * super.getGrossSales());
	}
	
	@Override
	public String toString() {//payment amount???
		return "base plus " + super.toString() + " " + baseSalary;
	}
}
