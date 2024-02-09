/** 
 * creates a list of 10 students with 27 grades each, ranging from 40 to 100
 */
import java.util.*;
public class danielRubianesProgramIUsedToMakeMyDataSetBecauseImLazy {
	public static void main(String args[])
    {
		Random rand = new Random();
		String lines = "";
		for (int index = 1; index <= 10; index++) {
			String currentLine = "";
			for (int index2 = 1; index2 <= 27; index2++) {
				currentLine += (int)(rand.nextDouble()*61 + 40) + " ";
			}
			lines += currentLine + "\n";
		}
		System.out.println(lines);
    }
}
