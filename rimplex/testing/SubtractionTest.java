package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Arithmetic;
import util.Expression;
import util.InvalidExpressionException;
import util.OverflowException;

class SubtractionTest
{

  @Test
  void testBothReal() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(5.0, 0.0, 1, '+');
    Expression exp2 = new Expression(3.0, 0.0, 1, '+');
    Expression expected = new Expression(2.0, 0.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

  @Test
  void testBothNegativeReal() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(-5.0, 0.0, 1, '+');
    Expression exp2 = new Expression(-3.0, 0.0, 1, '+');
    Expression expected = new Expression(-2.0, 0.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

  @Test
  void testBothImag() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(0.0, 7.0, 1, '+');
    Expression exp2 = new Expression(0.0, 1.0, 1, '+');
    Expression expected = new Expression(0.0, 6.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

  @Test
  void testComplexAndReal() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(11.0, 7.0, 1, '+');
    Expression exp2 = new Expression(4.0, 0.0, 1, '+');
    Expression expected = new Expression(7.0, 7.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

  @Test
  void testBothComplex() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(12.0, 4.0, 1, '+');
    Expression exp2 = new Expression(16.0, 5.0, 1, '+');
    Expression expected = new Expression(-4.0, -1.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

  @Test
  void testSubtractSame() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(100.0, 100.0, 1, '+');
    Expression exp2 = new Expression(100.0, 100.0, 1, '+');
    Expression expected = new Expression(0.0, 0.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

  @Test
  void testSubtractionWithBothMinus() throws InvalidExpressionException, OverflowException
  {
    Expression exp1 = new Expression(370.0, 370.0, 1, '-');
    Expression exp2 = new Expression(370.0, 370.0, 1, '-');
    Expression expected = new Expression(0.0, 0.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testSubtractionWithSingleMinus() throws InvalidExpressionException, OverflowException
  {
    Expression exp1 = new Expression(5.0, 5.0, 1, '+');
    Expression exp2 = new Expression(5.0, 5.0, 1, '-');
    Expression expected = new Expression(0.0, 10.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(5.0, 5.0, 1, '-');
    exp2 = new Expression(5.0, 5.0, 1, '+');
    expected = new Expression(0.0, -10.0, 1, '+');
    result = Arithmetic.subtraction(exp1, exp2);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testRandomTests() throws OverflowException, InvalidExpressionException
  {
    Expression exp1 = new Expression(0.0, 0.0, 1, '+');
    Expression exp2 = new Expression(0.0, 0.0, 1, '+');
    Expression expected = new Expression(0.0, 0.0, 1, '+');
    Expression result = Arithmetic.subtraction(exp1, exp2);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(13.5, 0.0, 1, '+');
    exp2 = new Expression(2.25, 0.0, 1, '+');
    expected = new Expression(11.25, 0.0, 1, '+');
    result = Arithmetic.subtraction(exp1, exp2);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(-8.0, -7.0, 1, '+');
    exp2 = new Expression(-8.0, -7.0, 1, '+');
    expected = new Expression(0.0, 0.0, 1, '+');
    result = Arithmetic.subtraction(exp1, exp2);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(0.0, 0.0, 1, '+');
    exp2 = new Expression(1.0, 0.0, 1, '+');
    expected = new Expression(-1.0, 0.0, 1, '+');
    result = Arithmetic.subtraction(exp1, exp2);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(123.45, 543.21, 1, '+');
    exp2 = new Expression(543.21, 123.45, 1, '+');
    expected = new Expression(-419.76, 419.76, 1, '+');
    result = Arithmetic.subtraction(exp1, exp2);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(63.0, 0.0, 1, '+');
    exp2 = new Expression(0.0, 27.0, 1, '+');
    expected = new Expression(63.0, -27.0, 1, '+');
    result = Arithmetic.subtraction(exp1, exp2);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }

}
