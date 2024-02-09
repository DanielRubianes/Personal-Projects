/**
  * Class that creates customer objects
  * 
  * @author Daniel Rubianes
  * @version 2/4/2019
 */
public class danielRubianesCustomer {
	// --- instance variables --- //
	private int income;
	private int consultingTime;
	
	// --- constructors --- //
	/** Method: danielRubianesCustomer()
	 * Purpose: Creates a customer object
	 * Pre: int inputIncome, int inputConsultingTime
	 * Post: Creates a customer object with the given income and consulting time */
	public danielRubianesCustomer(int inputIncome, int inputConsultingTime) {
		income = inputIncome;
		consultingTime = inputConsultingTime;
	}
	/** Method: danielRubianesCustomer()
	 * Purpose: Creates a customer object
	 * Pre: none
	 * Post: Creates a customer object with income and consultingTime of 0 */
	public danielRubianesCustomer() {
		income = 0;
		consultingTime = 0;
	}
	
	// --- other --- //
	/** Method: calcConsultingFee
	 * Purpose: calculates the consulting fee for a customer
	 * Pre: int hourlyRate
	 * Post: calculates the consulting fee for the given customer at the given hourly rate */
	public double calcConsultingFee(int hourlyRate) {
		if (income <= 25000 && consultingTime <= 30) {
			return 0.0;
		}
		else if (income <= 25000) {
			return (hourlyRate*.5) * (consultingTime - 30); 
		}
		else if (consultingTime <= 20) {
			return 0.0;
		}
		else {
			return (hourlyRate*.75) * (consultingTime - 20); 
		}
	}
	
	// --- accessors --- //
	/** Method: getIncome()
	 * Purpose: returns income
	 * Pre: none
	 * Post: the income for the given customer */
	public int getIncome() {return income;}
	/** Method: getConsultingTime()
	 * Purpose: returns consulting time
	 * Pre: none
	 * Post: the consulting time for the given customer */
	public int getConsultingTime() {return consultingTime;}
	
	// --- mutators --- //
	public void setIncome(int newIncome) {income = newIncome;}
	/** Method: setIncome()
	 * Purpose: sets income
	 * Pre: none
	 * Post: changes the income for the given customer to that given */
	public void setConsultingTime(int newConsultingTime) {consultingTime = newConsultingTime;}
	/** Method: setConsultingTime()
	 * Purpose: sets consulting time
	 * Pre: none
	 * Post: changes the consulting time for the given customer to that given */
}
