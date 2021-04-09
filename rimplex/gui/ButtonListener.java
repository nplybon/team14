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
    String str = "";
    TextFieldListener field = TextFieldListener.getInstance();

    switch (button.getText())
    {
      case "+":

        break;
      case "-":

        break;
      case "/":

        break;
      case "x":

        break;
      case "R":

        break;
      case "C":

        break;
      case "1":
        calc.updateDisplay("1");
        break;
      case "2":

        break;
      case "3":

        break;
      case "4":

        break;
      case "5":

        break;
      case "6":

        break;
      case "7":

        break;
      case "8":

        break;
      case "9":

        break;
      case "0":

        break;
      case "i":
        
        break;
      case "(":
        
        break;
      case ")":
        
        break;
      case ".":
        
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
