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
  private ImaginaryNumber i = ImaginaryNumber.ONE;
  private Operator op = Operator.ADDITION;
  private boolean realNumber = false;
  private boolean imagNumber = false;

  /**
   * Constructor with only real number.
   * 
   * @param real Double the real number.
   */
  public Expression(Double real)
  {
    this.real = real;
    imagCoef = 0.0;
    i = i.fromPower(1);
    op = op.fromSymbol('+');
    realNumber = true;
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
    i = i.fromPower(imagPower);
    op = op.fromSymbol('+');
    imagNumber = true;
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
    i = i.fromPower(imagPower);
    op = op.fromSymbol(symbol);
    realNumber = true;
    imagNumber = true;
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
  
  public void setAdditionEquation() {
    if (op.equals(Operator.SUBTRACTION)) {
      op = op.fromSymbol('+');
      imagCoef *= -1;
    }
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
    if (op.equals(Operator.SUBTRACTION) && imagCoef >= 0) {
      op = op.fromSymbol('+');
      imagCoef *= -1;
    }
  }

  /**
   * Returns the expression in a String.
   */
  public String toString() {
    
    String str = "";
    
    if (realNumber && imagNumber)
    {
      str = "(" + real + " " + op.toString() + " " + i.toString(imagCoef) + ")";
    }
    else
    {
      if (realNumber && !imagNumber)
      {
        str = "" + real;
      }
      if (!realNumber && imagNumber)
      {
        str = i.toString(imagCoef);
      }
    }

    return str;
  }

}
