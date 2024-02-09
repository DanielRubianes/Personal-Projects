/*
 * Daniel Rubianes
 * Date: 1/17/2019
 * Hendersonville High School
 * Overtime hours
 * 
 * Description: Uses an input file containing a list of employees with their IDs, titles, pay rates, and hours. Uses this data to create a talbe displaying the ID, pay rate, hours, and gross pay of each employee.
 * Difficulties: none
 * What I learned: n/a
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM9Overtime
{
    public static void main(String args[]) throws FileNotFoundException
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	// create the file scanner
    	Scanner employees = new Scanner(new File("employees.in"));
    	
    	// transcribing file to a list of employees
    	List<danielRubianesEmployee> employeeList = new ArrayList<danielRubianesEmployee>();
    	while (employees.hasNextLine()) {
        	danielRubianesEmployee tempEmployee = new danielRubianesEmployee();
    		Scanner currentEmployeeScan = new Scanner(employees.nextLine());
    		
    		tempEmployee.setID(currentEmployeeScan.nextInt());
    		tempEmployee.setJob(currentEmployeeScan.next().replace('_', ' '));
    		tempEmployee.setPay(currentEmployeeScan.nextDouble());
    		tempEmployee.setHours(currentEmployeeScan.nextInt());
    		employeeList.add(tempEmployee);
    		currentEmployeeScan.close();
    	}
    	
    	// printing output
    	System.out.printf("%-15s%-10s%-14s%-11s", "Employee ID", "Pay Rate", "Hours Worked", "Gross Pay");
    	for (int index = 0; index < employeeList.size(); index++) {
    		System.out.printf("\n%-15s$%-9.2f%-14s$%-11.2f", employeeList.get(index).getID(), employeeList.get(index).getPay(), employeeList.get(index).getHours(), employeeList.get(index).getGrossPay());
    	}
    	
    	input.close();
    	employees.close();
    }
}

/*
Sample Output: 
Employee ID    Pay Rate  Hours Worked  Gross Pay  
2343           $29.75    64            $2469.25    
3496           $21.50    64            $1784.50    
4565           $21.50    64            $1784.50    
4579           $21.50    64            $1784.50    
3454           $21.50    45            $1021.25    
3455           $21.50    45            $1021.25    
4567           $21.50    45            $1021.25    
5888           $21.50    40            $860.00     
3456           $21.50    40            $860.00     
1123           $10.33    60            $774.75     
1658           $10.33    60            $774.75     
4099           $10.33    40            $413.20     
6788           $10.33    40            $413.20     
4900           $9.50     44            $437.00     
1167           $9.50     44            $437.00     
2234           $9.50     44            $437.00     
2567           $9.50     44            $437.00     
3321           $9.50     44            $437.00     
1168           $9.50     40            $380.00     
6555           $9.50     40            $380.00     
 */