package util;

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
//				System.out.println( "in not minus" );
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
		int l = str.length();
		
		if ( str.indexOf( '+' ) != -1 ) {
//            System.out.println( "In plus index of" );
			i = str.indexOf( '+' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l );
//			System.out.println( "real:" + real + "Img:" + img );
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

	private boolean isImag( String input ) {
		
		boolean bool;
		String str = input;
		
		if ( str.charAt( str.length() - 1 ) == 'i' ) {
			
			String sub = str.substring( 0, str.length() - 1 );
//			System.out.println( "In isIMaG if :" + sub );
			bool = isReal( sub );
			
		} else {
			
			bool = false;
		}
//		System.out.println( "isImag:" + bool );
		return bool;
	}

	private boolean isReal( String input ) {
		
		boolean bool;
		
		String str = input;
		
		try {
//			System.out.println( "In real try:" + str );
			Double.parseDouble( str );
		    bool = true;
		} catch ( NumberFormatException e ) {
//			System.out.println( "In real catch" );
			bool = false;
		}
//		System.out.println( "Is real:" + bool );
		return bool;
	}
	
	private boolean notNull( String str ) {
		
		return str != null && str.length() > 0;
	}
	
//	private boolean isNumOri( String str, int i ) {
//		
//		
//		return str.charAt( i ) == '1';
//	}
	
	private boolean isMinus( String str, int i ) {
		
		return str.charAt( i ) == '-';
	}
	
//	private boolean isNum( String str, int i ) {
//		
//		return str.charAt( i ) == '1' ||  str.charAt( i ) == '2'
//				|| str.charAt( i ) == '3' || str.charAt( i ) == '4'
//				|| str.charAt( i ) == '5' || str.charAt( i ) == '6'
//				|| str.charAt( i ) == '7' || str.charAt( i ) == '8'
//				|| str.charAt( i ) == '9' || str.charAt( i ) == '0';
//	}
	//add get expressions method
}
