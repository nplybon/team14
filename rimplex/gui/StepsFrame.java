package gui;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;

/**
 * StepsFrame class for Rimplex project.
 *
 * @author Colton Shovlin
 * @version This work complies with the JMU Honor Code.
 */
public class StepsFrame extends JFrame
{

  private static final long serialVersionUID = 1L;

  // private JLabel history;
  private static StepsFrame frame;
  private static JTextArea area;
  private static JTextField windowDisplay;
  private JWindow stepsWindow;

  /**
   * Constructor method.
   */
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

  /**
   * Adds components to StepsFrame object.
   */
  public void addComponents()
  {

    add(area);
  }

  /**
   * Creats components for StepsFrame object.
   */
  public void createComponents()
  {

    // history = new JLabel();
    area = new JTextArea();

    windowDisplay = new JTextField();

    stepsWindow = new JWindow();
  }

  /**
   * Sets labels for StepFrame objects.
   */
  public void setLabels()
  {

    area.setFocusable(false);
    windowDisplay.setFocusable(false);
    // windowDisplay.setAlignmentY(getAlignmentY());
    stepsWindow.setVisible(false);
  }

  /**
   * Sets the StepFrame to visible.
   * 
   * @param bool - true or false
   */
  public void handleSteps(final boolean bool)
  {

    // historyWindow.setVisible( true );
    setVisible(bool);
  }

  /**
   * 
   * @param str
   */
  public void incrementSteps(final ArrayList<String> str)
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

  /**
   * Gets the display.
   * 
   * @return JTextArea - the display
   */
  public static JTextArea getDisplay()
  {
    return area;
  }

  /**
   * Gets the parent frame.
   * 
   * @return JFrame - parent frame
   */
  public static JFrame parent()
  {
    return frame;
  }

  /**
   * gets the StepsFrame instance.
   * 
   * @return StepsFrame - current instance
   */
  public static StepsFrame getInstance()
  {

    if (frame == null)
    {

      frame = new StepsFrame();
    }

    return frame;
  }
}
