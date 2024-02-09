import java.util.Calendar;
/** 
 * Class to create book objects
 * 
 * @author Daniel Rubianes
 */
public class danielRubianesBook extends danielRubianesMedia {
	// instance variables
	private String author;
	private String title;
	private Calendar today;
	
	/* construcors */
	/**
	 * default constructor for book objects
	 */
	public danielRubianesBook() {
		author = null;
		title = null;
		today = Calendar.getInstance();
	}
	/**
	 * constructor w/ variables
	 */
	public danielRubianesBook(String bookTitle, String bookAuthor, Calendar calendar) {
		title = bookTitle;
		author = bookAuthor;
		today = calendar;
	}
	/**
	 * constructor that copies the book
	 */
	public danielRubianesBook(danielRubianesBook book) {
		author = book.author;
		title = book.title;
		today = book.today;
	}
	
	/* accessors */
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public Calendar getToday() {
		return today;
	}
	
	/* mutators */
	public void setAuthor(String newAuthor) {
		author = newAuthor;
	}
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	public void setToday(Calendar calendar) {
		today = calendar;
	}
	
	/* msc */
	/**
	 * Method to print specs of a book object
	 * @return String
	 */
	public String toString() {
		String string = "The specs of this book are:";
		string += "\n\tTitle: " + title;
		string += "\n\tAuthor: " + author;
		string += "\n\tReturn date: " + today;
		return string;
	}
	/**
	 * Calculates and returns the due date of the given book object
	 */
	public Calendar getReturnDate() {
		Calendar dueDate = Calendar.getInstance();
		dueDate.set(today.MONTH, today.get(today.MONTH));
		dueDate.set(today.YEAR, today.get(today.YEAR));
		dueDate.set(today.DATE, today.get(today.DATE + 21));
		return dueDate;
	}
}
