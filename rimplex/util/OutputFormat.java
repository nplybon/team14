package util;

import java.util.ArrayList;

/**
 * A class that converts the solution into fractions/decimals.
 * 
 * @author Nic Plybon
 */
public class OutputFormat
{

  private static final String EQUALS = "=";
  private static final String I = "i";
  private static final String SPACE = " ";
  private static final String FRAC = "/";

  /**
   * Converts the solution into a fraction.
   * 
   * @param output
   *          the output from the display
   * @return solution in fraction form
   */
  public static String toFraction(final String output)
  {
    String ret = "";
    String answer = output.substring(output.indexOf(EQUALS) + 2);
    String beforeEquals = output.substring(0, output.indexOf(EQUALS) + 2);
    boolean containsImag = false;
    if (answer.contains(I))
    {
      answer = answer.replaceAll(I, "");
      containsImag = true;
    }
    String[] values = answer.split(SPACE);

    ArrayList<String> fractions = new ArrayList<>();
    for (int i = 0; i < values.length; i++)
    {
      try
      {
        fractions.add(convert(Double.parseDouble(values[i])));
      }
      catch (NumberFormatException e)
      {
      }

    }
    // for complex numbers
    try
    {
      ret = fractions.get(0) + SPACE + values[1] + SPACE + fractions.get(1) + I;
    }
    catch (IndexOutOfBoundsException e)
    {
      // for real numbers
      ret = fractions.get(0);
      // add an i for imaginary
      if (containsImag)
      {
        ret += I;
      }
    }
    return beforeEquals + ret;
  }

  /**
   * Converts a decimal into a fraction.
   * 
   * @param value
   *          the decimal value to be converted
   * @return fractional representation
   */
  public static String convert(final double value)
  {
    String a = "" + value;
    // split at decimal point
    String split[] = a.split("\\.");
    int length = split[1].length();
    int denominator = (int) Math.pow(10, length);
    int numerator = (int) (value * denominator);
    int gcd = getGCD(numerator, denominator);
    String fraction = "" + numerator / gcd + FRAC + denominator / gcd;
    return fraction;
  }

  /**
   * Recursive method that computes the GCD.
   * 
   * @param numer
   *          the numerator
   * @param denom
   *          the denominator
   * @return the GCD
   */
  public static int getGCD(final int numer, final int denom)
  {
    if (denom == 0)
    {
      return numer;
    }
    return getGCD(denom, numer % denom);
  }

  /**
   * Converts the solution into a decimal.
   * 
   * @param output
   *          the output from the display
   * @return solution in decimal form
   */
  public static String toDecimal(final String output)
  {
    String ret = "";
    String answer = output.substring(output.indexOf(EQUALS) + 2);
    String beforeEquals = output.substring(0, output.indexOf(EQUALS) + 2);
    boolean containsImag = false;
    if (answer.contains(I))
    {
      answer = answer.replaceAll(I, "");
      containsImag = true;
    }
    String split = answer.replaceAll(FRAC, SPACE);
    String[] values = split.split(SPACE);
    ArrayList<Double> decimals = new ArrayList<>();
    for (int i = 0; i < values.length; i++)
    {
      try
      {
        decimals.add(Double.parseDouble(values[i]));
      }
      catch (NumberFormatException e)
      {
      }
    }
    try
    {
      // for complex numbers
      ret = decimals.get(0) / decimals.get(1) + SPACE + values[2] + SPACE
          + decimals.get(2) / decimals.get(3);
      if (containsImag)
      {
        ret += I;
      }
    }
    catch (IndexOutOfBoundsException e)
    {
      try
      {
        // for real numbers
        ret = decimals.get(0) / decimals.get(1) + "";
        // add an i for imaginary
        if (containsImag)
        {
          ret += I;
        }
      }
      catch (IndexOutOfBoundsException e1)
      {

      }
    }
    return beforeEquals + ret;
  }
}
