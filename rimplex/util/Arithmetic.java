package util;

/**
 * @author Hunter Mann
 * @version 2-26-2021
 * 
 *          This class houses the arithmetic algorithms that will be performed
 *          on the operands based on the Operators in the Expression
 */
public class Arithmetic {

	/**
	 * Performs addition operation on two Expression objects.
	 * 
	 * @param exp1 "left" expression
	 * @param exp2 "right" expression
	 * @return resultant expression; null if one, or both, expression/s 
	 *  	is/are null
	 */
	public Expression addition(Expression exp1, Expression exp2) {

		// error checking
		if (exp1 == null || exp2 == null) {
			return null;
		}

		double realResult = exp1.getReal() + exp2.getReal();
		double coefResult = exp1.getImagCoef() + exp2.getImagCoef();

		if (coefResult == 0)
			return new Expression(realResult, 1, '+');
		else
			return new Expression(realResult, coefResult, 1, '+');
	}
	
	/**
	 * Performs multiplication operation on two Expression objects.
	 * 
	 * @param exp1 "left" expression
	 * @param exp2 "right" expression
	 * @return resultant expression; null if one, or both, expression/s
	 *  	is/are null
	 */
	public Expression multiplication(Expression exp1, Expression exp2) {
		
		// error checking
		if (exp1 == null || exp2 == null)	return null;
		
		Expression mid1;
		Expression mid2;
		
		double mid1Real = exp1.getReal() * exp2.getReal();
		double mid1Coef = exp1.getReal() * exp2.getImagCoef();
		mid1 = new Expression(mid1Real, mid1Coef, 1, '+');
		
		double mid2Coef = exp2.getReal() * exp1.getImagCoef();
		double mid2Real = -1 * (exp1.getImagCoef() * exp2.getImagCoef());
		mid2 = new Expression(mid2Real, mid2Coef, 1, '+');
		
		return addition(mid1, mid2);
	}

}
