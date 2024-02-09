/*
 * Daniel Rubianes
 * Date: 1/24/2019
 * Hendersonville High School
 * Dweeb Twerp
 * 
 * Description: Program that showcases public variables in classes
 * Difficulties: none
 * What I learned: how public variables work among separate classes
*/
public class danielRubianesM9L4PA4Tester
{
    public static void main(String args[])
    {
        danielRubianesDweeb twerp1 = new danielRubianesDweeb();
        	twerp1.x = 3;
        danielRubianesDweeb twerp2 = new danielRubianesDweeb();
        	twerp2.x = 5;
        
        System.out.println(twerp1.x);
        System.out.println(twerp2.x);
    }
}

/*
Sample Output: 
5
5
 */