/*
 * Daniel Rubianes
 * Date: 10/15
 * Hendersonville High School
 * Credit Card Theft
 * 
 * Description: Asks the user for a faux credit card number, then finds and displays an ASCII character generated using the numbers.
 * Difficulties: Turning the assignment in on time.
 * What I learned: How one can make use of the char data type in java.
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesMod4CreditCards
{
    public static void main(String args[])
    {
    	// create the scanner object
    	Scanner userInput = new Scanner(System.in);
    	System.out.println("Enter the credit card number (XX XX XX XX):");
    	// gets and stores all 4 portions of the card number
    	int cardNumber1 = userInput.nextInt();
    	int cardNumber2 = userInput.nextInt();
    	int cardNumber3 = userInput.nextInt();
    	int cardNumber4 = userInput.nextInt();
    	// find the number corresponding to the ASCII character by adding the 4 numbers together and finding the remainder when dividing by 26
    	int cardCode = (cardNumber1 + cardNumber2 + cardNumber3 + cardNumber4) % 26;
    	// convert this value to an uppercase ASCII character
    	char cardCharacter = (char) (cardCode + 65);
    	// Display the card number and the security character
    	System.out.println("The correct number and code is " + cardNumber1+" "+cardNumber2+" "+cardNumber3+" "+cardNumber4 + " " + cardCharacter);
    }
}

/*
 * Sample Output: 
 * Enter the credit card number (XX XX XX XX):
 * [input]26 54 74 56
 * The correct number and code is 26 54 74 56 C
 */