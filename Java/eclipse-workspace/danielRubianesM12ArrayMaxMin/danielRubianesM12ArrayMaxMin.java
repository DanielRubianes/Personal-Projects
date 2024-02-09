/*
 * Daniel Rubianes
 * Date: 3/19/2019
 * Hendersonville High School
 * Array max/min
 * 
 * Description: Program that calculates the maximum and minimum values within a 2d array and prints them out, then does the same for the maximum of each row within the array.
 * Difficulties: none
 * What I learned: How to calculate the maximum or minimum of a 2d array, or one row of a 2d array
*/
public class danielRubianesM12ArrayMaxMin
{
    public static void main(String args[])
    {
		int[][] data = { {3, 2, 5},
		        {1, 4, 4, 8, 13},
		        {9, 1, 0, 2},
		        {0, 2, 6, 3, -1, -8} };
		
		// declare and initialize the max and the min
		int max = data[0][0];
		int min = data[0][0];
		
		// find max and min values for each row
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++) 
			{
				if (data[row][col] > max)
				{max = data[row][col];}
				if (data[row][col] < min)
				{min = data[row][col];}
			}
		}
		 
		// write out the results
		System.out.println( "max = " + max + "; min = " + min );
		
		// find max for each row
		for (int row = 0; row < data.length; row++) {
			int rowMax = data[row][0];
			for (int col = 0; col < data[row].length; col++) {
				if (data[row][col] > rowMax)
				{rowMax = data[row][col];}
			}
			// print result
			System.out.println("The maximum value for row #" + (row+1) + " is " + rowMax + ".");
		}
    }
}

/*
Sample Output: 
max = 13; min = -8
The maximum value for row #1 is 5.
The maximum value for row #2 is 13.
The maximum value for row #3 is 9.
The maximum value for row #4 is 6.
 */