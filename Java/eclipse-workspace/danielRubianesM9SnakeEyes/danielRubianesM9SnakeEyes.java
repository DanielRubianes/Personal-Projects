/*
 * Daniel Rubianes
 * Date: 1/18/2019
 * Hendersonville High School
 * Snake Eyes
 * 
 * Description: Rolls two dice a specified number of times and returns the number of snake eyes and the ratio of snake eyes to the number of rolls.
 * Difficulties: none.
 * What I learned: N/A
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM9SnakeEyes
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// ask the user for the number of rolls
    	System.out.print("Enter the number of rolls: ");
    	int numberOfRolls = input.nextInt();
    	
    	// create two die objects
    	danielRubianesDie die1 = new danielRubianesDie(6);
    	danielRubianesDie die2 = new danielRubianesDie(6);
    	int numberOfSnakeEyes = 0;
    	// roll the dice the number of time specefied
    	for (int index = 1; index <= numberOfRolls; index++) {
    		if (die1.roll() == die2.roll()) {
    			// add one to numberOfSnakeEyes if the rolls are equal
    			numberOfSnakeEyes++;
    		}
    	}
    	// return the nummber of snake eyes rolled and the ratio
    	System.out.println("# of snake eyes: " + numberOfSnakeEyes);
    	System.out.println("ratio: " + (double)numberOfSnakeEyes/(double)numberOfRolls);
    }
}

/*
Sample Output: 
Enter the number of rolls: 1000
# of snake eyes: 183
ratio: 0.183

 */