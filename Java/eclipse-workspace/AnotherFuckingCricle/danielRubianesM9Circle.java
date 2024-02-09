/**
  * Circle class
  * 
  * @author Daniel Rubianes
  * @version 1/21/2019
 */
public class danielRubianesM9Circle {
	/**
	 * Method: Constructor
	 * Purpose: creates a circle object
	 * Pre: double radius
	 * Post: a circle object with the specefied radius
	*/
	public danielRubianesM9Circle(double inputRadius) {
		radius = inputRadius;
	}
	/**
	 * Method: area()
	 * Purpose: finds the area of a circle object
	 * Pre: none
	 * Post: the area of the given circle object
	*/
	public double area() {
		double area = Math.PI * radius * radius;
		return area;
	}
	/**
	 * Method: circumference()
	 * Purpose: finds the circumference of a circle object
	 * Pre: none
	 * Post: the circumference of the given circle object
	*/
	public double circumference() {
		double circumference = 2 * Math.PI * radius;
		return circumference;
	}
	/**
	 * Method: setRadius() (mutator)
	 * Purpose: sets the radius of a circle object
	 * Pre: double radius
	 * Post: changes the radius of the given circle object to that specified
	*/
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
	/**
	 * Method: getRadius() (accessor)
	 * Purpose: returns the radius of a circle object
	 * Pre: none
	 * Post: the radius of the given circle object
	*/
	public double getRadius() {
		return radius;
	}
	// instance variable
	private double radius;
}
