/*
 * Daniel Rubianes
 * Date: 10/8/2018
 * Hendersonville High School
 * Cell Phone Bill Calculator
 * 
 * Description: Calculates the dollar amount for a cell phone plan that has a fixed cost of $50 and adds $.50 for every MB over.
 * Difficulties: Declaring a variable inside an if statement makes it unusable outside, so I needed to declare it beforehand.
 * What I learned: Casting and constants in java.
*/
public class danielRubianesMod3CellPlan
{
    public static void main(String args[])
    {
    	// Ammount of data used & data cap in MB
        int dataUsed = 5017;
        int dataCap = 5000;
        // tax rate
        final double TAX_RATE = 1.0535;
        //Costs of the bill itself
        final int FIXED_COST = 50;
        final double OVERAGE_FEE = .50; // 50 cents per MB over
        double total;
        if (dataUsed-dataCap > 0) {
            total = (FIXED_COST + (dataUsed-dataCap)*OVERAGE_FEE)*TAX_RATE;
        } else {
        	total = 50*TAX_RATE;
        }
        System.out.println("Your total for this month is $" + (int)total);
    }
}

/*
 * Sample Output: 
 * Your total for this month is $61
 */