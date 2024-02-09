/*
 * Daniel Rubianes
 * Date: 3/19/2019
 * Hendersonville High School
 * Hashing example
 * 
 * Description: Gives the user a hash for the string they input
 * Difficulties: none
 * What I learned: How to create a hashing algorithm in java
*/
// import java.util.*
import java.util.*;
public class danielRubianesM11L5PA
{
	private static String hash(String string) {
		int hash = 9;
		for (int index = 0; index < string.length(); index++) {
			int currentChar = string.charAt(index);
			hash *= 23 + currentChar;
		}
		return Integer.toHexString(hash);
	}
	/** Method: hash()
	 * Purpose: creates a hexadecimal hash of the given string
	 * Pre: String string
	 * Post: returns a hexadecimal hash of the given string */
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	// main loop
    	boolean again = true;
    	while (again) {
    		System.out.print("Enter a string you would like to calculate a hash for: ");
    		String string = input.next();
    		System.out.println("String hash: " + hash(string));
    		System.out.print("Another? (y/n) ");
    		String choice = input.next();
    		if (!(choice.toLowerCase().equals("y"))) {again = false;}
    	}
    	input.close();
    }
}

/*
Sample Output: 

 */