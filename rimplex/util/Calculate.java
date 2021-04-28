package util;

import java.util.ArrayList;

/**
 * Calculates every expression using order of operations.
 * 
 * @author John Curley
 */
public class Calculate
{

  private Expression[] expressions;
  private Operator[] operators;
  private int[] order;
  private ArrayList<String> steps;
  private ArrayList<Integer> skips;

  private String space = " ";

  /**
   * Constructor.
   * 
   * @param expressions
   *          Expression[] all the expression
   * @param operators
   *          Operator[] all the operators
   */
  public Calculate(final Expression[] expressions, final Operator[] operators)
  {
    this.expressions = expressions;
    this.operators = operators;
    order = orderOfOperations(operators);
    steps = new ArrayList<>();
    skips = new ArrayList<>();
  }

  /**
   * Calculates a set of Expressions.
   * 
   * @param exp1
   *          Expression the right expression
   * @param op
   *          Operator the operator of the expressions
   * @param exp2
   *          Expression the left expression
   * @return the result expression
   * @throws OverflowException
   * @throws InvalidExpressionException
   */
  private Expression calculate(final Expression exp1, final Operator op, final Expression exp2)
      throws OverflowException, InvalidExpressionException
  {

    Expression result = null;

    switch (op)
    {
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
      case SQUAREROOT:
        result = Arithmetic.squareRoot(exp1);
        break;
      case INVERSE:
        result = Arithmetic.inverse(exp1);
        break;
      case CONJUGATE:
        result = Arithmetic.conjugate(exp1);
        break;
      default:
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
  public Expression calculateExpression() throws OverflowException, InvalidExpressionException
  {

    Expression result = null;
    int count = 1;

    steps.add(takeStep(count, Operator.NOTHING));

    for (int i = 0; i < expressions.length; i++)
    {
      if (expressions[i].hasExponent())
      {
        result = calculate(expressions[i], Operator.EXPONENT, null);
        expressions[i] = result;
        count++;
        steps.add(takeStep(count, Operator.EXPONENT));
        System.out.println(result);
      }
      if (expressions[i].hasLog())
      {
        result = calculate(expressions[i], Operator.LOGARITHM, null);
        expressions[i] = result;
        count++;
        steps.add(takeStep(count, Operator.LOGARITHM));
      }
      if (expressions[i].hasSqrt())
      {
        result = calculate(expressions[i], Operator.SQUAREROOT, null);
        expressions[i] = result;
        count++;
        steps.add(takeStep(count, Operator.SQUAREROOT));
      }
      if (expressions[i].hasInverse())
      {
        result = calculate(expressions[i], Operator.INVERSE, null);
        expressions[i] = result;
        count++;
        steps.add(takeStep(count, Operator.INVERSE));
      }
      if (expressions[i].hasConjugate())
      {
        result = calculate(expressions[i], Operator.CONJUGATE, null);
        expressions[i] = result;
        count++;
        steps.add(takeStep(count, Operator.CONJUGATE));
      }
    }

    for (int i = 0; i < order.length; i++)
    {
      result = calculate(expressions[order[i]], operators[order[i]], expressions[order[i] + 1]);
      expressions[order[i]] = result;
      expressions[order[i] + 1] = result;
      skips.add(order[i]);
      count++;
      steps.add(takeStep(count, operators[order[i]]));
    }

    result.simplify();

    return result;

  }

  /**
   * Takes step of the equation after each order of operation is executed.
   * 
   * @param count
   *          int the number of the step
   * @param type
   *          Operator the Operation type
   * @return String of the step with its count and instruction performed
   */
  private String takeStep(final int count, final Operator type)
  {

    String str = "(" + count + ")   ";

    if (expressions.length > 1)
    {
      if (skips.size() < operators.length)
      {
        for (int i = 0; i < expressions.length; i++)
        {
          if (!skips.contains(i))
          {
            str += expressions[i].toString() + space;
          }
          if (i < operators.length)
          {
            if (!skips.contains(i))
            {
              str += operators[i].toString() + space;
            }
          }
        }
      }
      else
      {
        str += expressions[skips.get(skips.size() - 1)].toString() + space;
      }
    }
    else
    {
      str += expressions[0].toString() + space;
    }

    switch (type)
    {
      case NOTHING:
        str += "Initial Equation";
        break;
      case ADDITION:
      case SUBTRACTION:
      case MULTIPLICATION:
      case DIVISION:
        str += "   Preformed " + type.getType();
        break;
      case EXPONENT:
      case LOGARITHM:
      case SQUAREROOT:
      case INVERSE:
      case CONJUGATE:
        str += "   Took " + type.getType();
        break;
      default:
        break;
    }
    
    return str;
  }

  /**
   * Gets the Intermediate Steps of the Calculated Equation.
   * 
   * @return the steps
   */
  public ArrayList<String> getSteps()
  {
    return steps;
  }

  /**
   * Determines the order of operations.
   * 
   * @param operators
   *          Operator[] all the operators used
   * @return array of the indexes for the correct order of operations
   */
  private int[] orderOfOperations(final Operator[] operators)
  {

    int index = 0;
    int[] order = new int[operators.length];

    for (int i = 0; i < operators.length; i++)
    {
      if (operators[i].equals(Operator.MULTIPLICATION) || operators[i].equals(Operator.DIVISION))
      {
        order[index] = i;
        index++;
      }
    }

    for (int i = 0; i < operators.length; i++)
    {
      if (operators[i].equals(Operator.ADDITION) || operators[i].equals(Operator.SUBTRACTION))
      {
        order[index] = i;
        index++;
      }
    }

    return order;
  }
}
