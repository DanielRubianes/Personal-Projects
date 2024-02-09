/*
 * Daniel Rubianes
 * Date: 1/15/2019
 * Hendersonville High School
 * M9L2 practice activity 2
 * 
 * Description: Program that displays how == and .equals() work
 * Difficulties: none
 * What I learned: .equals() does not work for arbitrary classes.
*/
public class danielRubianesTester {
	public static void main(String[] args) {
		danielRubianesRecipe yummyStuff;
		yummyStuff = new danielRubianesRecipe("Watermelon Salad");
		yummyStuff.setServings(new danielRubianesCircle(13.2));
		
		danielRubianesCircle circle1 = new danielRubianesCircle(12.1);
		danielRubianesCircle circle2;
		circle2 = circle1;
		// prints true b/c they are the same object
		System.out.println(circle1 == circle2);
		
		danielRubianesCircle circle3 = new danielRubianesCircle(12.1);
		danielRubianesCircle circle4 = new danielRubianesCircle(12.1);
		// prints false b/c they are different objects
		System.out.println(circle3 == circle4);
		// prints false b/c the circle class does not have its own equals method
		System.out.println(circle3.equals(circle4));
	}
}
/*
Sample Output: 
true
false
false
 */