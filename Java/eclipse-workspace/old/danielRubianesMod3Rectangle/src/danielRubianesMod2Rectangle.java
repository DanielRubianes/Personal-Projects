/*
 * Daniel Rubianes
 * Date: 10/1/18
 * Hendersonville High School
 * Rectangles
 * 
 * Description: Finds the area and perimeter of a rectangle that is 5X4 as well as a rectangle that has a length and width 1 unit larger than the other.
 * Difficulties: Punctuality.
 * What I learned: The fact that java follows the standard order of operation.
*/
public class danielRubianesMod2Rectangle
{
    public static void main(String args[])
    {
        int length = 5;
        int width = 4;
        int perimeter = length*2 + width*2;
        int area = length * width;
        int bigPerimeter = (length + 1)*2 + (width + 1)*2;
        int bigArea = (length+1) * (width+1);
        System.out.println("Length = " + length);
        System.out.println("Width = " + width);
        System.out.println("Perimeter = " + perimeter);
        System.out.println("Area = " + area);
        System.out.println("BigPerimeter = " + bigPerimeter);
        System.out.println("BigArea = " + bigArea);
    }
}

/*
 * Sample Output: 
 * Length = 5
 * Width = 4
 * Perimeter = 18
 * Area = 20
 * BigPerimeter = 22
 * BigArea = 30
 */