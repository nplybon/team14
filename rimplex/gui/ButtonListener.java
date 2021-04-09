package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import util.Operator;

public class ButtonListener implements ActionListener, WindowListener
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
    JButton button = (JButton) e.getSource();
    CalcPanel calc = CalcPanel.getInstance();
    TextFieldListener field = TextFieldListener.getInstance();

    switch (button.getText())
    {
      case "+":
        calc.updateDisplay(" + ");
        break;
      case "-":
        calc.updateDisplay(" - ");
        break;
      case "/":
        calc.updateDisplay(" / ");
        break;
      case "x":
        calc.updateDisplay(" x ");
        break;
      case "R":
        calc.resetDisplay();
        break;
      case "C":
        // create test case to check if operand has been entered already. (erase to that operand,
        // the operand, or all of the expression).
        break;
      case "1":
        calc.updateDisplay("1");
        break;
      case "2":
        calc.updateDisplay("2");
        break;
      case "3":
        calc.updateDisplay("3");
        break;
      case "4":
        calc.updateDisplay("4");
        break;
      case "5":
        calc.updateDisplay("5");
        break;
      case "6":
        calc.updateDisplay("6");
        break;
      case "7":
        calc.updateDisplay("7");
        break;
      case "8":
        calc.updateDisplay("8");
        break;
      case "9":
        calc.updateDisplay("9");
        break;
      case "0":
        calc.updateDisplay("0");
        break;
      case "i":
        calc.updateDisplay("i");
        break;
      case "(":
        calc.updateDisplay("(");
        break;
      case ")":
        calc.updateDisplay(")");
        break;
      case ".":
        calc.updateDisplay(".");
        break;
      case "=":

        break;
      case "<-":

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

}
