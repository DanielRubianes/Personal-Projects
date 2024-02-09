/**
  * Class that defines a book object
  * 
  * @author Daniel Rubianes
  * @version 1/13/2019
 */
public class danielRubianesBook
{
	// instance variables
	private String title;
	private String author;
	
	/**
	 * Methods: Constructors
	 * Purpose: Used to create book objects
	 * Pre: nothing | title&author | book object
	 * Post: book object containing null variables | specified title&author | copy of given book object
	*/
	public danielRubianesBook()
	{
		// initialize instance variables
		title = null;
		author = null;
	}
	public danielRubianesBook(String bookTitle, String bookAuthor)
	{
		// initialize instance variables
		title = bookTitle;
		author = bookAuthor;
	}
	public danielRubianesBook(danielRubianesBook bookCopy)
	{
		// initialize instance variables
		title = bookCopy.title;
		author = bookCopy.author;
	}
	
	/**
	 * Method: toString()
	 * Purpose: Returns the author and title of the book in a string
	 * Pre: book object
	 * Post: String containing the title and author stored in the book object
	*/
	public String toString()
	{
		String string = "The specs of the book are: ";
		string += "\n\t Title: " + title;
		string += "\n\t Author: " + author;
		return string;
	}
	
	/**
	 * Methods: Accessors
	 * Purpose: Used to access the title and author variables
	 * Pre: book object
	 * Post: returns the value
	*/
	public String getTitle() {return title;}
	public String getAuthor() {return author;}
	
	/**
	 * Methods: Mutators
	 * Purpose: Used to write to the title and author variables
	 * Pre: book object
	 * Post: writes to the variable
	*/
	public void setTitle(String bookTitle) {title = bookTitle;}
	public void setAuthor(String bookAuthor) {author = bookAuthor;}
	
}
