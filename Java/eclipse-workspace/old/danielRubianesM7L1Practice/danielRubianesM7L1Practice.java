/*
 * Daniel Rubianes
 * Date: 12/10/18
 * Hendersonville High School
 * M7L1 practice activity
 * 
 * Description: Displays use of the String.length() & String.substring() methods
 * Difficulties: Punctuality
 * What I learned: How to use the String.length() & String.substring() methods
*/
public class danielRubianesM7L1Practice
{
    public static void main(String args[])
    {
    	// Video 1; concatenates both strings with a space in the middle, then prints the resultant string out.
        String str1 = "Hello";
        String str2 = "good buddy";
        String concat = str1 + str2;
        System.out.println(concat.length());
        
        // Video 2; Creates a substring of myPet, starting at the 5th character and ending with the 12th character.
        String myPet = "Sparky the dog";
        String smallPart = myPet.substring(4,12);
        System.out.println(smallPart);
    }
}

/*
Sample Output: 
15
ky the d
 */