package util;

/**
 * Writes out an expression, currently expressions need both a real and
 * imaginary number.
 * 
 * @author John Curley
 * @author Hunter Mann
 */
public class Expression {

  private int real;
  private int imagCoef = 0;
  private ImaginaryNumber i = ImaginaryNumber.ONE;
  private Operator op = Operator.ADDITION;

  /**
   * Constructor without Imaginary Number Coefficient.
   * 
   * @param real
   * @param imagPower
   * @param symbol
   */
  public Expression(int real, int imagPower, char symbol) {
    this.real = real;
    i = i.fromPower(imagPower);
    op = op.fromSymbol(symbol);
  }
  
  /**
   * Constructor with Imaginary Number Coefficient.
   * 
   * @param real int Real Number in the expression
   * @param imagCoef int Imaginary Number coefficient in the expression
   * @param imagPower int Imaginary Number's power
   * @param symbol String type of Operation in the expression
   */
  public Expression(int real, int imagCoef, int imagPower, char symbol) {
    this.real = real;
    this.imagCoef = imagCoef;
    i = i.fromPower(imagPower);
    op = op.fromSymbol(symbol);
  }
  
  /**
   * Getter for real.
   */
  public int getReal() {
	  return this.real;
  }
  
  /**
   * Getter for imaginary coefficient.
   */
  public int getImagCoef() {
	  return this.imagCoef;
  }
  
  /**
   * Getter for imaginary number
   */
  public ImaginaryNumber getImaginary() {
	  return this.i;
  }

  /**
   * Returns the expression in a String surrounded by parentheses.
   */
  public String toString() {
    String str = "(" + real + " " + op.toString() + " ";
    
    if (imagCoef != 0) {
      str += i.toString(imagCoef);
    } else {
      str += i.toString();
    }
    
    return str + ")";
  }

}
