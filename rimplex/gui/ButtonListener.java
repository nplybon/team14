package gui;

import java.awt.Desktop;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import util.Calculate;
import util.Expression;
import util.InvalidExpressionException;
import util.Operator;
import util.OutputFormat;
import util.OverflowException;

public class ButtonListener implements ActionListener, WindowListener, KeyListener
{

  private static ButtonListener listener;

  // private Operator op;
  private ArrayList<String> history = new ArrayList<String>();
  private ArrayList<Operator> operator = new ArrayList<Operator>();
  private int exponent;
  private Expression exp1;
  private Expression exp2;
  private String display;
  private ArrayList<Expression> expression = new ArrayList<Expression>();
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
//	  if ( e.getSource() instanceof AbstractButton ) {
//		  System.out.println( "Inside if " );
    AbstractButton button = (AbstractButton) e.getSource();
    CalcPanel calc = CalcPanel.getInstance();
    TextAreaTester field = TextAreaTester.getInstance();
    String display = calc.getDisplay();

    switch (button.getText())
    {
      case "+":
  		if ( calc.isCloseParEnabled() ) {

  			calc.addToDisplay("+");
  			calc.enableEquals();
  	        calc.toggleAllNumsDI(true);
  	        calc.enableAllNums();
  	        calc.toggleImag(true);
  	        calc.handleExponent( false );

		} else {

			calc.addToDisplay("+");
			int exponent = setExponent( '+' );
			runOperator( Operator.ADDITION, exponent );
		}
       
        break;
      case "-":
    		if ( calc.isCloseParEnabled() ) {

      			calc.addToDisplay("-");
      			calc.enableEquals();
      	        calc.toggleAllNumsDI(true);
      	        calc.enableAllNums();
      	        calc.toggleImag(true);
      	        calc.handleExponent( false );

    		} else {

    			calc.addToDisplay("-");
    			int exponent = setExponent( '-' );
    			runOperator( Operator.SUBTRACTION, exponent );
    		}
        break;
      case "\u00F7":
        calc.enableEquals();
        calc.addToDisplay("/");
        int exponent = setExponent( '/' );
		runOperator( Operator.DIVISION, exponent );
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "x":
        calc.enableEquals();
        calc.addToDisplay("x");
        int exponent2 = setExponent( 'x' );
		runOperator( Operator.MULTIPLICATION, exponent2 );
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "R":
        calc.enableEquals();
        calc.resetDisplay();
        calc.addToDisplay( "\n" );
        calc.toggleAllNumsDI(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "C":
        if (display.contains("+")) {
          if (display.lastIndexOf("+") == display.length()) {
            calc.subDisplay(display.length() - 1);

          }
          calc.subDisplay(display.lastIndexOf("+"));
        } else {

          calc.resetDisplay();
        }
        // create test case to check if operand has been entered already. (erase to that operand,
        // the operand, or all of the expression).
        break;
      case "1":
        calc.enableEquals();
        calc.addToDisplay("1");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "2":
        calc.enableEquals();
        calc.addToDisplay("2");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "3":
        calc.enableEquals();
        calc.addToDisplay("3");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "4":
        calc.enableEquals();
        calc.addToDisplay("4");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "5":
        calc.enableEquals();
        calc.addToDisplay("5");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "6":
        calc.enableEquals();
        calc.addToDisplay("6");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "7":
        calc.enableEquals();
        calc.addToDisplay("7");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "8":
        calc.enableEquals();
        calc.addToDisplay("8");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "9":
        calc.enableEquals();
        calc.addToDisplay("9");
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case "0":
        calc.enableEquals();
        calc.addToDisplay("0");
        calc.handleExponent(true);
        calc.toggleOperators(true);
        break;
      case "i":

        calc.enableEquals();
        calc.addToDisplay("i");

        calc.disableAllNumsI();
        calc.handleExponent(true);
        break;
      case "(":
        calc.addToDisplay("(");
        calc.changeParenC(1);
        calc.toggleOperatorsI(false);
        // calc.toggleCParen();
        calc.handleExponent(false);
        break;
      case ")":
        calc.enableEquals();
        calc.addToDisplay(")");
        calc.changeParenC(-1);
        // calc.toggleCParen();
        calc.handleExponent(true);
        break;
      case ".":
        calc.enableEquals();
        calc.addToDisplay(".");
        calc.toggleDecimal(false);
        calc.handleExponent(true);
        break;
      case "=":
        calc.addToDisplay("=");
        runEquals();
        calc.handleExponent(false);
        break;
      case "\u2190":
        char last = display.charAt(display.length() - 1);

//        if (last == 'i') {
//          calc.toggleAllNums(true);
//          calc.toggleImag(true);
//        }
        calc.subDisplay(display.length() - 1);
        break;
      case "inv":
        calc.addToDisplay("inv(");
        calc.changeParenC(1);
        break;
      case "log":
        calc.addToDisplay("log(");
        calc.changeParenC(1);
        break;
      case "imag":
    	calc.addToDisplay("imag(");
        calc.changeParenC(1);  
    	break;
      case "+/-":
        if (display.isEmpty()) {
          break;
        } else {
          calc.changeSign();
        }
        break;
      case "steps":
    	  
    	  StepsFrame steps = StepsFrame.getInstance();
    	  if ( steps.isVisible() ) {
    		  
    		  steps.handleSteps( false );
    	  } else {
    		  
    		  steps.handleSteps( true );
    	  }
    	  break;
      case ">":
        HistoryFrame.getInstance().handleHistory(true);
        button.setText( "<" );
//        calc.handleCloseHistory(true);
//        calc.handleOpenHistory(false);
        // String str = null;
        // for ( int i = 0; i < history.size(); i++ ) {
        //
        // str += "\n" + history.get( i );
        // }
        // JOptionPane.showMessageDialog( null, str );
        break;
      case "<":
        HistoryFrame.getInstance().handleHistory(false);
        button.setText( ">" );
//        calc.handleCloseHistory(false);
 //       calc.handleOpenHistory(true);
        break;
      case "sqr":
          calc.addToDisplay("sqr(");
          calc.changeParenC(1);
        break;
      case "conj":
    	  calc.addToDisplay( "conj(" );
    	  calc.changeParenC(1);
    	  break;
      case "^":
        calc.addToDisplay("^");
        calc.handleExponent(false);
        calc.enableAllNums();
        calc.disableIButton();
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
        break;
      case "Print":
        try
        {          
          PrinterController.print(new DelegatingPrintable(HistoryFrame.getDisplay()),
              HistoryFrame.parent());
        }
        catch (NullPointerException e1)
        {
          JOptionPane j = new JOptionPane("ERROR: Nothing to print!");
          JOptionPane.showMessageDialog(j, j.getMessage());

        }
        break;    
      case "real":
    	 // calc.enableEquals();
          calc.addToDisplay("real(");
          calc.changeParenC(1);
          break;
      case "Help":
    	  try {

			  String url = "http://www.google.com"; 
	            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
//		        Desktop.getDesktop().browse(new URI("http://www.codejava.net"));
			  //Desktop.browse("http://www.google.de/");
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
          break;
      case "About":
    	
    	  String message = "Rimplex is a complex number calculator. This is \n"
    	  		+ "a CS345 final project designed by John Curley, Hunter Mann,\n"
    	  		+ "Nic Plybon, Colton Shovlin and Alexander Walker (team14).\n"
    	  		+ "This is the 3rd edition of Rimplex.";
      	JOptionPane.showMessageDialog( null, message, "About Rimplex", 
  				JOptionPane.PLAIN_MESSAGE );
    	  break;
    }
//	  } else if ( e.getSource() instanceof JMenu ) {
//		  
//		  JMenu menu = (JMenu) e.getSource();
//		  
//		  switch ( menu.getText() ) {
//		  case "about":
//			  try {
//			       System.out.println( "in try" );  
//				  String url = "http://www.google.com"; 
//		            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
////			        Desktop.getDesktop().browse(new URI("http://www.codejava.net"));
//				  //Desktop.browse("http://www.google.de/");
//			    } catch (IOException e1) {
//			        e1.printStackTrace();
//			    }
//	           break;
//		  }
//	  }
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
  public void keyTyped(KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyReleased(KeyEvent e) {
  // TODO Auto-generated method stub
	char result = (char) e.getKeyChar();
	CalcPanel panel = CalcPanel.getInstance();
	String str;
	
	switch ( result ) {
	case '+':
		if ( panel.isCloseParEnabled() ) {
			if ( !panel.isPlusEnabled() ) {
				
				errorMessage();
			}
		} else {
			//if ( panel.isPlusEnabled() )
			
			int exponent = setExponent( '+' );
			runOperator( Operator.ADDITION, exponent );
		}
		break;
	case '-':
		if ( panel.isCloseParEnabled() ) {
			if ( !panel.isPlusEnabled() ) {
				
				errorMessage();
			}
		} else {
		//if ( panel.isPlusEnabled() )
			
			int exponent = setExponent( '-' );
			runOperator( Operator.SUBTRACTION, exponent );
	    }
		break;
	case '/':
		if ( !panel.isDivEnabled() ) {
			
			errorMessage();
		} else {
			
			int exponent = setExponent( '/' );
			runOperator( Operator.DIVISION, exponent );
		}
		break;
	case 'x':
		if ( !panel.isDivEnabled() ) {
			
			errorMessage();
		} else {
			
			int exponent = setExponent( 'x' );
			runOperator( Operator.MULTIPLICATION, exponent );
		}
		break;
	case '\n':
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
		} else {
			
			panel.enableEquals();
			panel.toggleImag( true );
			panel.handleExponent( true );
		}
		break;
	case 'i':
		if ( !panel.isIEnabled() ) {
			
			errorMessage();
		} else {
		    
			panel.enableEquals();
			panel.disableAllNumsI();
			panel.handleExponent( true );
		}
		break;
	case '\u0008':
	case '\u007F':
		break;
	case ' ':
		break;
	case '=':
		if ( panel.isEqualsEnabled() ) {
			System.out.println( "IN EQUALS" );
			runEquals();
		} else {
			
			errorMessage();
		}
		break;
	case '(':
		if ( !panel.isOpenParEnabled() ) {
			
			errorMessage();
		} else {
			
	        panel.changeParenC(1);
	        panel.handleExponent( false );

		}
		break;
	case ')':
		if ( !panel.isCloseParEnabled() ) {
			
			errorMessage();
		} else {
			
			panel.enableEquals();
	        panel.changeParenC(-1);
	        panel.handleExponent( true );

		}
		break;
	case '^':
		if ( !panel.isExponentEnabled() ) {
			 
			errorMessage();
		} else {
			//currently have to assume user enters another number after hitting equals
			panel.enableEquals();
	    	panel.enableAllNums();
	    	panel.disableIButton();
			panel.handleExponent( false );
		}
		break;
	case '.':
		if ( !panel.isDecimalEnabled() ) {
			
			errorMessage();
		} else {
			
			panel.enableEquals();
	        panel.toggleDecimal(false);
	        panel.handleExponent( true );

		}
		break;
    default:	
    	if ( e.getKeyCode() != KeyEvent.VK_SHIFT ) {
    		
    		errorMessage();
    	}
    	break;
    }
  }

private int setExponent( char operator ) {
	CalcPanel panel = CalcPanel.getInstance();
	String str = panel.getDisplay().substring( panel.getDisplay().indexOf( '\n' ) );
	int exponent = 1;
	
	if ( str.indexOf( '^' ) != -1 ) {
	
		String sub = str.substring( str.indexOf( '^' ) + 1, str.indexOf( operator ) );
	    exponent = Integer.parseInt( sub );
	    
	}
	return exponent;
}


  private void runEquals() {
	
	CalcPanel panel = CalcPanel.getInstance();
	String str = panel.getDisplay();
	int newLine = str.indexOf( '\n' );
	str = str.substring( newLine ).strip();

	if ( !TextAreaTester.getInstance().verifyTarget( str ) ) {

		errorMessage();
	} else {
		try {
			int exponent = 1;
			
			if ( str.indexOf( '^' ) != -1 ) {
			
				String sub = str.substring( str.indexOf( '^' ) + 1, str.indexOf( '=' ) );
			    exponent = Integer.parseInt( sub );
			    
			}  
			this.expression.add( setExp( str, exponent ) );
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		Operator[] operators = new Operator[ operator.size() ];
	    operators = operator.toArray( operators );
	    Expression[] expression = new Expression[ this.expression.size() ];
	    expression = this.expression.toArray( expression );

	    Calculate calc = new Calculate(expression, operators);
	    Expression answer = null;
	    try
	    {
	    	answer = calc.calculateExpression();
	    }
	    catch (OverflowException | InvalidExpressionException q)
	    {
	    	// TODO Auto-generated catch block
	    	q.printStackTrace();
	    }
        
	    StepsFrame.getInstance().incrementSteps( calc.getSteps() );
	    panel.subDisplay( newLine );
	    panel.addToDisplay( this.expression.get( this.expression.size() - 1 ) 
	    		+ "=" + answer.toString() );
	    history.add(panel.getDisplay());
	    HistoryFrame.getInstance().incrementHistory( "\n" 
	    		+ history.get(history.size() - 1));
	    panel.handleExponent( false );
	    operator.clear();
	    this.expression.clear();
	}

  } 

private void runOperator( Operator op, int exponent ) {
	
	CalcPanel panel = CalcPanel.getInstance();
	String str;
	if ( !panel.isPlusEnabled() ) {
		
		errorMessage();
	} else if ( !panel.isCloseParEnabled() ){
		
		str = panel.getDisplay();
		int newLine = str.indexOf( '\n' );
		String other = str.substring( 0, newLine );
		str = str.substring( newLine ).strip();
		
		boolean bool = false;
		
		try {
			bool = runOperation( op, str, exponent );
	        
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if ( bool ) {
		
			panel.setDisplay( other + expression.get( expression.size() - 1 ).toString() 
				+ operator.get( operator.size() - 1 ).toString() + "\n" );
			panel.enableEquals();
			panel.toggleAllNumsDI(true);
			panel.enableAllNums();
			panel.handleExponent( false );

		} else {
			
			panel.enableAllNums();
		}
	} else {
		
        CalcPanel calc = CalcPanel.getInstance();
        String bad = "Invalid Input";
    	calc.setDisplay( calc.getDisplay().substring( 0, 
    			( calc.getDisplay().indexOf( '\n' ) ) )
    			+ "\n" );
        	JOptionPane.showMessageDialog( null, bad, "Invalid Input", 
    				JOptionPane.PLAIN_MESSAGE );
        calc.enableEquals();
        calc.resetDisplay();
        calc.addToDisplay( "\n" );
        calc.toggleAllNumsDI(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        calc.changeParenC( -1 );
        
	}
}

  private boolean runOperation(Operator operator, String str, int exponent ) 
		  throws NumberFormatException, InvalidExpressionException {
	  
		TextAreaTester text = TextAreaTester.getInstance();
		
		boolean bool = false;
		
	    if (text.verifyTarget(str))
	    {
	    	
	    	bool = true;
	    	Expression exp = setExp( str, exponent );
	    	expression.add( exp );
	    	this.operator.add( operator );
	    	
	    } else {
	    	
	        CalcPanel calc = CalcPanel.getInstance();
	        String bad = "Invalid Input";
	    	calc.setDisplay( calc.getDisplay().substring( 0, 
	    			( calc.getDisplay().indexOf( '\n' ) ) )
	    			+ "\n" );
	        	JOptionPane.showMessageDialog( null, bad, "Invalid Input", 
	    				JOptionPane.PLAIN_MESSAGE );

	    }
	    
	    return bool;
  }
  
  /**
   * Set input field to expression object.
   * 
   * @param str
   *          input
   * @param exp
   *          expression
   * @return parsed expression
   * @throws NumberFormatException
   *           WAP
   * @throws InvalidExpressionException
   *           WAP
   */
  private Expression setExp(String str, int exponent )
      throws NumberFormatException, InvalidExpressionException
  {

	  Expression expression = null;
    int l = str.length();

    if ( str.indexOf( 'm' ) != -1 ) {
    	
       	expression = setFunctionExpression(str);
    	expression.setImaginaryExpression();
    	
    } else if ( str.indexOf( 'e' ) != -1 ) {
    	
        expression = setFunctionExpression(str);
        expression.setRealExpression();
        
    } else if ( str.indexOf( 'j' ) != -1 ) {
    	
    	expression = setFunctionExpression(str);
    	expression.setConjugate();
    	
    } else if ( str.indexOf( 'v' ) != -1 ) {
    	
    	expression = setFunctionExpression(str);
    	expression.setInverse();
    	
    } else if ( str.indexOf( 'o' ) != -1 ) {
    	
    	expression = setFunctionExpression(str);
    	expression.setLog();
    	
    } else if ( str.indexOf( 'q' ) != -1 ) {
    	
    	expression = setFunctionExpression(str);
    	expression.setSqrt();
    	
    } else if ( str.indexOf( '(' ) != -1 ) {
    	
        String sub = str.substring( str.indexOf( '(' ), str.indexOf( ')' ) );
        if (sub.indexOf("+") != -1)
        {
  
          expression = setComplex( str, exponent, l, sub, '+' );
        }
        else if (sub.indexOf("-") != -1)
        {
  
        	expression = setComplex( str, exponent, l, sub, '-' );
        }
    } else if ( str.indexOf( 'i' ) != -1 ) {

      String sub = str.substring(0, str.indexOf( 'i' ) );
      expression = new Expression( Double.parseDouble(sub), exponent );  
    } else {
		if ( str.indexOf( '^' ) != -1 ) {
			
			expression = new Expression(Double.parseDouble(str.substring( 0, str.indexOf( '^' ) )));
		} else {
    	
			expression = new Expression(Double.parseDouble(str.substring( 0, str.length() - 1 )));
		}
		if ( exponent != 1 ) {
    	
			expression.setExpPower( exponent );
		}
    }
    
    return expression;
  }

private Expression setComplex(String str, int exponent, int l, String sub,
		char operator ) throws InvalidExpressionException {
	
	int i;
	Expression expression;
	i = sub.indexOf( operator );
	  String real = str.substring(1, i);
	  String img = str.substring(i + 1, l - 3);
	  expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
	    sub.charAt(i));
	  if ( exponent != 1 ) {
		
	      expression.setExpPower( exponent );
	  }
	return expression;
}

private Expression setFunctionExpression(String str) throws InvalidExpressionException {
	int i;
	Expression expression;
	String sub = str.substring( str.indexOf( '(' ), str.indexOf( ')' ) );
	int l = sub.length();
	
	if (sub.indexOf("+") != -1)
	{
  
	  i = sub.indexOf('+');
	  String real = sub.substring(1, i);
	  String img = sub.substring(i + 1, l - 1);
	  expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
	    sub.charAt(i));
	}
	else if (sub.indexOf("-") != -1)
	{
  
	  i = sub.indexOf('-');
	  String real = sub.substring(1, i);
	  String img = sub.substring(i + 1, l - 1 );
	  expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
	    sub.charAt(i));
	  
	}
	else if ( sub.indexOf( 'i' ) != -1 ) {
		
	    sub = sub.substring(0, sub.indexOf( 'i' ) );
	    
	    expression = new Expression( Double.parseDouble(sub), 1 );
	    
	}
	else {
		
		expression = new Expression(Double.parseDouble(sub.substring( 0, sub.length() - 1 )));
	}
	return expression;
}

  private void errorMessage()
  {

    CalcPanel calc = CalcPanel.getInstance();
    String bad = "Invalid Input";

	calc.subDisplay( ( calc.getDisplay().length() - 1 ) );
    	JOptionPane.showMessageDialog( null, bad, "Invalid Input", 
				JOptionPane.PLAIN_MESSAGE );
  }	
}
