/*
 * Daniel Rubianes
 * Date: 2/19/2019
 * Hendersonville High School
 * Fireflies
 * 
 * Description: Program that creates 10 virtual fireflies that kill each other when too close and has them fly around randomly until one is left
 * Difficulties: Not really a fixable difficulty, but I have noticed that this program freezes my laptop sometimes. I am assuming this is because two fireflies get to far away from each other and the program keeps looping. This could probably be fixed by add some sort of delay
 * What I learned: How to find the distance between to objects in three dimensional space using coordinates.
*/
// import java.util.*
import java.util.*;
public class danielRubianesM10Fireflies
{
    public static void main(String args[])
    {
    	// make the array
    	danielRubianesFirefly[] fireflies = new danielRubianesFirefly[10];
    	// populate the array
    	for (int index = 0; index < fireflies.length; index++) {
    		fireflies[index] = new danielRubianesFirefly();
    	}
    	
    	System.out.println(fireflies.length + " fireflys have been created!");
    	
    	// create variable to store the number of alive fireflies
    	int alive = fireflies.length;
    	// main loop; runs until there is only one firefly left
    	while (alive > 1) {
    		// for loop that moves through the list, moving each firefly at random
    		for (int movingFirefly = 0; movingFirefly < fireflies.length; movingFirefly++) {
    			// only runs if the selected firefly is still alive
    			if (fireflies[movingFirefly].getLife()) {
    				// moves the current firefly randomly
	    			fireflies[movingFirefly].move();
	    			// for loop that goes through the list checking for fireflies that have been killed (this happens when the moving firefly flies within 1 unit of another)
	    			for (int otherFirefly = 0; otherFirefly < fireflies.length; otherFirefly++) {
	    				// runs if the firefly is killed and is not already dead or the same firefly
	    				if ((fireflies[movingFirefly].getDistance(fireflies[otherFirefly]) <= 1) && movingFirefly != otherFirefly &&
	    					(fireflies[otherFirefly].getLife() != false) && (alive > 2)) {
	    					System.out.println("Firefly #"+(otherFirefly+1)+" was eaten by firefly #"+(movingFirefly+1) + 
	    							"\nThere are now " + --alive + " fireflies left!");
	    					fireflies[otherFirefly].setLife(false);
	    				}
	    				// runs when the last firefly is killed
	    				else if ((fireflies[movingFirefly].getDistance(fireflies[otherFirefly]) <= 1) && movingFirefly != otherFirefly &&
	    						(fireflies[otherFirefly].getLife() != false) && (alive == 2)) {
	    					System.out.println("The last firefly, firefly #"+(otherFirefly+1)+" was eaten by firefly #"+(movingFirefly+1) + 
	    							"\nFirefly #"+(movingFirefly+1)+" is the winner!");
	    					fireflies[otherFirefly].setLife(false);
	    					
	    				}
	    			}
    			}
    		}
    	}
    	// ask the user if they would like to see the position of all of the fireflies
    	Scanner input = new Scanner(System.in);
    	System.out.println("Show final positions? (y/n)");
    	String answer = input.next();
    	input.close();
    	// loop that prints out each firefly as a string
    	if (answer.toLowerCase().equals("y")) {
	    	for (int index = 0; index < fireflies.length; index++) {
	    		System.out.println(fireflies[index]);
	    	}
    	}
    }
}

/*
Sample Output: 
10 fireflys have been created!
Firefly #9 was eaten by firefly #2
There are now 9 fireflies left!
Firefly #4 was eaten by firefly #1
There are now 8 fireflies left!
Firefly #8 was eaten by firefly #3
There are now 7 fireflies left!
Firefly #10 was eaten by firefly #5
There are now 6 fireflies left!
Firefly #1 was eaten by firefly #7
There are now 5 fireflies left!
Firefly #2 was eaten by firefly #7
There are now 4 fireflies left!
Firefly #3 was eaten by firefly #6
There are now 3 fireflies left!
Firefly #5 was eaten by firefly #7
There are now 2 fireflies left!
The last firefly, firefly #6 was eaten by firefly #7
Firefly #7 is the winner!

 */