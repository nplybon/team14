package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.*;

class conjugateTest {

	@Test
	void testConjugateBothPositivePlus() throws InvalidExpressionException {
		Expression in = new Expression(5.0, 3.0, 1, '+');
		Expression expected = new Expression(5.0, 3.0, 1, '-');
		Expression result = Arithmetic.conjugate(in);
		
		assertEquals(expected.toString(), result.toString());
		
	}
	
	@Test
	void testConjugateBothNegativePlus() throws InvalidExpressionException {
		Expression in = new Expression(-5.0, -3.0, 1, '+');
		Expression expected = new Expression(-5.0, 3.0, 1, '+');
		Expression result = Arithmetic.conjugate(in);
		
		assertEquals(expected.toString(), result.toString());
		
	}
	
	@Test
	void testConjugateBothNegativeMinus() throws InvalidExpressionException {
		Expression in = new Expression(-5.0, -3.0, 1, '-');
		Expression expected = new Expression(-5.0, 3.0, 1, '-');
		Expression result = Arithmetic.conjugate(in);
		
		assertEquals(expected.toString(), result.toString());
		
	}
	
	@Test
	void testConjugateBothPositiveMinus() throws InvalidExpressionException {
		Expression in = new Expression(5.0, 3.0, 1, '-');
		Expression expected = new Expression(5.0, 3.0, 1, '+');
		Expression result = Arithmetic.conjugate(in);
		
		assertEquals(expected.toString(), result.toString());
		
	}

}
