/*
 * Daniel Rubianes
 * Date: 2/24/2019
 * Hendersonville High School
 * Array sorting 2.0
 * 
 * Description: Program that creates an array of a specified length, sorts it, and displays the execution time, as well as the mean and median.
 * Difficulties: none
 * What I learned: How to find the medean of a data set in java.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM11L2A
{
	// Sort the list
	public static void insertionSort (int[] list)
	{
	   //  For each unsorted integer
	   for (int index = 1; index < list.length; index++)
	   {
	      //  keep swapping with its left neighbor 
	      //  until it is larger or equal to left neighbor
	      int otherIndex = index;
	      while (otherIndex > 0 && list[otherIndex-1] > list[otherIndex] )
	      {
	         int temp  = list[otherIndex-1];
	         list[otherIndex-1] = list[otherIndex];
	         list[otherIndex]   = temp;
	         otherIndex--;
	      }
	   }
	}
	   
	// check to see if the list is sorted
	public static boolean isSorted(int[] array) {
		boolean isSorted = true;
		// check each pair of values to see if the array is sorted
		for (int index = 0; index < array.length-1; index++) {
			if (!(array[index] <= array[index+1])) {isSorted = false;}
		}
		return isSorted;
	}
	
	public static void main ( String[] args )
	{
		// create the input scanner
		Scanner input = new Scanner(System.in);
		// create the random number generator
		Random rand = new Random();
		// ask the use what size the array should be
		System.out.print("Enter the amount of values would you like to generate: ");
		int size = input.nextInt();
		int[] values = new int[size];
		
		// populate the array (the change that makes every 10th number much larger skews the data to the left and makes the mean larger than the medean)
		int indexOfTen = 1;
		for (int index = 0; index < values.length; index++) {
			if (indexOfTen < 10) {
				values[index] = rand.nextInt(101);
				indexOfTen++;
			}
			else {
				indexOfTen = 1;
				values[index] = rand.nextInt(1001)+100;
			}
		}
			
		// print out the array if it is shorter than 101
		if (values.length < 101) {
			System.out.println("initial values: "); 
			for ( int value : values ) {
				System.out.print( value + " " );
			}
			System.out.println();
		}
		
		// sort the array& record how long it took, then repeat with the already sorted array
		double startTime = System.currentTimeMillis();
		insertionSort(values);
		double endTime = System.currentTimeMillis();
		System.out.println("Total execution time for first sort: " + ((endTime - startTime)/1000) + " seconds");
		startTime = System.currentTimeMillis();
		insertionSort( values );
		endTime = System.currentTimeMillis();
		System.out.println("Total execution time for redundant sort: " + ((endTime - startTime)/1000) + " seconds");
		
		// print out the sorted array if it is shorter than 101
		if (values.length < 101) {
			System.out.println("sorted values: "); 
			for ( int value : values ) {
				System.out.print( value + " " );
			}
			System.out.println();
		}
		else {
			if (isSorted(values)) {
				System.out.println("That is too many numbers to display, but the array was successfully sorted.");
			}
			else {
				System.out.println("That is too many numbers to display and there was an error. The numbers were not properly sorted!");
			}
		}
		// find & print out mean and median
		// mean
		double sum = 0;
		double count = 0;
		for (int index = 0; index < values.length; index++) {
			sum += values[index];
			count++;
		}
		double average = sum/count;
		System.out.printf("Mean for this array: %.2f\n", average);
		// median
		double median;
		if ((values.length % 2) == 0) {
			median = (values[values.length/2] + values[values.length/2 - 1])/2.0;
		}
		else {
			median = values[(values.length - 1)/2];
		}
		System.out.printf("Median for this array: %.1f\n", median);
		
		input.close();
	}
}

/* Output:
Enter the amount of values would you like to generate: 100
initial values: 
87 58 50 36 67 69 62 93 24 810 86 86 43 55 21 32 34 53 43 710 90 17 63 54 32 26 1 25 41 670 28 92 28 40 96 50 69 84 84 148 99 20 23 53 34 24 80 25 56 703 18 63 67 15 16 78 60 39 12 576 66 41 79 85 96 34 44 29 71 376 20 49 70 52 15 95 11 7 9 1004 15 21 1 64 9 84 51 43 94 335 67 85 60 17 50 83 29 72 45 724 
Total execution time for first sort: 0.0 seconds
Total execution time for redundant sort: 0.0 seconds
sorted values: 
1 1 7 9 9 11 12 15 15 15 16 17 17 18 20 20 21 21 23 24 24 25 25 26 28 28 29 29 32 32 34 34 34 36 39 40 41 41 43 43 43 44 45 49 50 50 50 51 52 53 53 54 55 56 58 60 60 62 63 63 64 66 67 67 67 69 69 70 71 72 78 79 80 83 84 84 84 85 85 86 86 87 90 92 93 94 95 96 96 99 148 335 376 576 670 703 710 724 810 1004 
Mean for this array: 105.20
Median for this array: 53.0

*/