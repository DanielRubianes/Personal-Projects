/*
 * Daniel Rubianes
 * Date: 10/22/18
 * Hendersonville High School
 * Random Number Generators
 * 
 * Description: Three examples of random number generators.
 * Difficulties: None
 * What I learned: How to generate various types of random numbers in java.
*/

// import java.util.* for the random number generator
import java.util.*;

public class danielRubianesM5L7PracticeActivity
{
    public static void main(String args[])
    {
    	/* Video 1
        Random randGenerator = new Random();
        for (int j = 0; j < 100; j++) {
        	System.out.println(randGenerator.nextDouble());
        }
        */
    	
    	/* Video 2
    	Random randGenerator = new Random();
    	int randInt = 0;
        for (int j = 0; j < 100; j++) {
        	// generates double from 90-110 inclusive
        	randInt = 90 + randGenerator.nextInt(21);
        	System.out.println(randInt);
        }
        */
    	
    	/* Video 3
    	Random randGenerator = new Random();
    	double randDouble = 0;
        for (int j = 0; j < 100; j++) {
        	// generates double from 34.7838(inclusive) to 187.056(exclusive)
        	randInt = 34.7838 + 152.2722 * randGenerator.nextDouble();
        	System.out.println(randDouble);
        }
        */
    }
}

/*
Sample Output (From video 2): 
99
104
104
90
107
105
97
108
107
109
98
95
107
109
108
103
103
110
105
101
94
92
110
103
96
100
97
103
102
105
93
109
106
102
103
102
110
106
109
110
92
95
97
92
108
109
90
99
103
104
102
100
101
108
106
96
102
99
103
92
95
102
110
108
97
91
105
92
105
106
91
92
109
92
108
93
103
93
99
105
94
107
102
100
91
108
95
96
110
90
101
91
109
101
103
100
101
90
95
104

 */