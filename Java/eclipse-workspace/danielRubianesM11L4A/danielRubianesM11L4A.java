/*
 * Daniel Rubianes
 * Date: 3/4/2019
 * Hendersonville High School
 * Binary sorting
 * 
 * Description: Reads a data file and writes its content to an array, then asks the use for a number and returns the position the number was in within the data (it is assumed that the data is already in order).
 * Difficulties: none
 * What I learned: How to reset a file scanner to the first line (close then re-open)
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM11L4A
{
	// binary search algorithm
	private static int binarySearch(int array[], int searchVal) {
    	int lowerBound = 0;
    	int upperBound = array.length - 1;
    	
    	while (lowerBound <= upperBound) {
    		int middle = (lowerBound + upperBound)/2;
    		if (array[middle] == searchVal) {
    			return middle;
    		}
    		else if (searchVal > array[middle]) {
    			lowerBound = middle + 1;
    		}
    		else {
    			upperBound = middle -1;
    		}
    	}
    	return -1;
    }
    public static void main(String args[]) throws FileNotFoundException
    {
    	// create the file scanner
    	Scanner dataFile = new Scanner(new File("data.dat"));
    	// count the number of lines in the file
    	int count = 0;
    	while (dataFile.hasNextLine()) {
    		dataFile.nextLine();
    		count++;
    	}
    	dataFile.close();
    	dataFile = new Scanner(new File("data.dat"));
    	// create and populate an array with the data
    	int data[] = new int[count];
    	int index = 0;
    	while (dataFile.hasNextLine()) {
    		data[index] = Integer.parseInt(dataFile.nextLine());
    		index++;
    	}
    	dataFile.close();
    	
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	boolean again = true;
    	while (again) {
    		System.out.print("Enter a number to search for: ");
    		int number = input.nextInt();
    		int numberIndex = binarySearch(data, number);
    		if (numberIndex == -1) {
    			System.out.println("Your number does not occur in this list");
    		}
    		else {
    			System.out.println("Your number occurs at position " + (numberIndex+1));
    		}
    		System.out.print("Continue? (y/n) ");
    		String choice = input.next();
    		if (!(choice.toLowerCase().equals("y"))) {again = false;}
    	}
    	input.close();
    }
}

/*
Sample Output: 
Enter a number to search for: 110
Your number does not occur in this list
Continue? (y/n) y
Enter a number to search for: 60
Your number occurs at position 41
Continue? (y/n) y
Enter a number to search for: 1
Your number occurs at position 1
Continue? (y/n) y
Enter a number to search for: 92
Your number occurs at position 53
Continue? (y/n) y
Enter a number to search for: 17
Your number does not occur in this list
Continue? (y/n) n

 */