package package1;

public class EmployeeData {
	private int employeeId;
	private String employeeName;
	private double basicSalary;
	private double otHours;

	
	//constructor
	public EmployeeData() {
		
	}

	//getters
	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public double getBasicSalary() {
		return basicSalary;
	}
	
	public double getOtHours() {
		return otHours;
	}
	
	
	//setters
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public void setOtHours(double otHours) {
		this.otHours = otHours;
	}

	
}