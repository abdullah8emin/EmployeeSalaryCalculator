package application;

public class CommissionEmployee extends Employee {
	
	private double grossSales;
	private double commissionRates;
	
	public CommissionEmployee() {
	}
	
	public CommissionEmployee(String firstName,String lastName,String socialSecurityNumber,double grossSales, double commissionRates) {
		super.setFirstName(firstName);
		super.setLastName(lastName);
		super.setSocialSecuritynumber(socialSecurityNumber);
		this.grossSales = grossSales;
		this.commissionRates = commissionRates;
	}
	
	public double getGrossSales() {
		return grossSales;
		}
	
	public void setGrossSales(double grossSales) {
		if(grossSales >= 0) {
			this.grossSales = grossSales;			
		}
		else {
			System.out.println("This value is invalid");
			System.exit(0);
		}
	}
	
	public double getCommissionRates() {
		return commissionRates;
	}
	public void setCommissionRates(double commissionRates) {
		if(commissionRates > 0 && commissionRates < 1) {
			this.commissionRates = commissionRates;			
		}
		else {
			System.out.println("This value is invalid");
			System.exit(0);
		}
	}
	
	@Override
	public double getPaymentAmount() {
		return grossSales * commissionRates;
	}
	@Override
	public String toString() {
		return "commission " + super.toString() + " " + grossSales + " " + commissionRates;
	}
}
