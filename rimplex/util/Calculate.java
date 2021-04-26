package util;

import java.util.ArrayList;

/**
 * **UNFINISHED AND UNTESTED** Calculates every expression using order of
 * operations.
 * 
 * @author John Curley
 */
public class Calculate {

  private Expression[] expressions;
  private Operator[] operators;
  private int[] order;
  private ArrayList<String> steps;

  /**
   * Constructor.
   * 
   * @param expressions Expression[] all the expression
   * @param operators Operator[] all the operators
   */
  public Calculate(Expression[] expressions, Operator[] operators) {
    this.expressions = expressions;
    this.operators = operators;
    order = orderOfOperations(operators);
    steps = new ArrayList<>();
  }

  /**
   * Calculates a set of Expressions.
   * 
   * @param exp1 Expression the right expression
   * @param op Operator the operator of the expressions
   * @param exp2 Expression the left expression
   * @return the result expression
   * @throws OverflowException
   * @throws InvalidExpressionException 
   */
  private Expression calculate(Expression exp1, Operator op, Expression exp2)
      throws OverflowException, InvalidExpressionException {

    Expression result = null;

    switch (op) {
      case ADDITION:
        result = Arithmetic.addition(exp1, exp2);
        break;
      case SUBTRACTION:
        result = Arithmetic.subtraction(exp1, exp2);
        break;
      case MULTIPLICATION:
        result = Arithmetic.multiplication(exp1, exp2);
        break;
      case DIVISION:
        result = Arithmetic.division(exp1, exp2);
        break;
      case EXPONENT:
        result = Arithmetic.exponent(exp1);
        break;
      case LOGARITHM:
        result = Arithmetic.naturalLog(exp1);
        break;
      case REAL:
    	break;
      case IMAGINARY:
    	break;
    }

    return result;
  }

  /**
   * Calculates the entire set of expressions.
   * 
   * @return the final calculated expression.
   * @throws OverflowException
   * @throws InvalidExpressionException 
   */
  public Expression calculateExpression() throws OverflowException, InvalidExpressionException {

    Expression result = null;
    
    steps.add(takeStep());
    
    for (int i = 0; i < expressions.length; i++) {
      if (expressions[i].hasExponent()) {
        result = calculate(expressions[i], Operator.EXPONENT, null);
        expressions[i] = result;
      }
      if (expressions[i].hasLog()) {
        result = calculate(expressions[i], Operator.LOGARITHM, null);
        expressions[i] = result;
      }
    }
    
    for (int i = 0; i < order.length; i++) {
      result = calculate(expressions[order[i]], operators[order[i]],
          expressions[order[i] + 1]);
      expressions[order[i]] = result;
      expressions[order[i] + 1] = result;
      //steps.add(takeStep());
    }

    result.simplify();
    
    return result;

  }

  private String takeStep() {
    
    String str = "";
    
    for ( int i = 0; i < operators.length; i++ ) {
      str += expressions[i].toString() + " " + operators[i].toString() + " "; 
    }
    str += expressions[expressions.length-1].toString();
    System.out.println(str);
    
    return str;
  }
  
  /**
   * Determines the order of operations.
   * 
   * @param operators Operator[] all the operators used
   * @return array of the indexes for the correct order of operations
   */
  private int[] orderOfOperations(Operator[] operators) {

    int index = 0;
    int[] order = new int[operators.length];
    
    for (int i = 0; i < operators.length; i++) {
      if (operators[i].equals(Operator.MULTIPLICATION)
          || operators[i].equals(Operator.DIVISION)) {
        order[index] = i;
        index++;
      }
    }

    for (int i = 0; i < operators.length; i++) {
      if (operators[i].equals(Operator.ADDITION)
          || operators[i].equals(Operator.SUBTRACTION)) {
        order[index] = i;
        index++;
      }
    }

    return order;
  }
}
