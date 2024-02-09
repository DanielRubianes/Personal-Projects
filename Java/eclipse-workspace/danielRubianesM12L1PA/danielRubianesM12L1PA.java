/*
 * Daniel Rubianes
 * Date: 3/19/2019
 * Hendersonville High School
 * 2d arrays
 * 
 * Description: Program showcasing basic methods to modify and display information about 2d arrays
 * Difficulties: none
 * What I learned: How to use 2d arrays in java
*/
public class danielRubianesM12L1PA
{
    public static void main(String args[])
    {
        // three ways to initialize 2d arrays:
    	// method 1:
    	int[][] array1 = new int[2][2];
    	array1[0][0] = 1;
    	array1[0][1] = 2;
    	array1[1][0] = 3;
    	array1[1][1] = 4;
    	// method 2:
    	int[][] array2 = {
    			{1, 2},
    			{3, 4}
    	};
    	// method 3:
    	int array3[][] = new int[][] {
			{1, 2},
			{3, 4} 
		};
		// print out number of rows
		System.out.println(array1.length);
		// print out number of columns in the first row
		System.out.println(array2[0].length);
		// printing out a 2d array
    	int[][] reference = array3;
    	for (int index = 0; index < reference.length; index++) {
    		for (int subIndex = 0; subIndex < reference[index].length; subIndex++) {
    			System.out.print(reference[index][subIndex] + " ");
    		}
    		System.out.println();
    	}
    }
}

/*
Sample Output: 
2
2
1 2 
3 4 

 */