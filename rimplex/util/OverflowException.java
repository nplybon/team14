package util;

public class OverflowException extends Exception {
	
	public static final long serialVersionUID = 1L;

	  /**
	   * Default Constructor.
	   */
	  public OverflowException()
	  {
	    super();
	  }

	  /**
	   * Explicit value Constructor
	   * @param message the error message to be displayed
	   */
	  public OverflowException(String message) {
		  super(message);
	  }
}
