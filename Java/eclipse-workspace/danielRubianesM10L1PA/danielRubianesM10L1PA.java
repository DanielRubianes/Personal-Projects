/*
 * Daniel Rubianes
 * Date: 2/5/2019
 * Hendersonville High School
 * Array example
 * 
 * Description: An example of how arrays work in java
 * Difficulties: none
 * What I learned: how to make string arrays in java
*/
public class danielRubianesM10L1PA
{
    public static void main(String args[])
    {
    	// creates a string and a string array
        String string = "Hello again";
        String stringArray[];
        
        // splits the string and adds the parts to an array
        stringArray = string.split("a|g");
        
        // prints out all of the strings stored in the array
        for (int index = 0; index < stringArray.length; index++) {
        	System.out.println(stringArray[index]);
        }
    }
}

/*
Sample Output: 
Hello 


in
 */