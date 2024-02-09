/**
  * Class for creating rectangle objects
  * 
  * @author Daniel Rubianes
  * @version 1/15/2019
 */
public class danielRubianesM9Rectangle
{
	// instance variables
    private int width;
    private int length;
    
    /**
     * Method: Constructor
     * Purpose: Creates a rectangle object
     * Pre: length and width
     * Post: rectangle object w/ input length & width
    */
    public danielRubianesM9Rectangle(int inputLength, int inputWidth) {
    	width = inputWidth;
    	length = inputLength;
    }
    /**
     * Method: getArea()
     * Purpose: Finds the area of a rectangle object
     * Pre: rectangle object
     * Post: rectangle object's length*width
    */
    public int getArea() {
    	return width*length;
    }
    /**
     * Method: getPerimeter()
     * Purpose: Finds the perimeter of a rectangle object
     * Pre: rectangle object
     * Post: rectangle object's length*2 + width*2
    */
    public int getPerimeter() {
    	return width*2 + length*2;
    }
}