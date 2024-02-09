/*
 * Daniel Rubianes
 * Date: 1/7/18
 * Hendersonville High School
 * Vowels and Consonants
 * 
 * Description: Takes in a string and outputs the number of vowels and the number of consonants in the string.
 * Difficulties: Detection not working with uppercase characters; fixed by converting the tested character to lowercase.
 * What I learned: How to make a method that tests if a character is a consonant.
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM9NumOfVowels
{
	private static boolean isVowel(char character) {
		if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {return true;}
		else {return false;}
	}
	/*
	 * Method: isVowel(char character)
	 * Purpose: Tests if the given character is a vowel.
	 * Pre: A character in the primitive type char.
	 * Post: A boolean that is true if the character is a vowel.
	*/
	private static boolean isConsonant(char character) {
		if ((character == 'b' || character == 'c' || character == 'd' || character == 'f' || character == 'g' ||
		     character == 'h' || character == 'j' || character == 'k' || character == 'l' || character == 'm' || 
		     character == 'n' || character == 'p' || character == 'q' || character == 'r' || character == 's' || 
		     character == 't' || character == 'v' || character == 'w' || character == 'x' || character == 'y' || character == 'z')) {return true;}
		else {return false;}
	}
	/*
	 * Method: isConsonant(char character)
	 * Purpose: Tests if the given character is a consonant.
	 * Pre: A character in the primitive type char.
	 * Post: A boolean that is true if the character is a consonant.
	*/
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	// boolean to run the loop
    	boolean another = true;
    	while (another) {
    		// ask for string
	    	System.out.println("Please enter a string of characters.");
	    	String string = input.nextLine();
	    	// initialize variables
	    	int numberOfVowels = 0;
	    	int numberOfConsonants = 0;
	    	for (int index = 0; index <= string.length()-1; index++) {
	    		// set currentChar to the character at the current index, converted to lowercase
	    		char currentChar = Character.toLowerCase(string.charAt(index));
	    		// add one to numberOfVowels if the character is a vowel
	    		if (isVowel(currentChar)) {numberOfVowels++;}
	    		// add one to numberOfConsonants if the character is a consonant.
	    		if (isConsonant(currentChar)) {numberOfConsonants++;}
	    	}
	    	System.out.println("The string \"" + string + "\" contains " + numberOfConsonants + " consonants and " + numberOfVowels + " vowels.");
	    	
	    	// ask the user if they would like to enter another string and continue the loop if the answer is yes.
	    	System.out.print("Would you like to enter a new string (y/n)? ");
	    	String choice = input.nextLine();
	    	if (choice.toLowerCase().equals("y")) {another = true;}
	    	else {another = false;}
    	}
    }
}

/*
Sample Output: 
Please enter a string of characters.
Little Miss Muffet sat on her tuffet.
The string "Little Miss Muffet sat on her tuffet." contains 20 consonants and 10 vowels.
Would you like to enter a new string (y/n)? y
Please enter a string of characters.
Peter piper picked a peck of pickled peppers.
The string "Peter piper picked a peck of pickled peppers." contains 24 consonants and 13 vowels.
Would you like to enter a new string (y/n)? n

 */