/*
 * Daniel Rubianes
 * Date: 3/14/2019
 * Hendersonville High School
 * Bank
 * 
 * Description: Has the use enter an arraylist of bank accounts and returns the name and balance for the one with the largest deposit
 * Difficulties: input scanner skipping the nextLine() call after using nextDouble(); this was fixed by calling nextLine() again after nextDouble()
 * What I learned: *
*/
// import java.util.*
import java.util.*;
public class danielRubianesM11Bank
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	// create the ArrayList of account object
    	List<danielRubianesBankAccount> accounts = new ArrayList<danielRubianesBankAccount>();
    	// populate the list via user input
    	boolean again = true;
    	while (again) {
    		System.out.print("Please enter the name to whom the account belongs (\"Exit\" to abort): ");
    		String name = input.nextLine();
    		if (name.toLowerCase().equals("exit")) {again = false; break;}
    		System.out.print("Please enter the amount of the deposit: ");
    		double deposit = input.nextDouble();
    		input.nextLine();
    		accounts.add(new danielRubianesBankAccount(name, deposit));
    	}
    	// find and print out the account with the largest deposit within the list
    	double maxDeposit = 0;
    	int indexOfMax = -1;
    	for (int index = 0; index < accounts.size(); index++) {
    		if (accounts.get(index).getBalance() > maxDeposit) {
    			maxDeposit = accounts.get(index).getBalance();
    			indexOfMax = index;
    		}
    	}
    	input.close();
    	System.out.println("The account with the largest balance belongs to " + accounts.get(indexOfMax).getName());
    	System.out.println("The amount is " + accounts.get(indexOfMax).getBalance());
    }
}

/*
Sample Output: 
Please enter the name to whom the account belongs ("Exit" to abort): Jim Jones
Please enter the amount of the deposit: 186.22
Please enter the name to whom the account belongs ("Exit" to abort): Bill Gates
Please enter the amount of the deposit: 102.15
Please enter the name to whom the account belongs ("Exit" to abort): Helen Hunt
Please enter the amount of the deposit: 1034.02
Please enter the name to whom the account belongs ("Exit" to abort): Charles
Please enter the amount of the deposit: 870.85
Please enter the name to whom the account belongs ("Exit" to abort): exit
The account with the largest balance belongs to Helen Hunt
The amount is 1034.02
 */
 