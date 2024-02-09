/**
  * class that creates student objects
  * 
  * @author Daniel Rubianes
  * @version date
 */
// import java.util.*
import java.util.*;
public class danielRubianesStudent {
	// constructor for no input
	public danielRubianesStudent() {}
	
	// constructor with input
	public danielRubianesStudent(String assignmentList, String quizList, String testList, int finalExamGrade) {
		assignments = assignmentList;
		quizzes = quizList;
		tests = testList;
		finalExam = finalExamGrade;
	}
	
	// instance variables
	// lists of grades
	private String assignments;
	private String quizzes;
	private String tests;
	// final exam grade
	private int finalExam;
	// averages of each category
	private double assignmentAvg;
	private double quizAvg;
	private double testAvg;
	private double finalAverage; // final grade
	
	// --- Conversion Methods --- //
	public String toString() {
		return "Assignment List: " + assignments + "\nAssignment Average (40%): " + assignmentAvg + 
				"\nQuiz List: " + quizzes + "\nQuiz Average (20%): " + assignmentAvg + 
				"\nTest List: " + tests + "\nTest Average (20%): " + testAvg + 
				"\nFinal Exam Grade (20%): " + finalExam +
				"\nFinal Grade: " + finalAverage + "\n";
	}
	/** Method: toString()
	 * Purpose: converts a student object to a string
	 * Pre: none
	 * Post: returns all of the grades lists, all of the averages, and the final exam grade */
	
	// --- Accessors --- //
	public String getAssignments() {return assignments;}
	/** Method: getAssignments()
	 * Purpose: return the list of assignments for the student object
	 * Pre: none
	 * Post: returns the list of assignments */
	public String getQuizzes() {return quizzes;}
	/** Method: getQuizzes()
	 * Purpose: return the list of quizzes for the student object
	 * Pre: none
	 * Post: returns the list of quizzes */
	public String getTests() {return tests;}
	/** Method: getTests()
	 * Purpose: return the list of tests for the student object
	 * Pre: none
	 * Post: returns the list of tests */
	public double getAssignmentAvg() {return assignmentAvg;}
	/** Method: getAssignmentAvg()
	 * Purpose: return the average for the assignments
	 * Pre: none
	 * Post: returns the average for the assignments */
	public double getQuizAvg() {return quizAvg;}
	/** Method: getQuizAvg()
	 * Purpose: return the average for the quizzes
	 * Pre: none
	 * Post: returns the average for the quizzes */
	public double getTestAvg() {return testAvg;}
	/** Method: getTestAvg()
	 * Purpose: return the average for the tests
	 * Pre: none
	 * Post: returns the average for the test */
	public double getFinalGrade() {return finalAverage;}
	/** Method: getFinalGrade()
	 * Purpose: returns the final grade for the student
	 * Pre: none
	 * Post: returns the final grade for the student */
	public int getFinalExamGrade() {return finalExam;}
	/** Method: getFinalExamGrade()
	 * Purpose: returns the final exam grade for the student
	 * Pre: none
	 * Post: returns the final exam grade for the student */
	
	// --- Mutators --- //
	public void setAssignments(String assignmetList) {assignments = assignmetList;}
   /** Method: setAssignments()
	 * Purpose: changes the assignments variable to the input list (in string form)
	 * Pre: String assignmentList
	 * Post: Changes the assignments variable to the given list */
	public void setQuizzes(String quizList) {quizzes = quizList;}
   /** Method: setQuizzes()
	 * Purpose: changes the quizzes variable to the input list (in string form)
	 * Pre: String quizList
	 * Post: Changes the quizzes variable to the given list */
	public void setTests(String testList) {tests = testList;}
   /** Method: setTests()
	 * Purpose: changes the tests variable to the input list (in string form)
	 * Pre: String testList
	 * Post: Changes the tests variable to the given list */
	public void setFinal(int finalGrade) {finalExam = finalGrade;}
	/** Method: setFinal()
	 * Purpose: sets the finalExam variable the the input grade
	 * Pre: int finalGrade
	 * Post: Changes the finalExam variable to the given grade */
	
	// --- Average Calculators --- //
	public void calcAssignmentAvg() {
		Scanner assignmentScan = new Scanner(assignments);
		int gradeCount = 0;
		double gradeSum = 0;
		while (assignmentScan.hasNext()) {
			int currentGrade = assignmentScan.nextInt();
			gradeSum += currentGrade;
			gradeCount++;
		}
		assignmentAvg = gradeSum/gradeCount;
		assignmentScan.close();
	}
	/** Method: calcAssignmentAvg()
	 * Purpose: calculates the average of all of the assignments
	 * Pre: none
	 * Post: calculates the average of all of the assignments stored in the student object and stores it within the student object */
	public void calcQuizAvg() {
		Scanner quizScan = new Scanner(quizzes);
		int gradeCount = 0;
		double gradeSum = 0;
		while (quizScan.hasNext()) {
			int currentGrade = quizScan.nextInt();
			gradeSum += currentGrade;
			gradeCount++;
		}
		quizAvg = gradeSum/gradeCount;
		quizScan.close();
	}
	/** Method: calcQuizAvg()
	 * Purpose: calculates the average of all of the quizzes
	 * Pre: none
	 * Post: calculates the average of all of the quizzes stored in the student object and stores it within the student object */
	public void calcTestAvg() {
		Scanner testScan = new Scanner(tests);
		int gradeCount = 0;
		double gradeSum = 0;
		while (testScan.hasNext()) {
			int currentGrade = testScan.nextInt();
			gradeSum += currentGrade;
			gradeCount++;
		}
		testAvg = gradeSum/gradeCount;
		testScan.close();
	}
	/** Method: calcTestAvg()
	 * Purpose: calculates the average of all of the tests
	 * Pre: none
	 * Post: calculates the average of all of the tests stored in the student object and stores it within the student object */
	public void calcFinalGrade() {
		finalAverage = (finalExam*.2) + (testAvg*.2) + (quizAvg*.2) + (assignmentAvg*.4);
	}
	/** Method: calcFinalGrade()
	 * Purpose: calculates the final score for the student
	 * Pre: none
	 * Post: calculates the final average using final: 40% tests&quizzes: 40% & assignments: 40% */
}
