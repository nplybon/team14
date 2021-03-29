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
	 *  	is/are null, or either positive or negative overflow occurs
	 */
	public static Expression addition(Expression exp1, Expression exp2) {

		// null argument checking
		if (exp1 == null || exp2 == null) {
			return null;
		}
		
		// overflow checking (positive)
		if (exp1.getReal() + exp2.getReal() > Double.MAX_VALUE) {
			return null;
		}
		
		if (exp1.getImagCoef() + exp2.getImagCoef() > Double.MAX_VALUE) {
			return null;
		}

		// local variables
		double realResult = exp1.getReal() + exp2.getReal();
		double coefResult = exp1.getImagCoef() + exp2.getImagCoef();

		// return resultant expression
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
	public static Expression multiplication(Expression exp1, Expression exp2) {
		
		// null argument checking
		if (exp1 == null || exp2 == null) {
			return null;
		}
		
		// overflow checking (positive)
		if (exp1.getReal() * exp2.getReal() > Double.MAX_VALUE) {
			return null;
		}
				
		if (exp1.getImagCoef() * exp2.getImagCoef() > Double.MAX_VALUE) {
			return null;
		}
		
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
	
	public static Expression subtraction(Expression exp1, Expression exp2) {
	  return null;
	}
	
	public static Expression division(Expression exp1, Expression exp2) {
    return null;
  }

}
