/*
 * Daniel Rubianes
 * Date: 11/5/2018
 * Hendersonville High School
 * Start to end
 * 
 * Description: Asks user for a starting and ending number, then lists all numbers between inclusive and prints out the sum and averageof the data set.
 * Difficulties: None
 * What I learned: Nothing new
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM6StartEnd
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// ask user for start and end number
    	System.out.print("Enter starting number: ");
    	int startNumber = input.nextInt();
    	System.out.print("Enter ending number: ");
    	int endNumber = input.nextInt();
    	
    	// initialize sum, currentNumber and numberCount variables
    	int sum = 0;
    	int currentNumber = startNumber;
    	int numberCount = 0;
    	// loop until currentNumber is greater than endNumber
    	do {
    		// print current number
    		System.out.println(currentNumber);
    		// add current number to sum
    		sum += currentNumber;
    		// add one to number count
    		numberCount += 1;
    		// increment the current number
    		currentNumber += 1;
    	} while (currentNumber <= endNumber);
    	// print the sum
    	System.out.println("The sum of the numbers " + startNumber + " - " + endNumber + " is: " + sum);
    	// calculate the average
    	double average = sum / numberCount;
    	// print the average
    	System.out.println("The average of the numbers " + startNumber + " - " + endNumber + " is: " + average);
    }
}

/*
Sample Output: 
Enter starting number: 0
Enter ending number: 10
0
1
2
3
4
5
6
7
8
9
10
The sum of the numbers 0 - 10 is: 55
The average of the numbers 0 - 10 is: 5.0
 */