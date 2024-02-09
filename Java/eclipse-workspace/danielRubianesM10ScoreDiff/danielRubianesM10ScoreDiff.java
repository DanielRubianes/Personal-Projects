/*
 * Daniel Rubianes
 * Date: 2/12/2019
 * Hendersonville High School
 * Score difference
 * 
 * Description: reads a data file, stores its data in two arraylists and calculates and prints out the average and the differences for the scores
 * Difficulties: none
 * What I learned: You can avoid writing a large block of code twice by making a function
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM10ScoreDiff
{
	private static void printData(String fileName) throws FileNotFoundException {
		// scan the file and store the ids and scores in arraylists
    	Scanner data = new Scanner(new File(fileName));
    	
    	// find number of ids to define arrays
    	int idCount = 0;
    	while(data.hasNextLine()) {
    		data.nextLine();
    		idCount++;
    	}
    	
    	// redefining scanner to read
    	data = new Scanner(new File(fileName));
    	
    	int[] scores = new int[idCount];
    	int[] ids = new int[idCount];
    	int currentIndex = 0;
    	while(data.hasNextLine()) {
    		Scanner currentLine = new Scanner(data.nextLine());
    		ids[currentIndex] = currentLine.nextInt();
    		scores[currentIndex] = currentLine.nextInt();
    		currentLine.close();
    		currentIndex++;
    	}
    	data.close();
    	System.out.println("End of reading from file.");
    	
    	// find the average
    	int sum = 0;
    	int count = 0;
    	for (int index = 0; index < scores.length; index++) {
    		sum += scores[index];
    		count++;
    	}
    	double average = (double)sum/count;
    	
    	// print the sum, count, and average
    	System.out.println("Sum = " + sum);
    	System.out.println("Count = " + count);
    	System.out.printf("Average = %.2f\n", average);
    	
    	// print out the id, score, and difference for each id
    	System.out.printf("%-5s%-7s%-5s\n", "Id", "Score", "Diff");
    	for (int index = 0; index < ids.length; index++) {
    		System.out.printf("%-5s%-7s%-5.2f\n", ids[index], scores[index], scores[index]-average);
    	}
	}
	/** Method: printData()
	 * Purpose: Prints out all of the nessecary data for the given file
	 * Pre: file name
	 * Post: prints out the ids, scores, and differences, as well as the sum, count and average of the set of scores */
    public static void main(String args[]) throws FileNotFoundException
    {
    	System.out.println("File 1 processing...");
    	printData("scores.dat");
    	System.out.println("File 2 processing...");
    	printData("scores2.dat");
    }
}

/*
Sample Output: 
File 1 processing...
End of reading from file.
Sum = 5095
Count = 21
Average = 242.62
Id   Score  Diff 
115  257    14.38
123  253    10.38
116  246    3.38 
113  243    0.38 
112  239    -3.62
104  239    -3.62
110  238    -4.62
218  243    0.38 
208  242    -0.62
222  223    -19.62
223  230    -12.62
213  229    -13.62
207  228    -14.62
203  224    -18.62
305  265    22.38
306  262    19.38
311  256    13.38
325  246    3.38 
321  245    2.38 
323  245    2.38 
302  242    -0.62
File 2 processing...
End of reading from file.
Sum = 9659
Count = 40
Average = 241.48
Id   Score  Diff 
138  224    -17.47
296  241    -0.47
239  227    -14.47
264  229    -12.47
210  294    52.53
246  258    16.53
151  273    31.53
256  216    -25.47
293  257    15.53
194  276    34.53
145  226    -15.47
285  203    -38.47
229  224    -17.47
150  267    25.53
272  221    -20.47
298  253    11.53
155  237    -4.47
115  279    37.53
149  228    -13.47
120  292    50.53
283  231    -10.47
159  288    46.53
155  235    -6.47
256  232    -9.47
179  288    46.53
140  226    -15.47
223  297    55.53
114  221    -20.47
236  226    -15.47
170  220    -21.47
267  205    -36.47
285  247    5.53 
262  227    -14.47
201  252    10.53
169  264    22.53
151  212    -29.47
208  203    -38.47
174  236    -5.47
121  224    -17.47
182  200    -41.47
 */