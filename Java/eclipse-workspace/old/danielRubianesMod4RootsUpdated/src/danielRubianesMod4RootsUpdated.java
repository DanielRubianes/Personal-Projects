/*
 * Daniel Rubianes
 * Date: 10/15
 * Hendersonville High School
 * Roots Updated
 * 
 * Description: Finds the roots of a quatratic equation based on user input of a, b, and c
 * Difficulties: Turning the assignment in on time
 * What I learned: How to get basic user input in java.
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesMod4RootsUpdated
{
	// Function to solve the quadratic equation and return both values
		public static String solveEqn(double a, double b, double c) 
		{
			// calculate the "plus" form of the equation
			double plus = (b*(-1) + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
			// calculate the "minus" form of the equation
			double minus = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
			// return both roots
			return plus + ", " + minus;
	    }
	    public static void main(String args[])
	    {
	    	// introduces the program
	    	System.out.println("Quadratic Equation Solver\n-------------------------");
	    	// creates the scanner object used to get the a, c, and c variables for the quadratic equation
	    	Scanner getABC = new Scanner(System.in);
	    	// creates variables to store the values
	    	int a,b,c;
	    	// asks user for values and stores them in the corresponding variables
	    	System.out.println("Enter a value (integer):");
	    	a = getABC.nextInt();
	    	System.out.println("Enter b value (integer):");
	    	b = getABC.nextInt();
	    	System.out.println("Enter c value (integer):");
	    	c = getABC.nextInt();
	    	// calls the solveEqn function using the stored variables and outputs the roots to the console
	    	System.out.println("Roots: " + solveEqn(a,b,c));
	    }
}

/*
 * Sample Output: 
 * Quadratic Equation Solver 
 * -------------------------
 * Enter a value (integer):
 * [user input]4
 * Enter b value (integer):
 * [user input]-11
 * Enter c value (integer):
 * [user input]-3
 * 3.0, -0.25
 * If you enter the values 1, 0, 1, the program will return "NaN" for both roots. This is because it tries to take the square root of a negative number, which does not give a real answer.
 */