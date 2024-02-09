/*
 * Daniel Rubianes
 * Date: 10/9/18
 * Hendersonville High School
 * Quadratic Equation Solver
 * Description: Finds the zeros for two quadratic functions
 * Difficulties: Producing an output of "NaN, NaN"; this was caused by taking the square root of a negative number.
 * What I learned: How to make a function that finds the zeros of a quadratic function in java
*/
public class danielRubianesMod3Roots
{
	// Function to solve the quadratic equation and return both values
	public static String solve(double a, double b, double c) 
	{
		double plus = (b*(-1) + Math.sqrt(Math.pow(b, 2) - 4*a*c)) / (2*a);
		double minus = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);
		return plus + ", " + minus;
    }
    public static void main(String args[])
    {
    	int a,b,c;
    	a = 6;
    	b = -7;
    	c = -3;
    	System.out.println("Quadratic Equation Solver");
    	System.out.println("If a, b, and c are "+a+", "+b+", and "+c+", the roots are " + solve(a,b,c));
    	a = 2;
    	b = -7;
    	c = 3;
    	System.out.println("Quadratic Equation Solver");
    	System.out.println("If a, b, and c are "+a+", "+b+", and "+c+", the roots are " + solve(a,b,c));
    }
}

/*
 * Sample Output: 
 * Quadratic Equation Solver
 * If a, b, and c are 6, -7, and -3, the roots are 1.5, -0.3333333333333333
 * Quadratic Equation Solver
 * If a, b, and c are 2, -7, and 3, the roots are 3.0, 0.5
 */