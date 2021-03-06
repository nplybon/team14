package util;

/**
 * @author Hunter Mann
 * @author Nic Plybon
 * @version 2-26-2021
 * 
 *          This class houses the arithmetic algorithms that will be performed on the operands based
 *          on the Operators in the Expression
 */
public class Arithmetic
{

  private static String OVERFLOW = "Overflow";

  /**
   * Performs addition operation on two Expression objects.
   * 
   * @param exp1
   *          "left" expression
   * @param exp2
   *          "right" expression
   * @return resultant expression; null if one, or both, expression/s is/are null
   * @throws OverflowException
   *           when positive overflow has occurred when performing the operation
   * @throws InvalidExpressionException
   *           if expression operands are invalid
   */
  public static Expression addition(final Expression exp1, final Expression exp2)
      throws OverflowException, InvalidExpressionException
  {
    // null argument checking
    if (exp1 == null || exp2 == null)
    {
      return null;
    }

    // overflow checking (positive)
    if (exp1.getReal() + exp2.getReal() > Double.MAX_VALUE)
    {
      throw new OverflowException(OVERFLOW);
    }

    if (exp1.getImagCoef() + exp2.getImagCoef() > Double.MAX_VALUE)
    {
      throw new OverflowException(OVERFLOW);
    }

    // local variables
    double exp1NewCoef = 0;
    double exp2NewCoef = 0;
    double realResult = exp1.getReal() + exp2.getReal();
    double coefResult;

    if (exp1.getSymbol() == Operator.SUBTRACTION && exp2.getSymbol() != Operator.SUBTRACTION)
    {
      exp1NewCoef = exp1.getImagCoef() * -1;
      exp2NewCoef = exp2.getImagCoef();
    }
    else if (exp1.getSymbol() != Operator.SUBTRACTION && exp2.getSymbol() == Operator.SUBTRACTION)
    {
      exp1NewCoef = exp1.getImagCoef() * -1;
      exp2NewCoef = exp2.getImagCoef();
    }
    else
    {
      exp1NewCoef = exp1.getImagCoef();
      exp2NewCoef = exp2.getImagCoef();
    }

    coefResult = exp1NewCoef + exp2NewCoef;

    // return resultant expression
    return new Expression(realResult, coefResult, 1, '+');
  }

  /**
   * Performs multiplication operation on two Expression objects.
   * 
   * @param exp1
   *          "left" expression
   * @param exp2
   *          "right" expression
   * @return resultant expression; null if one, or both, expression/s is/are null
   * @throws OverflowException
   *           when positive overflow has occurred when performing the operation
   * @throws InvalidExpressionException
   *           if expression operands are invalid
   */
  public static Expression multiplication(final Expression exp1, final Expression exp2)
      throws OverflowException, InvalidExpressionException
  {
    // null argument checking
    if (exp1 == null || exp2 == null)
    {
      return null;
    }

    // overflow checking (positive)
    if (exp1.getReal() * exp2.getReal() > Double.MAX_VALUE)
    {
      throw new OverflowException(OVERFLOW);
    }

    if (exp1.getImagCoef() * exp2.getImagCoef() > Double.MAX_VALUE)
    {
      throw new OverflowException(OVERFLOW);
    }

    Expression mid1;
    Expression mid2;

    double mid1Real = exp1.getReal() * exp2.getReal();
    double mid1Coef = exp1.getReal() * exp2.getImagCoef();
    mid1 = new Expression(mid1Real, mid1Coef, 1, '+');

    double mid2Coef = exp2.getReal() * exp1.getImagCoef();
    double mid2Real = -1 * (exp1.getImagCoef() * exp2.getImagCoef());
    mid2 = new Expression(mid2Real, mid2Coef, 1, '+');

    return addition(mid1, mid2);
  }

  /**
   * Returns the difference of two expressions.
   * 
   * @param exp1
   *          the first expression
   * @param exp2
   *          the second expression
   * @return the difference
   * @throws InvalidExpressionException if expression operands are invalid
   * @throws OverflowException if expression exceeds max or min value of double
   */
  public static Expression subtraction(final Expression exp1, final Expression exp2)
      throws OverflowException, InvalidExpressionException
  {
    Expression e2 = exp2;
    // (a - c) + (b - d)
    if (exp1.getReal().equals(exp2.getReal()) && exp1.getImagCoef().equals(exp2.getImagCoef())
        && exp1.getSymbol().equals(exp2.getSymbol()))
    {
      return new Expression(0.0, 0.0, 1, '+');
    }

    if (exp2.getSymbol() == Operator.SUBTRACTION)
    {
      e2 = new Expression(exp2.getReal() * -1, exp2.getImagCoef(), 1, '+');
    }
    else
    {
      e2 = new Expression(exp2.getReal() * -1, exp2.getImagCoef() * -1, 1, '+');
    }

    return addition(exp1, e2);
  }

  /**
   * Returns the quotients of two expressions.
   * 
   * @param exp1
   *          the first expression
   * @param exp2
   *          the second expression
   * @return the quotient
   * @throws InvalidExpressionException if denominator is 0
   * @throws OverflowException if expression exceeds max or min value of double
   */
  public static Expression division(final Expression exp1, final Expression exp2)
      throws OverflowException, InvalidExpressionException
  {
    // real part = ac + bd / c^2 + d^2
    // imag part = bc - ad / c^2 + d^2
    double firstPart = exp1.getReal() * exp2.getReal() + exp1.getImagCoef() * exp2.getImagCoef();
    double secondPart = exp1.getImagCoef() * exp2.getReal() - exp1.getReal() * exp2.getImagCoef();
    double squaredPart = Math.pow(exp2.getReal(), 2) + Math.pow(exp2.getImagCoef(), 2);
    double realpart = firstPart / squaredPart;
    double imagpart = secondPart / squaredPart;

    if (Double.isNaN(realpart) && Double.isNaN(imagpart))
    {
      throw new InvalidExpressionException("ERROR: CANNOT DIVIDE BY ZERO");
    }
    return new Expression(realpart, imagpart, 1, '+');
  } 
     
  /**
   * Returns the result of an exponent operation.
   * 
   * @param exp
   *          the expression
   * @return the updated expression
   * @throws InvalidExpressionException WAP
   *           if expression operands are invalid
   * @throws OverflowException WAP
   */
  public static Expression exponent(final Expression exp)
      throws InvalidExpressionException, OverflowException
  {

    Expression result = exp;

    for (int i = 1; i < Math.abs(exp.getExpPower()); i++)
    {
      result = multiplication(result, exp);
    }

    if (exp.getExpPower() < 0)
    {
      result = division(new Expression(1.0), result);
    }
    
    if (exp.getExpPower() == 0)
    {
    	result = new Expression(1.0, 0.0, 1, '+');
    }

    return result;
  }

  /**
   * Returns the inverse of the given expression.
   * 
   * @param e
   *          the expression to be inversed
   * @return inverse of the given expression
   * @throws InvalidExpressionException WAP
   * @throws OverflowException WAP
   */
  public static Expression inverse(final Expression e)
      throws InvalidExpressionException, OverflowException
  {
    if (e.getReal() == 0.0 && e.getImagCoef() == 0.0)
    {
      throw new InvalidExpressionException("ERROR: ZERO DOES NOT HAVE AN INVERSE");
    }
    double length = Math.pow(e.getReal(), 2) + Math.pow(e.getImagCoef(), 2);
    return new Expression(e.getReal() / length, -1 * e.getImagCoef() / length, 1,
        e.getSymbol().getSymbol());

  }

  /**
   * Returns the conjugate of the given Expression.
   * 
   * @param exp1
   *          the given Expression
   * @return the expressions conjugate
   * @throws InvalidExpressionException
   *           if expression operands are invalid
   */
  public static Expression conjugate(final Expression exp1) throws InvalidExpressionException
  {

    Expression toReturn;

    if (exp1.getSymbol() == Operator.ADDITION && exp1.getImagCoef() < 0.0)
    {
      toReturn = new Expression(exp1.getReal(), -1 * exp1.getImagCoef(), 1, '+');
    }
    else if (exp1.getSymbol() == Operator.ADDITION && exp1.getImagCoef() >= 0.0)
    {
      toReturn = new Expression(exp1.getReal(), exp1.getImagCoef(), 1, '-');
    }
    else if (exp1.getSymbol() == Operator.SUBTRACTION && exp1.getImagCoef() < 0.0)
    {
      toReturn = new Expression(exp1.getReal(), -1 * exp1.getImagCoef(), 1, '-');
    }
    else if (exp1.getSymbol() == Operator.SUBTRACTION && exp1.getImagCoef() >= 0.0)
    {
      toReturn = new Expression(exp1.getReal(), exp1.getImagCoef(), 1, '+');
    }
    else
    {
      toReturn = null;
    }

    return toReturn;
  }

  /**
   * Calculates the Natural Logarithm of a single Expression.
   * 
   * @param exp1
   *          The given expression
   * @return The Expression that is the result of the Natural Logarithm
   * @throws InvalidExpressionException
   *           if the real portion of the given expression is less than or equal to zero
   */
  public static Expression naturalLog(final Expression exp1) throws InvalidExpressionException
  {

    // error checking
    if (exp1.getReal() == 0)
    {
      throw new InvalidExpressionException("ERROR: CANNOT DIVIDE BY ZERO (in logarithm)");
    }
    if (exp1.getReal() < 0)
    {
      throw new InvalidExpressionException("ERROR: NATURAL LOG UNDEFINED FOR A < 0");
    }

    Expression toReturn;
    double a = exp1.getReal();
    double b = exp1.getImagCoef();
    double a2 = a * a;
    double b2 = b * b;
    boolean isMinus;

    // if operand is real
    if (b == 0)
    {
      return new Expression(Math.log(a), 0.0, 1, '+');
    }

    // change expression to a + bi format
    if (exp1.getSymbol() == Operator.SUBTRACTION)
    {
      isMinus = true;
    }
    else
    {
      isMinus = false;
    }

    double real = Math.log((a2) + (b2)) / 2;
    double imag = Math.atan(b / a);

    // set right sign
    if (!isMinus)
    {
      toReturn = new Expression(real, imag, 1, '+');
    }
    else
    {
      toReturn = new Expression(real, imag, 1, '-');
    }

    return toReturn;
  }

  /**
   * Returns the real part of the given expression in the form a+0i.
   * 
   * @param exp1
   *          the given expression in the form a+bi
   * @return the real part of the given expression
   * @throws InvalidExpressionException
   *           if the expression is not in the form a+bi
   */
  public static Expression realPart(final Expression exp1) throws InvalidExpressionException
  {
    double real = exp1.getReal();
    return new Expression(real, 0.0, 1, '+');
  }

  /**
   * Returns the imaginary part of the given expression in the form 0+bi.
   * 
   * @param exp1
   *          the given expression in the form a+bi
   * @return the imaginary part of the given expression
   * @throws InvalidExpressionException
   *           if the expression is not in the form a+bi
   */
  public static Expression imagPart(final Expression exp1) throws InvalidExpressionException
  {
    double imag = exp1.getImagCoef();
    char sign;
    Operator symbol = exp1.getSymbol();

    if (symbol == Operator.ADDITION)
    {
      sign = '+';
    }
    else
    {
      sign = '-';
    }

    return new Expression(0.0, imag, 1, sign);
  }

  /**
   * Returns the square root of the given expression in the form a+bi.
   * 
   * @param exp1
   *          the given expression in the form a+bi
   * @return the square root of the expression
   * @throws InvalidExpressionException
   *           if the given expression is not in the form a+bi
   */
  public static Expression squareRoot(final Expression exp1) throws InvalidExpressionException
  {
    double x = exp1.getReal();
    double y = exp1.getImagCoef();
    double r = Math.sqrt(Math.sqrt(x * x + y * y));
    double theta = Math.atan2(y, x) / 2;

    return new Expression(r * Math.cos(theta), r * Math.sin(theta), 1, '+');
  }
}
