package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;

/**
 * container for history panel.
 * 
 * @author Colton Shovlin
 * @version rimplex sprint 3
 */
public class HistoryFrame extends JFrame
{

  private static final long serialVersionUID = 1L;

  private static HistoryFrame frame;
  private static JTextArea area;
  private static JTextField windowDisplay;
  private JWindow historyWindow;

  /**
   * Singleton Constructor method.
   */
  private HistoryFrame()
  {

    createComponents();
    setLabels();
    addComponents();

    setLayout(new GridLayout(1, 0));
    setSize(450, 450);
    setTitle("History");
    setVisible(false);
    setUndecorated(true);

  }

  /**
   * add JTextArea.
   */
  public void addComponents()
  {

    add(area);
  }

  /**
   * create components for panel.
   */
  public void createComponents()
  {

    area = new JTextArea();

    windowDisplay = new JTextField();

    historyWindow = new JWindow();
  }

  /**
   * set Labels.
   */
  public void setLabels()
  {

    area.setFocusable(false);
    windowDisplay.setFocusable(false);
    historyWindow.setVisible(false);
  }

  /**
   * Make history visible or not.
   * 
   * @param bool
   *          where to make is visible or not
   */
  public void handleHistory(final boolean bool)
  {

    setVisible(bool);
  }

  /**
   * add text to history panel.
   * 
   * @param str
   *          text to be added
   */
  public void incrementHistory(final String str)
  {

    area.setText(area.getText() + "\n" + str);
    area.setAlignmentY(TOP_ALIGNMENT);
  }

  /**
   * get text Area.
   * 
   * @return JTextArea
   */
  public static JTextArea getDisplay()
  {
    return area;
  }

  /**
   * @return get top level container
   */
  public static JFrame parent()
  {
    return frame;
  }

  /**
   * singleton method.
   * 
   * @return singleton instance
   */
  public static HistoryFrame getInstance()
  {

    if (frame == null)
    {

      frame = new HistoryFrame();
    }

    return frame;
  }
}
