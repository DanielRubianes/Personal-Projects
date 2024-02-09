/*
 * Daniel Rubianes
 * Date: 12/20/18
 * Hendersonville High School
 * Bank Account Runner
 * 
 * Description: Creates a bank account using the BankAccout class & creates an interface for the user to interact with the account.
 * Difficulties: None
 * What I learned: How to create private functions.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM8Bank
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// var declarations
    	int choice = 0;
    	double amount = 0;
    	String another;
    	boolean anotherTransaction = true;
    	
    	// make the account
        danielRubianesM8BankAccount account = new danielRubianesM8BankAccount();
        while (anotherTransaction) {
	        // ask user which action the would like to perform
	        System.out.println("What do you wish to do today?\n1 for deposit to savings\n" + 
	        		"2 for deposit to checking\n" + 
	        		"3 for withdraw from savings\n" + 
	        		"4 for withdraw from checking\n" + 
	        		"5 for transfer funds from savings to checking");
	        // get user's choice
	        choice = input.nextInt();
	        
	        // perform user's choice
	        switch (choice) {
	        	case 1:
	        		System.out.print("You chose to make a deposit to savings. How much would you like to deposit? ");
	        		amount = input.nextDouble();
	        		account.depositSavings(amount);
	        		break;
	        	case 2:
	        		System.out.print("You chose to make a deposit to checking. How much would you like to deposit? ");
	        		amount = input.nextDouble();
	        		account.depositChecking(amount);
	        		break;
	        	case 3:
	        		System.out.print("You chose to withdrawl from savings. How much would you like to withdrawl? ");
	        		amount = input.nextDouble();
	        		account.withdrawlSavings(amount);
	        		break;
	        	case 4:
	        		System.out.print("You chose to withdrawl from checking. How much would you like to withdrawl? ");
	        		amount = input.nextDouble();
	        		account.withdrawlChecking(amount);
	        		break;
	        	case 5:
	        		System.out.print("You chose to transfer funds from savings to checking. How much would you like to transfer? ");
	        		amount = input.nextDouble();
	        		account.transferSavingsToChecking(amount);
	        		break;
	        }
	        // ask user if they would like to perform another action
	        System.out.print("\nWould you like another transaction(Y/N)? ");
	        
	        // get user's response
	        another = input.next();
	        if (another.toLowerCase().equals("y")) {anotherTransaction = true;}
	        else {anotherTransaction = false;}
        	
        }
        input.close();
    }
}

/*
Sample Output: 
What do you wish to do today?
1 for deposit to savings
2 for deposit to checking
3 for withdraw from savings
4 for withdraw from checking
5 for transfer funds from savings to checking
1
You chose to make a deposit to savings. How much would you like to deposit? 100
Your total in checking is $0.00. Your total in savings is $100.00.
Would you like another transaction(Y/N)? y
What do you wish to do today?
1 for deposit to savings
2 for deposit to checking
3 for withdraw from savings
4 for withdraw from checking
5 for transfer funds from savings to checking
2
You chose to make a deposit to checking. How much would you like to deposit? 100
Your total in checking is $100.00. Your total in savings is $100.00.
Would you like another transaction(Y/N)? y
What do you wish to do today?
1 for deposit to savings
2 for deposit to checking
3 for withdraw from savings
4 for withdraw from checking
5 for transfer funds from savings to checking
3
You chose to withdrawl from savings. How much would you like to withdrawl? 100
Your total in checking is $100.00. Your total in savings is $0.00.
Would you like another transaction(Y/N)? y
What do you wish to do today?
1 for deposit to savings
2 for deposit to checking
3 for withdraw from savings
4 for withdraw from checking
5 for transfer funds from savings to checking
4
You chose to withdrawl from checking. How much would you like to withdrawl? 100
Your total in checking is $0.00. Your total in savings is $0.00.
Would you like another transaction(Y/N)? y
What do you wish to do today?
1 for deposit to savings
2 for deposit to checking
3 for withdraw from savings
4 for withdraw from checking
5 for transfer funds from savings to checking
5
You chose to transfer funds from savings to checking. How much would you like to transfer? 100
Your total in checking is $100.00. Your total in savings is $-100.00.
Would you like another transaction(Y/N)? n
 */