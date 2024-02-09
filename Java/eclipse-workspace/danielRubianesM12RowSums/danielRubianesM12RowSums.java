/*
 * Daniel Rubianes
 * Date: 3/19/2019
 * Hendersonville High School
 * Row Sums
 * 
 * Description: Finds the sums of both the rows ans columns for a 2d array
 * Difficulties: none
 * What I learned: How to find the sums of rows and columns for 2d arrays
*/
class danielRubianesM12RowSums
{
	public static void main (String[] args) 
	{
		// initilize data
		int[][] data = { {3, 2, 5},
		                 {1, 4, 4, 8, 13},
		                 {9, 1, 0, 2},
		                 {0, 2, 6, 3, -1, -8} };
		
		// compute the sums for each row
		// declare the sum
		int sum = 0;
		for (int row = 0; row < data.length; row++)
		{
		  // initialize the sum
		  sum = 0;
		  
		  // compute the sum for this row
		  for (int col = 0; col < data[row].length; col++) {
			  sum += data[row][col];
		  }
		  
		  // write the sum for this row
		  System.out.println("The sum for row #" + (row+1) + " is " + sum + ".");
		}
		
		System.out.println();
		
		// compute the sums for each column
		// find length of longest row
		int longestLength = 0;
		for (int row = 0; row < data.length; row++) {
			if (longestLength < data[row].length) 
			{longestLength = data[row].length;}
		}
		// create array of sums
		int[] colSums = new int[longestLength];
		// add each value in each row to the colSums array
		for (int row = 0; row < data.length; row++) {
			for (int col=0; col < data[row].length; col++) {
				colSums[col] += data[row][col];
			}
		}
		// print out the sums of the columns
		for (int index = 0; index < colSums.length; index++) {
			System.out.println("The sum for column #" + (index+1) + " is " + colSums[index] + ".");
		}
	}
}  
/*
Sample Output: 
The sum for row #1 is 10.
The sum for row #2 is 30.
The sum for row #3 is 12.
The sum for row #4 is 2.

The sum for column #1 is 13.
The sum for column #2 is 9.
The sum for column #3 is 15.
The sum for column #4 is 13.
The sum for column #5 is 12.
The sum for column #6 is -8.
 */