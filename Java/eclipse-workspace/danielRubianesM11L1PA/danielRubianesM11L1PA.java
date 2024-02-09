/*
 * Daniel Rubianes
 * Date: 2/24/2019
 * Hendersonville High School
 * Sorting
 * 
 * Description: Program that showcases two methods of ordering arrays; selection and bubble sorting
 * Difficulties: none
 * What I learned: How to sort arrays using these methods
*/
public class danielRubianesM11L1PA
{
    public static void main(String args[])
    {
    	// create the array
    	int array[] = {4,2,5,1,3,18,0,9,6};
    	// sort the array
    	// bubbleSort(array);
    	selectionSort(array);
    	// display the array
    	for (int index = 0; index < array.length; index++) {
    		System.out.print(array[index] + " ");
    	}
    }
    
    // sorting method 1 (bubble sort)
    public static void bubbleSort(int array[]) {
    	boolean continueLoop;
    	do {
    		continueLoop = false;
    		for (int index = 0; index < array.length-1; index++) {
    			if (array[index] > array[index+1]) {
    				// swap the two values if the latter is greater
    				int temp = array[index];
    				array[index] = array[index+1];
    				array[index+1] = temp;
    				continueLoop = true;
    			}
    		}
    	} while(continueLoop);
    }
    
    // sorting method 2 (selection sort)
    public static void selectionSort(int array[]) {
    	int min, minIndex;
    	for (int index = 0; index < array.length; index++) {
    		min = array[index];
    		minIndex = index;
    		for (int subIndex = index+1; subIndex < array.length; subIndex++) {
    			if (array[subIndex] < min) {
    				min = array[subIndex];
    				minIndex = subIndex;
    			}
    		}
    		array[minIndex] = array[index];
    		array[index] = min;
    	}
    }
}

/*
Sample Output: 
0 1 2 3 4 5 6 9 18 
 */