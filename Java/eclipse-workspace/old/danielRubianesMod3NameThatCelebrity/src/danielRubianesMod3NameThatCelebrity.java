/*
 * Daniel Rubianes
 * Date: 10/9/18
 * Hendersonville High School
 * Name That Celebrity
 * 
 * Description: Displays a portion of the name of three celebrities as a proof-of-concept for a game show
 * Difficulties: None
 * What I learned: How to properly use the substring, length, and toLowerCase methods.
*/
public class danielRubianesMod3NameThatCelebrity
{
    public static void main(String args[])
    {
    	String s1 = "Taylor Swift";
    	String s2 = "John Boyega";
    	String s3 = "Emma Stone";
    	System.out.println(
    		s1+">>>"+(s1.substring(2,s1.length()-3)).toLowerCase()+"\n"+
    		s2+">>>"+(s2.substring(2,s2.length()-3)).toLowerCase()+"\n"+
    		s3+">>>"+(s3.substring(2,s3.length()-3)).toLowerCase()+"\n"
    	);
    }
}

/*
 * Sample Output: 
 * Taylor Swift>>>ylor sw
 * John Boyega>>>hn boy
 * Emma Stone>>>ma st
 */