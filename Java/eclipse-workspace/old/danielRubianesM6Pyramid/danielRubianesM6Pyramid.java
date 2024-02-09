/*
 * Daniel Rubianes
 * Date: 11/27/18
 * Hendersonville High School
 * Pyramid
 * 
 * Description: Draws a number pyramid that counts down going towards the middle and up past the middle
 * Difficulties: None
 * What I learned: How to center text with printf
*/
public class danielRubianesM6Pyramid
{
    public static void main(String args[])
    {
    	// define the string used to create each row
    	String numbers = "";
    	// repeats 9 times, increasing "row"by 1 each time
        for (int row = 1; row <=9; row++) {
        	// define variable used to count up then down
        	int currNumber = 1;
        	
        	// count up (runs until currNumber = the row #)
        	do {
        		// add the current number to the string
        		numbers = numbers + currNumber;
        		// add 1 to the current number
        		currNumber++;
        	} while (currNumber <= row);
        	
        	// subtracts the extra 1 added at the end of the loop, as well as another to skip repeating the middle number
        	currNumber = currNumber - 2;
        	
        	// count down (runs until the current number is not greater than 0)
        	while (currNumber > 0) {
        		// add the current number to the string
        		numbers = numbers + currNumber;
        		// subtract 1 from the current number
        		currNumber--;
        	}
        	// add spaces to center the row (adds 9-the string length 0's, centering the pyramid along the 9th digit)
        	for (int spaces = 9-numbers.length()/2; spaces > 0; spaces--) {
        		numbers = " " + numbers;
        	}
        	// print the current row
        	System.out.printf("%-17s %n", numbers);
        	// reset the numbers string
        	numbers = "";
        }
    }
}

/*
Sample Output: 
         1        
        121       
       12321      
      1234321     
     123454321    
    12345654321   
   1234567654321  
  123456787654321 
 12345678987654321 
 */