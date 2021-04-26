package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
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
    AbstractButton button = (AbstractButton) e.getSource();
    CalcPanel calc = CalcPanel.getInstance();
    TextFieldListener field = TextFieldListener.getInstance();
    String display = calc.getDisplay();

    switch (button.getText())
    {
      case "+":
        calc.enableEquals();
        calc.addToDisplay("+");
        calc.toggleAllNumsDI(true);
        calc.enableAllNums();
        calc.toggleImag(true);
        calc.handleExponent( false );
        break;
      case "-":
        calc.enableEquals();
        calc.addToDisplay("-");
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "\u00F7":
        calc.enableEquals();
        calc.addToDisplay("/");
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "x":
        calc.enableEquals();
        calc.addToDisplay("x");
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "R":
        calc.enableEquals();
        calc.resetDisplay();
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
        calc.addToDisplay("^-1");
        break;
      case "log":
        calc.addToDisplay("ln(");
        calc.changeParenC(1);
        break;
      case "+/-":
        if (display.isEmpty()) {
          break;
        } else {
          calc.changeSign();
        }
        break;
      case ">":
        HistoryFrame.getInstance().handleHistory(true);
        calc.handleCloseHistory(true);
        calc.handleOpenHistory(false);
        // String str = null;
        // for ( int i = 0; i < history.size(); i++ ) {
        //
        // str += "\n" + history.get( i );
        // }
        // JOptionPane.showMessageDialog( null, str );
        break;
      case "<":
        HistoryFrame.getInstance().handleHistory(false);
        calc.handleCloseHistory(false);
        calc.handleOpenHistory(true);
      case "sqr":
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
        
      case "real":
    	  // calc.enableEquals();
          calc.addToDisplay("real(");
          calc.changeParenC(1);
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
			if ( panel.isPlusEnabled() ) {
				
				errorMessage();
			}
		} else {
			//if ( panel.isPlusEnabled() )
			str = panel.getDisplay().substring( panel.getDisplay().indexOf( '\n' ) );
			int exponent = 1;
			
			if ( str.indexOf( '^' ) != -1 ) {
			
				String sub = str.substring( str.indexOf( '^' ) + 1, str.indexOf( '+' ) );
			    exponent = Integer.parseInt( sub );
			    
			}
			
			runOperator( Operator.ADDITION, exponent );
		}
		break;
	case '-':
		if ( panel.isCloseParEnabled() ) {
			if ( panel.isPlusEnabled() ) {
				
				errorMessage();
			}
		} else {
		//if ( panel.isPlusEnabled() )
			str = panel.getDisplay().substring( panel.getDisplay().indexOf( '\n' ) );
			int exponent = 1;
			
			if ( str.indexOf( '^' ) != -1 ) {
			
				String sub = str.substring( str.indexOf( '^' ) + 1, str.indexOf( '-' ) );
			    exponent = Integer.parseInt( sub );
			    
			}
			
			runOperator( Operator.SUBTRACTION, exponent );
	    }
		break;
	case '/':
		if ( !panel.isDivEnabled() ) {
			
			errorMessage();
		} else {
			
			str = panel.getDisplay().substring( panel.getDisplay().indexOf( '\n' ) );
			int exponent = 1;
			
			if ( str.indexOf( '^' ) != -1 ) {
			
				String sub = str.substring( str.indexOf( '^' ) + 1, str.indexOf( '/' ) );
			    exponent = Integer.parseInt( sub );
			    
			}
			runOperator( Operator.DIVISION, exponent );
			panel.enableEquals();
	        panel.toggleAllNumsDI(true);
	        panel.enableAllNums();
			panel.handleExponent( false );
		}
		break;
	case 'x':
		if ( !panel.isDivEnabled() ) {
			
			errorMessage();
		} else {
			
			str = panel.getDisplay().substring( panel.getDisplay().indexOf( '\n' ) );
			int exponent = 1;
			
			if ( str.indexOf( '^' ) != -1 ) {
			
				String sub = str.substring( str.indexOf( '^' ) + 1, str.indexOf( 'x' ) );
			    exponent = Integer.parseInt( sub );
			    
			}
			runOperator( Operator.MULTIPLICATION, exponent );
			panel.enableEquals();
	        panel.toggleAllNumsDI(true);
	        panel.enableAllNums();
			panel.handleExponent( false );
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
			
			runEquals();
			panel.handleExponent( false );
//			System.out.println( exp1.toString() + " " + exp2.toString() );
//			System.out.println( exp1.getExpPower() + " " + exp2.getExpPower() );
//			System.out.println( operator.get( 0 ) );
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
			panel.handleExponent( true );
		}
		break;

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
		
		try {
			runOperation( op, str, exponent );
	        
		} catch (NumberFormatException | InvalidExpressionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel.setDisplay( other + expression.get( expression.size() - 1 ).toString() 
				+ operator.get( operator.size() - 1 ).toString() + "\n" );
		panel.enableEquals();
	    panel.toggleAllNumsDI(true);
	    panel.enableAllNums();
		panel.handleExponent( false );
	}
}

  private void runOperation(Operator operator, String str, int exponent ) 
		  throws NumberFormatException, InvalidExpressionException {
	  
		TextFieldListener text = TextFieldListener.getInstance();
	    if (text.verifyTarget(str))
	    {
	    	
	    	Expression exp = setExp( str, exponent );
	    	expression.add( exp );
	    	System.out.println( exp.getExpPower() );
	    	this.operator.add( operator );
	    	
	    } else {
	    	
	    	System.out.println( "error" );
	    }
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

    int l = str.length();

    int i;
    Expression expression = null;

    if ( str.indexOf( '(' ) != -1 ) {
    	
        String sub = str.substring( str.indexOf( '(' ), str.indexOf( ')' ) );
    	
        if (sub.indexOf("+") != -1)
        {
  
          i = sub.indexOf('+');
          String real = str.substring(1, i);
          String img = str.substring(i + 1, l - 3);
          expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
            sub.charAt(i));
          expression.setExpPower( exponent );
        }
        else if (sub.indexOf("-") != -1)
        {
  
          i = sub.indexOf('-');
          String real = str.substring(1, i);
          String img = str.substring(i + 1, l - 3);
          expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
            sub.charAt(i));
          expression.setExpPower( exponent );
        }
    } else if ( str.indexOf( 'i' ) != -1 ) {

      String sub = str.substring(0, str.indexOf( 'i' ) );
      expression = new Expression( Double.parseDouble(sub), exponent
//    		  , 1, str.charAt( str.length() - 1 ) 
    		  );  
    } else {
		if ( str.indexOf( '^' ) != -1 ) {
			
			expression = new Expression(Double.parseDouble(str.substring( 0, str.indexOf( '^' ) )) 
//	    			,0.0, 1, str.charAt( str.length() - 1 ) 
	    			);
		} else {
    	
			expression = new Expression(Double.parseDouble(str.substring( 0, str.length() - 1 )) 
//    			,0.0, 1, str.charAt( str.length() - 1 ) 
    			);
		}
    	expression.setExpPower( exponent );
    }
    
    return expression;
  }
  

  private void runEquals()
  {
    // ArrayList<Expression> expressions = new ArrayList<Expression>();
    exp1 = null;
    exp2 = null;
    exponent = 1;
    CalcPanel panel = CalcPanel.getInstance();
    boolean hasExponent = false;
    String str = panel.getDisplay();
    str = str.substring(0, str.length() - 1);

    if (str.indexOf('(') != -1)
    {

      hasExponent = parseExp1(hasExponent, str);

      str = setStr(hasExponent, exponent, str);

      if (str.charAt(0) == '(')
      {

        exponent = setExponent2(str);
        exp2 = parseComplex(str, exponent);

      }
      else
      {
        if (str.indexOf('i') != -1)
        {

          exp2 = setImgExp2(str);

        }
        else
        {

          exp2 = setRealExp2(str);
        }
      }
    }
    else
    {

      ifNoComplex(str);
    }

    Operator[] operators = {operator.get(0)};
    Expression[] expression = {exp1, exp2};
    operator.clear();
    // expressions.add( exp1 );
    // expressions.add( exp2 );

    Calculate calc = new Calculate(expression, operators);
    Expression answer = null;
    try
    {
      answer = calc.calculateExpression();
    }
    catch (OverflowException | InvalidExpressionException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    panel.addToDisplay(answer.toString());
    history.add(panel.getDisplay());
    HistoryFrame.getInstance().incrementHistory("\n" + history.get(history.size() - 1));
  }

  private boolean parseExp1(boolean hasExponent, String str)
  {

    // add null test Maybe
    if ((str.indexOf(')') + 2) < str.length() && str.charAt(str.indexOf(')') + 1) == '^')
    {

      hasExponent = true;
      String sub = str.substring(str.indexOf(')'));

      if (sub.indexOf('(') != -1)
      {

        sub = sub.substring(sub.indexOf('^'));
        if (sub.indexOf('(') != -1)
        {

          sub = sub.substring(0, sub.indexOf('('));
          exponent = setExpOp(sub);
        }
      }
      else
      {

        exponent = setExpOp(sub);
      }

      exp1 = parseComplex(str, exponent);
    }
    else
    {

      exp1 = parseComplex(str, exponent);
    }
    return hasExponent;
  }

  private void ifNoComplex(String str)
  {
    int l = str.length();
    int i;

    if (str.indexOf('+') != -1)
    {

      operator.add(Operator.ADDITION);
      i = str.indexOf('+');
      String real = str.substring(0, i);
      String img = str.substring(i + 1, l);

      exp1 = parseNoncomplexExp(real);

      exp2 = parseNoncomplexExp(img);

    }
    else if (str.indexOf('x') != -1)
    {

      operator.add(Operator.MULTIPLICATION);
      i = str.indexOf('x');
      String real = str.substring(0, i);
      String img = str.substring(i + 1, l);

      exp1 = parseNoncomplexExp(real);

      exp2 = parseNoncomplexExp(img);

    }
    else if (str.indexOf('/') != -1)
    {

      operator.add(Operator.DIVISION);
      i = str.indexOf('/');
      String real = str.substring(0, i);
      String img = str.substring(i + 1, l);

      exp1 = parseNoncomplexExp(real);

      exp2 = parseNoncomplexExp(img);

    }
    else if (str.indexOf('-') != -1)
    {

      operator.add(Operator.SUBTRACTION);
      i = str.indexOf('-');
      String real = str.substring(0, i);
      String img = str.substring(i + 1, l);

      exp1 = parseNoncomplexExp(real);

      exp2 = parseNoncomplexExp(img);

    }
  }

  private Expression parseNoncomplexExp(String real)
  {
    Expression exp1;
    if (real.indexOf('i') != -1)
    {

      exp1 = parseImg(real);
    }
    else
    {

      exp1 = parseReal(real);
    }
    return exp1;
  }

  private Expression parseImg(String img)
  {
    Expression exp2;
    int power;
    if (img.indexOf('^') != -1)
    {

      power = img.indexOf('^');
      int thePower = Integer.parseInt(img.substring(power + 1, img.length()));

      exp2 = new Expression(Double.parseDouble(img.substring(0, power - 1)),
          Integer.parseInt(img.substring(power + 1, img.length())));
      exp2.setExpPower(thePower);
    }
    else
    {
      if (img.length() > 1)
      {

        exp2 = new Expression(Double.parseDouble(img.substring(0, img.length() - 1)), 1);
      }
      else
      {

        exp2 = new Expression(1.0, 1);
      }
    }

    return exp2;
  }

  private Expression parseReal(String real)
  {
    Expression exp1;
    int power;
    if (real.indexOf('^') != -1)
    {

      power = real.indexOf('^');
      exp1 = new Expression(Double.parseDouble(real.substring(0, power)));
      exp1.setExpPower(Integer.parseInt(real.substring(power + 1, real.length())));
    }
    else
    {

      exp1 = new Expression(Double.parseDouble(real));
      exp1.setExpPower(1);
    }
    return exp1;
  }

  private Expression setRealExp2(String str)
  {
    Expression exp2;
    int exponent;
    if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '/'
        || str.charAt(0) == 'x')
    {

      str = str.substring(1);

    }
    else if (str.charAt(str.strip().length() - 1) == '+'
        || str.charAt(str.strip().length() - 1) == '-'
        || str.charAt(str.strip().length() - 1) == 'x'
        || str.charAt(str.strip().length() - 1) == '/')
    {

      str = str.substring(0, str.strip().length() - 1);
    }
    if (str.indexOf('^') != -1)
    {

      exponent = setExpOp(str);
      str = str.substring(0, str.indexOf('^'));

    }
    else
    {

      exponent = 1;
    }
    exp2 = new Expression(Double.parseDouble(str));
    exp2.setExpPower(exponent);
    return exp2;
  }

  private Expression setImgExp2(String str)
  {
    Expression exp2;
    int exponent;
    if ((str.indexOf('i') + 2) < str.length() && str.charAt(str.indexOf('i') + 1) == '^')
    {
      // removed last index
      String sub = str.substring(str.indexOf('i') + 1);
      exponent = setExpOp(sub);

    }
    else
    {

      exponent = 1;
    }
    if (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '/'
        || str.charAt(0) == 'x')
    {

      str = str.substring(1, str.indexOf('i'));

    }
    else
    {

      str = str.substring(0, str.indexOf('i'));
    }

    exp2 = new Expression(Double.parseDouble(str), exponent);
    exp2.setExpPower(1);
    return exp2;
  }

  private String setStr(boolean hasExponent, int exponent, String str)
  {
    StringBuilder builder = new StringBuilder(str);

    String sub;
    if (hasExponent)
    {

      builder.delete(str.indexOf('('), (str.indexOf(')') + String.valueOf(exponent).length() + 2));

    }
    else
    {

      builder.delete(str.indexOf('('), (str.indexOf(')') + 1));
    }
    sub = builder.toString();

    sub = updateOperator(sub);

    return sub;
  }

  private String updateOperator(String sub)
  {
    if (sub.charAt(0) == '+')
    {

      operator.add(Operator.ADDITION);
      sub = sub.substring(1);

    }
    else if (sub.charAt(0) == '-')
    {

      operator.add(Operator.SUBTRACTION);
      sub = sub.substring(1);

    }
    else if (sub.charAt(0) == 'x')
    {

      operator.add(Operator.MULTIPLICATION);
      sub = sub.substring(1);

    }
    else if (sub.charAt(0) == '/')
    {

      operator.add(Operator.DIVISION);
      sub = sub.substring(1);
    }
    else if (sub.charAt(sub.length() - 1) == '+')
    {

      operator.add(Operator.ADDITION);

    }
    else if (sub.charAt(sub.length() - 1) == '-')
    {

      operator.add(Operator.SUBTRACTION);

    }
    else if (sub.charAt(sub.length() - 1) == '/')
    {

      operator.add(Operator.DIVISION);

    }
    else if (sub.charAt(sub.length() - 1) == 'x')
    {

      operator.add(Operator.MULTIPLICATION);
    }
    return sub;
  }

  private int setExponent2(String str)
  {

    int exponent;
    if ((str.indexOf(')') + 1) < str.length() && str.charAt(str.indexOf(')') + 1) == '^')
    {

      String sub = str.substring(str.indexOf(')') + 1);
      exponent = setExpOp(sub);

    }
    else
    {

      exponent = 1;
    }
    return exponent;
  }

  private int setExpOp(String sub)
  {

    int operator;
    int exponent = 1;
    if (sub.indexOf('+') != -1)
    {

      operator = sub.indexOf('+');
      // op = op.fromSymbol( sub.charAt( operator ) );
      sub = sub.substring(sub.indexOf('^') + 1, operator);
      exponent = Integer.parseInt(sub);

    }
    else if (sub.indexOf('-') != -1)
    {

      operator = sub.indexOf('-');
      // op = op.fromSymbol( sub.charAt( operator ) );
      sub = sub.substring(sub.indexOf('^') + 1, operator);
      exponent = Integer.parseInt(sub);

    }
    else if (sub.indexOf('/') != -1)
    {

      operator = sub.indexOf('/');
      // op = op.fromSymbol( sub.charAt( operator ) );
      sub = sub.substring(sub.indexOf('^') + 1, operator);

      exponent = Integer.parseInt(sub);

    }
    else if (sub.indexOf('x') != -1)
    {

      operator = sub.indexOf('x');
      // op = op.fromSymbol( sub.charAt( operator ) );
      sub = sub.substring(sub.indexOf('^') + 1, operator);
      exponent = Integer.parseInt(sub);

    }
    else
    {

      // operator = sub.indexOf( '=' );
      // op = op.fromSymbol( sub.charAt( operator ) );
      sub = sub.substring(sub.indexOf('^') + 1);
      exponent = Integer.parseInt(sub);

    }

    return exponent;
  }

  private Expression parseComplex(String str, int exponent)
  {

    int openPar;
    openPar = str.indexOf('(');
    String sub = str.substring(openPar + 1, str.indexOf(')'));
    int l = sub.length();
    int i;
    Expression expression = null;

    if (sub.indexOf('+') != -1)
    {

      i = sub.indexOf('+');
      String real = sub.substring(0, i);
      String img = sub.substring(i + 1, l - 1);
      try
      {
        expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
            sub.charAt(i));
      }
      catch (NumberFormatException | InvalidExpressionException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
    else if (sub.indexOf("-") != -1)
    {

      i = sub.indexOf('-');
      String real = sub.substring(0, i);
      String img = sub.substring(i + 1, l - 1);
      try
      {
        expression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
            sub.charAt(i));
      }
      catch (NumberFormatException | InvalidExpressionException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

    }
    else if (sub.charAt(sub.length() - 1) == 'i')
    {

      String last = str.substring(0, str.length() - 1);
      try
      {
        expression = new Expression(0.0, Double.parseDouble(last), 1, '+');
      }
      catch (NumberFormatException | InvalidExpressionException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

    }
    expression.setExpPower(exponent);

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
