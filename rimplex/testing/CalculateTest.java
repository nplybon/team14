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

  /*
  @Test
  void testCalculateConstructor() throws InvalidExpressionException, OverflowException {
     Expression exp1 = new Expression(2.0, 8.0, 1, '+');
     exp1.getSymbol().setExpPower(2);
     Expression exp2 = new Expression(3.0, 10.0, 1, '-');
     Expression[] exps = {exp1, exp2};
     Operator[] ops = {Operator.SUBTRACTION};
     Calculate calc = new Calculate(exps, ops);
     Expression result = calc.calculateExpression();
     assertEquals(result.getReal(), -63.0, 0.001);
     assertEquals(result.getImagCoef(), 42.0, 0.001);
  }*/
  
  @Test
  void testCalculateConstructor2() throws InvalidExpressionException, OverflowException {
     Expression exp1 = new Expression(5.5, 9.0, 1, '-');
     exp1.getSymbol().setExpPower(2);
     Expression exp2 = new Expression(0.5, 1.2, 1, '+');
     exp2.getSymbol().setExpPower(3);
     Expression[] exps = {exp1, exp2};
     Operator[] ops = {Operator.MULTIPLICATION};
     Calculate calc = new Calculate(exps, ops);
     Expression result = calc.calculateExpression();
     assertEquals(result.getReal(), -249.33475, 0.001);
     assertEquals(result.getImagCoef(), -486.387, 0.001);
  }
  /*
  @Test
  void testCalculateConstructor3() throws InvalidExpressionException, OverflowException {
     Expression exp1 = new Expression(2.0, 8.0, 1, '+');
     exp1.getSymbol().setExpPower(3);
     Expression exp2 = new Expression(3.0, 10.0, 1, '-');
     Expression[] exps = {exp1, exp2};
     Operator[] ops = {Operator.DIVISION};
     Calculate calc = new Calculate(exps, ops);
     Expression result = calc.calculateExpression();
     assertEquals(result.getReal(), 27.816513761468, 0.001);
     assertEquals(result.getImagCoef(), -45.94495412844, 0.001);
  }*/

}
