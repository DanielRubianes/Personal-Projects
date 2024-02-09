/*
 * Daniel Rubianes
 * Date: 10/29/2018
 * Hendersonville High School
 * Music price calculator
 * 
 * Description: Asks user for number of songs ordered, finds price per song based on defined ranges, then tells user their price per song and their total price.
 * Difficulties: Trying to use a switch statement, but you can not test for a range of numbers efficiently using a switch statement.
 * What I learned: Nothing.
*/
// import java.io & java.util
import java.io.*;
import java.util.*;
public class danielRubianesM5MusicWebsite
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner input = new Scanner(System.in);
    	
    	// ask user for number of songs ordered
    	System.out.println("How many songs did you order?");
    	
    	// set input to a variable
    	int songsOrdered = input.nextInt();
    	
    	// declare price variable
    	double price;
    	
    	// set price variable based off of the amount of songs
    	if (songsOrdered>=0 && songsOrdered<=10) {
    		// 0 -10
    		price = 1.29;
    	}
    	else if (songsOrdered<=25) {
    		// 11 - 25
    		price = 1.19;
    	}
    	else if (songsOrdered<=50) {
    		// 25 - 50
    		price = 1.09;
    	}
    	else {
    		// 50+
    		price = 0.99;
    	}
    	
    	// print price
    	System.out.println("Price per song: " + price);
    	
    	// print amount due
    	System.out.printf("Amount due: %.2f", price*songsOrdered);
    }
}

/*
 * Sample Output: 
How many songs did you order?
200
Price per song: 0.99
Amount due: 198.00
 */