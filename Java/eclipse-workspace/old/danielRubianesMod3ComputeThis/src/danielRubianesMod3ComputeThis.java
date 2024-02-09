/*
 * Daniel Rubianes
 * Date: 10/9/18
 * Hendersonville High School
 * Compute This
 * 
 * Description: Defines 4 variables and performs various math functions on them.
 * Difficulties: Compile error when you try to use z without defining.
 * What I learned: Various math functions.
*/
public class danielRubianesMod3ComputeThis
{
    public static void main(String args[])
    {
        int x = 3;
        int y = -5;
        int z = 0; // Compile error if this is not defined
        double w = 17.5;
        System.out.println("w = "+w+", x = "+x+", y = "+y+", and z = "+z);
        z = Math.abs(y);
        System.out.println("z is the absolute value of y; "+z);
        System.out.println("The square root of w is " + Math.sqrt(w));
        System.out.println("x to the power of z is "+Math.pow(x, z));
        System.out.println(Math.max(x,y)+" is the max of x and y");
        System.out.println(Math.min(x,y)+" is the min of x and y");
        System.out.println("If you round w you get "+Math.round(w));
        System.out.println("The floor value of w is "+Math.floor(w));
        System.out.println("The veiling value of w is "+Math.ceil(w));
        System.out.println("A random number between 1 and 10 is: "+Math.random()*10);
    }
}

/*
 * Sample Output: 
 * w = 17.5, x = 3, y = -5, and z = 0
 * z is the absolute value of y; 5
 * The square root of w is 4.183300132670378
 * x to the power of z is 243.0
 * 3 is the max of x and y
 * -5 is the min of x and y
 * If you round w you get 18
 * The floor value of w is 17.0
 * The veiling value of w is 18.0
 * A random number between 1 and 10 is: 2.5311925681792036
 */