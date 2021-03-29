package testing;

import static org.junit.jupiter.api.Assertions.*;

import util.*;

import org.junit.jupiter.api.Test;

class additionTest {

	@Test
	void testAdditionTwoRealNoImag() {
		Expression left = new Expression(5.0, 0.0, 1, '+');
		Expression right = new Expression(3.0, 0.0, 1, '+');
		Expression expected = new Expression(8.0, 0.0, 1, '+');
		Expression result = Arithmetic.addition(left, right);
		
		double expectedReal = expected.getReal();
		double resultReal = result.getReal();
		double expectedCoef = expected.getImagCoef();
		double resultCoef = result.getImagCoef();
		
		assertEquals(expectedReal, resultReal, 0.0001);
		assertEquals(expectedCoef, resultCoef, 0.0001);
				
	}
	
	@Test
	void testAdditionTwoNegativeNoImag() {
		
		Expression left = new Expression(-5.0, 0.0, 1, '+');
		Expression right = new Expression(-3.0, 0.0, 1, '+');
		Expression expected = new Expression(-8.0, 0.0, 1, '+');
		Expression result = Arithmetic.addition(left, right);
		
		double expectedReal = expected.getReal();
		double resultReal = result.getReal();
		double expectedCoef = expected.getImagCoef();
		double resultCoef = result.getImagCoef();
		
		assertEquals(expectedReal, resultReal, 0.0001);
		assertEquals(expectedCoef, resultCoef, 0.0001);
	}
	
	@Test
	void testAdditionTwoComplex() {
		
		Expression left = new Expression(-5.0, 1.0, 1, '+');
		Expression right = new Expression(-3.0, 3.0, 1, '+');
		Expression expected = new Expression(-8.0, 4.0, 1, '+');
		Expression result = Arithmetic.addition(left, right);
		
		double expectedReal = expected.getReal();
		double resultReal = result.getReal();
		double expectedCoef = expected.getImagCoef();
		double resultCoef = result.getImagCoef();
		
		assertEquals(expectedReal, resultReal, 0.0001);
		assertEquals(expectedCoef, resultCoef, 0.0001);
		
	}
	
	@Test
	void testAdditionRealAndCompelx() {
		
		Expression left = new Expression(-5.0, 1.0, 1, '+');
		Expression right = new Expression(-3.0, 0.0, 1, '+');
		Expression expected = new Expression(-8.0, 1.0, 1, '+');
		Expression result = Arithmetic.addition(left, right);
		
		double expectedReal = expected.getReal();
		double resultReal = result.getReal();
		double expectedCoef = expected.getImagCoef();
		double resultCoef = result.getImagCoef();
		
		assertEquals(expectedReal, resultReal, 0.0001);
		assertEquals(expectedCoef, resultCoef, 0.0001);
		
	}
	
	@Test
	void testAdditionOverflowOnReal() {
		
		Expression left = new Expression(Double.MAX_VALUE, 0.0, 1, '+');
		Expression right = new Expression(Double.MAX_VALUE, 0.0, 1, '+');
		
		assertEquals(null, Arithmetic.addition(left, right));
		
	}
	
	@Test
	void testAdditionOverflowOnCoef() {
		
		Expression left = new Expression(5.0, Double.MAX_VALUE, 1, '+');
		Expression right = new Expression(3.0, Double.MAX_VALUE, 1, '+');
		
		assertEquals(null, Arithmetic.addition(left, right));
	}

}
