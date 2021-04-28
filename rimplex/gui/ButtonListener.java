package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import util.Calculate;
import util.Expression;
import util.InvalidExpressionException;
import util.Operator;
import util.OutputFormat;
import util.OverflowException;

/**
 * 
 *
 * @author Colton Shovlin & Alex Walker
 * @version This work complies with the JMU Honor Code.
 */
public class ButtonListener implements ActionListener, WindowListener, KeyListener
{

  private static ButtonListener listener;

  // private Operator op;
  private ArrayList<String> history = new ArrayList<String>();
  private ArrayList<Operator> operator = new ArrayList<Operator>();
  // private int exponent;
  // private Expression exp1;
  // private Expression exp2;
  // private String display;
  private ArrayList<Expression> expression = new ArrayList<Expression>();

  private final String nL = "\n";
  private final String plus = "+";
  private final String minus = "-";
  private final String times = "x";
  private final String one = "1";
  private final String two = "2";
  private final String three = "3";
  private final String four = "4";
  private final String five = "5";
  private final String six = "6";
  private final String seven = "7";
  private final String eight = "8";
  private final String nine = "9";
  private final String zero = "0";
  private final String im = "i";
  private final String oP = "(";
  private final String cP = ")";
  private final String dec = ".";
  private final String eq = "=";
  private final String oH = ">";
  private final String cH = "<";
  private final String ex = "^";
  private final String dF = "dec";
  private final String fF = "frac";

  private final String bad = "Invalid Input";

  /**
   * handles button events.
   * 
   * @param e
   *          JButton
   */
  @Override
  public void actionPerformed(final ActionEvent e)
  {
    // TODO Auto-generated method stub
    AbstractButton button = (AbstractButton) e.getSource();
    CalcPanel calc = CalcPanel.getInstance();
    TextAreaTester field = TextAreaTester.getInstance();
    String display = calc.getDisplay();

    switch (button.getText())
    {
      case plus:
        if (calc.isCloseParEnabled())
        {

          calc.addToDisplay(plus);
          calc.enableEquals();
          calc.toggleAllNumsDI(true);
          calc.enableAllNums();
          calc.toggleImag(true);
          calc.handleExponent(false);

        }
        else
        {

          calc.addToDisplay(plus);
          int exponent = setExponent('+');
          runOperator(Operator.ADDITION, exponent);
        }

        break;
      case minus:
        if (calc.isCloseParEnabled())
        {

          calc.addToDisplay(minus);
          calc.enableEquals();
          calc.toggleAllNumsDI(true);
          calc.enableAllNums();
          calc.toggleImag(true);
          calc.handleExponent(false);

        }
        else
        {

          calc.addToDisplay(minus);
          int exponent = setExponent('-');
          runOperator(Operator.SUBTRACTION, exponent);
        }
        break;
      case "\u00F7":
        calc.enableEquals();
        calc.addToDisplay("/");
        int exponent = setExponent('/');
        runOperator(Operator.DIVISION, exponent);
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case times:
        calc.enableEquals();
        calc.addToDisplay(times);
        int exponent2 = setExponent('x');
        runOperator(Operator.MULTIPLICATION, exponent2);
        calc.toggleAllNumsDI(true);
        calc.toggleImag(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "R":
        calc.enableEquals();
        calc.resetDisplay();
        calc.addToDisplay(nL);
        calc.toggleAllNumsDI(true);
        calc.enableAllNums();
        calc.handleExponent(false);
        break;
      case "C":
        if (display.contains(plus))
        {
          if (display.lastIndexOf(plus) == display.length())
          {
            calc.subDisplay(display.length() - 1);

          }
          calc.subDisplay(display.lastIndexOf(plus));
        }
        else
        {

          calc.resetDisplay();
        }
        // create test case to check if operand has been entered already. (erase to that operand,
        // the operand, or all of the expression).
        break;
      case one:
        calc.enableEquals();
        calc.addToDisplay(one);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case two:
        calc.enableEquals();
        calc.addToDisplay(two);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case three:
        calc.enableEquals();
        calc.addToDisplay(three);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case four:
        calc.enableEquals();
        calc.addToDisplay(four);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case five:
        calc.enableEquals();
        calc.addToDisplay(five);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case six:
        calc.enableEquals();
        calc.addToDisplay(six);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case seven:
        calc.enableEquals();
        calc.addToDisplay(seven);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case eight:
        calc.enableEquals();
        calc.addToDisplay(eight);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case nine:
        calc.enableEquals();
        calc.addToDisplay(nine);
        calc.handleExponent(true);
        calc.toggleOperators(true);

        break;
      case zero:
        calc.enableEquals();
        calc.addToDisplay(zero);
        calc.handleExponent(true);
        calc.toggleOperators(true);
        break;
      case im:

        calc.enableEquals();
        calc.addToDisplay(im);

        calc.disableAllNumsI();
        calc.handleExponent(true);
        break;
      case oP:
        calc.addToDisplay(oP);
        calc.changeParenC(1);
        calc.toggleOperatorsI(false);
        // calc.toggleCParen();
        calc.handleExponent(false);
        break;
      case cP:
        calc.enableEquals();
        calc.addToDisplay(cP);
        calc.changeParenC(-1);
        // calc.toggleCParen();
        calc.handleExponent(true);
        break;
      case dec:
        calc.enableEquals();
        calc.addToDisplay(dec);
        calc.toggleDecimal(false);
        calc.handleExponent(true);
        break;
      case eq:
        calc.addToDisplay(eq);
        runEquals();
        calc.handleExponent(false);
        break;
      case "\u2190":
        char last = display.charAt(display.length() - 1);

        // if (last == 'i') {
        // calc.toggleAllNums(true);
        // calc.toggleImag(true);
        // }
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
        if (display.isEmpty())
        {
          break;
        }
        else
        {
          calc.changeSign();
        }
        break;
      case "steps":

        StepsFrame steps = StepsFrame.getInstance();
        if (steps.isVisible())
        {

          steps.handleSteps(false);
        }
        else
        {

          steps.handleSteps(true);
        }
        break;
      case oH:
        HistoryFrame.getInstance().handleHistory(true);
        button.setText(cH);
        // calc.handleCloseHistory(true);
        // calc.handleOpenHistory(false);
        // String str = null;
        // for ( int i = 0; i < history.size(); i++ ) {
        //
        // str += "\n" + history.get( i );
        // }
        // JOptionPane.showMessageDialog( null, str );
        break;
      case cH:
        HistoryFrame.getInstance().handleHistory(false);
        button.setText(oH);
        // calc.handleCloseHistory(false);
        // calc.handleOpenHistory(true);
        break;
      case "sqr":
        calc.addToDisplay("sqr(");
        calc.changeParenC(1);
        break;
      case "conj":
        calc.addToDisplay("conj(");
        calc.changeParenC(1);
        break;
      case ex:
        calc.addToDisplay(ex);
        calc.handleExponent(false);
        calc.enableAllNums();
        calc.disableIButton();
        break;
      case dF:
        button.setText(fF);
        calc.resetDisplay();
        calc.addToDisplay(OutputFormat.toDecimal(display));
        break;
      case fF:
        button.setText(dF);
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
        try
        {

          String url = "http://www.google.com";
          java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
          // Desktop.getDesktop().browse(new URI("http://www.codejava.net"));
          // Desktop.browse("http://www.google.de/");
        }
        catch (IOException e1)
        {
          e1.printStackTrace();
        }
        break;
      case "About":

        String message = "Rimplex is a complex number calculator. This is \n"
            + "a CS345 final project designed by John Curley, Hunter Mann,\n"
            + "Nic Plybon, Colton Shovlin and Alexander Walker (team14).\n"
            + "This is the 3rd edition of Rimplex.";
        JOptionPane.showMessageDialog(null, message, "About Rimplex", JOptionPane.PLAIN_MESSAGE);
        break;
      default:
        break;
    }
    // } else if ( e.getSource() instanceof JMenu ) {
    //
    // JMenu menu = (JMenu) e.getSource();
    //
    // switch ( menu.getText() ) {
    // case "about":
    // try {
    // System.out.println( "in try" );
    // String url = "http://www.google.com";
    // java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
    //// Desktop.getDesktop().browse(new URI("http://www.codejava.net"));
    // //Desktop.browse("http://www.google.de/");
    // } catch (IOException e1) {
    // e1.printStackTrace();
    // }
    // break;
    // }
    // }
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
  public void windowOpened(final WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowClosing(final WindowEvent e)
  {
    System.exit((0));

  }

  @Override
  public void windowClosed(final WindowEvent e)
  {
    System.exit(0);
  }

  @Override
  public void windowIconified(final WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeiconified(final WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowActivated(final WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeactivated(final WindowEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyTyped(final KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyPressed(final KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyReleased(final KeyEvent e)
  {
    // TODO Auto-generated method stub
    char result = (char) e.getKeyChar();
    CalcPanel panel = CalcPanel.getInstance();

    switch (result)
    {
      case '+':
        if (panel.isCloseParEnabled())
        {
          if (!panel.isPlusEnabled())
          {

            errorMessage();
          }
        }
        else
        {
          // if ( panel.isPlusEnabled() )

          int exponent = setExponent('+');
          runOperator(Operator.ADDITION, exponent);
        }
        break;
      case '-':
        if (panel.isCloseParEnabled())
        {
          if (!panel.isPlusEnabled())
          {

            errorMessage();
          }
        }
        else
        {
          // if ( panel.isPlusEnabled() )

          int exponent = setExponent('-');
          runOperator(Operator.SUBTRACTION, exponent);
        }
        break;
      case '/':
        if (!panel.isDivEnabled())
        {

          errorMessage();
        }
        else
        {

          int exponent = setExponent('/');
          runOperator(Operator.DIVISION, exponent);
        }
        break;
      case 'x':
        if (!panel.isDivEnabled())
        {

          errorMessage();
        }
        else
        {

          int exponent = setExponent('x');
          runOperator(Operator.MULTIPLICATION, exponent);
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
        if (!panel.isNumEnabled())
        {

          errorMessage();
        }
        else
        {

          panel.enableEquals();
          panel.toggleImag(true);
          panel.handleExponent(true);
        }
        break;
      case 'i':
        if (!panel.isIEnabled())
        {

          errorMessage();
        }
        else
        {

          panel.enableEquals();
          panel.disableAllNumsI();
          panel.handleExponent(true);
        }
        break;
      case '\u0008':
      case '\u007F':
        break;
      case ' ':
        break;
      case '=':
        if (panel.isEqualsEnabled())
        {

          runEquals();
        }
        else
        {

          errorMessage();
        }
        break;
      case '(':
        if (!panel.isOpenParEnabled())
        {

          errorMessage();
        }
        else
        {

          panel.changeParenC(1);
          panel.handleExponent(false);

        }
        break;
      case ')':
        if (!panel.isCloseParEnabled())
        {

          errorMessage();
        }
        else
        {

          panel.enableEquals();
          panel.changeParenC(-1);
          panel.handleExponent(true);

        }
        break;
      case '^':
        if (!panel.isExponentEnabled())
        {

          errorMessage();
        }
        else
        {
          // currently have to assume user enters another number after hitting equals
          panel.enableEquals();
          panel.enableAllNums();
          panel.disableIButton();
          panel.handleExponent(false);
        }
        break;
      case '.':
        if (!panel.isDecimalEnabled())
        {

          errorMessage();
        }
        else
        {

          panel.enableEquals();
          panel.toggleDecimal(false);
          panel.handleExponent(true);

        }
        break;
      default:
        if (e.getKeyCode() != KeyEvent.VK_SHIFT)
        {

          errorMessage();
        }
        break;
    }
  }

  /**
   * set exponent.
   * 
   * @param exponentOperator
   *          char
   * @return value of exponent
   */
  private int setExponent(final char exponentOperator)
  {
    CalcPanel panel = CalcPanel.getInstance();
    String str = panel.getDisplay().substring(panel.getDisplay().indexOf('\n'));
    int exponent = 1;

    if (str.indexOf('^') != -1)
    {

      String sub = str.substring(str.indexOf('^') + 1, str.indexOf(exponentOperator));
      exponent = Integer.parseInt(sub);

    }
    return exponent;
  }

  /**
   * perform equals function.
   */
  private void runEquals()
  {

    CalcPanel panel = CalcPanel.getInstance();
    String str = panel.getDisplay();
    int newLine = str.indexOf('\n');
    str = str.substring(newLine).strip();

    if (!TextAreaTester.getInstance().verifyTarget(str))
    {

      errorMessage();
    }
    else
    {
      try
      {
        int exponent = 1;

        if (str.indexOf('^') != -1)
        {

          String sub = str.substring(str.indexOf('^') + 1, str.indexOf('='));
          exponent = Integer.parseInt(sub);

        }
        this.expression.add(setExp(str, exponent));
      }
      catch (NumberFormatException | InvalidExpressionException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      Operator[] operators = new Operator[operator.size()];
      operators = operator.toArray(operators);
      Expression[] theExpression = new Expression[this.expression.size()];
      theExpression = this.expression.toArray(theExpression);

      Calculate calc = new Calculate(theExpression, operators);
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

      StepsFrame.getInstance().incrementSteps(calc.getSteps());
      panel.subDisplay(newLine);
      panel.addToDisplay(this.expression.get(this.expression.size() - 1) + eq + answer.toString());
      history.add(panel.getDisplay());
      HistoryFrame.getInstance().incrementHistory(nL + history.get(history.size() - 1));
      panel.handleExponent(false);
      operator.clear();
      this.expression.clear();
    }

  }

  /**
   * run Operation.
   * 
   * @param op
   *          enum
   * @param exponent
   *          int
   */
  private void runOperator(final Operator op, final int exponent)
  {

    CalcPanel panel = CalcPanel.getInstance();
    String str;
    if (!panel.isPlusEnabled())
    {

      errorMessage();
    }
    else if (!panel.isCloseParEnabled())
    {

      str = panel.getDisplay();
      int newLine = str.indexOf('\n');
      String other = str.substring(0, newLine);
      str = str.substring(newLine).strip();

      boolean bool = false;

      try
      {
        bool = runOperation(op, str, exponent);

      }
      catch (NumberFormatException | InvalidExpressionException e1)
      {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      if (bool)
      {

        panel.setDisplay(other + expression.get(expression.size() - 1).toString()
            + operator.get(operator.size() - 1).toString() + nL);
        panel.enableEquals();
        panel.toggleAllNumsDI(true);
        panel.enableAllNums();
        panel.handleExponent(false);

      }
      else
      {

        panel.enableAllNums();
      }
    }
    else
    {

      CalcPanel calc = CalcPanel.getInstance();

      calc.setDisplay(calc.getDisplay().substring(0, (calc.getDisplay().indexOf('\n'))) + nL);
      JOptionPane.showMessageDialog(null, bad, bad, JOptionPane.PLAIN_MESSAGE);
      calc.enableEquals();
      calc.resetDisplay();
      calc.addToDisplay(nL);
      calc.toggleAllNumsDI(true);
      calc.enableAllNums();
      calc.handleExponent(false);
      calc.changeParenC(-1);

    }
  }

  /**
   * set and add expression to arrayList.
   * 
   * @param sign
   *          enum
   * @param strExpression
   *          String
   * @param known
   *          int >>>>>>> branch 'master' of https://github.com/bernstdh/team14.git
   * @return true if valid entry
   * @throws NumberFormatException
   *           WAP
   * @throws InvalidExpressionException
   *           WAP
   */
  private boolean runOperation(final Operator sign, final String strExpression, final int known)
      throws NumberFormatException, InvalidExpressionException
  {

    TextAreaTester text = TextAreaTester.getInstance();

    boolean bool = false;

    if (text.verifyTarget(strExpression))
    {

      bool = true;
      Expression exp = setExp(strExpression, known);
      expression.add(exp);
      this.operator.add(sign);

    }
    else
    {

      CalcPanel calc = CalcPanel.getInstance();

      calc.setDisplay(calc.getDisplay().substring(0, (calc.getDisplay().indexOf('\n'))) + nL);
      JOptionPane.showMessageDialog(null, bad, bad, JOptionPane.PLAIN_MESSAGE);

    }

    return bool;
  }

  /**
   * Set input field to expression object.
   * 
   * @param str
   *          input
   * @param exponent
   * @return parsed expression
   * @throws NumberFormatException
   *           WAP
   * @throws InvalidExpressionException
   *           WAP
   */
  private Expression setExp(final String str, final int exponent)
      throws NumberFormatException, InvalidExpressionException
  {

    Expression originalExpression = null;
    int l = str.length();

    if (str.indexOf('m') != -1)
    {

      originalExpression = setFunctionExpression(str);
      originalExpression.setImaginaryExpression();

    }
    else if (str.indexOf('e') != -1)
    {

      originalExpression = setFunctionExpression(str);
      originalExpression.setRealExpression();

    }
    else if (str.indexOf('j') != -1)
    {

      originalExpression = setFunctionExpression(str);
      originalExpression.setConjugate();

    }
    else if (str.indexOf('v') != -1)
    {

      originalExpression = setFunctionExpression(str);
      originalExpression.setInverse();

    }
    else if (str.indexOf('o') != -1)
    {

      originalExpression = setFunctionExpression(str);
      originalExpression.setLog();

    }
    else if (str.indexOf('q') != -1)
    {

      originalExpression = setFunctionExpression(str);
      originalExpression.setSqrt();

    }
    else if (str.indexOf('(') != -1)
    {

      String sub = str.substring(str.indexOf('('), str.indexOf(')'));
      if (sub.indexOf(plus) != -1)
      {

        originalExpression = setComplex(str, exponent, l, sub, '+');
      }
      else if (sub.indexOf(minus) != -1)
      {

        originalExpression = setComplex(str, exponent, l, sub, '-');
      }
    }
    else if (str.indexOf('i') != -1)
    {

      String sub = str.substring(0, str.indexOf('i'));
      originalExpression = new Expression(Double.parseDouble(sub), exponent);
    }
    else
    {
      if (str.indexOf('^') != -1)
      {

        originalExpression = new Expression(Double.parseDouble(str.substring(0, str.indexOf('^'))));
      }
      else
      {

        originalExpression = new Expression(Double.parseDouble(str.substring(0, str.length() - 1)));
      }
      if (exponent != 1)
      {

        originalExpression.setExpPower(exponent);
      }
    }

    return originalExpression;
  }

  /**
   * set complex expression.
   * 
   * @param str
   *          String
   * @param exponent
   *          int
   * @param l
   *          int
   * @param sub
   *          string
   * @param complexOperator
   *          char
   * @return parsed expression
   * @throws InvalidExpressionException
   */
  private Expression setComplex(final String str, final int exponent, final int l, final String sub,
      final char complexOperator) throws InvalidExpressionException
  {

    int i;
    Expression complexExpression;
    i = sub.indexOf(complexOperator);
    String real = str.substring(1, i);
    String img = str.substring(i + 1, l - 3);
    complexExpression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
        sub.charAt(i));
    if (exponent != 1)
    {

      complexExpression.setExpPower(exponent);
    }
    return complexExpression;
  }

  /**
   * set expression when function is set.
   * 
   * @param str
   *          String
   * @return parsed expression
   * @throws InvalidExpressionException
   *           WAP
   */
  private Expression setFunctionExpression(final String str) throws InvalidExpressionException
  {
    int i;
    Expression functionExpression;
    String sub = str.substring(str.indexOf('('), str.indexOf(')'));
    int l = sub.length();

    if (sub.indexOf(plus) != -1)
    {

      i = sub.indexOf('+');
      String real = sub.substring(1, i);
      String img = sub.substring(i + 1, l - 1);
      functionExpression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
          sub.charAt(i));
    }
    else if (sub.indexOf(minus) != -1)
    {

      i = sub.indexOf('-');
      String real = sub.substring(1, i);
      String img = sub.substring(i + 1, l - 1);
      functionExpression = new Expression(Double.parseDouble(real), Double.parseDouble(img), 1,
          sub.charAt(i));

    }
    else if (sub.indexOf('i') != -1)
    {

      sub = sub.substring(0, sub.indexOf('i'));

      functionExpression = new Expression(Double.parseDouble(sub), 1);

    }
    else
    {

      functionExpression = new Expression(Double.parseDouble(sub.substring(0, sub.length() - 1)));
    }
    return functionExpression;
  }

  /**
   * display error message and delete last character.
   */
  private void errorMessage()
  {

    CalcPanel calc = CalcPanel.getInstance();

    calc.subDisplay((calc.getDisplay().length() - 1));
    JOptionPane.showMessageDialog(null, bad, bad, JOptionPane.PLAIN_MESSAGE);
  }
}
