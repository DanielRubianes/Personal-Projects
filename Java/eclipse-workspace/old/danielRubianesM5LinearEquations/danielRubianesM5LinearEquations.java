/*
 * Daniel Rubianes
 * Date: 10/21/18
 * Hendersonville High School
 * Linear Equations
 * 
 * Description: Finds the solution to a linear equation
 * Difficulties: Punctuality
 * What I learned: Nothing new.
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesM5LinearEquations
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner input = new Scanner(System.in);
    	
    	// get A and B
    	System.out.println("Enter A:");
    	double slope = input.nextDouble();
    	System.out.println("Enter B:");
    	double intercept = input.nextDouble();
    	
    	// create string for displaying the equation
    	String equation;
    	if (intercept > 0) {
    		equation = slope+"x + "+intercept+" = 0";
    	}
    	else if (intercept < 0) {
    		equation = slope+"x + "+intercept+" = 0";
    	}
    	else {
    		equation = slope+"x = 0";
    	}
    	
    	// test if the problem has no solution, infinite solutions, or find the real solutions, then print output.
    	if ((slope == 0) && (intercept == 0)) {
    		System.out.println(equation+" --> There are infinite solutions");
    	}
    	else if ((slope == 0)) {
    		System.out.println(equation+" --> There are no solutions");
    	}
    	else {
    		System.out.println(equation+" --> X = "+(-intercept/slope));
    	}
    }
}

/*
 * Sample Output: 
 * Enter A:
 * [input]4
 * Enter B:
 * [input]-5
 * 4.0x + -5.0 = 0 --> X = 1.25

 */