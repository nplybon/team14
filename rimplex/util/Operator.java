package util;

/**
 * Operator enum of the different kind of operations.
 * 
 * @author John Curley
 */
public enum Operator {

  ADDITION('+', "sum", 0), SUBTRACTION('-', "difference", 0),
  MULTIPLICATION('x', "product", 0), DIVISION('/', "quoitent", 0), 
  EXPONENT('^', "exponent", 0), LOGARITHM('l', "logarithm", 0),
  INVERSE('v', "inverse", 0), CONJUGATE('c', "conjugate", 0);

  private char symbol;
  private String type;
  private int expPower;

  /**
   * Constructor.
   * 
   * @param symbol char Operator symbol
   * @param type String name of Operator result
   */
  private Operator(char symbol, String type, int expPower) {
    this.symbol = symbol;
    this.type = type;
    this.expPower = expPower;
  }

  /**
   * Creates an Operator from the operation symbol.
   * 
   * @param symbol char Operator symbol
   * @return Operator
   */
  public Operator fromSymbol(char symbol) {

    Operator op;

    switch (symbol) {
      case '+':
        op = Operator.ADDITION;
        break;
      case '-':
        op = Operator.SUBTRACTION;
        break;
      case '*':
        op = Operator.MULTIPLICATION;
        break;
      case 'x':
        op = Operator.MULTIPLICATION;
        break;
      case '/':
        op = Operator.DIVISION;
        break;
      case '^':
        op = Operator.EXPONENT;
        break;
      case 'l':
        op = Operator.LOGARITHM;
        break;
      case 'v':
        op = Operator.INVERSE;
        break;
      case 'c':
        op = Operator.CONJUGATE;
        break;
      default:
        op = null;
        break;
    }

    return op;
  }

  /**
   * Gets the symbol of the Operator.
   * 
   * @return symbol
   */
  public char getSymbol() {
    return symbol;
  }

  /**
   * Gets the result name of the Operator.
   * 
   * @return result name
   */
  public String getResultType() {
    return type;
  }
  
  /**
   * Sets the Exponent.
   * 
   * @param power the exponent
   */
  public void setExpPower(int power) {
    expPower = power;
  }
  
  /**
   * Gets the exponent.
   * 
   * @return the exponent.
   */
  public int getExpPower() {
    return expPower;
  }

  /**
   * Returns just the Operator symbol.
   */
  public String toString() {
    return "" + symbol;
  }
}