/*
 * Daniel Rubianes
 * Date: 1/30/2019
 * Hendersonville High School
 * Stocks
 * 
 * Description: Calculates losses when buying or selling a stock
 * Difficulties: Punctuality
 * What I learned: How to calculate the profit made from the purchase of a stock using java.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM9L5Stocks
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("How many stocks to you want to calculate purchases for?");
    	int numberOfStocks = input.nextInt();
    	
    	// make a list of stocks
    	List<danielRubianesStock> stocks = new ArrayList<danielRubianesStock>();
    	for (int index = 0; index < numberOfStocks; index++) {
    		System.out.print("Enter the symbol for stock #" + (index+1) + ":");
    		String currentStockSymbol = input.next();
    		System.out.print("Enter the price of this stock:");
    		double currentStockPrice = input.nextDouble();
    		stocks.add(new danielRubianesStock(currentStockPrice, currentStockSymbol));
    	}
    	
    	// run the loop until the user is done
    	boolean again = true;
    	while(again) {
    		// ask which stock to calculate a transaction for
    		System.out.print("Which stock would you like to calculate a transaction for? (enter the number for the stock):");
    		int chosenStock = input.nextInt()-1;
    		double gainOrLoss = 0.0;
    		// ask for the number of purchases as well as the price for 3 purchases
    		for (int index = 1; index <= 3; index++) {
    			System.out.print("Enter the number of purchases, then the purchace price per share for purchase #" + index + ":");
    			int purchaseNum = input.nextInt();
    			double price = input.nextDouble();
    			gainOrLoss += stocks.get(chosenStock).buy(price) * purchaseNum;
    		}
    		// ask for the number of sales as well as the price for the sale
    		System.out.print("Enter the number of sales, then the sell price per share for your sale:");
			int saleNum = input.nextInt();
			double price = input.nextDouble();
			gainOrLoss += stocks.get(chosenStock).sell(price) * saleNum;
			if (gainOrLoss < 0) {System.out.println("Net loss: " + gainOrLoss);}
			else {System.out.printf("Net gain: $%.2f", gainOrLoss);}
			
			// ask the user if they would like to calculate another transaction
			System.out.println("\nWould you like to make another transaction (y/n)?");
			String answer = input.next();
			if (answer.toLowerCase().equals("y")) {again = true;}
			else {again = false;}
    	}
    	input.close();
    }
}

/*
Sample Output: 

How many stocks to you want to calculate purchases for?
2
Enter the symbol for stock #1:WMT
Enter the price of this stock:93.53
Enter the symbol for stock #2:APPL
Enter the price of this stock:167.26
Which stock would you like to calculate a transaction for? (enter the number for the stock):1
Enter the number of purchases, then the purchace price per share for purchase #1:100 36.73
Enter the number of purchases, then the purchace price per share for purchase #2:100 44.74
Enter the number of purchases, then the purchace price per share for purchase #3:100 66.96
Enter the number of sales, then the sell price per share for your sale:1 79.80
Net gain: $13202.27
Would you like to make another transaction (y/n)?
y
Which stock would you like to calculate a transaction for? (enter the number for the stock):2
Enter the number of purchases, then the purchace price per share for purchase #1:100 152.74
Enter the number of purchases, then the purchace price per share for purchase #2:100 153.46
Enter the number of purchases, then the purchace price per share for purchase #3:100 150.46
Enter the number of sales, then the sell price per share for your sale:1 147.50
Net gain: $4492.24
Would you like to make another transaction (y/n)?
n


 */