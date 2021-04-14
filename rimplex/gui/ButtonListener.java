package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import util.Expression;
import util.InvalidExpressionException;
import util.Operator;
import util.OutputFormat;

public class ButtonListener implements ActionListener, WindowListener, KeyListener
{

  private static ButtonListener listener;
  
//  private Operator op;
  private int operator;
  /**
   * handles button events.
   * 
   * @param e
   *          JButton
   */
  @Override
  public void actionPerformed(ActionEvent e)
  {
    // TODO Auto-generated method stub
    AbstractButton button = (AbstractButton) e.getSource();
    CalcPanel calc = CalcPanel.getInstance();
    TextFieldListener field = TextFieldListener.getInstance();
    String display = calc.getDisplay();

    switch (button.getText())
    {
      case "+":
        calc.addToDisplay("+");
        calc.enableAllNums();
        break;
      case "-":
        calc.addToDisplay("-");
        calc.enableAllNums();
        break;
      case "/":
        calc.addToDisplay("/");
        calc.enableAllNums();
        break;
      case "x":
        calc.addToDisplay("x");
        calc.enableAllNums();
        break;
      case "R":
        calc.resetDisplay();
        calc.enableAllNums();
        break;
      case "C":
        if (display.contains("+")) {
          if (display.lastIndexOf("+") == display.length()) {
            calc.setDisplay(display.length() - 1);
          }
          calc.setDisplay(calc.getDisplay().lastIndexOf("+"));
        } else {
          calc.resetDisplay();
        }
        calc.enableAllNums();
        // create test case to check if operand has been entered already. (erase to that operand,
        // the operand, or all of the expression).
        break;
      case "1":
        calc.addToDisplay("1");
        break;
      case "2":
        calc.addToDisplay("2");
        break;
      case "3":
        calc.addToDisplay("3");
        break;
      case "4":
        calc.addToDisplay("4");
        break;
      case "5":
        calc.addToDisplay("5");
        break;
      case "6":
        calc.addToDisplay("6");
        break;
      case "7":
        calc.addToDisplay("7");
        break;
      case "8":
        calc.addToDisplay("8");
        break;
      case "9":
        calc.addToDisplay("9");
        break;
      case "0":
        calc.addToDisplay("0");
        break;
      case "i":
        calc.addToDisplay("i");
        calc.disableAllNumsI();
        break;
      case "(":
        calc.addToDisplay("(");
        break;
      case ")":
        calc.addToDisplay(")");
        break;
      case ".":
        calc.addToDisplay(".");
        calc.disableDecimal();
        break;
      case "=":
        
        break;
      case "<-":
        calc.setDisplay(calc.getDisplay().length() - 1);
        break;
      case "inv":
        calc.addToDisplay("^-1");
        break;
      case "log":
        calc.addToDisplay("ln(");
        break;
      case "+/-":

        break;
      case ">":

        break;
      case "sqr":
        break;
        
      case "dec":
        button.setText("frac");       
        calc.resetDisplay();
        calc.addToDisplay(OutputFormat.toDecimal(display));
        break;       
      case "frac":
        button.setText("dec");
        calc.resetDisplay();
        calc.addToDisplay(OutputFormat.toFraction(display));        
    }
  }

  /**
   * Singleton method.
   * 
   * @return instance of ButtonListener
   */
  public static ButtonListener getInstance()
  {
    // TODO Auto-generated method stub
    if (listener == null)
    {
      listener = new ButtonListener();
    }

    return listener;
  }

  @Override
  public void windowOpened(WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosing(WindowEvent e)
  {
    System.exit((0));

  }

  @Override
  public void windowClosed(WindowEvent e)
  {
    System.exit(0);
  }

  @Override
  public void windowIconified(WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified(WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowActivated(WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeactivated(WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyTyped(KeyEvent e) {
  // TODO Auto-generated method stub
  
  }

  @Override
  public void keyPressed(KeyEvent e) {
  // TODO Auto-generated method stub
  
  }

  @Override
  public void keyReleased(KeyEvent e) {
  // TODO Auto-generated method stub
	char result = (char) e.getKeyChar();
	CalcPanel panel = CalcPanel.getInstance();
	
	switch ( result ) {
	case '+':
	case '-':
		if ( !panel.isPlusEnabled() ) {
			
			errorMessage();
		}
		break;
	case '/':
	case 'x':
		if ( !panel.isDivEnabled() ) {
			
			errorMessage();
		}
		break;
	case '1':
	case '2':
	case '3':
	case '4':
	case '5':
	case '6':
	case '7':
	case '8':
	case '9':
	case '0':
		if ( !panel.isNumEnabled() ) {
			
			errorMessage();
		}
		break;
	case 'i':
		if ( !panel.isIEnabled() ) {
			
			errorMessage();
		}
		break;
	case '\u0008':
	case '\u007F':
		break;
	case ' ':
		break;
	case '=':
		if ( panel.isEqualsEnabled() ) {
			
			Expression exp1 = null;
			Expression exp2 = null;
			boolean hasExponent = false;
			int exponent = 1;
			
			String str = panel.getDisplay();
			str = str.substring( 0, str.length() - 1 );
			
			if ( str.indexOf( '(' ) != -1 ) {
				//add null test
				if ( ( str.indexOf( ')' ) + 2 ) < str.length() 
						&& str.charAt( str.indexOf( ')' ) + 1 ) == '^' ) {
					
					hasExponent = true;
					String sub = str.substring( str.indexOf( ')' ) );
					
					if ( sub.indexOf( '(' ) != -1 ) {
						
						sub = sub.substring( sub.indexOf( '^' ) );
                        if ( sub.indexOf( '(' ) != -1 ) {
                        	
                        	sub = sub.substring( 0, sub.indexOf( '(' ) );
                        	exponent = setExpOp( sub );
                        }
					} else {
						
						exponent = setExpOp( sub );
					}
					
					exp1 = parseComplex(str, exponent );
				} else {
				
					exp1 = parseComplex(str, exponent );
				}
				
				str = setStr(hasExponent, exponent, str);
                System.out.println( str );
				if ( str.charAt( 0 ) == '(' ) {
                    
					exponent = setExponent2(str);
					exp2 = parseComplex( str, exponent );

				} else {
					if ( str.indexOf( 'i' ) != -1 ) {
						
						exp2 = setImgExp2(str);
						
					} else {
						
						exp2 = setRealExp2(str);
					}
				}
			} else {

			}
			
			System.out.println( exp1.toString() + " " + exp2.toString() );
			System.out.println( exp1.getExpPower() + " " + exp2.getExpPower() );
		} else {
			
			errorMessage();
		}
		break;
	case '(':
		if ( !panel.isOpenParEnabled() ) {
			
			errorMessage();
		}
		break;
	case ')':
		if ( !panel.isCloseParEnabled() ) {
			
			errorMessage();
		}
		break;
	case '^':
		break;
	case '.':
		if ( !panel.isCloseParEnabled() ) {
			
			errorMessage();
		}
		break;

	default:
//		System.out.println( "other Boobs" );
		if ( e.getKeyCode() != KeyEvent.VK_SHIFT ) {
		
			errorMessage();
		}
    	break;
	}
  }

private Expression setRealExp2(String str) {
	Expression exp2;
	int exponent;
	if ( str.charAt( 0 ) == '+' 
			|| str.charAt( 0 ) == '-'
			|| str.charAt( 0 ) == '/'
			|| str.charAt( 0 ) == 'x') {
		
		str = str.substring( 1 );
		
	} else if ( str.charAt( str.strip().length() - 1 ) == '+' 
			|| str.charAt( str.strip().length() - 1 ) == '-' 
			|| str.charAt( str.strip().length() - 1 ) == 'x' 
			|| str.charAt( str.strip().length() - 1 ) == '/' ) {
		
		str = str.substring( 0, str.strip().length() - 1 );
	}
	if ( str.indexOf( '^' ) != -1 ) {
		
		exponent = setExpOp( str );
		str = str.substring( 0, str.indexOf( '^' ) );
		
	} else {
		
		exponent = 1;
	}
	exp2 = new Expression( Double.parseDouble( str ) );
	exp2.setExpPower( exponent );
	return exp2;
}

private Expression setImgExp2(String str) {
	Expression exp2;
	int exponent;
	if ( ( str.indexOf( 'i' ) + 2 ) < str.length()
			&& str.charAt( str.indexOf( 'i' ) + 1 ) == '^' ) {
		//removed last index
		String sub = str.substring( str.indexOf( 'i' ) + 1 );
		exponent = setExpOp( sub );
		
	} else {
		
		exponent = 1;
	}
	if ( str.charAt( 0 ) == '+' 
			|| str.charAt( 0 ) == '-'
			|| str.charAt( 0 ) == '/'
			|| str.charAt( 0 ) == 'x') {
		
		str = str.substring( 1, str.indexOf( 'i' ) );
		
	} else {
	
		str = str.substring( 0, str.indexOf( 'i' ) );
	}
	
	exp2 = new Expression( Double.parseDouble( str ), exponent );
	exp2.setExpPower( 1 );
	return exp2;
}

private String setStr(boolean hasExponent, int exponent, String str) {
	StringBuilder builder = new StringBuilder( str );
	
	String sub;
	if ( hasExponent ) {
		
		builder.delete( str.indexOf( '(' ), ( str.indexOf( ')' ) 
				+ String.valueOf( exponent ).length() + 3 ) );
		
	} else {
	
		builder.delete( str.indexOf( '(' ), ( str.indexOf( ')' ) + 1 ) );
	}
	
	sub = builder.toString();
	return sub;
}

private int setExponent2(String str) {
	
	int exponent;
	if ( str.indexOf( ')' ) <= str.length() &&
			str.charAt( str.indexOf( ')' ) + 1 ) == '^' ) {
		
		String sub = str.substring( str.indexOf( ')' ) + 1 );
		exponent = setExpOp( sub );
		
	} else {
		
		exponent = 1;
	}
	return exponent;
}

private int setExpOp( String sub ) {

	int exponent = 1;
	if ( sub.indexOf( '+' ) != -1 ) {
		
		operator = sub.indexOf( '+' );
//		op = op.fromSymbol( sub.charAt( operator ) );
		sub = sub.substring( sub.indexOf( '^' ) + 1, operator );
		exponent = Integer.parseInt( sub );
		
	} else if ( sub.indexOf( '-' ) != -1 ) {
		
		operator = sub.indexOf( '-' );
//		op = op.fromSymbol( sub.charAt( operator ) );
		sub = sub.substring( sub.indexOf( '^' ) + 1, operator ); 
		exponent = Integer.parseInt( sub );
		
	} else if ( sub.indexOf( '/' ) != -1 ) {
		
		operator = sub.indexOf( '/' );
//		op = op.fromSymbol( sub.charAt( operator ) );
		sub = sub.substring( sub.indexOf( '^' ) + 1, operator );
		
		exponent = Integer.parseInt( sub );
		
	} else if ( sub.indexOf( 'x' ) != -1 ) {
		
		operator = sub.indexOf( 'x' );
//		op = op.fromSymbol( sub.charAt( operator ) );
		sub = sub.substring( sub.indexOf( '^' ) + 1, operator );
		exponent = Integer.parseInt( sub );
		
	} else {
		
//		operator = sub.indexOf( '=' );
//		op = op.fromSymbol( sub.charAt( operator ) );
		sub = sub.substring( sub.indexOf( '^' ) + 1 );
		exponent = Integer.parseInt( sub );
       
	}
	
	return exponent;
}

  private Expression parseComplex(String str, int exponent) {
	
	int openPar;
	openPar = str.indexOf( '(' );
	String sub = str.substring( openPar + 1, str.indexOf( ')' )  );
	int l = sub.length();
	int i;
	Expression expression = null;
	
	if ( sub.indexOf( '+' ) != -1 ) {
		
	      i = sub.indexOf( '+' );
	      String real = sub.substring( 0, i );
	      String img = sub.substring( i + 1, l - 1 );
	      try {
			expression = new Expression( Double.parseDouble( real ), 
					  Double.parseDouble( img ), 1, sub.charAt( i ) );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	} else if ( sub.indexOf( "-" ) != -1 ) {
	      
	      i = sub.indexOf( '-' );
	      String real = sub.substring( 0, i );
//	      System.out.println( real );
	      String img = sub.substring( i + 1, l - 1 );
//	      System.out.println( str.charAt( i ) );
	      try {
			expression = new Expression( Double.parseDouble( real ), Double.parseDouble( img ),
			      1, sub.charAt( i ) );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    } else if ( sub.charAt( sub.length() - 1 ) == 'i' ) {
	      
	      String last = str.substring( 0, str.length() - 1 );
	      try {
			expression = new Expression( 0.0, Double.parseDouble( last ), 1, '+' );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	    }
	    expression.setExpPower( exponent );
	    
	return expression;

  }
  
  private void errorMessage() {
    
    CalcPanel calc = CalcPanel.getInstance();
    String bad = "Invalid Input";

//<<<<<<< HEAD
		calc.setDisplay( ( calc.getDisplay().length() - 1 ) );
		JOptionPane.showMessageDialog( null, bad, "Invalid Input", 
				JOptionPane.PLAIN_MESSAGE );
	}	
//=======
//    calc.setDisplay( ( calc.getDisplay().length() - 1 ) );
//    JOptionPane.showMessageDialog( null, bad, "Invalid Input", 
//        JOptionPane.PLAIN_MESSAGE );
//  }
//
//>>>>>>> branch 'master' of https://github.com/bernstdh/team14.git
}
