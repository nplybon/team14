package util;

/**
 * Writes out an expression, currently expressions need both a real and
 * imaginary number.
 * 
 * @author John Curley
 * @author Hunter Mann
 */
public class Expression {

  private Double real = null;
  private Double imagCoef = null;
  private ImaginaryNumber i = ImaginaryNumber.ONE;
  private Operator op = Operator.ADDITION;

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
   * Getter for the operator symbol.
   */
  public Operator getSymbol() {
    return op;
  }

  /**
   * Getter for imaginary number
   */
  public ImaginaryNumber getImaginary() {
    return this.i;
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
   * Returns the expression in a String surrounded by parentheses.
   */
  public String toString() {
    String str = "(" + real + " " + op.toString() + " " + i.toString(imagCoef);

    return str + ")";
  }

}
