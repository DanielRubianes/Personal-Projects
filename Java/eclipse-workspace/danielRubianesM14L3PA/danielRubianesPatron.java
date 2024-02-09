/** 
 * Class to create patron objects
 * 
 * @author Daniel Rubianes
 */
public class danielRubianesPatron {
	// instance variables
	private String FName;
	private String LName;
	private String libNumber;
	private danielRubianesBook myMedia;
	
	/* Constructors */
	/**
	 * Constructor for blank patron objects
	 */
	public danielRubianesPatron() {
		FName = null;
		LName = null;
		libNumber = null;
		myMedia = null;
	}
	
	/** 
	 * Constructor for patron objects
	 */
	public danielRubianesPatron(String first, String last, String ln, danielRubianesBook media) {
		FName = first;
		LName = last;
		libNumber = ln;
		myMedia = media;
	}
	
	/* Accessors */
	public String getFName() {return FName;}
	public String getLName() {return LName;}
	public String getlibNumber() {return libNumber;}
	public danielRubianesBook getMedia() {return myMedia;}
	
	/* Mutators */
	public void setFName(String first) {FName = first;}
	public void setLName(String last) {LName = last;}
	public void setlibNumber(String ln) {libNumber = ln;}
	public void setBook(danielRubianesBook media) {myMedia = media;}
	
	/* msc */
	/**
	 * Method to print specs of a patron object
	 * @return String
	 */
	public String toString() {
		String string = "The specs of this patron are:";
		string += "\n\tName: " + FName + " "  + LName;
		string += "\n\tLibrary Number: " + libNumber;
		string += "\n\tCurrent Book:\n" + myMedia;
		return string;
	}
}
