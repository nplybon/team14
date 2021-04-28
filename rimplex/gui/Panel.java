package gui;

import javax.swing.JPanel;

/**
 * Abstract Panel class.
 * 
 * @author John Curley
 *
 */
public abstract class Panel extends JPanel
{
  /**
  * 
  */
  private static final long serialVersionUID = 1L;

  /**
   * Panel Object Constructor.
   */
  public Panel()
  {

    createComponents();
    setParameters();
    setPanel();
    addComponents();
    setListeners();

  }

  /**
   * Creates Components for Panel Object.
   */
  public abstract void createComponents();

  /**
   * Add Components to Panel Object.
   */
  public abstract void addComponents();

  /**
   * Sets Parameters of Panel Object.
   */
  public abstract void setParameters();

  /**
   * Sets Listeners for Panel Object.
   */
  public abstract void setListeners();

  /**
   * Sets the Panel.
   */
  public abstract void setPanel();
}
