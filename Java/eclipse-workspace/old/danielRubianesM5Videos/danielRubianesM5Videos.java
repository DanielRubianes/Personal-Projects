/*
 * Daniel Rubianes
 * Date: 10/21/18
 * Hendersonville High School
 * Booleans
 * 
 * Description: Sets three variables then does various tests returning booleans to the console.
 * Difficulties: None
 * What I learned: How to use booleans and conditional statements in java
*/
public class danielRubianesM5Videos
{
    public static void main(String args[])
    {
        int x = 37;
        int y = 49;
        int z = 37;
        // prints if x is equal to y
        boolean b = (x == y);
        System.out.println(b);
        // prints if x is less than or equal to y
        b = (x <= y);
        System.out.println(b);
        // prints true if x is greater than or equal to y and x is equal to z
        b = ((x >= y) && (x == z));
        System.out.println(b);
        // prints true if x is not less than y and x is equal to z
        b = (!(x < y) && (x == z));
        System.out.println(b);
        // prints true if x is greater than y or x is equal to z
        b = ((x > y) || (x == z));
        System.out.println(b);
    }
}

/*
 * Sample Output: 
 * false
 * true
 * false
 * false
 */