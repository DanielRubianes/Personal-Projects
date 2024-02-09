/*
 * Daniel Rubianes
 * Date: 1/7/2019
 * Hendersonville High School
 * Overloaded
 * 
 * Description: An example of how methods can be overloaded by having multiple definitions that are differentiated by the objects called by an instance of a method.
 * Difficulties: None
 * What I learned: How to overload methods.
*/
// import java.util.*
import java.util.*;
public class danielRubianesEnrichmentOverloaded
{
	private static int product(int number) {return number * number;}
	/*
	 * Method: product(int number)=
	 * Purpose: Returns the square of the given number.
	 * Pre: int number
	 * Post: int number^2
	*/
	private static double product(double number) {return number * number;}
	/*
	 * Method: product(double number)
	 * Purpose: Returns the square of the given number.
	 * Pre: double number
	 * Post: double number^2
	*/
	private static double product(int number, int number2) {return number * number2;}
	/*
	 * Method: product(int number, int number2)
	 * Purpose: Returns the product of the two numbers.
	 * Pre: int number1, int number2
	 * Post: double number1*number2
	*/
    public static void main(String args[])
    {
    	System.out.println("Call product (5): " + product(5));
    	System.out.println("Call product (5.0): " + product(5.0));
   		System.out.println("Call product (5, 6): " +  product(5, 6));
    }
}

/*
Sample Output: 
Call product (5): 25
Call product (5.0): 25.0
Call product (5, 6): 30.0

 */