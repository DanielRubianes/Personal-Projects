/*
 * Daniel Rubianes
 * Date: 2/24/2019
 * Hendersonville High School
 * Sorting (revised to include insertion sorting)
 * 
 * Description: Program that showcases three methods of ordering arrays; selection, insertion and bubble sorting
 * Difficulties: none
 * What I learned: How to sort arrays using the insertion method
*/
public class danielRubianesM11L2PA
{
    public static void main(String args[])
    {
    	// create the array
    	int array[] = {4,2,5,1,3,18,0,9,6};
    	// sort the array
    	// bubbleSort(array);
    	// selectionSort(array);
    	System.out.println("test");
    	insertionSort(array);
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
    		for (int otherIndex = index+1; otherIndex < array.length; otherIndex++) {
    			if (array[otherIndex] < min) {
    				min = array[otherIndex];
    				minIndex = otherIndex;
    			}
    		}
    		array[minIndex] = array[index];
    		array[index] = min;
    	}
    }
    
    // sorting method 3 (insertion sort)
    public static void insertionSort(int array[]) {
    	int currentValue,otherIndex;
    	boolean continueLoop;
    	// Go through the array, placing each integer individually at its correct position
    	for (int index = 1; index < array.length; index++) {
    		currentValue = array[index];
    		otherIndex = index - 1;
    		continueLoop = true;
    		while ((otherIndex >= 0) && continueLoop) {
    			if (currentValue < array[otherIndex]) {
    				array[otherIndex+1] = array[otherIndex];
    				otherIndex--;
    				if (otherIndex == -1) {
    					array[0] = currentValue;
    				}
    				
    			}
    			else {
					continueLoop = false;
					array[otherIndex + 1] = currentValue;
				}
    		}
    	}
    }
}

/*
Sample Output: 
0 1 2 3 4 5 6 9 18 
 */