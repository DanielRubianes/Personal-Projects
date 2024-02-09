/*
 * Daniel Rubianes
 * Date: 11/1/2018
 * Hendersonville High School
 * Basic While loop
 * 
 * Description: A program that displays the basic functionality of a while loop
 * Difficulties: None
 * What I learned: Nothing new
*/
public class danielRubianesMod6WhileLoop
{
    public static void main(String args[])
    {
    	// initialize sum to 0 and number to 3
    	int sum = 0;
    	int number = 3;
    	// loop until number is >79
        while(number<=79) {
        	// add number to sum
        	sum += number;
        	// add 1 to number
        	number++;
        }
        // print sum
        System.out.println(sum);
    }
}

/*
 * Sample Output: 
 * 3157
 */