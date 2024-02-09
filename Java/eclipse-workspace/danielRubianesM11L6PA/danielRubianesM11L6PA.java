/*
 * Daniel Rubianes
 * Date: 3/19/2019
 * Hendersonville High School
 * ArrayList examples
 * 
 * Description: Program that showcases many of the methods that can be used to create and manipulate ArrayLists.
 * Difficulties: none
 * What I learned: How to better utilize ArrayLists in java.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM11L6PA
{
    public static void main(String args[])
    {
    	// create an ArrayList
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        // populate
        for (int index = 0; index < 15; index++) {
        	intArray.add(index*5);
        }
        // print out integer at index 7
        System.out.println(intArray.get(7));
        
        // create an iterator for the ArrayList
        Iterator<Integer> iterator = intArray.iterator();
        
        // two ways to remove "15" from the list
        // Method 1: indexOf
        intArray.remove(intArray.indexOf(15));
        /* Method 2: loop
        while (iterator.hasNext()) {
        	Integer currentInt = iterator.next();
        	if (currentInt == 15) {iterator.remove();}
        } */
        
        // print out the ArrayList
        System.out.println(intArray);
    }
}

/*
Sample Output: 
35
[0, 5, 10, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70]

 */