package gui;

import java.awt.event.FocusEvent;

import java.awt.event.FocusListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;

public class TextFieldListener implements FocusListener {

	private static TextFieldListener listener;
	
	private TextFieldListener() {
		
	}
	
	public static TextFieldListener getInstance() {
        if ( listener == null ) {
            listener = new TextFieldListener();
        }

        return listener;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
//		// TODO Auto-generated method stub
//		JTextField input = (JTextField)e.getSource();
//		String str = input.getText();
////		int i;
//		if ( !verifyTarget( str ) ) {
//           
////			CalcPanel.getInstance().setInput( "" );
//		}
	}

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

	private boolean testInput( String input ) {
		
		boolean bool = true;
		boolean isImg = true;
		boolean isReal = true;
		
		String str = input;
		
		int i;
		
		if ( str.indexOf( '(' ) != -1 ) {
			
			str = str.substring( str.indexOf( '(' ) + 1, str.indexOf( ')' ) );
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
				
			}			
		} else if ( str.indexOf( 'i' ) != -1 ) {
			
			bool = isImag( str );
			isImg = bool;
		} else {
			if ( str.indexOf( '^' ) != -1 ) {
				
				bool = isReal( str.substring( 0, str.indexOf( '^' ) ) );
			} else {
			
				bool = isReal( str.substring( 0, str.length() - 1 ) );
			}
			isReal = bool;
		}
		if ( !isReal && !isImg ) {
			
			bool = false;
		}
		return bool;
	}

	private boolean isImag( String input ) {
		
		boolean bool;
		String str = input;
		//changed if
		if ( str != null && !str.isEmpty()
				&& str.indexOf( 'i' ) != -1 ) {
			//changed sub
			String sub = str.substring( 0, str.indexOf( 'i' ) );
			
			bool = isReal( sub );
			
		} else {
			
			bool = false;
		}

		return bool;
	}

	private boolean isReal( String input ) {
		
		boolean bool;
		//changed instantiation
		String str = input;
		
		try {
			Double.parseDouble( str );
		    bool = true;
		} catch ( NumberFormatException e ) {
			bool = false;
		}
		
		return bool;
	}
	
	private boolean notNull( String str ) {
		
		return str != null && str.length() > 0;
	}
	
	private boolean isMinus( String str, int i ) {
		
		return str.charAt( i ) == '-';
	}
}
