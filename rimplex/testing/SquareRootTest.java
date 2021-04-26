package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.*;

class SquareRootTest {

	@Test
	void testSquareRootPositive() throws InvalidExpressionException {
		Expression in = new Expression(5.0, 3.0, 1, '+');
		Expression expected = new Expression(2.3271175, 0.6445742, 1, '+');
		Expression result = Arithmetic.squareRoot(in);
		
		assertEquals(expected.getReal(), result.getReal(), 0.0001);
		assertEquals(expected.getImagCoef(), result.getImagCoef(), 0.0001);
		assertEquals(expected.getSymbol(), result.getSymbol());
	}
	
	@Test
	void testSquareRootNegative() throws InvalidExpressionException {
		Expression in = new Expression(-5.0, 3.0, 1, '-');
		Expression expected = new Expression(0.6445742, 2.3271175, 1, '-');
		Expression result = Arithmetic.squareRoot(in);
		
		assertEquals(expected.getReal(), result.getReal(), 0.0001);
		assertEquals(expected.getImagCoef(), result.getImagCoef(), 0.0001);
		assertEquals(expected.getSymbol(), result.getSymbol());
	}

}
