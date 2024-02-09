/*
 * Daniel Rubianes
 * Date: 11/6/2018
 * Hendersonville High School
 * Factorial Calculator
 * 
 * Description: Loop that takes a number as input and outputs the factorial of the number, then asks the user if they would like to calculate another, continuing if the response is yes, and ending the loop if not.
 * Difficulties: Using the int data type instead of long to calculate the factorials; the long data type supports larger numbers.
 * What I learned: How to calculate factorials in java using a for loop.
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM6Factorials
{
	// function that takes a number as input and outputs the factorial of said number
	public static long factorial(long number) {
		// initialize solution variable
		long solution = 1;
		// repeats, subtracting 1 from currNum until currNum is 0
		for (long currNum = number; currNum > 0; currNum--) {
			solution *= currNum;
		}
		// return the solution
		return solution;
	}
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// initialize continueLoop boolean and answer string
    	boolean continueLoop;
    	String answer;
    	
    	do {
    		// ask user for a number
        	System.out.print("Enter a number: ");
        	long number = input.nextInt();
        	
    		// output the factorial of the number
    		System.out.println("The value of " + number + "! is " + factorial(number));
    		
    		// ask the user if they want to calculate another factorial
    		System.out.print("Would you like to calculate another number? ");
    		answer = input.next();
    		
    		// continue if "yes" or "Yes"
    		if (answer.equals("yes") || answer.equals("Yes")) {continueLoop = true;}
    		// end program if answer is anything else
    		else {continueLoop = false;}
    	} while (continueLoop);
    	// output "End factorial processing"
    	System.out.println("End factorial processing");
    	input.close();
    }
}

/*
Sample Output: 
Enter a number: [input]6
The value of 6! is 720
Would you like to calculate another number? Yes
Enter a number: [input]9
The value of 9! is 362880
Would you like to calculate another number? Yes
Enter a number: [input]12
The value of 12! is 479001600
Would you like to calculate another number? Yes
Enter a number: [input]20
The value of 20! is 2432902008176640000
Would you like to calculate another number? Yes
Enter a number: [input]15
The value of 15! is 1307674368000
Would you like to calculate another number? Yes
Enter a number: [input]17
The value of 17! is 355687428096000
Would you like to calculate another number? Yes
Enter a number: 13
The value of 13! is 6227020800
Would you like to calculate another number? No
End factorial processing
 */