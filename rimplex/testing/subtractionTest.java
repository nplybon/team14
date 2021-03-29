package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Arithmetic;
import util.Expression;

class subtractionTest
{

  @Test
  void testBothReal()
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
  void testBothNegativeReal() {
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
  void testBothImag() {
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
  void testComplexAndReal() {
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
  void testBothComplex() {
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
  void testSubtractSame() {
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
  void testRandomTests() {
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
    
    

  }
  

}
