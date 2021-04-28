package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Arithmetic;
import util.Expression;
import util.InvalidExpressionException;
import util.OverflowException;

class InverseTest
{

  @Test
  void testOnlyReal() throws InvalidExpressionException, OverflowException
  {
    Expression exp1 = new Expression(2.0, 0.0, 1, '+');
    Expression expected = new Expression(.5, 0.0, 1, '+');
    Expression result = Arithmetic.inverse(exp1);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

    exp1 = new Expression(-10.0, 0.0, 1, '+');
    expected = new Expression(-.1, 0.0, 1, '+');
    result = Arithmetic.inverse(exp1);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testOnlyImag() throws InvalidExpressionException, OverflowException
  {
    Expression exp1 = new Expression(0.0, 9.0, 1, '+');
    Expression expected = new Expression(0.0, 0.11111, 1, '-');
    Expression result = Arithmetic.inverse(exp1);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, -0.11111, 0.0001);

    exp1 = new Expression(0.0, 50.0, 1, '-');
    expected = new Expression(0.0, 0.02, 1, '+');
    result = Arithmetic.inverse(exp1);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testComplexNumber() throws InvalidExpressionException, OverflowException
  {
    Expression exp1 = new Expression(4.0, 2.0, 1, '+');
    Expression expected = new Expression(0.2, 0.1, 1, '-');
    Expression result = Arithmetic.inverse(exp1);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, -0.1, 0.0001);

    exp1 = new Expression(4.0, 2.0, 1, '-');
    expected = new Expression(0.2, 0.1, 1, '+');
    result = Arithmetic.inverse(exp1);

    expectedReal = expected.getReal();
    resultReal = result.getReal();
    expectedCoef = expected.getImagCoef();
    resultCoef = result.getImagCoef();

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }

  @Test
  void testInverseZero() throws InvalidExpressionException
  {
    Expression exp1 = new Expression(0.0, 0.0, 1, '+');
    assertThrows(InvalidExpressionException.class, () -> {
      Arithmetic.inverse(exp1);
    });

  }
  
  @Test
  void testInverseWithNegativeAndMinus() throws InvalidExpressionException, OverflowException {
    Expression exp1 = new Expression(-1.0, -1.0, 1, '-');
    Expression expected = new Expression(-0.5, 0.5, 1, '-');
    Expression result = Arithmetic.inverse(exp1);

    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    char expectedSymbol = expected.getSymbol().getSymbol();
    char resultSymbol = result.getSymbol().getSymbol();
    

    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, -0.5, 0.1);
    assertEquals(expectedSymbol, resultSymbol);
  }

}
