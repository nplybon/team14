package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Calculate;
import util.Expression;
import util.InvalidExpressionException;
import util.Operator;
import util.OverflowException;

class CalculateTest
{

  @Test
  void testCalculateConstructor() throws InvalidExpressionException, OverflowException {
     Expression exp1 = new Expression(2.0, 8.0, 1, '+');
     exp1.getSymbol().setExpPower(2);
     Expression exp2 = new Expression(3.0, 10.0, 1, '-');
     Expression[] exps = {exp1, exp2};
     Operator[] ops = {Operator.ADDITION};
     Calculate calc = new Calculate(exps, ops);
     Expression result = calc.calculateExpression();
     assertEquals(result.getReal(), -57.0, 0.001);
     assertEquals(result.getImagCoef(), 22.0, 0.001);
  }
  
  @Test
  void testCalculateAddition()
  {
    fail("Not yet implemented");
  }

}
