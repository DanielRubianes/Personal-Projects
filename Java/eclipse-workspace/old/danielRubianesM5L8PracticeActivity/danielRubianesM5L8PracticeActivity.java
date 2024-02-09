/*
 * Daniel Rubianes
 * Date: 10/24/18
 * hendersonville High School
 * Lesson 8 videos
 * 
 * Description: reads a text file and displays the numbers added together
 * Difficulties: using the wrong input file
 * What I learned: how to read text files in java
*/
// import classes for io and scanners
import java.util.*;
import java.io.*;
public class danielRubianesM5L8PracticeActivity
{
    public static void main(String args[]) throws IOException
    {
    	// create a scanner to read the file
        Scanner sf = new Scanner(new File("NumData.in") );
        
        // transcribe the file to text[]
        int maxIndex = -1;
        String text[] = new String[100];
        while(sf.hasNext())
        {
        	maxIndex++;
        	text[maxIndex] = sf.nextLine();
        }
        sf.close();
        
        // define some variables
        String answer = "";
        int sum = 0;
        for(int j = 0; j <= maxIndex; j++)
        {
        	// create a scanner to read text[]
        	Scanner sc = new Scanner(text[j]);
        	sum = 0;
        	answer = "";
        	
        	// add each number on each line of text and display it with +'s and =
        	while(sc.hasNext())
        	{
        		int i = sc.nextInt();
        		answer = answer + i;
        		// add plus unless on last number
        		if (sc.hasNext()) {answer = answer + "+";}
        		sum = sum + i;
        	}
        	answer = answer + "=" + sum;
        	System.out.println(answer);
        }
    }
}

/*
 * Sample Output: 
12+10+3+5=30
18+1+5+92+6+8=130
2+9+3+22+4+11+7=58

 */