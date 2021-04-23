package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.*;

class ExponentTest {

  @Test
  void testExponentZero() throws InvalidExpressionException, OverflowException {
    Expression exp = new Expression(8.0, 2.0, 1, '+');
    exp.setExpPower(0);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), 8.0, 0.001);
    assertEquals(result.getImagCoef(), 2.0, 0.001);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testExponent() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(8.0, 2.0, 1, '+');
    exp.setExpPower(3);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), 416.0, 0.001);
    assertEquals(result.getImagCoef(), 376.0, 0.001);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testExponent2() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(7.3, 13.2, 1, '-');
    exp.setExpPower(2);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), -120.95, 0.1);
    assertEquals(result.getImagCoef(), -192.72, 0.1);
    assertEquals(result.getImaginary().getPower(), 1);
    
  }
  
  @Test
  void testExponent3() throws InvalidExpressionException, OverflowException {
    
    Expression exp1 = new Expression(5.5, 9.0, 1, '-');
    exp1.setExpPower(2);
    Expression result = Arithmetic.exponent(exp1);
    assertEquals(result.getReal(), -50.75, 0.1);
    assertEquals(result.getImagCoef(), -99.0, 0.1);
    assertEquals(result.getImaginary().getPower(), 1);
    
  }
  
  @Test
  void testExponentBig() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(8.0, 2.0, 1, '+');
    exp.setExpPower(10);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), -1119667200.0, 0.001);
    assertEquals(result.getImagCoef(), 927506432.0, 0.001);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testExponentBig2() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(7.3, 13.2, 1, '-');
    exp.setExpPower(10);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), -202948434174.17, 0.1);
    assertEquals(result.getImagCoef(), 575046172764.38, 0.1);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testNegativeExponent() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(2.0, 8.0, 1, '+');
    exp.setExpPower(-2);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), -0.012975778546713, 0.001);
    assertEquals(result.getImagCoef(), -0.0069204152249135, 0.001);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testNegativeExponent2() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(7.3, 13.2, 1, '-');
    exp.setExpPower(-3);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), -0.00029092276087185, 0.001);
    assertEquals(result.getImagCoef(), -0.000016103293143686, 0.001);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testNegativeExponent3() throws InvalidExpressionException, OverflowException {
    
    Expression exp = new Expression(10.0, 5.0, 1, '-');
    exp.setExpPower(-1);
    Expression result = Arithmetic.exponent(exp);
    assertEquals(result.getReal(), 0.08, 0.001);
    assertEquals(result.getImagCoef(), 0.04, 0.001);
    assertEquals(result.getImaginary().getPower(), 1);
  }
  
  @Test
  void testImaginaryNumber() throws InvalidExpressionException, OverflowException {
    Expression exp1 = new Expression(0.0, 1.0, 1, '+');
    exp1.setExpPower(2);
    Expression exp2 = new Expression(-4.0, 0.0, 1, '+');
    Expression[] exps = {exp1, exp2};
    Operator[] ops = {Operator.ADDITION};
    Calculate calc = new Calculate( exps, ops);
    Expression result = calc.calculateExpression();
    assertEquals(result.getReal(), -5.0, 0.001);
    assertEquals(result.getImagCoef(), 0.0, 0.001);
  }

}