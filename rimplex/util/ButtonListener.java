package util;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * Handles button events.
 * 
 * @author Colton Shovlin
 * @version sprint1 CS345
 */
public class ButtonListener implements ActionListener, WindowListener {

	private static ButtonListener listener;
	
	private ArrayList<Operator> ops = new ArrayList<Operator>();
	
	private Expression answer;
	private Expression exp1;
	private Expression exp2;
	
	/**
	 * Singleton constructor.
	 */
	private ButtonListener() {
	
	}
	
	/**
	 * handles button events.
	 * 
	 * @param e JButton
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
			if ( calc.getDisplay().indexOf( '=' ) != -1 ) {
				calc.setDisplay( "" );
				String[] options = new String[] { "+", "-", "x", "÷" };
				int response;
				exp1 = answer;
				do {
					response = JOptionPane.showOptionDialog( null, 
							"Please select a new operator", "Answer Button", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
							null, options, options[ 0 ] );
					} while ( response == -1 );
					
//					ops.remove( ops.get( ops.size() - 1 ) );
					updateOps(response);
			} else {
				exp2 = answer;
				try {
					runEquals();
				} catch (OverflowException | InvalidExpressionException e1) {
					// TODO Auto-generated catch block
					System.out.println( "Equals Exception" );
				}
			}
			break;
		case "C":
			runCancelButton();
//			calc.enableEquals();
//			calc.disableOperators();
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
				
				try {
					trySetExpression2( str );
					runEquals();
				} catch (OverflowException | InvalidExpressionException e1) {
					// TODO Auto-generated catch block
					System.out.println( "Equals Exception" );
				}
			} else {
				
				errorMessage();
			}
			calc.setInput( "" );
			break;
		default:
			break;
		}
	}

	/**
	 * clear operator list, add new operator, and update panel.
	 * 
	 * @param response new operator 
	 */
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

	/**
	 * transfer input text to display and clear input.
	 * 
	 * @param operator +, -, x, or /
	 * @param str input text
	 */
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
	
	/**
	 * update panel when first expression is added.
	 */
	private void updatePanel() {
		
		CalcPanel calc = CalcPanel.getInstance();
		calc.setDisplay( exp1.toString() + ops.get( ops.size() - 1 ).toString() );
		calc.enableEquals();
		calc.disableOperators();
	}

	/**
	 * evaluate expression.
	 * 
	 * @throws OverflowException WAP
	 * @throws InvalidExpressionException 
	 */
	private void runEquals() throws OverflowException, InvalidExpressionException {
		
		CalcPanel calc = CalcPanel.getInstance();
		ArrayList<Expression> expression = new ArrayList<Expression>();
		expression.add( exp1 );
		expression.add( exp2 );
		
		Expression[] e = new Expression[expression.size()];
		Operator[] o = new Operator[ops.size()];
		
    for (int i = 0; i < expression.size(); i++) {
      e[i] = expression.get(i);
    }
    for (int i = 0; i < ops.size(); i++) {
      o[i] = ops.get(i);
    }
		Calculate calculate = new Calculate(e, o);
		answer = calculate.calculateExpression();
		calc.incrementDisplay( exp2.toString() + "=" + answer );
		ops.clear();
		calc.disableEquals();
//		calc.disableCancel();
		calc.enableOperators();
		calc.enableAnswer();
	}

	/**
	 * display option panel for new operator.
	 */
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
		
        updateOps(response);
	}

	/**
	 * if user enters in wrong format.
	 */
	private void errorMessage() {
		String bad = "Input must be in the form of a+bi, bi, or a";
		JOptionPane.showMessageDialog( null, bad, "Bad Input", JOptionPane.PLAIN_MESSAGE );
	}

	/**
	 * for order of operations in expression.
	 * 
	 * @return list of operators
	 */
	public ArrayList<Operator> getOps() {
		
		return ops;
	}
	
	/**
	 * attempt to parse input field
	 * 
	 * @param str input
	 */
	private void trySetExpression1(String str) {
		try {
			exp1 = setExp( str, exp1 );
		} catch (NumberFormatException | InvalidExpressionException e1 ) {
			// TODO Auto-generated catch block
			System.out.println( "Verification error" );
		}
	}
	
	/**
	 * attempt to parse input field
	 * 
	 * @param str input
	 */
	private void trySetExpression2(String str) {
		try {
			exp2 = setExp( str, exp2 );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			System.out.println( "Verification error" );
		}
	}

	/**
	 * Set input field to expression object.
	 * 
	 * @param str input
	 * @param exp expression
	 * @return parsed expression
	 * @throws NumberFormatException WAP
	 * @throws InvalidExpressionException WAP
	 */
	private Expression setExp( String str, Expression exp ) throws NumberFormatException, 
	InvalidExpressionException {
		
        int l = str.length();
		int i;
		Expression expression = exp;
		
		if ( str.indexOf( "+" ) != -1 ) {
			
			i = str.indexOf( '+' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l - 1 );
			expression = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
					1, str.charAt( i ) );
			
		} else if ( str.indexOf( "-" ) != -1 ) {
			
			i = str.indexOf( '-' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l - 1 );
			expression = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
					1, str.charAt( i ) );
			
		} else if ( str.charAt( str.length() - 1 ) == 'i' ) {
			
			String sub = str.substring( 0, str.length() - 1 );
			expression = new Expression( 0.0, Double.parseDouble( sub ), 1, '+' );
			
		} else {
			
			expression = new Expression( Double.parseDouble( str ), 0.0, 1, '+' );
		}
		
		return expression;
	}

	/**
	 * For Expression class.
	 */
	public Expression getExpression1() {
		
		return exp1;
	}
	
	/**
	 * For Expression class.
	 */
	public Expression getExpression2() {
		
		return exp2;
	}
	
	/**
	 * Singleton method.
	 * 
	 * @return instance of ButtonListener
	 */
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
}
