/*
 * Daniel Rubianes
 * Date: 1/24/2019
 * Hendersonville High School
 * Recipe tester
 * 
 * Description: Showcases how private methods can not be accesed from another class (will not compile)
 * Difficulties: None
 * What I learned: The fact that private methods can not be accessed by other classes
*/
public class danielRubianesM9L4PA2Tester {
	public static void main(String args[]) {
		danielRubianesRecipe yummyStuff = new danielRubianesRecipe("Watermelon salad");
		double ff = yummyStuff.pricePerCalorie(3);
	}
}
/*
Sample Output: 
N/A
 */