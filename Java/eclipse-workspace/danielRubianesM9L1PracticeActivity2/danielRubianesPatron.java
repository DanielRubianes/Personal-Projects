/**
  * Class for creating patron objects
  * 
  * @author Daniel Rubianes
  * @version 1/15/2019
 */
public class danielRubianesPatron {
	// instance variables
	private String firstName;
	private String lastName;
	private String cardNum;
	private danielRubianesBook patronBook;
	
	/**
	 * Methods: Constructors
	 * Purpose: Used to create patron objects
	 * Pre: nothing or first/last name, card number, & checked-out book
	 * Post: patron object containing null variables or given variables
	*/
	public danielRubianesPatron() {
		// init instance vars
		firstName = null;
		lastName = null;
		cardNum = null;
		patronBook = null;
	}
	public danielRubianesPatron(String first, String last, String number, danielRubianesBook book) {
		// init instance vars
				firstName = first;
				lastName = last;
				cardNum = number;
				patronBook = book;
	}
	
	/**
	 * Methods: Accessors
	 * Purpose: Used to read the instance variables of patron objects
	 * Pre: patron object
	 * Post: The instance variable requested
	*/
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getNumber() {return cardNum;}
	public danielRubianesBook getBook() {return patronBook;}
	
	/**
	 * Methods: Mutators
	 * Purpose: Used to modify the instance variables of patron objects
	 * Pre: patron object & value to change
	 * Post: modified patron object w/ new value
	*/
	public void setFirstName(String first) {firstName = first;}
	public void setLastName(String last) {lastName = last;}
	public void setNumber(String number) {cardNum = number;}
	public void setBook(danielRubianesBook book) {patronBook = book;}
	
	/**
	 * Method: toString()
	 * Purpose: Used to print out a patron object as a string
	 * Pre: patron object
	 * Post: String displaying the name of the patron, their card number, and their current book
	*/
	public String toString()
	{
		String string = "The details for the patron are: ";
		string += "\n\t Name: " + firstName + " " + lastName;
		string += "\n\t Card Number: " + cardNum;
		string += "\n\t " + patronBook;
		return string;
	}
}
