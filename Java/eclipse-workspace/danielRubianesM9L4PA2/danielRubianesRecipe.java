
public class danielRubianesRecipe {
	// instance variables
	public String name;
	public int calories;
	public int carbs;
	public int fat;
	private double cost;
	/**
	 * Method: Constructor
	 * Purpose: Creates a recipe object
	 * Pre: inputNane
	 * Post: recipe object with the given name
	*/
	public danielRubianesRecipe(String inputName) {
		name = inputName;
	}
	/**
	 * Method: getCost() (accessor)
	 * Purpose: gets the cost of a recipe object
	 * Pre: none
	 * Post: the cost of the object
	*/
	public double getCost() {
		return cost;
	}
	/**
	 * Method: setCost() (mutator)
	 * Purpose: changes the cost of a recipe object
	 * Pre: newCost
	 * Post: changes the cost of the given recipe object to the newCost
	*/
	public void setCost(double newCost) {
		cost = newCost;
	}
	/**
	 * Method: pricePerCalorie()
	 * Purpose: returns the price per calorie
	 * Pre: int z
	 * Post: returns 15.21 as an example
	*/
	public double pricePerCalore(int z) {return 15.21;}
}
