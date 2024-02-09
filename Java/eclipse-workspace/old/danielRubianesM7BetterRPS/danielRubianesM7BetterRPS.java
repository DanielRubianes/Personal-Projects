/*
 * Daniel Rubianes
 * Date: 12/6/2018
 * Hendersonville High School
 * Rock Paper Scissors 2.0
 * 
 * Description: 5-round game of rock paper scissors against the computer
 * Difficulties: Not properly initializing variables; not setting integers to 0;
 * What I learned: How to compare strings w/o case testing.
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM7BetterRPS
{
    public static void main(String args[])
    {
    	// create the input scanner and the random number generator
    	Scanner input = new Scanner(System.in);
    	Random rand = new Random();
    	
    	// define variables
    	int playerChoiceNum = 0;
    	String playerChoice = "";
    	int playerScore = 0;
    	int compChoiceNum = 0;
    	String compChoice = "";
    	int compScore = 0;
    	
    	// introduce the program
    	System.out.println("--- Rock | Paper | Scissors ---");
    	System.out.println("You will play five rounds against the computer. Enter \"Rock\", \"Paper\", or \"Scissors\".");
    	// main loop; loops until "anotherGame" is false
    	boolean anotherGame = true;
    	while (anotherGame) {
    		// runs 5 rounds
	    	for (int round = 1; round <=5; round++) {
	    		// introduce round
	    		System.out.println("Round #" + round);
	    		
	    		// computer's choice
	    		compChoiceNum = rand.nextInt(2)+1;
	    		switch (compChoiceNum) {
					case 1: compChoice = "rock"; break;
					case 2: compChoice = "paper"; break;
					case 3: compChoice = "scissors"; break;
	    		}
	    		
	    		// player's choice
	    		boolean invalidEntry = true;
	    		// (loops until player enters a valid response)
	    		while (invalidEntry) {
	        		System.out.print("Enter your choice: ");
	        		playerChoice = input.next();
	    			invalidEntry = false;
		    		if (playerChoice.substring(0, 2).equalsIgnoreCase("ro")) {
		    			playerChoice = "rock";
		    			playerChoiceNum = 1;
		    		}
		    		else if (playerChoice.substring(0, 2).equalsIgnoreCase("pa")) {
		    			playerChoice = "paper";
		    			playerChoiceNum = 2;
		    		}
		    		else if (playerChoice.substring(0, 2).equalsIgnoreCase("sc")) {
		    			playerChoice = "scissors";
		    			playerChoiceNum = 3;
		    		}
		    		else {
		    			System.out.println("Invalid entry! Enter \"Rock\", \"Paper\", or \"Scissors\".");
		    			invalidEntry = true;
		    		}
	    		}
	    		
	    		System.out.println("The computer chose " + compChoice);
	    		
	    		// check who won
	    		if (playerChoiceNum == compChoiceNum) {
	        		// tie
	        		System.out.println("It is a draw!");
	        	}
	        	else if ((playerChoiceNum == 1 && compChoiceNum == 3) || (playerChoiceNum == 2 && compChoiceNum == 1) || (playerChoiceNum == 3 && compChoiceNum == 2)) {
	        		// player wins
	        		System.out.println("You win, " + playerChoice + " beats " + compChoice + ".");
	        		playerScore += 1;
	        	}
	        	else {
	        		// computer wins
	        		System.out.println("Computer wins, " + compChoice + " beats " + playerChoice + ".");
	        		compScore += 1;
	        	}
	    		
	    		// display the score
	    		System.out.println("Computer: " + compScore + ", You: " + playerScore);
	    	}
	    	// display who won
	    	if (playerScore == compScore) {
	    		System.out.println("You tied with the computer. :/");
	    	}
	    	else if (playerScore > compScore) {
	    		System.out.println("You beat the computer! ;)");
	    	}
	    	else {
	    		System.out.println("The computer won! :'(");
	    	}
	    	// ask the use if they would like to play again
        	System.out.print("Would you like to play again?");
        	String again = input.next();
        	// end the loop if the user does not enter "yes"
        	if (again.equalsIgnoreCase("yes")) {anotherGame = true;}
        	else {anotherGame = false;}
    	}
    }
}

/*
Sample Output: 
--- Rock | Paper | Scissors ---
You will play five rounds against the computer. Enter "Rock", "Paper", or "Scissors".
Round #1
Enter your choice: rock
The computer chose paper
Computer wins, paper beats rock.
Computer: 1, You: 0
Round #2
Enter your choice: eorij
Invalid entry! Enter "Rock", "Paper", or "Scissors".
Enter your choice: paper
The computer chose rock
You win, paper beats rock.
Computer: 1, You: 1
Round #3
Enter your choice: scissors
The computer chose paper
You win, scissors beats paper.
Computer: 1, You: 2
Round #4
Enter your choice: paper
The computer chose paper
It is a draw!
Computer: 1, You: 2
Round #5
Enter your choice: rock
The computer chose rock
It is a draw!
Computer: 1, You: 2
You beat the computer! ;)
Would you like to play again?
 */