/*
 * Daniel Rubianes
 * Date: 10/21/18
 * Hendersonville High School
 * Discount calculator
 * 
 * Description: Takes user input price and applies a discount dependant on the price and a tax, displaying every step.
 * Difficulties: Punctuality
 * What I learned: Nothing new.
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;

public class danielRubianesM5Discount
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner input = new Scanner(System.in);
    	
    	// ask the user for their subtotal
    	System.out.println("Enter subtotal:");
    	double subTotal = input.nextDouble();
    	
    	// find discount
    	double discountRate;
    	if (subTotal > 100) {
    		discountRate = .20;
    	}
    	else {
    		discountRate = .10;
    	}
    	
    	// set tax rate
    	double taxRate = .06;
    	
    	// print original price
    	System.out.printf("%-20s %-1s %5.2f %n", "Purchase price:", "$", subTotal);
    	// print discount
    	System.out.printf("%-20s %-1s %5.2f %n", "Discount("+(int)(discountRate*100)+"%):", "$", subTotal*discountRate);
    	// set and print discounted price
    	double salePrice = subTotal - subTotal*discountRate;
    	System.out.printf("%-20s %-1s %5.2f %n", "Sale price:", "$", salePrice);
    	// print tax
    	System.out.printf("%-20s %-1s %5.2f %n", "Tax:", "$", salePrice*taxRate);
    	// print final price
    	System.out.printf("%-20s %-1s %5.2f %n", "Final price:", "$", salePrice + salePrice*taxRate);
    }
}

/*
 * Sample Output: 
 * Enter subtotal:
 * [input]55.25
 * Purchase price:      $ 55.25 
 * Discount(10%):       $  5.53 
 * Sale price:          $ 49.73 
 * Tax:                 $  2.98 
 * Final price:         $ 52.71 
 */