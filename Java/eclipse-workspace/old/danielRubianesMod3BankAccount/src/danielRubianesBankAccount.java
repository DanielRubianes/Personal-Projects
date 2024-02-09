/*
 * Daniel Rubianes
 * Date: 10/15
 * Hendersonville High School
 * Bank Account Tester
 * 
 * Description: Class for the creation of bank account objects, which store a name and balance, and can be withdrawn from, or deposited to.
 * Difficulties: Turning the assignment in on time
 * What I learned: How to create a class in java that produces objects, and how to manipulate said objects.
*/
public class danielRubianesBankAccount
{
	public double balance;
	public String name;
	// creates an account
    public danielRubianesBankAccount(double initialBalance, String accountName)
    {
    	balance = initialBalance;
    	name = accountName;
    }
    // deposits money into the account
    public void deposit(double amount)
    {
    	balance += amount;
    }
    public void withdraw(double amount)
    {
    	balance -= amount;
    }
}

/*
 * Sample Output: 
 * 1505.22
 * 1405.22
 */