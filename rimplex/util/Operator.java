package util;

/**
 * Operator enum of the different kind of operations.
 * 
 * @author John Curley
 */
public enum Operator {

  ADDITION('+', "sum"), SUBTRACTION('-', "difference"),
  MULTIPLICATION('x', "product"), DIVISION('/', "quoitent"), 
  EXPONENT('^', "exponent"), LOGARITHM('l', "logarithm"),
  INVERSE('v', "inverse"), CONJUGATE('c', "conjugate"), 
  SQUAREROOT('2', "square root"), REAL('r', "real"), 
  IMAGINARY('m', "imaginary");

  private char symbol;
  private String type;

  /**
   * Constructor.
   * 
   * @param symbol char Operator symbol
   * @param type String name of Operator result
   */
  private Operator(char symbol, String type) {
    this.symbol = symbol;
    this.type = type;
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
      case '2':
        op = Operator.SQUAREROOT;
        break;
      case 'r':
    	  op = Operator.REAL;
    	  break;
      case 'm':
    	  op = Operator.IMAGINARY;
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
   * Returns just the Operator symbol.
   */
  public String toString() {
    return "" + symbol;
  }
}