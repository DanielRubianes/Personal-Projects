/*
 * Daniel Rubianes
 * Date: 3/4/2019
 * Hendersonville High School
 * Hash Library
 * 
 * Description: Program that creates a list of book objects which store a hash of their title and author. The user can then check if the hash of a book is in the database
 * Difficulties: issues when using an input scanner within a while loop; for some reason unpredictable issues occur (the program skipping over inputs and presumably taking null for the value) when I use input.next() but not with input.nextLine() for the answer to the Continue? (y/n) question.
 * What I learned: How to make a hashing algorithm in java
*/
// import java.util.*]
import java.util.*;
// a class for creating book objects that stores them in hash form
class book {
	public String titleHash;
	public String authorHash;
	// constructor that stores the title and author as hashes
	public book(String title, String author) {
		titleHash = hash(title);
		authorHash = hash(author);
	}
	// hashing algorithm
	private static String hash(String string) {
		int hash = 37;
		for (int index = 0; index < string.length(); index++) {
			int currentChar = string.charAt(index);
			hash *= 17 + currentChar;
		}
		return Integer.toHexString(hash);
	}
}

public class danielRubianesM11HashLibrary
{
	public static void main(String args[])
	{
		// create an array of 15 book objects
		book library[] = {new book("Night","Elie Wiesel"),
						new book("Moby Dick","Herman Melville"),
						new book("Catch-22","Joseph Heller"),
						new book("Adventures of Huckleberry Finn","Mark Twain"),
						new book("Feed","M. T. Anderson"),
						new book("Hamlet","William Shakespeare"),
						new book("Gone with the Wind","Margret Mitchell"),
						new book("The Great Gatsby"," F. Scott Fitzgerald"),
						new book("As I Lay Dying","William Faulkner"),
						new book("Uncle Tom's Cabin","Harriet Beecher Stowe"),
						new book("The Color Purple","Alice Walker"),
						new book("Of Mice and Men","John Steinbeck"),
						new book("Where the Wild Things Are","Maurice Sendak"),
						new book("The Underground Railroad","Colson Whitehead"),
						new book("Frankenstein","Mary Shelley")};
		// loop until the user exits
		// create the input scanner
		Scanner input = new Scanner(System.in);
		boolean again = true;
		while (again) {
			System.out.print("Enter the title of the book you would like to look up: ");
			String title = input.nextLine();
			System.out.print("Enter the author of the book you would like to look up: ");
			String author = input.nextLine();
			book query = new book(title, author);
			boolean exists = false;
			for (int index = 0; index < library.length; index++) {
				if (query.titleHash.equals(library[index].titleHash) && query.authorHash.equals(library[index].authorHash)) {
					exists = true;
				}
			}
			if (exists) {System.out.println("Your book was found in our database.");}
			else {System.out.println("Sorry, we do not have this book in our database.");}
			System.out.print("Continue? (y/n) ");
			String choice = input.nextLine();
			if (!(choice.toLowerCase().equals("y"))) {again = false;}
		}
		input.close();
	}
}

/*
Sample Output: 
Enter the title of the book you would like to look up: Adventures of Tom Sawyer
Enter the author of the book you would like to look up: Mark Twain
Sorry, we do not have this book in our database.
Continue? (y/n) y
Enter the title of the book you would like to look up: Night
Enter the author of the book you would like to look up: Elie Wiesel
Your book was found in our database.
Continue? (y/n) n
 */