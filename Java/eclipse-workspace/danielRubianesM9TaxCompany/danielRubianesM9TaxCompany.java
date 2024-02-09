/*
 * Daniel Rubianes
 * Date: 2/4/2019
 * Hendersonville High School
 * Tax Company
 * 
 * Description: Calculates the consultation fee for a customer of a tax company
 * Difficulties: punctuality
 * What I learned: if you structure if else statements in the right order, you don't have to have as many conditions for each statement.
*/
// import java.io.* and java.util.*
import java.util.*;
public class danielRubianesM9TaxCompany
{
    public static void main(String args[])
    {
    	boolean another = true;
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	while (another) {
	    	danielRubianesCustomer currentCustomer = new danielRubianesCustomer();
	        System.out.print("Enter the income of this customer: ");
	        currentCustomer.setIncome(input.nextInt());
	        System.out.print("Enter the consulting time for this customer: ");
	        currentCustomer.setConsultingTime(input.nextInt());
	        System.out.print("Enter the hourly rate: ");
	        int hourlyRate = input.nextInt();
	        System.out.printf("The consulting fee for this customer is $%.2f", currentCustomer.calcConsultingFee(hourlyRate));
	        System.out.println("\nWould you like to calculate the fee for another? (y/n)");
	        String answer = input.next();
	        if (answer.toLowerCase().equals("y")) {another = true;}
	        else {another = false;}
	    }
	    input.close();
    }
}

/*
Sample Output: 
Enter the income of this customer: 455500
Enter the consulting time for this customer: 45
Enter the hourly rate: 27
The consulting fee for this customer is $506.25
Would you like to calculate the fee for another? (y/n)
y
Enter the income of this customer: 2000
Enter the consulting time for this customer: 32
Enter the hourly rate: 27
The consulting fee for this customer is $27.00
Would you like to calculate the fee for another? (y/n)
n

 */