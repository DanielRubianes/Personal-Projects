/*
 * Daniel Rubianes
 * Date: 11/28
 * Hendersonville High School
 * Rock Paper Scissors
 * 
 * Description: Plays a game of virtual rock paper scissors against a random number generator.
 * Difficulties: none
 * What I learned: A way to properly utilize switch statements.
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM6RPS
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// create the random number generator
    	Random rand = new Random();
    	
    	// initialize variables
        int playerChoiceNum;
        int compChoiceNum;
        String playerChoice = "";
        String compChoice = "";
        boolean anotherGame = true;
        
        // repeats while anotherGame is true
        while (anotherGame) {
        	// tell the player what each number represents
        	System.out.print("Game choices are 1 for rock, 2 for paper, or 3 for scissors\nEnter your game choice (1, 2, or 3):");
        	// get the player's choice
        	playerChoiceNum = input.nextInt();
        	// get the computer's choice
        	compChoiceNum = rand.nextInt(2)+1;
        	
        	// set the playerChoice string to the name of the option the player chose
        	switch (playerChoiceNum) {
        		case 1: playerChoice = "rock"; break;
        		case 2: playerChoice = "paper"; break;
        		case 3: playerChoice = "scissors"; break;
        	}
        	// set the compChoice string to the name of the option that the computer selected
        	switch (compChoiceNum) {
    			case 1: compChoice = "rock"; break;
    			case 2: compChoice = "paper"; break;
    			case 3: compChoice = "scissors"; break;
        	}
        	
        	// output what the player chose and what the computer chose
        	System.out.println("You chose " + playerChoice + ".");
        	System.out.println("The computer chose " + compChoice + ".");
        	
        	// test if the player beat the computer
        	
        	if (playerChoiceNum == compChoiceNum) {
        		// tie
        		System.out.println("It is a draw! :/");
        	}
        	else if ((playerChoiceNum == 1 && compChoiceNum == 3) || (playerChoiceNum == 2 && compChoiceNum == 1) || (playerChoiceNum == 3 && compChoiceNum == 2)) {
        		// player wins
        		System.out.println("You win, " + playerChoice + " beats " + compChoice + ". ;)");
        	}
        	else {
        		// computer wins
        		System.out.println("Computer wins, " + compChoice + " beats " + playerChoice + ". :'(");
        	}
        	
        	// ask the use if they would like to play again
        	System.out.print("Play again? (y/n):");
        	String again = input.next();
        	// end the loop if the user does not enter "y"
        	if (again.equals("y")) {anotherGame = true;}
        	else {anotherGame = false;}
        }
    }
}

/*
Sample Output: 
Game choices are 1 for rock, 2 for paper, or 3 for scissors
Enter your game choice (1, 2, or 3):[input]2
You chose paper.
The computer chose paper.
It is a draw! :/
Play again? (y/n):[input]y
Game choices are 1 for rock, 2 for paper, or 3 for scissors
Enter your game choice (1, 2, or 3):[input]3
You chose scissors.
The computer chose paper.
You win, scissors beats paper. ;)
Play again? (y/n):[input]y
Game choices are 1 for rock, 2 for paper, or 3 for scissors
Enter your game choice (1, 2, or 3):[input]2
You chose paper.
The computer chose rock.
You win, paper beats rock. ;)
Play again? (y/n):[input]y
Game choices are 1 for rock, 2 for paper, or 3 for scissors
Enter your game choice (1, 2, or 3):[input]1
You chose rock.
The computer chose paper.
Computer wins, paper beats rock. :'(
Play again? (y/n):[input]n
 */