//Array Example
//
class ChangeArray
{
void print ( int[] x )
{
 for ( int j=0; j < x.length; j++ )
   System.out.print( x[j] + " " );
 System.out.println( );
}

//Make all the elements zero.
void zeroAll ( int[] ar )
{
 for ( int j=0; j < ar.length; j++ )
   ar[j] = 0;
}

void zeroElt ( int[] x, int elt )             // 6.
{
 if ( elt < x.length )                       // 7.
   x[ elt ] = 0;                             // 8.
}
}

class ChangeTest
{
public static void main ( String[] args )     // 1.
{
 ChangeArray cng = new ChangeArray();        // 2.
 
 int[] value = {27, 19, 34, 5, 12} ;         // 3.
 
 System.out.println( "Before:" );            // 4.
 cng.print( value );
 
 cng.zeroElt( value, 0 );                    // 5.
 System.out.println( "After:" );             // 9.
 cng.print( value );
}
}

/* answers to questions:
 * 2: Yes
 * 3: Yes, it can use this reference to change the values in the array.
 * 4: The 12 in the array would turn into a 0.
 * 6: no.
 * 
*/
