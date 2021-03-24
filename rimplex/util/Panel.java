package util;

import javax.swing.JPanel;

public abstract class Panel extends JPanel {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

  public abstract void createComponents();
  
  public abstract void addComponents();
  
  public abstract void setParameters();
  
  public abstract void setListeners();
  
  public abstract void setPanel();
}
