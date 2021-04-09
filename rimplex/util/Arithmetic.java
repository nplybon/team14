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
	 * @throws InvalidExpressionException if expression operands are invalid
	 * @throws OverflowException when positive overflow has occurred when performing the operation
	 * @throws InvalidExpressionException 
	 * @throws InvalidExpressionException if expression operands are invalid
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
		double exp1NewCoef = 0;
		double exp2NewCoef = 0;
		double realResult = exp1.getReal() + exp2.getReal();
		double coefResult;
		
		if (exp1.getSymbol() == Operator.SUBTRACTION && exp2.getSymbol() != Operator.SUBTRACTION) {
			exp1NewCoef = exp1.getImagCoef() * -1;
			exp2NewCoef = exp2.getImagCoef();
		} else if (exp1.getSymbol() != Operator.SUBTRACTION && exp2.getSymbol() == Operator.SUBTRACTION) {
			exp1NewCoef = exp1.getImagCoef() * -1;
			exp2NewCoef = exp2.getImagCoef();
		} else {
			exp1NewCoef = exp1.getImagCoef();
			exp2NewCoef = exp2.getImagCoef();
		}
		
		coefResult = exp1NewCoef + exp2NewCoef;

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
	 * @throws InvalidExpressionException if expression operands are invalid
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
	/**
	 * Returns the difference of two expressions.
	 * @param exp1 the first expression
	 * @param exp2 the second expression
	 * @return the difference
	 * @throws InvalidExpressionException if expression operands are invalid
	 */
	public static Expression subtraction(Expression exp1, Expression exp2) throws OverflowException, InvalidExpressionException {
	  // (a - c) + (b - d)
	  if (exp1.getReal().equals(exp2.getReal()) && exp1.getImagCoef().equals(exp2.getImagCoef()) && exp1.getSymbol().equals(exp2.getSymbol())) {
	    return new Expression(0.0, 0.0, 1, '+');
	  }
	  
	  if (exp2.getSymbol() == Operator.SUBTRACTION) {
      exp2 = new Expression(exp2.getReal() * -1, exp2.getImagCoef(), 1, '+');
	  } else {
      exp2 = new Expression(exp2.getReal() * -1, exp2.getImagCoef() * -1, 1, '+');
	  }
	
	  
	 
	  return addition(exp1, exp2);  
	}
	
	/**
	 * Returns the quotients of two expressions.
	 * @param exp1 the first expression
	 * @param exp2 the second expression
	 * @return the quotient
	 * @throws InvalidExpressionException if denominator is 0
	 */
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
	
	/**
	 * Returns the inverse of the given expression
	 * @param e the expression to be inversed
	 * @return inverse of the given expression
	 * @throws InvalidExpressionException 
	 * @throws OverflowException 
	 */
	public static Expression inverse(Expression e) throws InvalidExpressionException, OverflowException {
	   Expression conjugate = new Expression(e.getReal(), e.getImagCoef(), 1, '+');
     double denominator = Math.sqrt(Math.pow(e.getReal(), 2) + Math.pow(e.getImagCoef(), 2));
     denominator = Math.pow(denominator, 2);
     if (e.getImagCoef() > 0) {
       return new Expression(conjugate.getReal() / denominator, conjugate.getImagCoef() / denominator, 1, '-');
     } else {
       return new Expression(conjugate.getReal() / denominator, conjugate.getImagCoef() / denominator, 1, '+');

     }
	  
	}
	
	public static void main(String[] args) throws InvalidExpressionException, OverflowException
  {
    Expression e = new Expression(0.0, 9.0, 1, '+');
    System.out.println(inverse(e));
  }
	
}
