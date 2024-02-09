import java.io.*;
import java.util.*;
class testing
{
  public static void main ( String[] args ) 
  {
    int[] array =  { -20, 19, 1, 5, -1, 27, 19, 5 } ;
    int   max;

    // initialize the current maximum
    max = array[0];

    // scan the array
    for ( int index=0; index < array.length-1; index++ )
    { 
      if ( array[ index ] > max )    // examine the current element
        max = array[ index ];        // if it is the largest so far, change max
    }     
    System.out.println("The maximum of this array is: " + max );
  }
}     
