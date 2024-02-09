/*
 * Daniel Rubianes
 * Date: 12/21/18
 * Hendersonville High School
 * Class Averages
 * 
 * Description: Program that reads a data from the file "students.in" and prints the averages for each class & the averages for each student, then makes a graph showing the averages for each class.
 * Difficulties: The amount of time this took to make. (Also a lot of small problems I don't remember because it's 3:53 AM)
 * What I learned: How to use classes to create objects in java.
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM8ClassAverages
{
	private static void printRow(String course, String studentNum, double courseAvg) {System.out.printf("%-13s%-15s%-14.2f\n", course, studentNum, courseAvg);}
	private static void printRow(String course, String studentNum, String courseAvg) {System.out.printf("%-13s%-15s%-14s\n", course, studentNum, courseAvg);}
	
	public static double average(String list) {
		// create a scanner to read the list given
    	Scanner grades = new Scanner(list);
    	double sum = 0;
    	double count = 0;
    	double currentGrade = 0;
    	while (grades.hasNext()) {
    		// add the current number to the sum and add one to the count for each integer (excluding the -999s that signify the end of the lines)
    		currentGrade = grades.nextDouble();
    		if (currentGrade != -999) {
    			count++;
    			sum += currentGrade;
    		}
    	}
    	grades.close();
    	// return the average
    	return sum/count;
    }
	
	public static void drawBar(String mark, int length)
	{
		for (int currDot = 1; currDot <= length; currDot++) {System.out.print(mark);}
	}
	
	public static void main(String args[]) throws FileNotFoundException
    {
		// transcribe file into Student objects
    	// create variables
    	String currLine = "";
    	int currCourseNum = 0;
    	danielRubianesM8Student student1 = new danielRubianesM8Student();
    	student1.number = "1";
    	student1.initialize();
    	danielRubianesM8Student student2 = new danielRubianesM8Student();
    	student2.number = "2";
    	student2.initialize();
    	// create the scanner
    	Scanner students = new Scanner(new File("students.in"));
    	// loop until end of file
    	while (students.hasNextLine()) {
    		currLine  = students.nextLine();
    		if (currLine.length() > 0 && currLine.charAt(7) == ':') {
    			if (currCourseNum < 4) {
	    			// set course names
	    			student1.courses.get(currCourseNum).name  = currLine.substring(0, 7);
	    			// set grades
	    			student1.courses.get(currCourseNum).grades  = currLine.substring(9, currLine.length());
    			}
    			else {
	    			// set course names
	    			student2.courses.get(currCourseNum-4).name  = currLine.substring(0, 7);
	    			// set grades
	    			student2.courses.get(currCourseNum-4).grades  = currLine.substring(9, currLine.length());
    			}
    			currCourseNum++;
    		}
    	}
    	students.close();
    	
    	String avgList1 = "";
    	String avgList2 = "";
    	// print title row
		printRow("Course ID", "Student%", "Course Average");
		// repeat for each course
    	for (currCourseNum = 0; currCourseNum < 4; currCourseNum++) {
    		// print average for student 1 and 2
    		printRow(student1.courses.get(currCourseNum).name, "1", average(student1.courses.get(currCourseNum).grades));
    		printRow("", "2", average(student2.courses.get(currCourseNum).grades));
    		// add current average for each student to their respective list (for calculating the average of all of their grades)
    		avgList1 += average(student1.courses.get(currCourseNum).grades) + " ";
    		avgList2 += average(student2.courses.get(currCourseNum).grades) + " ";
    	}
    	
    	// print averages for both students
    	System.out.println("\nAverage for student 1: " + average(avgList1) + "\nAverage for student 2: " + average(avgList2) + "\n");
    	
    	// print key and bar for the graph of the grades
    	System.out.println("Key:\n* - Student 1\n# - Student 2");
    	System.out.print("         0    10   20   30   40   50   60   70   80   90   100\n"
    				   + "         |----|----|----|----|----|----|----|----|----|----|");
    	// repeats for each course
    	for (currCourseNum = 0; currCourseNum < 4; currCourseNum++) {
    		System.out.print("\n" + student1.courses.get(currCourseNum).name + "  ");
    		// print a bar for the current grade for student1 (multiplied by .51 to line it up with the bar, which is 51 characters long)
    		drawBar("*", (int)(average(student1.courses.get(currCourseNum).grades)*.51));
    		System.out.print("\n         ");
    		// print a bar for the current grade for student2
    		drawBar("#", (int)(average(student2.courses.get(currCourseNum).grades)*.51));
    	}
    }
}

/*
Sample Output: 
Course ID    Student%       Course Average
CIS 110      1              79.10         
             2              65.00         
ENG 111      1              73.40         
             2              85.00         
MTH 141      1              89.80         
             2              80.60         
CHM 121      1              72.20         
             2              91.40         

Average for student 1: 78.625
Average for student 2: 80.5

Key:
* - Student 1
# - Student 2
         0    10   20   30   40   50   60   70   80   90   100
         |----|----|----|----|----|----|----|----|----|----|
CIS 110  ****************************************
         #################################
ENG 111  *************************************
         ###########################################
MTH 141  *********************************************
         #########################################
CHM 121  ************************************
         ##############################################
 */