/**
  * class for the creation of stock objects
  * 
  * @author Daniel Rubianes
  * @version 2/1/2019
 */
public class danielRubianesStock {
	// instance variables
	private double stockPrice;
	private String stockSymbol;
	public danielRubianesStock(double price, String symbol) {
		stockPrice = price;
		stockSymbol = symbol;
	}
   /** Method: danielRubianesStock (constructor)
	 * Purpose: creates a stock object
	 * Pre: double price, String symbol
	 * Post: creates a stock object with the given symbol and price */
	public double buy(double buyPrice) {return stockPrice-buyPrice;}
	   /** Method: buy()
		 * Purpose: calculates the profit or loss for a buy of a stock using its price
		 * Pre: double buyPrice
		 * Post: the profit or loss for a buy of the given stock at the given price */
	public double sell(double sellPrice) {return sellPrice-stockPrice;}
	   /** Method: sell()
		 * Purpose: calculates the profit or loss for a sell of a stock using its price
		 * Pre: double sellPrice
		 * Post: the profit or loss for a sell of the given stock at the given price */
	// --- accessors --- //
	public double getPrice() {return stockPrice;}
	   /** Method: getPrice()
		 * Purpose: gets the price for a given stock
		 * Pre: none
		 * Post: the price of the given stock */
	public String getSymbol() {return stockSymbol;}
	   /** Method: getSymbol()
		 * Purpose: gets the symbol for a given stock
		 * Pre: none
		 * Post: the symbol of the given stock */
	
	public void setPrice(double price) {stockPrice = price;}
	   /** Method: setPrice()
		 * Purpose: sets the price for a given stock
		 * Pre: double price
		 * Post: changes the price of the given stock */
	public void setSymbol(String symbol) {stockSymbol = symbol;}
	   /** Method: setSymbol()
		 * Purpose: sets the symbol for a given stock
		 * Pre: String symbol
		 * Post: changes the symbol of the given stock */
	
}
