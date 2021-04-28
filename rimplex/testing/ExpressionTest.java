package testing;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import util.Expression;
import util.ImaginaryNumber;
import util.InvalidExpressionException;

class ExpressionTest {

  @Test
  void testAdditionExpression() throws InvalidExpressionException {
    Expression test = new Expression(10.0, 10.0, 1, '+');
    assertEquals(test.getReal(), 10.0, 0.01);
    assertEquals(test.getImagCoef(), 10.0, 0.01);
    assertTrue(test.getImaginary().equals(ImaginaryNumber.ONE));
    assertTrue(test.toString().equals("(10.0 + 10.0i)"));
  }
  
  @Test
  void testAdditionExpression2() throws InvalidExpressionException {
    Expression test = new Expression(10.0, 0.0, 1, '+');
    assertEquals(test.getReal(), 10.0, 0.01);
    assertEquals(test.getImagCoef(), 0.0, 0.01);
    assertTrue(test.getImaginary().equals(ImaginaryNumber.ONE));
    assertTrue(test.toString().equals("(10.0 + 0.0i)"));
  }

  @Test
  void testSubtractionExpression() throws InvalidExpressionException {
    Expression test = new Expression(25.0, 5.5, 1, '-');
    assertEquals(test.getReal(), 25.0, 0.01);
    assertEquals(test.getImagCoef(), -5.5, 0.01);
    assertTrue(test.getImaginary().equals(ImaginaryNumber.ONE));
    assertTrue(test.toString().equals("(25.0 + -5.5i)"));
  }

  @Test
  void testAdditionExpressionSimplified() throws InvalidExpressionException {
    Expression test = new Expression(7.0, -8.5, 1, '+');
    assertEquals(test.getReal(), 7.0, 0.01);
    assertEquals(test.getImagCoef(), -8.5, 0.01);
    assertTrue(test.getImaginary().equals(ImaginaryNumber.ONE));
    assertTrue(test.toString().equals("(7.0 + -8.5i)"));
  }

  @Test
  void testSubtractionExpressionSimplified() throws InvalidExpressionException {
    Expression test = new Expression(5.0, -5.0, 1, '-');
    assertEquals(test.getReal(), 5.0, 0.01);
    assertEquals(test.getImagCoef(), 5.0, 0.01);
    assertTrue(test.getImaginary().equals(ImaginaryNumber.ONE));
    assertTrue(test.toString().equals("(5.0 + 5.0i)"));
  }
}
