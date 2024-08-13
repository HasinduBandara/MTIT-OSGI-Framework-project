package package1;

import java.sql.DriverManager;
import java.util.Properties;

public class Employee {

	EmployeeData data = new EmployeeData();
	
	private static final double OT_RATE = 30.0;
    private static final double TAX_RATE = 0.3;
    private static double netTotal = 0;
    private static double taxAmount = 0;
    private static double finalSalary = 0;
    
    private static final String PROPERTY_FILE = "config.properties";

	public static void main(String[] args) {		
		Employee employee = new Employee();
		
		employee.data.setEmployeeId(1);
		employee.data.setEmployeeName("John");
		employee.data.setBasicSalary(50000);
		employee.data.setOtHours(2);
	
		double result = CalculateNetSalary(employee);
		System.out.println(result);
			    
		if ( result > 50000){
			System.out.println("You are subjected to Tax Payment");
		}
			    
		double tax = CalculateTax(employee);
		System.out.println("You have to pay a tax of " + tax);
			    
		double finalTotal = CalculateSalaryAfterTax(employee);
		System.out.println("Your salary after deducting tax is "+finalTotal);	
		
		getDatabaseDetails();
		
	}
	
	/**
	 * Retrieves database connection details from configuration file.
	*/
	public static void getDatabaseDetails() {

		Properties properties = new Properties();

			try {
				properties.load(Employee.class.getResourceAsStream(PROPERTY_FILE));
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url = properties.getProperty("url");
				String username = properties.getProperty("username");
				String tablename = properties.getProperty("tablename");
				String password = properties.getProperty("password");
				
				DriverManager.getConnection(url,username,password);
				
				System.out.println("You are connected to database through "+url+"as"+username+"user. All your details are stored in "+tablename+"table.");
				
		} catch (Exception e) {
		}
	}
	
	//calculate net salary
	public static double CalculateNetSalary(Employee employee) {
		netTotal = employee.data.getBasicSalary() + employee.data.getOtHours()*OT_RATE;
		return netTotal;
	}
	
	//calculate tax
	public static double CalculateTax(Employee employee) {		    	
    	taxAmount = CalculateNetSalary(employee) * TAX_RATE;
    	return taxAmount;
	}
  
	//calculate salary after tax
	public static double CalculateSalaryAfterTax(Employee employee) {
    	finalSalary = CalculateNetSalary(employee) - CalculateTax(employee); 
    	return finalSalary;
    }

}
