/*
 * Daniel Rubianes
 * Date: 10/22/18
 * Hendersonville High School
 * Guessing Game
 * 
 * Description: The computer generates a random number between 1 and 100, then asks the user to guess until they get it correct, telling them if they need to guess higher or lower.
 * Difficulties: Punctuality
 * What I learned: How to use random nubmer generators in java.
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesM5GuessingGame
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner input = new Scanner(System.in);
    	
    	// crate the random number generator
    	Random rand = new Random();
    	
    	// introduce the program
    	System.out.println("--- Guessing Game ---");
    	
    	// generate the number
    	int randomNumber = rand.nextInt(100) + 1;
    	
    	// initialize guess variable
    	int guess;
    	
    	// repeat until the user's guess is correct
    	do {
    		// ask user for their guess
        	System.out.println("Enter your guess (1-100):");
        	guess = input.nextInt();
    		
	    	// test is the guess is above, below, or correct, then tell the user
	    	if (guess == randomNumber) {
	    		System.out.println("Your guess is correct!");
	    		System.out.println("The computer's number is: " + randomNumber);
	    	}
	    	else if (guess > randomNumber) {
	    		System.out.println("Your guess should be lower.\nTry again.");
	    	}
	    	else if (guess < randomNumber) {
	    		System.out.println("Your guess should be higher.\nTry again.");
	    	}
    	} while (guess != randomNumber);
	    	
    }
}

/*
 * Sample Output: 
 * --- Guessing Game ---
 * Enter your guess (1-100):
 * 50
 * Your guess should be higher.
 * Try again.
 * Enter your guess (1-100):
 * 60
 * Your guess should be higher.
 * Try again.
 * Enter your guess (1-100):
 * 70
 * Your guess should be higher.
 * Try again.
 * Enter your guess (1-100):
 * 80
 * Your guess should be lower.
 * Try again.
 * Enter your guess (1-100):
 * 75
 * Your guess should be lower.
 * Try again.
 * Enter your guess (1-100):
 * 73
 * Your guess is correct!
 * The computer's number is: 73
 */