/*
 * Daniel Rubianes
 * Date: 10/2/18
 * Hendersonville High School
 * Mints
 * 
 * Description: Calculates how many bags required to store three mints per bag, as well as the number of mints that will be left over.
 * Difficulties: None
 * What I learned: How to find the remainder of division in java.
*/
public class danielRubianesMod3Mints
{
    public static void main(String args[])
    {
        int totalMints = 500;
        int numberOfBags = totalMints / 3;
        int mintsLeftOver = totalMints % 3;
        System.out.println("Total Mints = " + totalMints);
        System.out.println("Number of Bags = " + numberOfBags);
        System.out.println("Mints Left Over = " + mintsLeftOver);
    }
}

/*
 * Sample Output: 
 * Total Mints = 500
 * Number of Bags = 166
 * Mints Left Over = 2
 */