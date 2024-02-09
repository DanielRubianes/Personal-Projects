/**
  * class to create die objects
  * 
  * @author Daniel Rubianes
  * @version 1/18/2019
 */
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesDie {
	// instance variable
	private int numberOfSides;
	/**
	 * Method: danielRubianesDie() (constructor)
	 * Purpose: creates a die object
	 * Pre: int sides
	 * Post: creates a die object with the input number of sides
	*/
	public danielRubianesDie(int sides) {numberOfSides = sides;}
	/**
	 * Method: roll()
	 * Purpose: rolls a die object
	 * Pre: none
	 * Post: a random number from 1 to the number of sides
	*/
	public int roll() {
		Random rand = new Random();
		return rand.nextInt(numberOfSides)+1;
	}
}
