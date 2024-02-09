/**
  * creates roman time objects and has functions to convert to and from roman time
  * 
  * @author Daniel Rubianes
  * @version date
 */
public class danielRubianesRoman {
	
	// instance variable
	private String numerals;
	
	// constructor
	public danielRubianesRoman(String timeInRoman) {numerals = timeInRoman;}
	/** Method: danielRubainesRoman()
	 * Purpose: Constructs a Roman time object
	 * Pre: String timeInRoman
	 * Post: Creates object with the specified time */
	
	// accessor
	public String getValue() {return numerals;}
	/** Method: getValue()
	 * Purpose: returns the value for the given time object
	 * Pre: none
	 * Post: returns the numerals variable for the given time object */
	
	// mutator
	public void setValue(String newValue) {numerals = newValue;}
	/** Method: setValue()
	 * Purpose: changes the value for the given time object
	 * Pre: String newValue
	 * Post: sets the numerals value for the given object to the given value */
	
	// etc
	public String toString() {return numerals;}
	/** Method: toString()
	 * Purpose: converts the given object to a string
	 * Pre: none
	 * Post: returns the numerals values for the given object */
	private static int parseRoman(String string) {
		if (string.equals("")) {return 0;}
		int decimal = 0;
		String currentChar, nextChar;
		// runs through each character in the string, adding the corresponding value to the decimal value, and skipping indexes when accounting for the subtractive principal of Roman numerals
		for (int index = 0; index < string.length(); index++) {
			currentChar = string.substring(index, index+1);
			if (index < (string.length()-1)) {
				nextChar = string.substring(index+1, index+2);
			}
			else {nextChar = "";}
			switch (currentChar) {
	        	case "I":
	        		if (nextChar.equals("V")) {
	        			decimal += 4;
	        			index++;
	        		}
	        		else if (nextChar.equals("X")) {
	        			decimal += 9;
	        			index++;
	        		}
	        		else {decimal += 1;}
	        		break;
	        	case "V": decimal += 5; break;
	        	case "X":
	        		if (nextChar.equals("L")) {
	        			decimal += 40;
	        			index++;
	        		}
	        		else if (nextChar.equals("C")) {
	        			decimal += 90;
	        			index++;
	        		}
	        		else {
	        			decimal += 10;
	        		}
	        		break;
	        	case "L": decimal += 50; break;
	        	case "C":
	        		if (nextChar.equals("D")) {
	        			decimal += 400;
	        			index++;
	        		}
	        		else if (nextChar.equals("M")) {
	        			decimal += 900;
	        			index++;
	        		}
	        		else {decimal += 100;}
	        		break;
	        	case "D": decimal += 500; break;
	        	case "M": decimal += 1000; break;
			}
		}
		return decimal;
	}
	/** Method: parseRoman()
	 * Purpose: Converts a string of Roman character to decimal form
	 * Pre: String string (Roman numerals)
	 * Post: returns the decimal value for the given Roman numerals */
	private static String toRoman(int decimal) {
		String roman = "";
		// loops until the decimal reaches 0, subtracting the largest amount possible and adding the corresponding roman numerals to the roman string
		while (decimal > 0) {
			if (decimal >= 1000) {
				decimal -= 1000;
				roman += "M";
			}
			else if (decimal >= 900) {
				decimal -= 900;
				roman += "CM";
			}
			else if (decimal >= 500) {
				decimal -= 500;
				roman += "D";
			}
			else if (decimal >= 400) {
				decimal -= 400;
				roman += "CD";
			}
			else if (decimal >= 100) {
				decimal -= 100;
				roman += "C";
			}
			else if (decimal >= 90) {
				decimal -= 90;
				roman += "XC";
			}
			else if (decimal >= 50) {
				decimal -= 50;
				roman += "L";
			}
			else if (decimal >= 40) {
				decimal -= 40;
				roman += "XL";
			}
			else if (decimal >= 10) {
				decimal -= 10;
				roman += "X";
			}
			else if (decimal >= 9) {
				decimal -= 9;
				roman += "IX";
			}
			else if (decimal >= 5) {
				decimal -= 5;
				roman += "V";
			}
			else if (decimal >= 4) {
				decimal -= 4;
				roman += "IV";
			}
			else if (decimal >= 1) {
				decimal -= 1;
				roman += "I";
			}
		}
		return roman;
	}
	/** Method: toRoman()
	 * Purpose: converts a decimal value to a string of Roman numerals
	 * Pre: int decimal
	 * Post: a string containing the roman numerals equaling the given decimal value */
	private int compareTo(danielRubianesRoman otherTime) {
		String current = convertToDecimalTime();
		String other = otherTime.convertToDecimalTime();
		int thisHours = Integer.parseInt( current.substring(0, current.indexOf(":")) );
		int thisMinutes = Integer.parseInt( current.substring(current.indexOf(":")+1, current.length()) );
		int otherHours = Integer.parseInt( other.substring(0, other.indexOf(":")) );
		int otherMinutes = Integer.parseInt( other.substring(other.indexOf(":")+1, other.length()) );
		
		if (thisHours > otherHours) {return 1;}
		else if (thisHours < otherHours) {return -1;}
		else {
			if (thisMinutes > otherMinutes) {return 1;}
			else if (thisMinutes < otherMinutes) {return -1;}
			else {return 0;}
		}
	}
	/** Method: compareTo()
	 * Purpose: Compares two Roman time objects
	 * Pre: danielRubianesRomen otherTime
	 * Post: returns 1 if the given object is first chronologically than the other, a 0 if they are equal, or a -1 if the other is first */
    public static void sort(danielRubianesRoman array[]) {
    	danielRubianesRoman currentTime;
    	int otherIndex;
    	boolean continueLoop;
    	// Go through the array, placing each time individually at its correct position
    	for (int index = 1; index < array.length; index++) {
    		currentTime = array[index];
    		otherIndex = index - 1;
    		continueLoop = true;
    		while ((otherIndex >= 0) && continueLoop) {
    			if (currentTime.compareTo(array[otherIndex]) == -1) {
    				array[otherIndex+1] = array[otherIndex];
    				otherIndex--;
    				if (otherIndex == -1) {
    					array[0] = currentTime;
    				}
    				
    			}
    			else {
					continueLoop = false;
					array[otherIndex + 1] = currentTime;
				}
    		}
    	}
    }
    /** Method: sort()
	 * Purpose: sorts an array of Roman time objects chronologically
	 * Pre: array of Roman time objects
	 * Post: sorts the array chronologically */
	public String convertToDecimalTime() {
        String hours = numerals.substring(0, numerals.indexOf(":"));
        String minutes = numerals.substring(numerals.indexOf(":")+1, numerals.length());
        int decimalHours = parseRoman(hours);
        int decimalMinutes = parseRoman(minutes);
        String decimalMinutesString = "" + decimalMinutes;
        if (decimalMinutesString.length() == 1) {decimalMinutesString = "0" + decimalMinutesString;}
        return decimalHours + ":" + decimalMinutesString;
	}
	/** Method: convertToDecimalTime()
	 * Purpose: converts the given time object to decimal
	 * Pre: none
	 * Post: returns the given time object in decimal form */
	public static String convertToRomanTime(String decimalTime) {
        String hours = decimalTime.substring(0, decimalTime.indexOf(":"));
        String minutes = decimalTime.substring(decimalTime.indexOf(":")+1, decimalTime.length());
        String romanHours = toRoman(Integer.parseInt(hours));
        String romanMinutes = toRoman(Integer.parseInt(minutes));
        return romanHours + ":" + romanMinutes;
	}
	/** Method: convertToRomanTime()
	 * Purpose: converts from decimal time to Roman
	 * Pre: String decimalTime
	 * Post: returns the Roman numeral form for the given decimal time */
}
