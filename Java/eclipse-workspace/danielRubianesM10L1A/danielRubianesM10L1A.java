/*
 * Daniel Rubianes
 * Date: 2/6/2019
 * Hendersonville High School
 * Program Name
 * 
 * Description: Program that creates an array, prints it out, then reverses the order and prints out the reversed array
 * Difficulties: I originally made the for loop run through the array, but this countered the effect of it because the loop went through the latter half of the array and reversed it back.
 * What I learned: How to write a simple for loop that reverses and array in java.
*/
public class danielRubianesM10L1A
{
	public static void main ( String[] args )
	{
		// creates array & temp variable
		int[] array = {0, 1, 2, 3, 4}; 
		int temp;
		
		// prints out array before reversing
		System.out.println("Original Array: " + array[0] + " " + array[1] + " " + array[2] + " " + array[3]);
		
		// runs for the first half of the array
		for (int index = 0; index < array.length/2; index++) {
			// set the temp variable to the current index of the array
			temp = array[index];
			// set the current index of the array to the value on the opposite side
			array[index] = array[array.length-1 - index];
			// set the value on the opposite side to the value stored in the temp variable
			array[array.length-1 - index] = temp;
		}

		// prints out array after reversing
		System.out.println("Reversed Array: " + array[0] + " " + array[1] + " " + array[2] + " " + array[3]);
	  }
}

/*
Sample Output: 
Original Array: 0 1 2 3
Reversed Array: 4 3 2 1
 */