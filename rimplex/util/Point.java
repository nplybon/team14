package util;

/**
 * Point class.
 *
 * @author team 14
 * @version This work complies with the JMU Honor Code.
 */
public class Point
{

  private double a;
  private double b;

  /**
   * Point constructor.
   * 
   * @param a
   *          - first double
   * @param b
   *          - second double
   */
  public Point(final double a, final double b)
  {
    this.a = a;
    this.b = b;
  }

  /**
   * Gets the "a" value.
   * 
   * @return double - a value
   */
  public double getA()
  {
    return this.a;
  }

  /**
   * Gets the "b" value.
   * 
   * @return double - b value
   */
  public double getB()
  {
    return this.b;
  }

}
