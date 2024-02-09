/*
 * Daniel RupperBoundianes
 * Date: 3/4/2019
 * Hendersonville High School
 * Binary search
 * 
 * Description: Program that displays binary searching, which is an efficient way of finding the index of a value within an ordered list
 * Difficulties: none
 * What I learned: How to write a binary search algorithm
*/
public class danielRubianesM11BinarySearch
{
    public static void main(String args[])
    {
        int ints[] = {-7,15,21,22,43,49,51,67,78,81,84,89,95,97};
        int lowerBound = 0;
    	int upperBound = ints.length - 1;
        System.out.println(binarySearch(ints, 22, lowerBound, upperBound));
        System.out.println(binarySearch(ints, 89, lowerBound, upperBound));
        System.out.println(binarySearch(ints, -100, lowerBound, upperBound));
        System.out.println(binarySearch(ints, 72, lowerBound, upperBound));
        System.out.println(binarySearch(ints, 102, lowerBound, upperBound));
    }
    
    // recursive (returns index of searchVal or -1 if the value is not in the list)
    private static int binarySearch(int array[], int searchVal, int lowerBound, int upperBound) {
    	if (lowerBound > upperBound) {
    		return -1;
    	}
    	else {
    		int middle = (lowerBound + upperBound)/2;
    		if (array[middle] == searchVal) {
    			return middle;
    		}
    		else if (searchVal > array[middle]) {
    			return binarySearch(array, searchVal, middle+1, upperBound);
    		}
    		else {
    			return binarySearch(array, searchVal, lowerBound, middle-1);
    		}
    	}
    }
    
    /* non-recursive:
    private static int binarySearch(int array[], int searchVal) {
    	int lowerBound = 0;
    	int upperBound = array.length - 1;
    	
    	while (lowerBound <= upperBound) {
    		int middle = (lowerBound + upperBound)/2;
    		if (array[middle] == searchVal) {
    			return middle;
    		}
    		else if (searchVal > array[mid]) {
    			lowerBound = middle + 1;
    		}
    		else {
    			upperBound = middle -1;
    		}
    	}
    	return -1;
    } */
}

/*
Sample Output: 
3
11
-1
-1
-1

 */