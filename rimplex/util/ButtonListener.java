package util;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonListener implements ActionListener, WindowListener {

	private static ButtonListener listener;
	private ArrayList<Operator> ops = new ArrayList<Operator>();
	private Expression exp1;
	private Expression exp2;
	
	private ButtonListener() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		CalcPanel calc = CalcPanel.getInstance();
		String str = calc.getInput();
		
		switch ( button.getText() ) {
		case "+":
            
			if ( TextFieldListener.getInstance().verifyTarget( str ) ) {
		    
//				calc.setDisplay( calc.getInput() + "+" );
//				calc.setInput( "" );
				try {
					setExp1( str );
				} catch (NumberFormatException | InvalidExpressionException e1) {
					// TODO Auto-generated catch block
					System.out.println( "Verification error" );
				}
				
				ops.add( Operator.ADDITION );
				calc.setDisplay( exp1.toString() + ops.get( 0 ).toString() );
			} else {
				System.out.println( "Problem in buttons" );
			}
			calc.setInput( "" );
			break;
		case "-":
			
			if ( TextFieldListener.getInstance().verifyTarget( str ) ) {

				try {
					setExp1( str );
				} catch (NumberFormatException | InvalidExpressionException e1) {
					// TODO Auto-generated catch block
					System.out.println( "Verification error" );
				}				
				ops.add( Operator.SUBTRACTION );
				calc.setDisplay( exp1.toString() + ops.get( 0 ).toString() );
			} else {
				System.out.println( "Problem in buttons" );
			}
			calc.setInput( "" );
			break;
		case "x":
			
			if ( TextFieldListener.getInstance().verifyTarget( str ) ) {

				try {
					setExp1( str );
				} catch (NumberFormatException | InvalidExpressionException e1) {
					// TODO Auto-generated catch block
					System.out.println( "Verification error" );
				}				
				ops.add( Operator.MULTIPLICATION );
				calc.setDisplay( exp1.toString() + ops.get( 0 ).toString() );
			} else {
				System.out.println( "Problem in buttons" );
			}
			calc.setInput( "" );
			break;
		case "÷":
			
			if ( TextFieldListener.getInstance().verifyTarget( str ) ) {

				try {
					setExp1( str );
				} catch (NumberFormatException | InvalidExpressionException e1) {
					// TODO Auto-generated catch block
					System.out.println( "Verification error" );
				}				
				ops.add( Operator.DIVISION );
				calc.setDisplay( exp1.toString() + ops.get( 0 ).toString() );
			} else {
				System.out.println( "Problem in buttons" );
			}
			calc.setInput( "" );
			break;
		case "ans":
			break;
		case "C":
			break;
		case "R":
			CalcPanel cal = CalcPanel.getInstance();
			cal.setDisplay( "" );
			
			break;
		case "=":
			break;
		default:
			break;
		}
	}

	private void setExp1( String str ) throws NumberFormatException, InvalidExpressionException {
		
        int l = str.length();
		int i;
		
		if ( str.indexOf( "+" ) != -1 ) {
			
			i = str.indexOf( '+' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l - 1 );
			exp1 = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
					1, str.charAt( i ) );
			
		} else if ( str.indexOf( "-" ) != -1 ) {
			
			i = str.indexOf( '-' );
			String real = str.substring( 0, i );
			String img = str.substring( i + 1, l - 1 );
			exp1 = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
					1, str.charAt( i ) );
			
		} else if ( str.charAt( str.length() - 1 ) == 'i' ) {
			
			String sub = str.substring( 0, str.length() - 1 );
			exp1 = new Expression( 0.0, Double.parseDouble( sub ), 1, '+' );
			
		} else {
			
			exp1 = new Expression( Double.parseDouble( str ), 0.0, 1, '+' );
		}
	}

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
