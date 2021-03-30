package util;

/**
 * @author Hunter Mann
 * @author Nic Plybon
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
	 * @throws OverflowException when positive overflow has occurred when performing the operation
	 * @throws InvalidExpressionException 
	 */
	public static Expression addition(Expression exp1, Expression exp2) throws OverflowException, InvalidExpressionException {

		// null argument checking
		if (exp1 == null || exp2 == null) {
			return null;
		}
		
		// overflow checking (positive)
		if (exp1.getReal() + exp2.getReal() > Double.MAX_VALUE) {
			throw new OverflowException("Overflow");
		}
		
		if (exp1.getImagCoef() + exp2.getImagCoef() > Double.MAX_VALUE) {
			throw new OverflowException("Overflow");
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
	 * @throws OverflowException when positive overflow has occurred when performing the operation
	 * @throws InvalidExpressionException 
	 */
	public static Expression multiplication(Expression exp1, Expression exp2) throws OverflowException, InvalidExpressionException {
		
		// null argument checking
		if (exp1 == null || exp2 == null) {
			return null;
		}
		
		// overflow checking (positive)
		if (exp1.getReal() * exp2.getReal() > Double.MAX_VALUE) {
			throw new OverflowException("Overflow");
		}
				
		if (exp1.getImagCoef() * exp2.getImagCoef() > Double.MAX_VALUE) {
			throw new OverflowException("Overflow");
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
	
	public static Expression subtraction(Expression exp1, Expression exp2) throws OverflowException, InvalidExpressionException {
	  // (a - c) + (b - d)
	  double real = exp1.getReal() - exp2.getReal();
	  double imag = exp1.getImagCoef() - exp2.getImagCoef();
	  
	  return new Expression(real, imag, 1, '+');
	  
	}
	
	public static Expression division(Expression exp1, Expression exp2)throws OverflowException, InvalidExpressionException {
	
	  //real part = ac + bd / c^2 + d^2
	  //imag part = bc - ad / c^2 + d^2
	  
	  double firstPart = exp1.getReal() * exp2.getReal() + exp1.getImagCoef() * exp2.getImagCoef();
	  double secondPart = exp1.getImagCoef() * exp2.getReal() - exp1.getReal() * exp2.getImagCoef();
	  double squaredPart = Math.pow(exp2.getReal(), 2) + Math.pow(exp2.getImagCoef(), 2);
	  double realpart  = firstPart / squaredPart;
	  double imagpart  = secondPart/ squaredPart;
	  
	  if (Double.isNaN(realpart) && Double.isNaN(imagpart)) {
	    throw new InvalidExpressionException("ERROR: CANNOT DIVIDE BY ZERO");
	  }
    return new Expression(realpart, imagpart, 1, '+');
  }
	public static void main(String[] args) throws InvalidExpressionException, OverflowException
  {
    Expression exp1 = new Expression(1.0, 5.0, 1, '-');
    Expression exp2 = new Expression(1.0, 5.0, 1, '-');
    System.out.println(addition(exp1, exp2));
  }

}
