/**
  * Class that defines Recipe objects
  * 
  * @author Daniel Rubianes
  * @version 1/15/2019
 */
public class danielRubianesRecipe {
	// instance variables
	private String name;
	private danielRubianesCircle circle;
	/**
	 * Method: Constructor
	 * Purpose: Creates a recipe object
	 * Pre: Name
	 * Post: Recipe object w/ given name
	*/
	public danielRubianesRecipe(String inputName) {name = inputName;}
	/**
	 * Method: setSetvings
	 * Purpose: sets the Recipe's circle instance variable to a circle object (uses in the tester class as a demonstration)
	 * Pre: recipe object & circle object
	 * Post: recipe object w/ circle object contained
	*/
	public void setServings(danielRubianesCircle inputCircle) {
		circle = inputCircle;
	}
}
