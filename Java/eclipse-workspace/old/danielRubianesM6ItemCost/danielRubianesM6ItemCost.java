/*
 * Daniel Rubianes
 * Date: 11/1/2018
 * Hendersonville High School
 * Item Cost
 * 
 * Description: Reads a data file that contains a set of costs and finds the average of said costs, then prints the total of the costs added together, the number of costs, and the average.
 * Difficulties: Using nextInt() instead of next Double (the file contains doubles and this make nextInt() throw an error)
 * What I learned: Nothing new
*/
// import java classes for scanners and io
import java.util.*;
import java.io.*;
public class danielRubianesM6ItemCost
{
    public static void main(String args[]) throws FileNotFoundException
    {
    	// Create a scanner to read the file
    	Scanner dataFile = new Scanner(new File("data.in"));
    	// Create a scanner to read the first line of the file
    	Scanner itemCosts = new Scanner(dataFile.nextLine());
        
    	// Introduce the list of costs
    	System.out.println("Item Costs:");
    	
    	// initialize sum and number of cost variables
    	double sum = 0;
    	int costCount = 0;
    	
    	// List the item costs
    	while (itemCosts.hasNext()) {
    		double currentCost = itemCosts.nextDouble();
    		if (currentCost != 0) {
    			System.out.printf("$%.2f%n", currentCost);
    			// add current number to the sum
    			sum += currentCost;
    			// add 1 to the number of costs
    			costCount++;
    		}
    		else {
    			// break when the program gets to the number "0.00" in the file
    			break;
    		}
    	}
    	// calculate the average
    	double average = sum / costCount;
    	// print formatted results
    	System.out.printf("%nThe sum of the costs = $%.2f%nThe number of costs = %1d%nThe average cost = $%.2f", sum, costCount, average);
    }
}

/*
 * Sample Output: 
Item Costs:
$14.99
$39.99
$69.95
$74.95
$59.95
$49.95
$75.50
$14.50
$29.95
$29.95

The sum of the costs = $459.68
The number of costs = 10
The average cost = 45.97
 */