/*
 * Daniel Rubianes
 * Date: 12/21/18
 * Hendersonville High School
 * Class Averages
 * 
 * Description: Class to create student objects. Creates a list of course objects and a name String.
 * Difficulties: The amount of time this took to make. (Also a lot of small problems I don't remember because it's 3:53 AM)
 * What I learned: How to use classes to create objects in java.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM8Student
{
	public static void main(String args[]) {}
    public String number; 
    public List<danielRubianesM8Course> courses = new ArrayList<danielRubianesM8Course>();
    public void initialize() {
    	courses.add(new danielRubianesM8Course());
    	courses.add(new danielRubianesM8Course());
    	courses.add(new danielRubianesM8Course());
    	courses.add(new danielRubianesM8Course());
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