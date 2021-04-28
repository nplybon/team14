package util;

/**
 * OverflowException class.
 *
 * @author team 14
 * @version This work complies with the JMU Honor Code.
 */
public class OverflowException extends Exception
{

  public static final long serialVersionUID = 1L;

  /**
   * Default Constructor.
   */
  public OverflowException()
  {
    super();
  }

  /**
   * Explicit value Constructor.
   * 
   * @param message
   *          the error message to be displayed
   */
  public OverflowException(final String message)
  {
    super(message);
  }
}
