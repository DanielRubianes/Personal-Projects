/*
 * Daniel Rubianes
 * Date: 10/16
 * Hendersonville High School
 * Turn on the lights
 * 
 * Description: Calculates an electric bill as well as how much the bill would be late based of user-input number of KWH
 * Difficulties: Turning the assignment in on time
 * What I learned: How to display doubles as currency by rounding to two decimal places.
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesMod4ElectricBill
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner userInput = new Scanner(System.in);
    	
    	// ask user for KWH used and store in KWHUsed
    	System.out.println("Enter KWH used this month:");
    	int KWHUsed = userInput.nextInt();
    	
    	// program introduction (repeats KWH used)
    	System.out.println("    	        APCS  Electric\r\n" + "------------------------------------------------");
    	System.out.println("Kilowatts Used\t"+KWHUsed+" @\t$  0.0425\r\n" + "------------------------------------------------");
    	// display the base charge
    	System.out.print("Base Charge\t\t$  "); System.out.printf("%.2f\n", KWHUsed*.0425);
    	// display the surcharge amount
    	System.out.print("Surcharge\t\t$  "); System.out.printf("%.2f\n", (KWHUsed*.0425)*.1);
    	// display tax
    	System.out.print("City Tax\t\t$  "); System.out.printf("%.2f\n", (KWHUsed*.0425)*.03);
    	System.out.println("\t\t\t---------");
    	// display bill amount
    	System.out.print("Pay this amount\t\t$  "); System.out.printf("%.2f\n", (KWHUsed*.0425)*1.13);
    	// display bill amount after 4% late fee
    	System.out.print("\nAfter May 20 pay\t$  "); System.out.printf("%.2f\n", ((KWHUsed*.0425)*1.13)*1.04);
    }
}

/*
 * Sample Output: 
 * Enter KWH used this month:
 * [input]997
 * 	        APCS  Electric
 * ------------------------------------------------
 * Kilowatts Used	997 @	$  0.0425
 * ------------------------------------------------
 * Base Charge		$  42.37
 * Surcharge		$  4.24
 * City Tax			$  1.27
 * 					---------
 * Pay this amount	$  47.88
 * After May 20 pay	$  49.80
 */