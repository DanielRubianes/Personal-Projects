/*
 * Daniel Rubianes
 * Date: 10/25/2018
 * Hendersonville High School
 * Sum Average
 * 
 * Description: Lists all the numbers in numData.in, adds them together, then finds the average, displaying each step.
 * Difficulties: None
 * What I learned: How to read and manipulate data from a file in java.
*/
// import classes for scanners and io
import java.util.*;
import java.io.*;
public class danielRubianesM5SumAverage
{
    public static void main(String args[]) throws FileNotFoundException
    {
    	// create a scanner to read numData
        Scanner numData = new Scanner(new File("numData.in") );
        
        // transcribe the file to numbers[]
        int maxIndex = -1;
        String numbers[] = new String[100];
        while(numData.hasNext())
        {
        	maxIndex++;
        	numbers[maxIndex] = numData.nextLine();
        }
        numData.close();
        
        // define some variables
        String numList = "";
        int sum = 0;
        for(int j = 0; j <= maxIndex; j++)
        {
        	// create a scanner to read numbers[]
        	Scanner sc = new Scanner(numbers[j]);
        	sum = 0;
        	numList = "";
        	int numberOfScores = 0;
        	
        	// add each number on each line of text and display it with +'s and =
        	while(sc.hasNext())
        	{
        		int curNum = sc.nextInt();
        		numList = numList + curNum + "\n";
        		sum = sum + curNum;
        		numberOfScores++;
        	}
        	System.out.println(numList + "The sum of then numbers  = " + sum);
        	System.out.println("The number of scores = " + numberOfScores);
        	System.out.printf("The average of the numbers = %.2f", ((double)sum / (double)numberOfScores));
            sc.close();
        }
    }
}

/*
 * Sample Output: 
3
8
1
13
18
15
7
17
1
14
0
12
3
2
5
4
The sum of then numbers  = 123
The number of scores = 16
The average of the numbers = 7.69
 */