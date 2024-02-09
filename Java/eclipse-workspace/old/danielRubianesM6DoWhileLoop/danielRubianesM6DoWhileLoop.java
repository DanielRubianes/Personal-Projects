/*
 * Daniel Rubianes
 * Date: 11/5/2018
 * Hendersonville High School
 * Do While Loop
 * 
 * Description: Examples of while loops.
 * Difficulties: None
 * What I learned: the difference between a while loop and a do while loop
*/
public class danielRubianesM6DoWhileLoop
{
    public static void main(String args[])
    {
        int sum = 0;
        int j = 3;
        
        /* checks (j<=79) BEFORE each loop
        while(j<=79) {
        	sum += j;
        	j++;
        }
        */
        
        /* checks (j<=79) AFTER each loop
        do {
        	sum += j;
        	j++;
        } while (j<=79);
        */
        
        System.out.println(sum);
    }
}

/*
 * Sample Output: 
 * 3157
 */