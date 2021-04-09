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
    //simplify();
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
   * Getter for The symbol between the real portion and the imaginary 
   * portion of a complex number.
   * @return the operation in the Expression
   */
  public Operator getSymbol() {
	  return this.op;
  }

  /**
   * Simplifies Addition, Subtraction, Multiplication Expressions, Division
   * Expressions only check for divide by zero currently.
   * 
   * @throws InvalidExpressionException
   */
  private void simplify() throws InvalidExpressionException {
    switch (op) {
      case ADDITION:
        if (imagCoef < 0) {
          op = op.fromSymbol('-');
          imagCoef *= -1;
        }
        break;
      case SUBTRACTION:
        if (imagCoef < 0) {
          op = op.fromSymbol('+');
          imagCoef *= -1;
        }
        break;
      case MULTIPLICATION:
        imagCoef *= real;
        real = 0.0;
        op = op.fromSymbol('+');
        simplify();
        break;
      case DIVISION:
        if (imagCoef == 0.0) {
          throw new InvalidExpressionException("Cannot Divide by Zero");
        }
        break;
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
