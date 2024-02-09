/*
 * Daniel Rubianes
 * Date: 10/30/2018
 * Hendersonville High School
 * Minute converter
 * 
 * Description: Converts minutes in to days, hours, minutes
 * Difficulties: None
 * What I learned: Nothing new
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM5Minutes
{
    public static void main(String args[])
    {
    	// create the scanner
    	Scanner input = new Scanner(System.in);
    	
    	// ask the use for the number of seconds
    	System.out.print("Enter number of minutes: ");
    	int totalMinutes = input.nextInt();
    	
    	// find number of days
    	int days = totalMinutes / 1440;
    	// find number of hours left over
    	int hours = (totalMinutes%1440) / 60;
    	// find number of minutes left over
    	int minutes = totalMinutes%60;
    	// print output
    	System.out.println(days + " days " + hours + " hours " + minutes + " minutes");
    	int a = 3, b = 5, s = 0;

    	for (int i=0; i<10; i++)

    	{

    	 s=a+b;

    	 b=a-b;

    	 a=s;

    	}
    	System.out.println("s " + s + "b " + b + "a " + a);


    	
    }
}

/*
 * Sample Output: 
Enter number of minutes: 6789
4 days 17 hours 9 minutes
 */