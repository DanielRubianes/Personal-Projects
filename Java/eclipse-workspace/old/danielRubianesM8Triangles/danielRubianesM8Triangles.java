/*
 * Daniel Rubianes
 * Date: 12/25/18
 * Hendersonville High School
 * Triangle calculator
 * 
 * Description: takes the 3 sides of a triangle as input, then outputs if the triangle is right, equilateral, isosceles, or none of these, as well as its area.
 * Difficulties: Using int type as the input for the sides within the area() method; this made the function round unnecessarily and output incorrect answers. This was fixed by changing the type to double.
 * What I learned: How to properly document methods.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM8Triangles
{
	/*
	 * Method: isRight()
	 * Purpose: Determines if a triangle with the given sides is right.
	 * Pre: The three sides of a triangle as integers.
	 * Post: A boolean that is true if the triangle is right.
	*/
	private static boolean isRight(int side1, int side2, int side3) {
		int hypotenuse, leg1, leg2;
		// this block of if statements determines which side is the longest
    	if ((side1 > side2) && (side1 > side3)) {
    		hypotenuse = side1;
    		leg1 = side2;
    		leg2 = side3;
    	}
    	else if ((side2 > side1) && (side2 > side3)) {
    		hypotenuse = side2;
    		leg1 = side1;
    		leg2 = side3;
    	}
    	// happens if the longest side is side3, or if there is a tie, but the tie is irrelevant because right triangles can not have a tie for the largest side
    	else {
    		hypotenuse = side3;
    		leg1 = side1;
    		leg2 = side2;
    	}
    	// checks if a^2 + b^2 = c^2, if this is true, then the triangle is right and the function returns true
		if ((Math.pow(leg1, 2)+Math.pow(leg2, 2)) == Math.pow(hypotenuse, 2)) {return true;}
		else {return false;}
	}
	/*
	 * Method: isIsosceles()
	 * Purpose: Determines if a triangle with the given sides is isosceles, returns true if only two sides are equal.
	 * Pre: The three sides of a triangle as integers.
	 * Post: A boolean that is true if the triangle is isosceles.
	*/
	private static boolean isIsosceles(int side1, int side2, int side3) {
		if (((side1 == side2) && (side1 != side3)) || 
			((side1 == side3) && (side1 != side2)) || 
			((side2 == side3) && (side1 != side3))) {return true;}
		else {return false;}
	}
	/*
	 * Method: isEquilateral()
	 * Purpose: Determines if a triangle with the given sides is equilateral, returns true if all sides are equal.
	 * Pre: The three sides of a triangle as integers.
	 * Post: A boolean that is true if the triangle is equilateral.
	*/
	private static boolean isEquilateral(int side1, int side2, int side3) {
		if ((side1 == side2) && (side1 == side3)) {return true;}
		else {return false;}
	}
	/*
	 * Method: area()
	 * Purpose: Finds the area of a triangle with the given sides using Heron's formula; sqrt(p(p-a)(p-b)(p-c)), where p = half of the perimeter and a, b, & c are the sides of the triangle.
	 * Pre: The three sides of a triangle as doubles.
	 * Post: The area of the triangle as a double.
	*/
	private static double area(double side1, double side2, double side3) {
		double halfPerimeter = (side1 + side2 + side3)/2;
		return Math.sqrt(halfPerimeter*(halfPerimeter-side1)*(halfPerimeter-side2)*(halfPerimeter-side3));
	}
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the three sides of the triangle. (Place a space between each number)");
    	// gets user's input
    	String sides = input.nextLine();
    	// splits input into three integers
    	Scanner sidesScanner = new Scanner(sides);
    	int side1 = sidesScanner.nextInt();
    	int side2 = sidesScanner.nextInt();
    	int side3 = sidesScanner.nextInt();
    	sidesScanner.close();
    	
    	if (Double.isNaN(area(side1, side2, side3)) || area(side1, side2, side3) == 0) {
    		// returns this if the area calculates to 0 or NaN, meaning the triangle with the given sides is impossible
    		System.out.println("Impossible triangle!");
    	}
    	else if (isRight(side1, side2, side3)) {
    		System.out.println("This is a right triangle with area of " + area(side1, side2, side3) + ".");
    	}
    	else if (isIsosceles(side1, side2, side3)) {
    		System.out.println("This is an isosceles triangle with area of " + area(side1, side2, side3) + ".");
    	}
    	else if (isEquilateral(side1, side2, side3)) {
    		System.out.println("This is an equilateral triangle with area of " + area(side1, side2, side3) + ".");
    	}
    	// returns if the triangle is not right, isosceles, or equilateral
    	else {System.out.println("This triangle is not right, isosceles, or equilateral, but its area is " + area(side1, side2, side3) + ".");}
    	input.close();
    }
}

/*
Sample Output: 
Enter the three sides of the triangle. (Place a space between each number)
2 7 7
This is an isosceles triangle with area of 6.928203230275509.

Enter the three sides of the triangle. (Place a space between each number)
7 2 7
This is an isosceles triangle with area of 6.928203230275509.

Enter the three sides of the triangle. (Place a space between each number)
3 4 5
This is a right triangle with area of 6.0.

Enter the three sides of the triangle. (Place a space between each number)
7 7 7
This is an equilateral triangle with area of 21.21762239271875.

 */