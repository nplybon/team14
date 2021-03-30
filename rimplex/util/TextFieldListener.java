package util;

import java.awt.event.FocusEvent;

import java.awt.event.FocusListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
/**
 * Handles and tests text Fields.
 * 
 * @author Colton Shovlin
 * @version Sprint1 CS 345
 */
public class TextFieldListener implements FocusListener {

	private static TextFieldListener listener;
	
	private TextFieldListener() {
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Verify that user input is valid.
	 * 
	 * @param string user input
	 * @return true if valid
	 */
	public boolean verifyTarget(String string) {
		// TODO Auto-generated method stub
		boolean bool = true;
		String str = string.strip();
	
		if ( notNull( str ) ) {
			if ( isMinus( str, 0 ) ) {
				
				String sub = str.substring( 1 );
				bool = testInput( sub );
				
			} else {

				bool = testInput( str );
			} 
		} else {
			
			bool = false;
		}
		
		return bool;
	}

	/**
	 * is user input a valid imaginary number.
	 * 
	 * @param input user
	 * @return true if valid
	 */
	private boolean isImag( String input ) {
		
		boolean bool;
		String str = input;
		
		if ( str.charAt( str.length() - 1 ) == 'i' ) {
			
			String sub = str.substring( 0, str.length() - 1 );
	
			bool = isReal( sub );
			
		} else {
			
			bool = false;
		}
	
		return bool;
	}

	/**
	 * Is this character a minus sign?
	 * 
	 * @param str user input
	 * @param i character of question
	 * @return true if is minus
	 */
	private boolean isMinus( String str, int i ) {
		
		return str.charAt( i ) == '-';
	}

	/**
	 * is user input a valid real number.
	 * 
	 * @param input user 
	 * @return true if valid
	 */
	private boolean isReal( String input ) {
		
		boolean bool;
		
		String str = input;
		
		try {
	
			Double.parseDouble( str );
		    bool = true;
		} catch ( NumberFormatException e ) {
	
			bool = false;
		}
		
		return bool;
	}

	/**
	 * is user entry null or empty?
	 * 
	 * @param str user input
	 * @return true if NOT null and NOT empty
	 */
	private boolean notNull( String str ) {
		
		return str != null && str.length() > 0;
	}

	/**
	 * parse user input into imaginary and real parts.
	 * 
	 * @param input user input
	 * @return true if user input is valid
	 */
	private boolean testInput( String input ) {
		
		boolean bool = true;
		boolean isImg = true;
		boolean isReal = true;
		
		String str = input;
		
		int i;
		int l = str.length();
		
		if ( str.indexOf( '+' ) != -1 ) {

			i = str.indexOf( '+' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l );

			isReal = isReal( real );
			isImg = isImag( img );
			
		} else if ( str.indexOf( '-' ) != -1 ) {
			
			i = str.indexOf( '-' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l );
			isReal = isReal( real );
			isImg = isImag( img );
			
		} else if ( str.charAt( str.length() - 1 ) == 'i' ) {
			
			bool = isImag( str );
			isImg = bool;
		} else {
			bool = isReal( str );
			isReal = bool;
		}
		if ( !isReal || !isImg ) {
			
			bool = false;
		}
		return bool;
	}

	/**
	 * Singleton method.
	 * 
	 * @return TextFieldListener
	 */
	public static TextFieldListener getInstance() {
	    if ( listener == null ) {
	        listener = new TextFieldListener();
	    }
	
	    return listener;
	}
	
}
