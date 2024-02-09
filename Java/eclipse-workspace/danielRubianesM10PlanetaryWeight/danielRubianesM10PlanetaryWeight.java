/*
 * Daniel Rubianes
 * Date: 2/18/2019
 * Hendersonville High School
 * Planetary weight
 * 
 * Description: Calculates the user's 
 * Difficulties: none
 * What I learned: How to make a more modular program using arrays and for loops
*/
// import java.util.*]
import java.util.*;
public class danielRubianesM10PlanetaryWeight
{
    public static void main(String args[])
    {
    	// create the input scanner
    	Scanner input = new Scanner(System.in);
    	
    	// create list of planets and list of gravity ratios
    	String[] planets = {"Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
    	double[] gravityRatios = {.38, .91, .38, 2.36, .91, 1.12, .89, .06};
    	
    	boolean another = true;
    	while (another) {
	    	// ask user which planet they want to calculate weight for
	    	System.out.println("Convert your weight on earth to:");
	    	for (int index = 0; index < planets.length; index++) {
	    		System.out.printf("%d.\t%s\n", index+1, planets[index]);
	    	}
	    	System.out.printf("%d.\t%s\nSelection: ", planets.length+1, "Quit");
	    	int choice = input.nextInt();
	    	if (choice < 1 || choice > planets.length+1) {
	    		System.out.println("ERROR: Invalid destination");
	    	}
	    	else if (choice == 9) {
	    		another = false;
	    	}
	    	else {
		    	System.out.print("Enter your weight: ");
		    	int weight = input.nextInt();
	    		System.out.printf("Your weight on %s would be %.1f pounds.\n", planets[choice-1], weight*gravityRatios[choice-1]);
	    	}
    	}
    	
    	input.close();
    }
}

/*
Sample Output: 
Convert your weight on earth to:
1.	Mercury
2.	Venus
3.	Mars
4.	Jupiter
5.	Saturn
6.	Neptune
7.	Uranus
8.	Pluto
9.	Quit
Selection: 6
Enter your weight: 160
Your weight on Neptune would be 179.2 pounds.
Convert your weight on earth to:
1.	Mercury
2.	Venus
3.	Mars
4.	Jupiter
5.	Saturn
6.	Neptune
7.	Uranus
8.	Pluto
9.	Quit
Selection: 8
Enter your weight: 150
Your weight on Pluto would be 9.0 pounds.
Convert your weight on earth to:
1.	Mercury
2.	Venus
3.	Mars
4.	Jupiter
5.	Saturn
6.	Neptune
7.	Uranus
8.	Pluto
9.	Quit
Selection: 9
 */