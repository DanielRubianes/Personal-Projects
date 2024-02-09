/*
 * Daniel Rubianes
 * Date: 1/15/2019
 * Hendersonville High School
 * Library Project
 * 
 * Description: A project containing classes that allow for storage of data for patrons and books within a library using objects.
 * Difficulties: None
 * What I learned: A lot about classes, ex: the constructor can be redefined with different inputs to acheive different results.
*/
public class danielRubianesTestPatron {
	public static void main(String [ ] args) 
	{
		danielRubianesBook myBook = new danielRubianesBook("ABC", "Lucy Wells");
		danielRubianesBook myBook2 = new danielRubianesBook("Milking", "Go Troils");
		danielRubianesPatron patron1 = new danielRubianesPatron();
		danielRubianesPatron patron2 = new danielRubianesPatron("Harry", "Wells", "a99h78sd", myBook);
		
		System.out.println("" + patron2);
		
		patron1.setFirstName("Mary");
		patron1.setLastName("Suzel");
		patron1.setNumber("aa97jlo");
		patron1.setBook(myBook2);
		System.out.println("" + patron1);
	}
}
/*
Sample Output: 
The details for the patron are: 
	 Name: Harry Wells
	 Card Number: a99h78sd
	 The specs of the book are: 
	 Title: ABC
	 Author: Lucy Wells
The details for the patron are: 
	 Name: Mary Suzel
	 Card Number: aa97jlo
	 The specs of the book are: 
	 Title: Milking
	 Author: Go Troils
 */