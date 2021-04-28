package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Arithmetic;
import util.Expression;
import util.InvalidExpressionException;
import util.OverflowException;

class MultiplicationTest
{

  @Test
  void testMultiplicationTwoRealNoImag() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(5.0, 0.0, 1, '+');
    Expression right = new Expression(3.0, 0.0, 1, '+');
    Expression expected = new Expression(15.0, 0.0, 1, '+');
    Expression result = Arithmetic.multiplication(left, right);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testMultiplicationTwoComplex() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(5.0, 3.0, 1, '+');
    Expression right = new Expression(3.0, 2.0, 1, '+');
    Expression expected = new Expression(9.0, 19.0, 1, '+');
    Expression result = Arithmetic.multiplication(left, right);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testMultiplicationOneRealOneCompelx() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(5.0, 0.0, 1, '+');
    Expression right = new Expression(3.0, 3.0, 1, '+');
    Expression expected = new Expression(15.0, 15.0, 1, '+');
    Expression result = Arithmetic.multiplication(left, right);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testMultiplicationTwoNegativeNoImag() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(-5.0, 0.0, 1, '+');
    Expression right = new Expression(-3.0, 0.0, 1, '+');
    Expression expected = new Expression(15.0, 0.0, 1, '+');
    Expression result = Arithmetic.multiplication(left, right);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testMultiplicationOneNegativeNoImag() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(-5.0, 0.0, 1, '+');
    Expression right = new Expression(3.0, 0.0, 1, '+');
    Expression expected = new Expression(-15.0, 0.0, 1, '+');
    Expression result = Arithmetic.multiplication(left, right);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testMultiplicationOneNegativeComplex() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(-5.0, 5.0, 1, '+');
    Expression right = new Expression(3.0, 4.0, 1, '+');
    Expression expected = new Expression(-35.0, -5.0, 1, '+');
    Expression result = Arithmetic.multiplication(left, right);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testMultiplicationOverflowOnReal() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(Double.MAX_VALUE, 5.0, 1, '+');
    Expression right = new Expression(3.0, 4.0, 1, '+');
    assertThrows(OverflowException.class, () -> Arithmetic.multiplication(left, right));
  }

  @Test
  void testMultiplicationOverflowOnCoef() throws OverflowException, InvalidExpressionException
  {
    Expression left = new Expression(5.0, Double.MAX_VALUE, 1, '+');
    Expression right = new Expression(3.0, 4.0, 1, '+');
    assertThrows(OverflowException.class, () -> Arithmetic.multiplication(left, right));
  }

}
