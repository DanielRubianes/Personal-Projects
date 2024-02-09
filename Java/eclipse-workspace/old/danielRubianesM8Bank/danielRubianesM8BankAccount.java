/*
 * Daniel Rubianes
 * Date: 12/20/18
 * Hendersonville High School
 * Bank Account
 * 
 * Description: Class that creates a bank account with the ability to deposit, withdrawl, and transfer funds w/ a savings account and a checking account.
 * Difficulties: None
 * What I learned: How to create private functions.
*/
public class danielRubianesM8BankAccount
{
	private void balance() {
    	System.out.printf("Your total in checking is $%.2f. Your total in savings is $%.2f.", checkingBalance, savingsBalance);
	}
    public danielRubianesM8BankAccount() {}
    public static double checkingBalance;
    public static double savingsBalance;
    public void depositSavings(double amount) {
    	savingsBalance += amount;
    	balance();
    }
    public void depositChecking(double amount) {
    	checkingBalance += amount;
    	balance();
    }
    public void withdrawlSavings(double amount) {
    	savingsBalance -= amount;
    	balance();
    }
    public void withdrawlChecking(double amount) {
    	checkingBalance -= amount;
    	balance();
    }
    public void transferSavingsToChecking(double amount) {
    	savingsBalance -= amount;
    	checkingBalance += amount;
    	balance();
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