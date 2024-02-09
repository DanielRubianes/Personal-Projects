/*
 * Daniel Rubianes
 * Date: 1/29/2019
 * Hendersonville High School
 * Grade Lists
 * 
 * Description: Takes a list of grades for a number of students from StudentData.in and StudentData2.in
 * Difficulties: made the scanner for the data file without the "new File()" part and it was just a scanner of the string "StudentData.in"
 * What I learned: Ways to more efficiently write tedious code (efficient copy/pasting)
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM9Students
{
    public static void main(String args[]) throws FileNotFoundException
    {
    	// create the input scanner
    	Scanner StudentData = new Scanner(new File("StudentData.in"));
    	Scanner StudentData2 = new Scanner(new File("StudentData2.in"));
    	
    	List<danielRubianesStudent> studentList1 = new ArrayList<danielRubianesStudent>();
    	while (StudentData.hasNextLine()) {
    		Scanner currentStudentGrades = new Scanner(StudentData.nextLine());
    		danielRubianesStudent currentStudent = new danielRubianesStudent();
    		// set assignments
    		String gradeList = "";
    		for (int index = 0; index < 15; index++) {
    			gradeList += currentStudentGrades.nextInt() + " ";
    		}
			currentStudent.setAssignments(gradeList);
			// set quizzes
    		gradeList = "";
    		for (int index = 0; index < 7; index++) {
    			gradeList += currentStudentGrades.nextInt() + " ";
    		}
			currentStudent.setQuizzes(gradeList);
			// set tests
    		gradeList = "";
    		for (int index = 0; index < 4; index++) {
    			gradeList += currentStudentGrades.nextInt() + " ";
    		}
			currentStudent.setTests(gradeList);
			// set final exam grade
			currentStudent.setFinal(currentStudentGrades.nextInt());
			//calculate all of the averages, including the final grade
			currentStudent.calcAssignmentAvg();
			currentStudent.calcQuizAvg();;
			currentStudent.calcTestAvg();
			currentStudent.calcFinalGrade();
			studentList1.add(currentStudent);
			currentStudentGrades.close();
    	}
    	StudentData.close();
    	List<danielRubianesStudent> studentList2 = new ArrayList<danielRubianesStudent>();
    	while (StudentData2.hasNextLine()) {
    		Scanner currentStudentGrades = new Scanner(StudentData2.nextLine());
    		danielRubianesStudent currentStudent = new danielRubianesStudent();
    		// set assignments
    		String gradeList = "";
    		for (int index = 0; index < 15; index++) {
    			gradeList += currentStudentGrades.nextInt() + " ";
    		}
			currentStudent.setAssignments(gradeList);
			// set quizzes
    		gradeList = "";
    		for (int index = 0; index < 7; index++) {
    			gradeList += currentStudentGrades.nextInt() + " ";
    		}
			currentStudent.setQuizzes(gradeList);
			// set tests
    		gradeList = "";
    		for (int index = 0; index < 4; index++) {
    			gradeList += currentStudentGrades.nextInt() + " ";
    		}
			currentStudent.setTests(gradeList);
			// set final exam grade
			currentStudent.setFinal(currentStudentGrades.nextInt());
			//calculate all of the averages, including the final grade
			currentStudent.calcAssignmentAvg();
			currentStudent.calcQuizAvg();;
			currentStudent.calcTestAvg();
			currentStudent.calcFinalGrade();
			studentList2.add(currentStudent);
			currentStudentGrades.close();
    	}
    	StudentData2.close();
    	System.out.println("The table of averages for the first list of students:");
    	System.out.printf("|%-7s|%-11s|%-7s|%-5s|%-10s|%-7s|\n", "Student", "Assignments", "Quizzes", "Tests", "Final Exam", "Average");
    	for (int index = 0; index < studentList1.size(); index++) {
    		danielRubianesStudent currentStudent = studentList1.get(index);
    		System.out.printf("|%-7s|%-11.2f|%-7.2f|%-5.2f|%-10s|%-7.2f|\n", index+1, currentStudent.getAssignmentAvg(), currentStudent.getQuizAvg(), currentStudent.getTestAvg(), currentStudent.getFinalExamGrade(), currentStudent.getFinalGrade());
    	}
    	System.out.println("\nThe table of averages for the second list of students:");
    	System.out.printf("|%-7s|%-11s|%-7s|%-5s|%-10s|%-7s|\n", "Student", "Assignments", "Quizzes", "Tests", "Final Exam", "Average");
    	for (int index = 0; index < studentList2.size(); index++) {
    		danielRubianesStudent currentStudent = studentList2.get(index);
    		System.out.printf("|%-7s|%-11.2f|%-7.2f|%-5.2f|%-10s|%-7.2f|\n", index+1, currentStudent.getAssignmentAvg(), currentStudent.getQuizAvg(), currentStudent.getTestAvg(), currentStudent.getFinalExamGrade(), currentStudent.getFinalGrade());
    	}
    }
}

/*
Sample Output: 
The table of averages for the first list of students:
|Student|Assignments|Quizzes|Tests|Final Exam|Average|
|1      |92.67      |79.29  |89.50|85        |87.82  |
|2      |90.00      |80.00  |84.50|74        |83.70  |
|3      |85.33      |89.29  |82.50|88        |86.09  |
|4      |90.67      |94.29  |89.25|90        |90.97  |
|5      |94.67      |81.43  |79.00|88        |87.55  |
|6      |86.67      |92.14  |84.00|92        |88.30  |
|7      |90.67      |83.57  |80.75|75        |84.13  |
|8      |93.33      |83.57  |79.25|85        |86.90  |
|9      |93.33      |80.71  |86.00|74        |85.48  |
|10     |84.67      |78.00  |77.25|80        |80.92  |

The table of averages for the second list of students:
|Student|Assignments|Quizzes|Tests|Final Exam|Average|
|1      |73.33      |67.43  |66.25|87        |73.47  |
|2      |70.13      |71.29  |67.25|45        |64.76  |
|3      |75.33      |80.86  |83.00|96        |82.10  |
|4      |67.00      |66.00  |72.75|94        |73.35  |
|5      |59.33      |71.29  |65.75|50        |61.14  |
|6      |66.60      |73.71  |68.50|95        |74.08  |
|7      |68.33      |75.29  |73.00|56        |68.19  |
|8      |67.93      |72.86  |63.00|84        |71.14  |
|9      |68.87      |57.00  |85.00|43        |64.55  |
|10     |72.93      |77.57  |68.00|80        |74.29  |

 */