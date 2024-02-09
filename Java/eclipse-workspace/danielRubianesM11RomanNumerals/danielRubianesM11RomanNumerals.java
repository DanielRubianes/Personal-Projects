/*
 * Daniel Rubianes
 * Date: 3/4/2019
 * Hendersonville High School
 * Roman Numeral Time
 * 
 * Description: Gives the user the option to convert to or from Roman time or they can create an array of roman times and have the program order the list. This loops until the user chooses to exit.
 * Difficulties: Finding a way to efficiently read Roman numerals and convert them to decimal
 * What I learned: How to write a program that can convert to and from Roman numerals
*/
// import java.util.*
import java.util.*;
public class danielRubianesM11RomanNumerals
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	boolean again = true;
    	// run while again is true
    	while (again) {
    		// ask the user which operation they would like to perform
	    	System.out.print("1: roman time --> decimal\n"
	    					+ "2: decimal time --> roman\n"
	    					+ "3: order a list of roman time\n"
	    					+ "4: exit\n"
	    					+ "Make your selection: ");
	    	int choice = input.nextInt();
	    	// check if they chose outside the range
	    	if ((choice < 1) || (choice > 4)) {System.out.println("Invalid choice!");}
	    	// option 1: Roman to decimal time conversion
	    	else if (choice == 1) {
	    		System.out.print("Enter time in roman numerals: ");
	    		danielRubianesRoman time = new danielRubianesRoman(input.next());
	    		System.out.println("Decimal form: " + time.convertToDecimalTime());
	    	}
	    	// option 2: decimal to Roman time converstion
	    	else if (choice == 2) {
	    		System.out.print("Enter time in decimal: ");
	    		String time = input.next();
	    		System.out.println("Roman numeral form: " + danielRubianesRoman.convertToRomanTime(time));
	    	}
	    	// option 3: puts the given list of Roman times in chronological order
	    	else if (choice == 3) {
		    	System.out.print("Enter the number of Roman times you would like to enter: ");
		    	int amount = input.nextInt();
		    	danielRubianesRoman[] times = new danielRubianesRoman[amount];
		    	for (int index = 0; index < times.length; index++) {
		    		System.out.print("Enter time #" + (index+1) + " in roman numerals: ");
		    		times[index] = new danielRubianesRoman(input.next());
		    	}
		    	
		    	danielRubianesRoman.sort(times);
		    	
		    	for (int index = 0; index < times.length; index++) {
		    		System.out.println(times[index]);
		    	}
		    }
	    	else if (choice == 4) {again = false;}
    	}
    	input.close();
    }
}

/*
Sample Output: 
1: roman time --> decimal
2: decimal time --> roman
3: order a list of roman time
4: exit
Make your selection: 1
Enter time in roman numerals: IX:XL
Decimal form: 9:40
1: roman time --> decimal
2: decimal time --> roman
3: order a list of roman time
4: exit
Make your selection: 2
Enter time in decimal: 12:34
Roman numeral form: XII:XXXIV
1: roman time --> decimal
2: decimal time --> roman
3: order a list of roman time
4: exit
Make your selection: 3
Enter the number of Roman times you would like to enter: 5
Enter time #1 in roman numerals: IV:XXX
Enter time #2 in roman numerals: X:XLII
Enter time #3 in roman numerals: IX:I
Enter time #4 in roman numerals: I:XXV
Enter time #5 in roman numerals: I:X
I:X
I:XXV
IV:XXX
IX:I
X:XLII
1: roman time --> decimal
2: decimal time --> roman
3: order a list of roman time
4: exit
Make your selection: 4

 */