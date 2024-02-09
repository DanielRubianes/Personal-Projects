/*
 * Daniel Rubianes
 * Date: 10/21/18
 * Hendersonville High School
 * Ulam Hypothesis
 * 
 * Description: Displays the string of numbers following the ulam hypothesis for every number from 1 to 25.
 * Difficulties: Setting the for interval to 0, which caused an infinite loop because dividing 0 by two over and over will never make it reach 1.
 * What I learned: The ulam hypothesis, and how to use do and for loops.
*/
public class danielRubianesM5Ulam
{
	// function to produce the ulam sequence for a given number
	public static String ulamTest(int number) {
		// begin the list with the given number
		String list = number + "";
		
		// divide by two if even or multiply by 3 then add 1 if odd, then add the new number to the list. Do this until the number reaches 1.
    	do {
    		if ((number % 2) == 0) {
    			number /= 2;
    		}
    		else {
    			number *= 3;
    			number += 1;
    		}
    		list += " "+number;
    	} while (number != 1);
    	// return the list of numbers
    	return list;
    }
    public static void main(String args[])
    {
    	// run the ulamTest function, then display the output in console for every number from 1 to 25.
    	for (int i = 1; i <= 25; i++) {
        	System.out.println(i+": "+ulamTest(i));
        }
    }
}

/*
 * Sample Output: 
 * 1: 1 4 2 1
 * 2: 2 1
 * 3: 3 10 5 16 8 4 2 1
 * 4: 4 2 1
 * 5: 5 16 8 4 2 1
 * 6: 6 3 10 5 16 8 4 2 1
 * 7: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 8: 8 4 2 1
 * 9: 9 28 14 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 10: 10 5 16 8 4 2 1
 * 11: 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 12: 12 6 3 10 5 16 8 4 2 1
 * 13: 13 40 20 10 5 16 8 4 2 1
 * 14: 14 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 15: 15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1
 * 16: 16 8 4 2 1
 * 17: 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 18: 18 9 28 14 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 19: 19 58 29 88 44 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 20: 20 10 5 16 8 4 2 1
 * 21: 21 64 32 16 8 4 2 1
 * 22: 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * 23: 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1
 * 24: 24 12 6 3 10 5 16 8 4 2 1
 * 25: 25 76 38 19 58 29 88 44 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 */