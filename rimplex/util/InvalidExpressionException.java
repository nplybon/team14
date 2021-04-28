package util;

/**
 * Exception if the Exception is in an invalid format.
 * 
 * @author John Curley
 */
public class InvalidExpressionException extends Exception
{

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param message
   *          String message to display with the exception
   */
  public InvalidExpressionException(final String message)
  {
    super(message);
  }
}
