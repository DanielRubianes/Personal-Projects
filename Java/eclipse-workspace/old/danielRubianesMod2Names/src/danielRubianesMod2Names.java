/*
 * Daniel Rubianes
 * Date: 9/20/18
 * Hendersonville High School
 * Program Name
 * 
 * Description: Displays my name, the length of my first name, and 3 letters of my last name
 * Difficulties: None
 * What I learned: Nothing
*/
public class danielRubianesMod2Names
{
    public static void main(String args[])
    {
        String firstName = "Daniel";
        String lastName = "Rubianes";
        System.out.println("My name is " + firstName + " " + lastName);
        System.out.println("My first name is " + firstName.length() + " letters long");
        System.out.println("A substring of my last name is " + lastName.substring(1, 4));
    }
}

/*
 * Sample Output: 
 * My name is Daniel Rubianes
 * My first name is 6 letters long
 * A substring of my last name is ubi
 */