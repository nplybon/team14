package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class StepsFrame extends JFrame
{

  private static final long serialVersionUID = 1L;

  // private JLabel history;
  private static StepsFrame frame;
  private static JTextArea area;
  private static JTextField windowDisplay;
  private JWindow stepsWindow;

  public StepsFrame()
  {

    createComponents();
    setLabels();
    addComponents();

    setLayout(new GridLayout(1, 0));
    setSize(450, 450);
    setTitle("Steps");
    setVisible(false);
    setUndecorated(true);
    setLocation(1000, 0);
  }

  public void addComponents()
  {

    add(area);
  }

  public void createComponents()
  {

    // history = new JLabel();
    area = new JTextArea();

    windowDisplay = new JTextField();

    stepsWindow = new JWindow();
  }

  public void setLabels()
  {

    area.setFocusable(false);
    windowDisplay.setFocusable(false);
    // windowDisplay.setAlignmentY(getAlignmentY());
    stepsWindow.setVisible(false);
  }

  public void handleSteps(boolean bool)
  {

    // historyWindow.setVisible( true );
    setVisible(bool);
  }

  public void incrementSteps(ArrayList<String> str)
  {

    // windowDisplay.add( str, null );
    // history = new JLabel( history.getText() + "/n" + str );
    // history.setVerticalAlignment(SwingConstants.TOP);
    // windowDisplay.setText( windowDisplay.getText()
    // + "\n" + str );
    // windowDisplay.setCaret( history );
    area.setText("");

    for (int i = 0; i < str.size(); i++)
    {

      area.setText(area.getText() + str.get(i) + "\n");
      area.setAlignmentY(TOP_ALIGNMENT);
    }
  }

  public static JTextArea getDisplay()
  {
    return area;
  }

  public static JFrame parent()
  {
    return frame;
  }

  public static StepsFrame getInstance()
  {

    if (frame == null)
    {

      frame = new StepsFrame();
    }

    return frame;
  }
}
