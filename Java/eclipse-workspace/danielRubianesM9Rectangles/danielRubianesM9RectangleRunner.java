/*
 * Daniel Rubianes
 * Date: 1/15/2019
 * Hendersonville High School
 * Rectangles
 * 
 * Description: Asks user for length and width of a rectangle & returns the area and perimeter, using the rectangle class
 * Difficulties: none
 * What I learned: n/a
*/
// import java.util.*
import java.util.*;
public class danielRubianesM9RectangleRunner
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	boolean again = true;
    	while (again) {
	        System.out.println("Enter the length of the rectangle (in inches)");
	        int length = input.nextInt();
	        System.out.println("Enter the width of the rectangle (in inches)");
	        int width = input.nextInt();
	        danielRubianesM9Rectangle rectangle = new danielRubianesM9Rectangle(length, width);
	        System.out.print("The are of the rectegle is " + rectangle.getArea() + " inches. The perimeter is " + rectangle.getPerimeter() + " inches. Would you like to run another? (y/n) ");
	        String answer = input.next();
	        if (answer.toLowerCase().equals("y")) {again = true;}
	        else {again = false;}
    	}
    	input.close();
    }
}

/*
Sample Output: 
Enter the length of the rectangle (in inches)
6
Enter the width of the rectangle (in inches)
10
The are of the rectegle is 60 inches. The perimeter is 32 inches. Would you like to run another? (y/n) y
Enter the length of the rectangle (in inches)
10
Enter the width of the rectangle (in inches)
7
The are of the rectegle is 70 inches. The perimeter is 34 inches. Would you like to run another? (y/n) y
Enter the length of the rectangle (in inches)
5
Enter the width of the rectangle (in inches)
5
The are of the rectegle is 25 inches. The perimeter is 20 inches. Would you like to run another? (y/n) n

 */