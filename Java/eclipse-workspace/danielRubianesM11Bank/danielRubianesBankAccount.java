public class danielRubianesBankAccount
{
	private String name;
	private double balance;
	public danielRubianesBankAccount(String setName, double amount) {
		name=setName;
		balance=amount;
	}
	public void deposit (double deposit)
	{
		balance=balance + deposit;
	}	
	public void withdraw (double withdrawl)
	{
		balance=balance-withdrawl;
	}
	public String getName()
	{
		return name;
	}
	public double getBalance()
	{
		return balance;
	}
}