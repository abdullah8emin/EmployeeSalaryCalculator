package application;

public abstract class Employee implements Payable {
	
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee() {
		firstName = "Bob";
		lastName = "Lewis";
		socialSecurityNumber = "333-33-3333";
	}
	
	public Employee(String firstName,String lastName,String socialSecurityNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSocialSecuritynumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecuritynumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public String toString() {
		return "employee: " + firstName + " " + lastName + " " + socialSecurityNumber;
	}
}
