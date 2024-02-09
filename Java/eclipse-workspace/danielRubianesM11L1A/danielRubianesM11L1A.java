/*
 * Daniel Rubianes
 * Date: 2/24/2019
 * Hendersonville High School
 * Array sorting
 * 
 * Description: Program that creates an array of a specified length, sorts it, and displays the execution time
 * Difficulties: none
 * What I learned: How to store how long an operation took in java
*/
// import java.util.*
import java.util.*;
public class danielRubianesM11L1A
{
  // Sort the Array
  public static void selectionSort( int[] array )
  {
    // Find the integer that should go in each cell of
    // the array, from cell 0 to the end
    for ( int index=0; index<array.length-1; index++ )
    {
      // Find min: the index of the integer that should go into cell index.
      // LoosubIndex through the unsorted integers (those at index or higher)
       for ( int subIndex=index+1; subIndex<array.length; subIndex++ ) {
    	   int min = index;
    	   if ( array[subIndex] < array[min] ) {min = subIndex;}
    	   // Swap the int at index with the int at min
    	   int temp = array[index];
    	   array[index] = array[min];
    	   array[min] = temp;
       }
    }
  }
  
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
	  
	  // populate the array
	  int indexOfTen = 0;
	  for (int index = 0; index < values.length; index++) {
		  if (indexOfTen < 10) {
			  values[index] = rand.nextInt(101);
			  indexOfTen++;
		  }
		  else {
			  indexOfTen = 0;
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
	  
	  // sort the array  & record how long it took, then repeat with the already sorted array
	  double startTime = System.currentTimeMillis();
	  selectionSort(values);
	  double endTime = System.currentTimeMillis();
	  System.out.println("Total execution time for first sort: " + ((endTime - startTime)/1000) + " seconds");
	  startTime = System.currentTimeMillis();
	  selectionSort( values );
	  endTime = System.currentTimeMillis();
	  System.out.println("Total execution time for redundant sort: " + ((endTime - startTime)/1000) + " seconds");
	  // the second sort usually takes less time because it requires fewer steps
	  
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
	  
	  // find number of duplicates
	  int duplicates = 0;
	  for (int index = 0; index < values.length; index++) {
		  for (int subIndex = index+1; subIndex < values.length; subIndex++) {
			  if (values[index] == values[subIndex]) {
				  duplicates++;
			  }
		  }
	  }
	  System.out.println("Number of duplicates: " + duplicates);
	  
	  input.close();
  }
}
/*
Sample Output: 

Enter the amount of values would you like to generate: 50
initial values: 
47 97 18 77 43 83 62 24 30 74 11 29 1 4 45 55 20 4 97 34 99 99 19 40 42 68 68 21 41 36 49 43 60 56 3 79 2 84 0 93 91 24 56 47 53 61 58 17 20 67 
Total execution time for first sort: 0.0 seconds
Total execution time for redundant sort: 0.0 seconds
sorted values: 
0 1 2 3 4 4 11 17 18 19 20 20 21 24 24 29 30 34 36 40 41 42 43 43 45 47 47 49 53 55 56 56 58 60 61 62 67 68 68 74 77 79 83 84 91 93 97 97 99 99 
Number of duplicates: 9

Enter the amount of values would you like to generate: 100000
Total execution time for first sort: 7.947 seconds
Total execution time for redundant sort: 7.837 seconds
That is too many numbers to display, but the array was successfully sorted.
Number of duplicates: 49501822


 */