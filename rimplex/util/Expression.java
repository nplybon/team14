package util;

/**
 * Writes out an expression, currently expressions need both a real and
 * imaginary number.
 * 
 * @author John Curley
 */
public class Expression {

  private Double real = null;
  private Double imagCoef = null;
  private int imagPower = 0;
  private ImaginaryNumber i = ImaginaryNumber.ONE;
  private Operator op = Operator.ADDITION;
  private int expPower = 0;
  private boolean realNumber = false;
  private boolean imagNumber = false;
  private boolean hasExponent = false;
  private boolean hasLog = false;
  private boolean hasSqrt = false;
  private boolean hasInv = false;
  private boolean hasConj = false;
  private boolean realExp = false;
  private boolean imagExp = false;
  private Double displayReal = 0.0;
  private Double displayImagCoef = 0.0;
  private int displayImagPower = 0;

  /**
   * Constructor with only real number.
   * 
   * @param real Double the real number.
   */
  public Expression(Double real)
  {
    this.real = real;
    imagCoef = 0.0;
    imagPower = 1;
    i = i.fromPower(1);
    op = op.fromSymbol('+');
    realNumber = true;
    displayReal = real;
    displayImagCoef = imagCoef;
    displayImagPower = imagPower;
  }
  
  /**
   * Constructor with only imaginary number.
   * 
   * @param imagCoef Double imaginary number coefficient
   * @param imagPower int the power of the imaginary number
   */
  public Expression(Double imagCoef, int imagPower)
  {
    real = 0.0;
    this.imagCoef = imagCoef;
    this.imagPower = imagPower;
    i = i.fromPower(imagPower);
    op = op.fromSymbol('+');
    imagNumber = true;
    displayReal = real;
    displayImagCoef = imagCoef;
    displayImagPower = imagPower;
  }
  
  /**
   * Constructor with Imaginary Number Coefficient.
   * 
   * @param real int Real Number in the expression
   * @param imagCoef int Imaginary Number coefficient in the expression
   * @param imagPower int Imaginary Number's power
   * @param symbol String type of Operation in the expression
   * @throws InvalidExpressionException
   */
  public Expression(Double real, Double imagCoef, int imagPower, char symbol)
      throws InvalidExpressionException {
    this.real = real;
    this.imagCoef = imagCoef;
    this.imagPower = imagPower;
    i = i.fromPower(imagPower);
    op = op.fromSymbol(symbol);
    realNumber = true;
    imagNumber = true;
    displayReal = real;
    displayImagCoef = imagCoef;
    displayImagPower = imagPower;
    setAdditionEquation();
  }

  /**
   * Getter for real.
   */
  public Double getReal() {
    return real;
  }

  /**
   * Getter for imaginary coefficient.
   */
  public Double getImagCoef() {
    return imagCoef;
  }
  
  /**
   * Getter for imaginary number
   */
  public ImaginaryNumber getImaginary() {
    return this.i;
  }
  
  /**
   * Checks if the expression is real number only.
   * 
   * @return true if only a real number
   */
  public boolean realOnly()
  {
    return realNumber && !imagNumber;
  }
  
  /**
   * Checks if the expression is imaginary number only.
   * 
   * @return true if only an imaginary number
   */
  public boolean imagOnly()
  {
    return !realNumber && imagNumber;
  }
  
  /**
   * Checks if the expression is a complex number.
   * 
   * @return true if the expression is a complex number
   */
  public boolean isComplex()
  {
    return realNumber && imagNumber;
  }
  
  /**
   * Getter for The symbol between the real portion and the imaginary 
   * portion of a complex number.
   * @return the operation in the Expression
   */
  public Operator getSymbol() {
    return this.op;
  }
  
  /**
   * Sets the power of the exponent.
   * 
   * @param power int Exponent power
   */
  public void setExpPower(int power) {
    expPower = power;
    hasExponent = true;
  }
  
  /**
   * Gets the power of the expression.
   * 
   * @return the exponent power
   */
  public int getExpPower() {
    return expPower;
  }
  
  /**
   * Gets if the expression has an exponent or not.
   * 
   * @return true if the expression has an exponent, false if not
   */
  public boolean hasExponent() {
    return hasExponent;
  }
  
  /**
   * Sets the hasLog boolean to true.
   */
  public void setLog() {
    hasLog = true;
  }
  
  /**
   * Gets if the expression is a natural log expression.
   * 
   * @return true is the expression is a natural log expression, false if not
   */
  public boolean hasLog() {
    return hasLog;
  }
  
  public void setSqrt() {
    hasSqrt = true;
  }
  
  public boolean hasSqrt() {
    return hasSqrt;
  }
  
  public void setInverse() {
    hasInv = true;
  }
  
  public boolean hasInverse() {
    return hasInv;
  }
  
  public void setConjugate() {
    hasConj = true;
  }
  
  public boolean hasConjugate() {
    return hasConj;
  }
  
  /**
   * Sets a Subtraction Complex Number equation to an Addition equation.
   */
  public void setAdditionEquation() {
    if (op.equals(Operator.SUBTRACTION)) {
      op = op.fromSymbol('+');
      imagCoef *= -1;
    }
  }
  
  /**
   * Gets the conjugate of the expression.
   * 
   * @return the conjugate of the expression
   * @throws InvalidExpressionException
   */
  public Expression getConjugate() throws InvalidExpressionException {
    return Arithmetic.conjugate(this);
  }
  
  /**
   * Gets the inverse of the expression.
   * 
   * @return the inverse of the expression
   * @throws InvalidExpressionException
   * @throws OverflowException
   */
  public Expression getInverse() throws InvalidExpressionException, OverflowException {
    return Arithmetic.inverse(this);
  }
  
  public Expression getRealPart() throws InvalidExpressionException {
    return Arithmetic.realPart(this);
  }
  
  public Expression getImagPart() throws InvalidExpressionException {
    return Arithmetic.imagPart(this);
  }

  public void setRealExpression() {
    realExp = true;
    imagCoef = 0.0;
    imagPower = 0;
  }
  
  public void setImaginaryExpression() {
    imagExp = true;
    real = 0.0;
  }
  
  /**
   * Simplifies.
   * 
   * @throws InvalidExpressionException
   */
  public void simplify() throws InvalidExpressionException {
    if (op.equals(Operator.ADDITION) && imagCoef < 0) {
      op = op.fromSymbol('-');
      imagCoef *= -1;
    }
    if (op.equals(Operator.SUBTRACTION) && imagCoef < 0) {
      op = op.fromSymbol('+');
      imagCoef *= -1;
    }
  }

  /**
   * Returns the expression in a String.
   */
  public String toString() {
    
    String str = "";
    
    if (hasLog) {
      str += "log";
    }
    if (hasSqrt) {
      str += "sqrt";
    }
    if (hasConj) {
      str += "conj";
    }
    if (hasInv) {
      str += "inv";
    }
    if (realExp) {
      str += "real";
    }
    if (imagExp) {
      str += "imag";
    }
    
    if (realNumber && imagNumber)
    {
      str += "(" + displayReal + " " + op.toString() + " " + i.toString(displayImagCoef) + ")";
    }
    else
    {
      if (realNumber && !imagNumber)
      {
        str += "" + displayReal;
      }
      if (!realNumber && imagNumber)
      {
        str += i.toString(displayImagCoef);
      }
    }
    
    if (hasExponent) {
      str += "^" + expPower;
    }

    return str;

  }

}