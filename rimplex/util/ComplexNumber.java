package util;
/**
 * A class to represent a complex number in the form "a + bi".
 * 
 * @author team 14
 * @version rimplex v1
 */
public class ComplexNumber
{

  private final String i = "i";
  private final double real;
  private final double imag;

  public ComplexNumber(double real, double imag)
  {
    this.real = real;
    this.imag = imag;
  }

  public ComplexNumber sum(ComplexNumber other)
  {
    return null;
  }

  public ComplexNumber difference(ComplexNumber other)
  {
    double realDiff = this.real - other.real;
    double imagDiff = this.imag - other.imag;
    return new ComplexNumber(realDiff, imagDiff);

  }

  public ComplexNumber product(ComplexNumber other)
  {
    return null;

  }

  public ComplexNumber quotient(ComplexNumber other) throws IllegalArgumentException
  {
    return null;
  }

  public double getReal()
  {
    return real;
  }

  public double getImaginary()
  {
    return imag;
  }

  @Override
  public String toString()
  {
    if (isComplex())
    {
      if (imag < 0)
      {
        return real + " - " + imag * -1 + i;
      }
      return real + " + " + imag + i;
    }
    else if (isImag())
    {
      return imag + i;
    }
    else
    {
      return real + "";
    }
  }

  public ComplexNumber conjugate()
  {
    return new ComplexNumber(this.real, -this.imag);

  }

  public boolean isReal()
  {
    return real != 0 && real != 0.0;
  }

  public boolean isImag()
  {
    return imag != 0 && imag != 0.0;
  }

  public boolean isComplex()
  {
    return isReal() && isImag();
  }

  public static void main(String[] args)
  {
    ComplexNumber c = new ComplexNumber(5, 2);
    ComplexNumber c2 = new ComplexNumber(3, 2);
    System.out.println("Complex Number 1: " + c);
    System.out.println("Complex Number 2: " + c2);
    System.out.println("The difference is: " + c.difference(c2));
    System.out.println("The conjugate is " + c.conjugate());
  }
}
