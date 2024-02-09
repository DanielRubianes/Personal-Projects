/*
 * Daniel Rubianes
 * Date: 9/13/2018
 * Hendersonville High School
 * Variables
 * 
 * Description: Combines two strings, adding a space in the middle, displays the combined string's length, then displays a portion of a defined string; "Sparky the dog"
 * Difficulties: Forgetting semicolon
 * What I learned: How the substring() and length() functions work
*/
public class danielRubianesMod2Strings {
	public static void main(String args[]) {
		// These two strings have bad names because their names do not describe the strings
		String nm = "Hello";
		String nx = "good buddy";
		String c = nm + " " + nx;
		System.out.println(c.length());
		// "myPet" is a better string name because it describes what is contained inside the string
		String myPet = "Sparky the dog";
		String smallPart = myPet.substring(4, 12);
		System.out.println(smallPart);
	}
}

/*
 * Sample Output:
 * 16
 * ky the d
 */