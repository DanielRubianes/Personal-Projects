/*
 * Daniel Rubianes
 * Date: 10/16/18
 * Hendersonville High School
 * Circle Updated
 * 
 * Description: A java class for creating circle objects
 * Difficulties: Turning the assignment in on time
 * What I learned: How to use printf to round numbers in java
*/
public class danielRubianesMod4CircleUpdated
{
	// creates a circle object with radius as the input
    public danielRubianesMod4CircleUpdated(double r)
    {
        radius = r;
    }
    
    // returns the area of a circle
    public double area()
    {
    	double a = Math.PI * radius * radius;
    	return a;
    }
    
    // returns the circumference of a circle
    public double circumference()
    {
    	double c = 2 * Math.PI * radius;
    	return c;
    }
    
    // changes the radius of a circle
    public void setRadius(double nr)
    {
    	radius = nr;
    }
    
    public double radius;
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