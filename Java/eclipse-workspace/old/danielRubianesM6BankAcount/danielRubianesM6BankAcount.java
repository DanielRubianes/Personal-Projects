/*
 * Daniel Rubianes
 * Date: 11/5/2018
 * Hendersonville High School
 * Bank Account
 * 
 * Description: Takes an initial balance and interest rate of a bank account as input, then calculates how long it will take the account to double when compounding annually, monthly, and yearly, then prints this out as well as the final balance for each type of compounding.
 * Difficulties: None
 * What I learned: How to calculate interest in java.
*/
// import java.io and java.util
import java.io.*;
import java.util.*;
public class danielRubianesM6BankAcount
{
    public static void main(String args[])
    {
    	// create input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// ask user for initial balance and the interest rate
    	System.out.print("Enter initial balance: ");
    	double initialBalance = input.nextDouble();
    	System.out.print("Enter interest rate (as a decimal): ");
    	double interestRate = input.nextDouble();
    	input.close();
    	
    	// compounding yearly
    	// initialize variables; years counts the number of years it takes for the money to double, initialBalance is the initial balance, and interestBalnce is used to calculate the final balance
    	int years = 0;
    	double interestBalance = initialBalance;
    	// while loop that runs until interestBalace is greater than or equal to initialBalance doubled
    	while (interestBalance < initialBalance*2) {
    		// multiply the balance by 1 + the interest rate, then increment years
    		interestBalance = interestBalance*(1 + interestRate);
    		years += 1;
    	}
    	// print out the number of years to double and the final balance
    	System.out.println("Coumpounding anually, this account will double in " + years + " years.");
    	System.out.printf("The final balance would be $%.2f%n", interestBalance);
    	
    	// compounding monthly
    	// reset years and interestBalance variables
    	interestBalance = initialBalance;
    	years = 0;
    	// while loop that runs until interestBalace is greater than or equal to initialBalance doubled
    	while (interestBalance < initialBalance*2) {
    		// multiply the balance by 1 + (rate/12)^12; this compounds the interest 12 times
    		interestBalance = interestBalance*Math.pow(1 + (interestRate/12),12);
    		years += 1;
    	}
    	// print out the number of years to double and the final balance
    	System.out.println("Coumpounding monthly, this account will double in " + years + " years.");
    	System.out.printf("The final balance would be $%.2f%n", interestBalance);
    	
    	interestBalance = initialBalance;
    	years = 0;
    	// while loop that runs until interestBalace is greater than or equal to initialBalance doubled
    	while (interestBalance < initialBalance*2) {
    		// multiply the balance by 1 + (rate/365)^365; this compounds the interest 365 times
    		interestBalance = interestBalance*Math.pow(1 + (interestRate/365),365);
    		years += 1;
    	}
    	// print out the number of years to double and the final balance
    	System.out.println("Coumpounding daily, this account will double in " + years + " years.");
    	System.out.printf("The final balance would be $%.2f%n", interestBalance);
    }
}

/*
Sample Output: 
Enter initial balance: [input]5000
Enter interest rate (as a decimal): [input].05
Coumpounding anually, this account will double in 15 years.
The final balance would be $10394.64
Coumpounding monthly, this account will double in 14 years.
The final balance would be $10054.13
Coumpounding daily, this account will double in 14 years.
The final balance would be $10068.28
 */