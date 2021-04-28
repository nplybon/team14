package gui;

/**
 * Handles testing of user input. 
 * 
 * @author coltonshovlin
 * @version rimplex sprint 3
 */
public class TextAreaTester 
{

  private static TextAreaTester listener;
	
  /**
   * singleton constructor.
   */
  private TextAreaTester() 
  {
		
  }
	
	/**
	 * Get Instance method.
	 * 
	 * @return singleton
	 */
  public static TextAreaTester getInstance() 
  {
    if ( listener == null ) 
    {
      listener = new TextAreaTester();
    }

    return listener;
  }

	/**
	 * very input isn't null.
	 * 
	 * @param string user input
	 * 
	 * @return bool true if not null
	 */
  public boolean verifyTarget( final String string) 
  {
		// TODO Auto-generated method stub
    boolean bool = true;
    String str = string;
	
    if ( notNull( str ) ) 
    {
      str.strip();
      if ( notEmpty( str )) 
      {
		    	
        if ( isMinus( str, 0 ) ) 
        {
				
          String sub = str.substring( 1 );
          bool = testInput( sub );
				
        } else 
        {

          bool = testInput( str );
        } 
      } else 
      {
		    	
        bool = false;
      }
    } else 
    {
			
      bool = false;
    }
		
    return bool;
  }

	/**
	 * actually verifies user input.
	 * 
	 * @param input user input
	 * @return bool true if valid
	 */
  private boolean testInput( final String input ) 
  {
		
    boolean bool = true;
    boolean isImg = true;
    boolean isReal = true;
		
    String str = input;
		
    int i;
		
    if ( str.indexOf( '(' ) != -1 ) 
    {
			
      str = str.substring( str.indexOf( '(' ) + 1, str.indexOf( ')' ) );
      int l = str.length();

      if ( str.indexOf( '+' ) != -1 
				&& str.indexOf( '+' ) + 1 < str.length() - 1 ) 
      {
				
        i = str.indexOf( '+' );
        String real = str.substring( 0, i );
        String img = str.substring( i + 1, l );

        isReal = isReal( real );
        isImg = isImag( img );
				
      } else if ( str.indexOf( '-' ) != -1 
				&&  ( str.indexOf( '-' ) + 1 ) < ( str.length() - 1 ) ) 
      {
				
        i = str.indexOf( '-' );
        String real = str.substring( 0, i );
        String img = str.substring( i + 1, l );
        isReal = isReal( real );
        isImg = isImag( img );
				
      } else 
      {
				
        bool = false;
      }
    } else if ( str.indexOf( 'i' ) != -1 ) 
    {
		
      bool = isImag( str );
      isImg = bool;
    } else 
    {
      if ( str.indexOf( '^' ) != -1 ) 
      {
				
        bool = isReal( str.substring( 0, str.indexOf( '^' ) ) );
      } else 
      {
			
        bool = isReal( str.substring( 0, str.length() - 1 ) );
      }
			
      isReal = bool;
    }
    if ( !isReal && !isImg ) 
    {
			
      bool = false;
    }
    return bool;
  }

	/**
	 * tests to see if valid imaginary method.
	 * 
	 * @param input user input
	 * @return true if valid input
	 */
  private boolean isImag( final String input ) 
  {
		
    boolean bool;
    String str = input;
		//changed if
    if ( str != null && !str.isEmpty()
			&& str.indexOf( 'i' ) != -1 ) 
    {
		//changed sub
      String sub = str.substring( 0, str.indexOf( 'i' ) );
			
      bool = isReal( sub );
			
    } else 
    {
			
      bool = false;
    }

    return bool;
  }

	/**
	 * tests real input.
	 * 
	 * @param input user input
	 * @return bool true if valid
	 */
  private boolean isReal( final String input ) 
  {
		
    boolean bool;
		//changed instantiation
    String str = input;
		
    try 
    {
      Double.parseDouble( str );
      bool = true;
    } catch ( NumberFormatException e ) 
    {
      bool = false;
    }
        		
    return bool;
  }
	
	/**
	 * tests to see if input isn't null.
	 * 
	 * @param str user input
	 * @return true if not null
	 */
  private boolean notNull( final String str ) 
  {

    return str != null;
  }
	
  private boolean notEmpty( final String str ) 
  {
        		
    return str.length() > 0;
  }
	
	/**
	 * tests to see if input is minus.
	 * 
	 * @param str user input
	 * @param i index of minus button
	 * @return true if minus
	 */
  private boolean isMinus( final String str, final int i ) 
  {
		
    return str.charAt( i ) == '-';
  }
}
