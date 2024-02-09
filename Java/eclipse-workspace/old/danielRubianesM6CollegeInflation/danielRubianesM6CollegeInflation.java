/*
 * Daniel Rubianes
 * Date: 11/27/18
 * Hendersonville High School
 * College Inflation
 * 
 * Description: A program that calculates how far in debt a college student will be, accounting for inflation and cost of living raises. It displays all of the data found along the way in a chart.
 * Difficulties: None
 * What I learned: How to better use loops and printf.
*/
public class danielRubianesM6CollegeInflation
{
    public static void main(String args[])
    {
    	// define initial variables
        double sallary = 14000;
        double tuition = 4000;
        double board = 9500;
        
        // define variables for counting the totals
        double totalTuition = 0;
        double totalBoard = 0;
        double totalCost = 0;
        double totalSallary = 0;
        double totalDebt = 0;
        
        // print the title row
        System.out.printf("%-5s %-13s %-13s %-13s %-13s %-13s %n", "Year", "Tuition", "Rm&Bd", "Total Cost", "Sallary", "Excess/Shortage");
        // loop 4 times (counting from 0)
        for (int year = 0; year <= 3; year++) {
        	// Multiply each value by their interest rate + 1, raised to the power of the current year (this is why it counts from 0)
        	sallary *= Math.pow(1.04, year);
        	tuition *= Math.pow(1.15, year);
        	board *= Math.pow(1.10, year);
        	// print out each of the values, as well as the total cost and the excess/shortage
        	System.out.printf("%-5s %-13.2f %-13.2f %-13.2f %-13.2f %-13.2f %n", year+1 /* (Counts from 0) */, tuition, board, tuition+board, sallary, sallary-(tuition+board));
        	// add values to the totals
        	totalTuition += tuition;
            totalBoard += board;
            totalCost += tuition+board;
            totalSallary += sallary;
            totalDebt += sallary-(tuition+board);
        }
        
        // print totals
        System.out.printf("%-5s %-13.2f %-13.2f %-13.2f %-13.2f %-13.2f %n", "Total", totalTuition, totalBoard, totalCost, totalSallary, totalDebt);
    	
    }
}

/*
Sample Output: 
Year  Tuition       Rm&Bd         Total Cost    Sallary       Excess/Shortage 
1     4000.00       9500.00       13500.00      14000.00      500.00        
2     4600.00       10450.00      15050.00      14560.00      -490.00       
3     6083.50       12644.50      18728.00      15748.10      -2979.90      
4     9252.24       16829.83      26082.07      17714.47      -8367.61      
Total 23935.74      49424.33      73360.07      62022.56      -11337.51     
 */