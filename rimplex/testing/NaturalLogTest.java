package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.*;

class NaturalLogTest {

	@Test
	void testNaturalLogReal() throws InvalidExpressionException {
		Expression in = new Expression(5.0, 0.0, 1, '+');
		Expression expected = new Expression(Math.log(5.0), 0.0, 1, '+');
		Expression result = Arithmetic.naturalLog(in);
		
		assertEquals(expected.toString(), result.toString());
	}
	
	@Test
	void testNaturalLogZero() throws InvalidExpressionException {
		Expression in = new Expression(0.0, 1.0, 1, '+');
		
		assertThrows(InvalidExpressionException.class, () -> Arithmetic.naturalLog(in));
	}
	
	@Test
	void testNaturalLogNegative() throws InvalidExpressionException {
		Expression in = new Expression(-1.0, 1.0, 1, '+');
		
		assertThrows(InvalidExpressionException.class, () -> Arithmetic.naturalLog(in));
	}
	
	@Test
	void testNaturalLogComplexPlus() throws InvalidExpressionException {
		Expression in = new Expression(5.0, 3.0, 1, '+');
		Expression expected = new Expression(1.7631803, 0.5404195, 1, '+');
		Expression result = Arithmetic.naturalLog(in);
		
		assertEquals(expected.getReal(), result.getReal(), 0.0001);
		assertEquals(expected.getImagCoef(), result.getImagCoef(), 0.0001);
	}
	
	@Test
	void testNaturalLogComplexMinus() throws InvalidExpressionException {
		Expression in = new Expression(5.0, 3.0, 1, '-');
		Expression expected = new Expression(1.7631803, 0.5404195, 1, '-');
		Expression result = Arithmetic.naturalLog(in);
		
		
		assertEquals(expected.getReal(), result.getReal(), 0.0001);
		assertEquals(expected.getImagCoef(), result.getImagCoef(), 0.0001);
		assertEquals(expected.getSymbol(), result.getSymbol());
	}
	
	

}
