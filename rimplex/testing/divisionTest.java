package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Arithmetic;
import util.Expression;

class divisionTest
{

  @Test
  void testBothReal()
  {
    Expression exp1 = new Expression(15.0, 0.0, 1, '+');
    Expression exp2 = new Expression(3.0, 0.0, 1, '+');
    Expression expected = new Expression(5.0, 0.0, 1, '+');
    Expression result = Arithmetic.division(exp1, exp2);
    
    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    
    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);

  }
  
  @Test
  void testBothNegativeReal() {
    Expression exp1 = new Expression(-20.0, 0.0, 1, '+');
    Expression exp2 = new Expression(-4.0, 0.0, 1, '+');
    Expression expected = new Expression(5.0, 0.0, 1, '+');
    Expression result = Arithmetic.division(exp1, exp2);
    
    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    
    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }
  
  @Test
  void testBothImag() {
    Expression exp1 = new Expression(0.0, 100.0, 1, '+');
    Expression exp2 = new Expression(0.0, 10.0, 1, '+');
    Expression expected = new Expression(10.0, 0.0, 1, '+');
    Expression result = Arithmetic.division(exp1, exp2);
    
    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    
    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }
  
  @Test
  void testBothComplex() {
    Expression exp1 = new Expression(60.0, 20.0, 1, '+');
    Expression exp2 = new Expression(30.0, 10.0, 1, '+');
    Expression expected = new Expression(2.0, 0.0, 1, '+');
    Expression result = Arithmetic.division(exp1, exp2);
    
    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    
    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }
  
  @Test
  void testComplexAndReal() {
    Expression exp1 = new Expression(60.0, 20.0, 1, '+');
    Expression exp2 = new Expression(3.0, 0.0, 1, '+');
    Expression expected = new Expression(20.0, 20.0/3, 1, '+');
    Expression result = Arithmetic.division(exp1, exp2);
    
    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    
    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }
  
  @Test
  void testDivideByZero() {
    Expression exp1 = new Expression(4.0, 4.0, 1, '+');
    Expression exp2 = new Expression(0.0, 0.0, 1, '+');
    assertThrows(IllegalArgumentException.class, () -> {
      Arithmetic.division(exp1, exp2);
    });
  }
  
  @Test
  void testRandom() {
    Expression exp1 = new Expression(0.0, 0.0, 1, '+');
    Expression exp2 = new Expression(0.0, 5.0, 1, '+');
    Expression expected = new Expression(0.0, 0.0, 1, '+');
    Expression result = Arithmetic.division(exp1, exp2);
    
    double expectedReal = expected.getReal();
    double resultReal = result.getReal();
    double expectedCoef = expected.getImagCoef();
    double resultCoef = result.getImagCoef();
    
    assertEquals(expectedReal, resultReal, 0.0001);
    assertEquals(expectedCoef, resultCoef, 0.0001);
  }
  
  
}
