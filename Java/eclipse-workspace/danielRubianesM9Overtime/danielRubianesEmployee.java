/**
  * Class for creating employee objects
  * 
  * @author Daniel Rubianes
  * @version 1/17/2019
 */
public class danielRubianesEmployee {
	// instance variables
	private double payRate;
	private int ID;
	private String job;
	private int hoursWorked;
	
	/**
	 * Method: (Constructor) danielRubianesEmployee()
	 * Purpose: Creates an employee object
	 * Pre: none
	 * Post: employee object
	*/
	public danielRubianesEmployee() {}
	/**
	 * Method: getGrossPay
	 * Purpose: finds the gross pay of an employee object accounting for overtime pay
	 * Pre: none
	 * Post: gross pay of the employee object
	*/
	public double getGrossPay() {
		if (hoursWorked <= 40) {
			return hoursWorked*payRate;
		}
		else if (hoursWorked <= 50) {
			return 40*payRate + payRate*(hoursWorked-40)*1.5;
		}
		else {
			return 40*payRate + payRate*10*1.5 + payRate*(hoursWorked-50)*2;
		}
	}
	
	/* ---------------------Mutators--------------------- */
	/**
	 * Method: setPay
	 * Purpose: sets the payRate variable for an employee object
	 * Pre: double inputPay
	 * Post: changes the payRate of the employee object to inputPay
	*/
	public void setPay(double inputPay) {payRate = inputPay;}
	/**
	 * Method: setID
	 * Purpose: sets the ID variable for an employee object
	 * Pre: int inputID
	 * Post: changes the ID of the employee object to inputID
	*/
	public void setID(int inputID) {ID = inputID;}
	/**
	 * Method: setJob
	 * Purpose: sets the job variable for an employee object
	 * Pre: String inputJob
	 * Post: changes the job of the employee object to inputJob
	*/
	public void setJob(String inputJob) {job = inputJob;}
	/**
	 * Method: setHours
	 * Purpose: sets the hoursWorked variable for an employee object
	 * Pre: int inputHours
	 * Post: changes the hoursWorked of the employee object to inputHours
	*/
	public void setHours(int inputHours) {hoursWorked = inputHours;}
	
	/* ---------------------Accessors--------------------- */
	/**
	 * Method: getPay
	 * Purpose: gets the payRate of an employee object
	 * Pre: none
	 * Post: returns the payRate of an employee object
	*/
	public double getPay() {return payRate;}
	/**
	 * Method: getID
	 * Purpose: gets the ID of an employee object
	 * Pre: none
	 * Post: returns the ID of an employee object
	*/
	public int getID() {return ID;}
	/**
	 * Method: getJob
	 * Purpose: gets the job of an employee object
	 * Pre: none
	 * Post: returns the job of an employee object
	*/
	public String getJob() {return job;}
	/**
	 * Method: getHours
	 * Purpose: gets the hoursWorked of an employee object
	 * Pre: none
	 * Post: returns the hoursWorked of an employee object
	*/
	public int getHours() {return hoursWorked;}
}
