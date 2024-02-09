import java.util.Calendar;
/** 
 * Abstract class to create media objects
 * 
 * @author Daniel Rubianes
 */
public abstract class danielRubianesMedia {
	// instance variabes
	private String title;
	private Calendar today;
	
	/* Constructors */
	/** 
	 * Blank constructor
	 */
	public danielRubianesMedia() {
		title = null;
		today = Calendar.getInstance();
	}
	
	/**
	 * Populated constructor
	 */
	public danielRubianesMedia(String setTitle, Calendar calendar) {
		title = setTitle;
		today = calendar;
	}
	
	public abstract Calendar getReturnDate();
}
