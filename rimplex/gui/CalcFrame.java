package gui;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * top level container for calculator.
 * 
 * @author Colton Shovlin
 * @version Rimplex Sprint 3
 */

public class CalcFrame extends JFrame
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private static CalcFrame frame;

  private JMenuBar menuBar;

  private JMenu file;
  private JMenuItem about;
  private JMenuItem print;

  private JMenuItem help;

  private JPanel current;

  /**
   * Singleton constructor.
   */
  private CalcFrame()
  {

    createCompnents();
    setLabels();
    addMenus();
    // changed to new Panel
    setPanel(CalcPanel.getInstance());
    setListeners();
    setJMenuBar(menuBar);
    // Changed Dimensions
    setSize(450, 450);
    setTitle("Calculator");
    setVisible(true);
    centerForm();

  }

  /**
   * Sets Panel object.
   * 
   * @param panel to be set as contentPane
   */
  public void setPanel(final JPanel panel)
  {

    if (current != null)
    {
      current.setVisible(false);
      getContentPane().remove(current);
    }

    getContentPane().add(panel, BorderLayout.CENTER);
    current = panel;
    current.setVisible(true);
  }

  /**
   * singleton method.
   * 
   * @return calcFrame instance
   */
  public static CalcFrame getInstance()
  {

    if (frame == null)
    {

      frame = new CalcFrame();
    }

    return frame;
  }

  /**
   * add Menu items.
   */
  private void addMenus()
  {

    file.add(about);
//    file.add(help);
    file.add(print);

    menuBar.add(file);

  }

  /**
   * create components.
   */
  private void createCompnents()
  {

    menuBar = new JMenuBar();

    file = new JMenu();
    help = new JMenuItem();
    print = new JMenuItem();

    about = new JMenuItem();

    current = new JPanel();

  }

  /**
   * center form on screen.
   */
  private void centerForm()
  {

    Dimension dimScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dimFrameSize = getSize();

    if (dimFrameSize.height > dimScreenSize.height)
    {
      dimFrameSize.height = dimScreenSize.height;
    }
    if (dimFrameSize.width > dimScreenSize.width)
    {
      dimFrameSize.width = dimScreenSize.width;
    }

    setLocation((dimScreenSize.width - dimFrameSize.width) / 2,
        (dimScreenSize.height - dimFrameSize.height) / 2);

  } // method centerForm

  /**
   * set menu labels.
   */
  private void setLabels()
  {

    file.setText("File");
    help.setText("Help");
    about.setText("About");
    print.setText("Print");

  }

  /**
   * set menu listeners.
   */
  private void setListeners()
  {

    this.addWindowListener(ButtonListener.getInstance());
    about.addActionListener(ButtonListener.getInstance());
    help.addActionListener(ButtonListener.getInstance());
    print.addActionListener(ButtonListener.getInstance());
  }
}
