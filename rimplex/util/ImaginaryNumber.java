package util;

/**
 * ImaginaryNumber enum for the different powers of imaginary numbers.
 * 
 * @author John Curley
 */
public enum ImaginaryNumber
{
  
  ONE(1, "i"), TWO(2, "-1"), THREE(3, "-i"), FOUR(4, "1");

  private static String IValue = ImaginaryNumber.ONE.getType();
  private int power;
  private String type;

  /**
   * Constructor.
   * 
   * @param power
   *          int power of the imaginary number
   * @param type
   *          String result of the imaginary number
   */
  private ImaginaryNumber(final int power, final String type)
  {
    this.power = power;
    this.type = type;
  }

  /**
   * Creates an ImaginaryNumber from the power.
   * 
   * @param imgPower
   *          int power of the imaginary number
   * @return Imaginary Number
   */
  public ImaginaryNumber fromPower(final int imgPower)
  {

    ImaginaryNumber i;

    switch (imgPower % 4)
    {
      case 0:
        i = ImaginaryNumber.FOUR;
        break;
      case 1:
        i = ImaginaryNumber.ONE;
        break;
      case 2:
        i = ImaginaryNumber.TWO;
        break;
      case 3:
        i = ImaginaryNumber.THREE;
        break;
      default:
        i = null;
    }

    return i;
  }

  /**
   * Gets the unmodified power of the imaginary number.
   * 
   * @return power of imaginary number
   */
  public int getPower()
  {
    return power;
  }

  /**
   * Gets the result type of the imaginary number.
   * 
   * @return result type of the imaginary number
   */
  public String getType()
  {
    return type;
  }

  /**
   * Returns the imaginary number with no coefficient.
   * 
   * @return the result of the imaginary number
   */
  public String toString()
  {
    return type;
  }

  /**
   * Returns the imaginary number with a coefficient.
   * 
   * @param coef
   *          int coefficient of the imaginary number
   * @return the imaginary number factored to include a coefficient
   */
  public String toString(final double coef)
  {

    String str;

    switch (this)
    {
      case ONE:
        str = coef + type;
        break;
      case TWO:
        str = "" + (coef * Integer.parseInt(type));
        break;
      case THREE:
        str = "" + (-coef) + IValue;
        break;
      case FOUR:
        str = "" + (coef * Integer.parseInt(type));
        break;
      default:
        str = null;
        break;
    }

    return str;
  }
}
