/*
 * Daniel Rubianes
 * Date: 10/16
 * Hendersonville High School
 * Circle Tester Updated
 * 
 * Description: Creates two circle objects from user input of the radii, then displays their radius and diamerter, as well as the are rounded to the nearest tenth.
 * Difficulties: Turning the assignment in on time
 * What I learned: How to use printf to round numbers in java
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesMod4CircleTesterUpdated
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner userInput = new Scanner(System.in);
    	
    	// create two circles using user input for radius
    	System.out.println("Enter Radius 1:");
        danielRubianesMod4CircleUpdated circle1 = new danielRubianesMod4CircleUpdated(userInput.nextDouble());
    	System.out.println("Enter Radius 2:");
        danielRubianesMod4CircleUpdated circle2 = new danielRubianesMod4CircleUpdated(userInput.nextDouble());
        
        // display labels
        System.out.println("Circle\tRadius\tDiameter\tArea");
        
        // print the circle #, radius, and diameter for circle 1
        System.out.print("1\t"+circle1.radius+"\t"+circle1.radius*2+"\t\t");
        // print area rounded to the nearest tenth
        System.out.printf("%.1f\n", circle1.area());
        
        // print the circle #, radius, and diameter for circle 1
        System.out.print("1\t"+circle2.radius+"\t"+circle2.radius*2+"\t\t");
        // print area rounded to the nearest tenth
        System.out.printf("%.1f\n", circle2.area());
        
    }
}

/*
 * Sample Output: 
 * Enter Radius 1:
 * [input]3
 * Enter Radius 2:
 * [input]2.5
 * Circle	Radius	Diameter	Area
 * 1	3.0	6.0		28.3
 * 1	2.5	5.0		19.6
 */