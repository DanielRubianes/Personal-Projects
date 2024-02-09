/*
 * Daniel Rubianes
 * Date: 3/19/2019
 * Hendersonville High School
 * Images
 * 
 * Description: Creates ASCII art using an arbitrary "image" format and a data file
 * Difficulties: none
 * What I learned: How to turn a data file into an image using characters corresponding to ranges of numbers.
*/
// import java.io.* and java.util.*
import java.io.*;
import java.util.*;
public class danielRubianesM12Images
{
    public static void main(String args[]) throws FileNotFoundException
    {
    	// create the file scanner
    	Scanner data = new Scanner(new File("data.in"));
    	
    	int currentCol = 0;
    	
    	while (data.hasNextInt()) {
    		int currentValue = data.nextInt()/8;
    		switch (currentValue) {
    			case 0:
    				System.out.print(" ");
    				break;
    			case 1:
    				System.out.print(".");
    				break;
    			case 2:
    				System.out.print(",");
    				break;
    			case 3:
    				System.out.print("-");
    				break;
    			case 4:
    				System.out.print("+");
    				break;
    			case 5:
    				System.out.print("o");
    				break;
    			case 6:
    				System.out.print("O");
    				break;
    			case 7:
    				System.out.print("X");
    				break;
    		}
    		currentCol++;
    		if (currentCol == 64) {currentCol = 0; System.out.println();}
    	}
    	
    	data.close();
    }
}

/*
Sample Output: 
                                                               O
                                                                
                                                               ,
                                                               X
                                                               O
                                                               X
                                                               O
                                                                
                                                               X
                                                               ,
                                                               ,
                                                               ,
                                                               o
                                                               ,
                                                               ,
                                                               ,
                                                               ,
                                                               .
  OOOOOOOOOO   OOOOOOOOOO   OOOOOOOOOO   OOOOOOOOOO            X
  XXXXXXXXXX   XXXXXXXXXX   XXXXXXXXXX   XXXXXXXXXX            X
  ++++++++++   ++++++++++   ++++++++++   ++++++++++            -
  oo      oo   oo      oo   oo      oo   oo      oo            O
  OO      OO   OO      OO   OO      OO   OO      OO            o
  XX      XX   XX      XX   XX      XX   XX      XX            -
  ++      ++   ++      ++   ++           ++                    o
  oo      oo   oo      oo   oo           oo                     
  OO      OO   OO      OO   OO           OO                    ,
  XX      XX   XX      XX   XX           XX                    +
  ++      ++   ++      ++   ++           ++                     
  oo      oo   oo      oo   oo           oo                    o
  OO      OO   OO      OO   OO           OO                    -
  XX      XX   XX      XX   XX           XX                    ,
  ++      ++   ++      ++   ++           ++                    .
  oooooooooo   oooooooooo   oo           oooooooooo            ,
  OOOOOOOOOO   OOOOOOOOOO   OO           OOOOOOOOOO             
  XXXXXXXXXX   XXXXXXXXXX   XX           XXXXXXXXXX             
  ++      ++   ++           ++                   ++            ,
  oo      oo   oo           oo                   oo            -
  OO      OO   OO           OO                   OO            X
  XX      XX   XX           XX                   XX            o
  ++      ++   ++           ++                   ++            -
  oo      oo   oo           oo                   oo            ,
  OO      OO   OO           OO                   OO            ,
  XX      XX   XX           XX                   XX            -
  ++      ++   ++           ++                   ++             
  oo      oo   oo           oo                   oo            ,
  OO      OO   OO           OO                   OO            ,
  XX      XX   XX           XX      XX   X       XX            +
  ++      ++   ++           ++      ++   ++      ++            ,
  oo      oo   oo           oo      oo   oo      oo            ,
  OO      OO   OO           OOOOOOOOOO   OOOOOOOOOO            -
  XX      XX   XX           XXXXXXXXXX   XXXXXXXXXX            .
  ++      ++   ++           ++++++++++   ++++++++++             
                                                               +
                                                                
                                                               +
                                                               +
                                                               +
                                                               o
                                                               .
                                                               X
                                                               ,
                                                               .
                                                                
 */