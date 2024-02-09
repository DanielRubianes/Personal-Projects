/**
  * Class used to test the book class
  * 
  * @author Daniel Rubianes
  * @version 1/15/2019
 */
public class danielRubianesTestBook {
	public static void main(String [ ] args) 
	{
		danielRubianesBook myBook1 = new danielRubianesBook("Alice in Wonderland","Lewis Car");
		danielRubianesBook myBook2 = new danielRubianesBook();
		danielRubianesBook myBook3 = new danielRubianesBook("On the highway","Jen jones");
		danielRubianesBook myBook4 = new danielRubianesBook(myBook3);
		
		System.out.println("" + myBook1);
		System.out.println("" + myBook3);
		
		myBook2.setTitle("Alphabet 123");
		myBook2.setAuthor("Sam Smith");
		System.out.print("" + myBook2);
		myBook3.setAuthor("Jennifer Jones");
		System.out.println("\n" + myBook3);
		
		System.out.print(myBook1.getAuthor() + " ");
		System.out.println(myBook1.getTitle());
		
		System.out.println(myBook4);
	}
}
/*
Sample Output: 
The specs of the book are: 
	 Title: Alice in Wonderland
	 Author: Lewis Car
The specs of the book are: 
	 Title: On the highway
	 Author: Jen jones
The specs of the book are: 
	 Title: Alphabet 123
	 Author: Sam Smith
The specs of the book are: 
	 Title: On the highway
	 Author: Jennifer Jones
Lewis Car Alice in Wonderland
The specs of the book are: 
	 Title: On the highway
	 Author: Jen jones


 */