package util;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
/**
 * Handles action and window events.
 * 
 * @author Colton Shovlin
 * @version sprint1 CS345
 */
public class ButtonListener implements ActionListener, WindowListener {

	private static ButtonListener listener;
	private ArrayList<Operator> ops = new ArrayList<Operator>();
	private Expression exp1;
	private Expression exp2;
	
	private ButtonListener() {
	
	}
	
	/**
	 * handles Action events.
	 * 
	 * @param e JButton
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ( e.getSource() instanceof JButton ) {
		
			handleButtonEvents(e);
		} else if ( e.getSource() instanceof JMenuItem ) {
			
			handleMenuItemEvents( e );
		}
	}

	/**
	 * handle about Panel.
	 * 
	 * @param e JMenuItem
	 */
	private void handleMenuItemEvents( ActionEvent e ) {
		
		JMenuItem item = (JMenuItem)e.getSource();
		switch ( item.getText() ) {
		case "Help":
			String bad = "Input must be in the form of a+bi, bi, or a";
			JOptionPane.showMessageDialog( null, bad, "Help", JOptionPane.PLAIN_MESSAGE );
			break;
		default:
			break;
		}
	}
	
	/**
	 * handle button events.
	 * 
	 * @param e JButton
	 */
	private void handleButtonEvents(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		CalcPanel calc = CalcPanel.getInstance();
		String str = calc.getInput();
	    TextFieldListener field = TextFieldListener.getInstance();
	    
		switch ( button.getText() ) {
		case "+":
			runOperation( Operator.ADDITION, str );
			break;
		case "-":
			runOperation( Operator.SUBTRACTION, str );
			break;
		case "x":
			runOperation( Operator.MULTIPLICATION, str );
			break;
		case "÷":
			runOperation( Operator.DIVISION, str );
			break;
		case "ans":
			break;
		case "C":
			runCancelButton();
			break;
		case "R":
			CalcPanel cal = CalcPanel.getInstance();
			cal.setDisplay( "" );
			ops.clear();
			calc.disableEquals();
			calc.enableOperators();
			calc.disableCancel();
			break;
		case "=":
			if ( field.verifyTarget( str ) ) {
				
				runEquals( str );
			} else {
				
				errorMessage();
			}
			calc.setInput( "" );
			break;
		default:
			break;
		}
	}

	private void runOperation( Operator operator, String str ) {
		
		CalcPanel calc = CalcPanel.getInstance();
		TextFieldListener field = TextFieldListener.getInstance();
		
		if ( field.verifyTarget( str ) ) {
			trySetExpression1(str);
			ops.add( operator );
			updatePanel();
		} else {
			errorMessage();
		}
		calc.setInput( "" );
	}
	private void updatePanel() {
		
		CalcPanel calc = CalcPanel.getInstance();
		calc.setDisplay( exp1.toString() + ops.get( ops.size() - 1 ).toString() );
		calc.enableEquals();
		calc.disableOperators();
	}

	private void runEquals( String str ) {
		
		CalcPanel calc = CalcPanel.getInstance();
		trySetExpression2( str );
		Operator[] other = new Operator[] { ops.get( 0 ) };
		Expression[] exps = new Expression[] { exp1, exp2 };
		calc.incrementDisplay( exp2.toString() + "=" );
		ops.clear();
		calc.disableEquals();
//		calc.disableCancel();
		calc.enableOperators();
		calc.enableAnswer();
	}

	private void runCancelButton() {
		
		CalcPanel calc = CalcPanel.getInstance();
		int response;
		String[] options = new String[] { "+", "-", "x", "÷" };
		
		do {
		response = JOptionPane.showOptionDialog( null, 
				"Please select a new operator", "Cancel Button", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[ 0 ] );
		} while ( response == -1 );
		
//		ops.remove( ops.get( ops.size() - 1 ) );
		updateOps(response);
	}

	private void updateOps(int response) {
		ops.clear();
		if ( response == 0 ) {
			
			ops.add( Operator.ADDITION );
		} else if ( response == 1 ) {
			
			ops.add( Operator.SUBTRACTION );
		} else if ( response == 2 ) {
			
			ops.add( Operator.MULTIPLICATION );
		} else if ( response == 3 ) {
			
			ops.add( Operator.DIVISION );
		}
		
		updatePanel();
	}

	private void errorMessage() {
		String bad = "Input must be in the form of a+bi, bi, or a";
		JOptionPane.showMessageDialog( null, bad, "Bad Input", JOptionPane.PLAIN_MESSAGE );
	}

	public ArrayList<Operator> getOps() {
		
		return ops;
	}
	
	private void trySetExpression1(String str) {
		try {
			exp1 = setExp( str, exp1 );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			System.out.println( "Verification error" );
		}
	}
	
	private void trySetExpression2(String str) {
		try {
			exp2 = setExp( str, exp2 );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			System.out.println( "Verification error" );
		}
	}

	private Expression setExp( String str, Expression expression ) throws NumberFormatException, InvalidExpressionException {
		
        int l = str.length();
		int i;
		Expression exp = expression;
		
		if ( str.indexOf( "+" ) != -1 ) {
			
			i = str.indexOf( '+' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l - 1 );
			exp = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
					1, str.charAt( i ) );
			
		} else if ( str.indexOf( "-" ) != -1 ) {
			
			i = str.indexOf( '-' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l - 1 );
			exp = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
					1, str.charAt( i ) );
			
		} else if ( str.charAt( str.length() - 1 ) == 'i' ) {
			
			String sub = str.substring( 0, str.length() - 1 );
			exp = new Expression( 0.0, Double.parseDouble( sub ), 1, '+' );
			
		} else {
			
			exp = new Expression( Double.parseDouble( str ), 0.0, 1, '+' );
		}
		
		return exp;
	}
	
//	private void setExp2( String str ) throws NumberFormatException, InvalidExpressionException {
//		
//        int l = str.length();
//		int i;
//		
//		if ( str.indexOf( "+" ) != -1 ) {
//			
//			i = str.indexOf( '+' );
//			String real = str.substring( 0, i );
//			String img = str.substring( i + 1, l - 1 );
//			exp2 = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
//					1, str.charAt( i ) );
//			
//		} else if ( str.indexOf( "-" ) != -1 ) {
//			
//			i = str.indexOf( '-' );
//			String real = str.substring( 0, i );
//			String img = str.substring( i + 1, l - 1 );
//			exp2 = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
//					1, str.charAt( i ) );
//			
//		} else if ( str.charAt( str.length() - 1 ) == 'i' ) {
//			
//			String sub = str.substring( 0, str.length() - 1 );
//			exp2 = new Expression( 0.0, Double.parseDouble( sub ), 1, '+' );
//			
//		} else {
//			
//			exp2 = new Expression( Double.parseDouble( str ), 0.0, 1, '+' );
//		}
//	}

	public Expression getExpression1() {
		
		return exp1;
	}
	
	public Expression getExpression2() {
		
		return exp2;
	}
	
	public static ButtonListener getInstance() {
		// TODO Auto-generated method stub
        if ( listener == null ) {
            listener = new ButtonListener();
        }

        return listener;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

//    private void setExpression1( ) {
//    	
//    }
}
