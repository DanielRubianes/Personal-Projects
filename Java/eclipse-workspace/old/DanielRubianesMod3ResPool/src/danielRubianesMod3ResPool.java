/*
 * Daniel Rubianes
 * Date: 10/4/18
 * Hendersonville High School
 * Resistance Pool
 * 
 * Description: Finds the area of tile needed to cover the floor of a resistance pool with an island in the middle.
 * Difficulties: None
 * What I learned: How to calculate exponenet in java.
*/
public class danielRubianesMod3ResPool
{
    public static void main(String args[])
    {
        double pi = 3.1415;
        double poolDiameter = 8.32;
        double islandDiameter = 1.91;
        double poolRadius = poolDiameter/2;
        double islandRadius = islandDiameter/2;
        double poolArea = (pi*Math.pow(poolRadius,2.0)); // pi*R^2
        double islandArea = (pi*Math.pow(islandRadius,2.0)); // pi*R^2
        double tileArea = poolArea - islandArea;
        System.out.println("A resistance pool with a diameter of 8.32 meters that contains a circular island of 1.91 meters has " + tileArea + " square meters that needs tile.");
    }
}

/*
 * Sample Output: 
 * A resistance pool with a diameter of 8.32 meters that contains a circular island of 1.91 meters has 51.500415862500006 square meters that needs tile.
 */