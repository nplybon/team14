package util;

import javax.swing.JPanel;
/**
 * Abstract Panel class.
 * 
 * @author John Curley
 *
 */
public abstract class Panel extends JPanel {
    /**
	 * 
	 */
     private static final long serialVersionUID = 1L;

  public Panel() {
	  
	  createComponents();
      setParameters();
      setPanel();
      addComponents();
      setListeners();
      
  }
  
  public abstract void createComponents();
  
  public abstract void addComponents();
  
  public abstract void setParameters();
  
  public abstract void setListeners();
  
  public abstract void setPanel();
}
