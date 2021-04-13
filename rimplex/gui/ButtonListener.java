package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;


import util.Operator;
import util.OutputFormat;

public class ButtonListener implements ActionListener, WindowListener, KeyListener
{

  private static ButtonListener listener;
  
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

        break;
      case "log":

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
      
//      int openPar;
//      int closePar;
//      int operator;
//      
//      String str = panel.getDisplay();
//      str = str.substring( 0, str.length() - 1 );
//      
//      if ( str.indexOf( '(' ) != -1 ) {
//        
//        openPar = str.indexOf( '(' );
//        //String 
//      } else {
//        if ( str.indexOf( '+' ) != -1 ) {
//          
//          
//        } else if ( str.indexOf( '-' ) != -1 ) {
//          
//        } else if ( str.indexOf( '/' ) != -1 ) {
//          
//        } else if ( str.indexOf( 'x' ) != -1 ) {
//          
//        }
//      }
    } else {
      
      errorMessage();
    }
    break;
  case '.':
    if ( !panel.isDecimalEnabled() ) {
      
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
  default:
  
    errorMessage();
      break;
  }
  }
  
  private void errorMessage() {
    
    CalcPanel calc = CalcPanel.getInstance();
    String bad = "Invalid Input";

    calc.setDisplay( ( calc.getDisplay().length() - 1 ) );
    JOptionPane.showMessageDialog( null, bad, "Invalid Input", 
        JOptionPane.PLAIN_MESSAGE );
  }

}
