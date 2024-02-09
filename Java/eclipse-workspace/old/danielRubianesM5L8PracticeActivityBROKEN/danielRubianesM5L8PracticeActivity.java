/*
 * Daniel Rubianes
 * Date: *
 * Hendersonville High School
 * Program Name
 * 
 * Description: *
 * Difficulties: *
 * What I learned: *
*/
import java.io.*;
import java.util.*;
public class danielRubianesM5L8PracticeActivity
{
    public static void main(String args[]) throws FileNotFoundException
    {
    	Scanner numData = new Scanner(new File("numData.in"));
        
        int maxIndx = -1;
        String text[] = new String[100];
        
        while(numData.hasNext()) {
        	maxIndx++;
        	text[maxIndx] = numData.nextLine();
        }
        numData.close();
        
        String answer = "";
        int sum = 0;
        for(int j = 0; j <= maxIndx; j++) {
        	Scanner textSc = new Scanner(text[j]);
        	sum = 0;
        	answer = "";
        	
        	while(textSc.hasNext()) {
        		 int i = textSc.nextInt();
        		 answer = answer + "+" + i;
        		 sum = sum + 1;
        	}
        	answer = answer + "=" + sum;
        	System.out.println(answer);
        }
        
    }
}

/*
 * Sample Output: 
 * 
 */