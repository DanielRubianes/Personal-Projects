/*
 * Daniel Rubianes
 * Date: 10/21
 * Hendersonville High School
 * Car insurance calculator
 * 
 * Description: A program that calculates the cost of car insurance based on age.
 * Difficulties: Confused by the wording of the assignment; how would this teach me about different types of loops? (also turning it in on time)
 * What I learned: How to use if else statements in java
*/

// import the classes necessary for scanner objects
import java.io.*;
import java.util.*;


public class danielRubianesM5CarInsurance
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner input = new Scanner(System.in);
    	
    	// introduce the program
    	System.out.println("---- Car Insurance Calculator ----");
    	
        // get age and initilize cost variable
        System.out.println("Enter driver age:");
        int age = input.nextInt();
        int cost;
        
        // find cost
        if (age >= 25) {
        	cost = 500;
        }
        else if (age >= 18) {
        	cost = age * 72;
        }
        else {
        	cost = age * 88;
        }
        
        // print age and cost
        System.out.println("Driver age = " + age);
        System.out.println("Insurance cost = $" + cost);
    }
}

/*
 * Sample Output: 
 * ---- Car Insurance Calculator ----
 * Enter driver age:
 * [input]5
 * Driver age = 5
 * Insurance cost = $440

 */