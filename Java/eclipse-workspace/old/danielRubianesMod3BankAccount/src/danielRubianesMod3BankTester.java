/*
 * Daniel Rubianes
 * Date: 10/15
 * Hendersonville High School
 * Bank Account Tester
 * 
 * Description: Creates a bank account with an initial balance of $1,000, under the name "Sally Jones", despoits and withdraws money, then displays the balance. 
 * Difficulties: Turning the assignment in on time
 * What I learned: How to create a class in java that produces objects, and how to manipulate said objects.
*/
public class danielRubianesMod3BankTester
{
    public static void main(String args[])
    {
        danielRubianesBankAccount myAccount = new danielRubianesBankAccount(1000,"Sally Jones");
        myAccount.deposit(505.22);
        System.out.println(myAccount.balance);
        myAccount.withdraw(100);
        System.out.println("The " + myAccount.name + "account balance is, " + myAccount.balance);
    }
}

/*
 * Sample Output: 
 * 1505.22
 * 1405.22
 */