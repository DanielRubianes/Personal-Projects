/*
 * Daniel Rubianes
 * Date: 1/21/2019
 * Hendersonville High School
 * Circle Tester
 * 
 * Description: Program that uses the circle class and showcases its accessor & mutator methods as well as the circumference method.
 * Difficulties: None
 * What I learned: How to create a circle class.
*/
public class danielRubianesM9L1PA3Tester
{
    public static void main(String args[])
    {
        danielRubianesM9Circle circle1 = new danielRubianesM9Circle(5.1);
        danielRubianesM9Circle circle2 = new danielRubianesM9Circle(20.6);
        System.out.println(circle1.area());
        circle1.setRadius(20);
        // verify the radius was changed
        if (circle1.getRadius() == 20) {System.out.println("The radius was successfully changed");}
        System.out.println(circle1.circumference());
    }
}

/*
Sample Output: 
81.7128249198705
The radius was successfully changed
125.66370614359172

 */