class PhoneEntry
{
  String name;    // name of a person
  String phone;   // their phone number

  PhoneEntry( String n, String p )
  {
    name = n; phone = p;
  }
}

class PhoneBook
{
  PhoneEntry[] phoneBook; 

  PhoneBook()    // constructor
  {
    phoneBook = new PhoneEntry[ 5 ] ;

    phoneBook[0] = new PhoneEntry( "James Barclay", "(418) 665-1223" );
    phoneBook[1] = new PhoneEntry( "Grace Dunbar", "(860) 399-3044" );
    phoneBook[2] = new PhoneEntry( "Paul Kratides", "(815) 439-9271" );
    phoneBook[3] = new PhoneEntry( "Violet Smith", "(312) 223-1937" );
    phoneBook[4] = new PhoneEntry( "John Wood", "(913) 883-2874" );

  }

  // Use linear search to find the targetName.
  // Return a reference to the matching PhoneEntry or null
  // if none is found.
  //
  PhoneEntry search( String targetName )  
  {
    for (int j=0; j<phoneBook.length; j++)
    {
      if ( phoneBook[ j ].
        name.equals( targetName))
            return phoneBook[ j ];
    }
    return null;
  }
}

// Test the PhoneBook object by searching for one person.
//
class PhoneBookTester
{
  public static void main ( String[] args )
  {
    PhoneBook pb = new PhoneBook();  
  
    // search for "Violet Smith"
    PhoneEntry entry = pb.search( "Violet Smith" ); 

    // if found, print out the entry
    if ( entry != null ) {
      System.out.println( entry.name + ": " + entry.phone );
    }
    else {
      System.out.println("Name not found" );
    }
  }
}

/*
 * Answers to questions:
 * 3: Null
 * 5: Yes
 * 7: Yes
 */