/*
 * Daniel Rubianes
 * Date: 10/29/2018
 * Hendersonville High School
 * Calculator
 * 
 * Description: A basic calculator that asks the user which of the 4 basic math operations to perform, and two numbers to preform said operation on. It then uses a switch statement to take the two operands inputed by the user, perform the operation, and display the output.
 * Difficulties: Punctuality.
 * What I learned: How to use switch statements in java.
*/
// import java.io & java.util
import java.io.*;
import java.util.*;
public class danielRubianesM5Switch
{
    public static void main(String args[])
    {
    	// Ask the user which operation to perform
        System.out.println("Make your arithmetic selection from the choices below:\n");
        System.out.println("1. addition");
        System.out.println("2. subtraction");
        System.out.println("2. subtraction");
        System.out.println("3. multiplication");
        System.out.println("4. division\n");
        System.out.print("   Your choice? ");
        
        // get the user's choice, and both numbers to perform the operation on
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        
        System.out.print("\nEnter first operand: ");
        double op1 = input.nextDouble();
        
        System.out.print("\nEnter second operand: ");
        double op2 = input.nextDouble();
        
        input.close();
        
        // perform the operation selected with choice
        switch(choice)
        {
        	case 1: //addition
        		System.out.println(op1 + " plus " + op2 + " = " + (op1 + op2));
        		break;
        	case 2: // subtraction
        		System.out.println(op1 + " minus " + op2 + " = " + (op1 - op2));
        		break;
        	case 3: //multiplication
        		System.out.println(op1 + " times " + op2 + " = " + (op1 * op2));
        		break;
        	case 4: // division
        		System.out.println(op1 + " divided by " + op2 + " = " + (op1 / op2));
        		break;
        	default: 
        		// outputs if something other than 1, 2, 3, or 4 is selected at the choice
        		System.out.println("Please enter 1, 2, 3, or 4");
        }
    }
}

/*
 * Sample Output: 
Make your arithmetic selection from the choices below:

1. addition
2. subtraction
2. subtraction
3. multiplication
4. division

   Your choice? [input]3

Enter first operand: [input]6

Enter second operand: [input]3
6.0 times 3.0 = 18.0
 */