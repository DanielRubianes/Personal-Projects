/**
  * class to create firefly objects
  * 
  * @author Daniel Rubianes
  * @version 2/19
 */
import java.util.*;
public class danielRubianesFirefly {
	Random rand = new Random();
	// instance variables
	private double XPos;
	private double YPos;
	private double ZPos;
	private boolean alive;
	public String toString() {
		return "X: " + XPos + "\n" + 
			   "Y: " + YPos + "\n" + 
			   "Z: " + ZPos + "\n" +
			   "Is Alive: " + alive + "\n";
	}
	/** Method: toString()
	 * Purpose: converts a firefly object to a string
	 * Pre: none
	 * Post: returns a string containing the coordinates and life status of the given firefly */
	// --- constructor --- //
	public danielRubianesFirefly() {
		XPos = rand.nextDouble()*20 - 10;
		YPos = rand.nextDouble()*20 - 10;
		ZPos = rand.nextDouble()*20 - 10;
		alive = true;
	}
	/** Method: danielRubianesFirefly()
	 * Purpose: creates a firefly object
	 * Pre: none
	 * Post: firefly obect with random position and true alive value */
	// --- Accessors --- //
	public double getX() {return XPos;}
	/** Method: getX()
	 * Purpose: gets the X value for the given firefly
	 * Pre: none
	 * Post: returns the X value for the given firefly */
	public double getY() {return YPos;}
	/** Method: getY()
	 * Purpose: gets the Y value for the given firefly
	 * Pre: none
	 * Post: returns the Y value for the given firefly */
	public double getZ() {return ZPos;}
	/** Method: getZ()
	 * Purpose: gets the Z value for the given firefly
	 * Pre: none
	 * Post: returns the Z value for the given firefly */
	public boolean getLife() {return alive;}
	/** Method: getLife()
	 * Purpose: gets the life status for the given firefly
	 * Pre: none
	 * Post: returns the life status for the given firefly */
	
	// --- Mutators --- //
	public void setX(double newX) {XPos = newX;}
	/** Method: setX()
	 * Purpose: sets the X value for the given firefly
	 * Pre: double newX
	 * Post: changes the X value for the given firefly */
	public void setY(double newY) {YPos = newY;}
	/** Method: setY()
	 * Purpose: sets theY  value for the given firefly
	 * Pre: double newY
	 * Post: changes the Y value for the given firefly */
	public void setZ(double newZ) {ZPos = newZ;}
	/** Method: setZ()
	 * Purpose: sets the Z value for the given firefly
	 * Pre: double newZ
	 * Post: changes the Z value for the given firefly */
	public void setLife(boolean status) {alive = status;}
	/** Method: setLife()
	 * Purpose: sets the value for the alive boolean
	 * Pre: none
	 * Post: changes the Z value for the given firefly */
	// --- Other --- //
	public void move() {
		XPos += rand.nextDouble()*2 - 1;
		YPos += rand.nextDouble()*2 - 1;
		ZPos += rand.nextDouble()*2 - 1;
	}
	/** Method: move()
	 * Purpose: moves the firefly a random amount in each dimension between -1 & 1
	 * Pre: none
	 * Post: adds a random number (-1.0, 1.0) to the Z, Y, & Z values for the given firefly object */
	public double getDistance(danielRubianesFirefly otherFirefly) {
		return Math.sqrt((XPos - otherFirefly.getX()) 
			  + Math.pow((YPos - otherFirefly.getY()), 2) 
		      + Math.pow((ZPos - otherFirefly.getZ()), 2)
		);
	}
	/** Method: getDistance()
	 * Purpose: gets the distance between two fireflies
	 * Pre: firefly object otherFirefly
	 * Post: returns the distance between the given fireflies using the 3D distance formula */
}
