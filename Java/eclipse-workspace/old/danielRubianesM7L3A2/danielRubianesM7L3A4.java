/*
 * Daniel Rubianes
 * Date: 12/16/18
 * Hendersonville High School
 * Magpie modifications 2
 * 
 * Description: A chat bot programmed to respond to certain messages. (Updated to respond to two questions)
 * Difficulties: Punctuality
 * What I learned: How to use the findKeyWord() function within the magpie class
 * 
 * Added knowledge
 * (keywords:response)
 * "Colorado","capital":"The capital of Colorado is Denver."
 * "Where","myrtle beach":"Myrtle beach is in South Carolina."
 * "Where","asheville":"Asheville is in Buncombe County, North Carolina."
 * 
 * Added responses (other assignment):
 * (trigger						:response)
 * Empty string or only spaces	:"Please say something."
 * String 100 chars or longer	:"I'm sorry, but I am too primitive to understand statements that long."
 * Contains "school"			:"Where did you go to high school?"
 * Contains "science"			:"What science are you taking next year?"
 * Contains "car"				:"What is your dream car?"
*/
/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class danielRubianesM7L3A4
{
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.toLowerCase().indexOf(
				goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn)
						.toLowerCase();
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1)
						.toLowerCase();
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal.toLowerCase(),
					psn + 1);

		}

		return -1;
	}

	
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.trim().equals(""))
		{
			response = "Please say something.";
		}
		else if (statement.length() >= 100)
		{
			response = "I'm sorry, but I am too primitive to understand statements that long.";
		}
		else if (statement.indexOf("school") >= 0)
		{
			response = "Where did you go to high school?";
		}
		else if (statement.indexOf("science") >= 0)
		{
			response = "What science are you taking next year?";
		}
		else if (statement.indexOf("car") >= 0)
		{
			response = "What is your dream car?";
		}
		else if (findKeyword(statement, "Colorado", 0) >= 0 && findKeyword(statement, "capital", 0) >= 0) 
		{
			response = "The capital of Colorado is Denver.";
		}
		else if (findKeyword(statement, "Where", 0) >= 0 && findKeyword(statement, "myrtle beach", 0) >= 0) 
		{
			response = "Myrtle beach is in South Carolina.";
		}
		else if (findKeyword(statement, "Where", 0) >= 0 && findKeyword(statement, "Asheville", 0) >= 0) 
		{
			response = "Asheville is in Buncombe County, North Carolina.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}
	
	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}

		return response;
	}
}
/*
Sample Output: 
Hello, let's talk.
What is the capital of Colorado
The capital of Colorado is Denver.
Where is myrtle beach?
Myrtle beach is in South Carolina.
Where is Asheville?
Asheville is in Buncombe County, North Carolina.
Bye

 */