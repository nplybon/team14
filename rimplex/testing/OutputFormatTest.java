package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.Arithmetic;
import util.Expression;
import util.OutputFormat;

class OutputFormatTest
{
  
  @Test
  void testFracReal() {
    String output = "(3.5) + (5.75) = 9.25";
    String expected = "(3.5) + (5.75) = 37/4"; 
    assertEquals(OutputFormat.toFraction(output), expected);
    
    output = "(1.0) + (1.5) = 2.5";
    expected = "(1.0) + (1.5) = 5/2";
    assertEquals(OutputFormat.toFraction(output), expected);
  }
  
  @Test
  void testDecReal() {
    String expected = "(3.5) + (5.75) = 9.25";
    String output = "(3.5) + (5.75) = 37/4"; 
    assertEquals(OutputFormat.toDecimal(output), expected);
    
    expected = "(1.0) + (1.5) = 2.5";
    output = "(1.0) + (1.5) = 5/2";
    assertEquals(OutputFormat.toDecimal(output), expected);
  }

  @Test
  void testFracImag()
  {
    String output = "(1.25i) + (1.25i) = 2.5i";
    String expected = "(1.25i) + (1.25i) = 5/2i";
    assertEquals(OutputFormat.toFraction(output), expected);
    
    output = "(6.0i) + (3.0i) = 9.0i";
    expected = "(6.0i) + (3.0i) = 9/1i";
    assertEquals(OutputFormat.toFraction(output), expected);    
  }
  
  @Test
  void testDecImag() {
    String expected = "(1.25i) + (1.25i) = 2.5i";
    String output = "(1.25i) + (1.25i) = 5/2i";
    assertEquals(OutputFormat.toDecimal(output), expected);
    
    expected = "(6.0i) + (3.0i) = 9.0i";
    output = "(6.0i) + (3.0i) = 9/1i";
    assertEquals(OutputFormat.toDecimal(output), expected);   
  }
  
  @Test
  void testFracComplex() {
    String output = "(1.0 + 1.5i) + (1.0 + 3.1i) = 5.1 + 1.5i";
    String expected = "(1.0 + 1.5i) + (1.0 + 3.1i) = 51/10 + 3/2i";
    assertEquals(OutputFormat.toFraction(output), expected);
    
    
    output = "(100 + 2.3i) + (423.4 + 1.0i) = 523.4 + 3.3i";
    expected = "(100 + 2.3i) + (423.4 + 1.0i) = 2617/5 + 33/10i";
    assertEquals(OutputFormat.toFraction(output), expected);    
  }
  
  @Test
  void testDecComplex() {
    String expected = "(1.0 + 1.5i) + (1.0 + 3.1i) = 5.1 + 1.5i";
    String output = "(1.0 + 1.5i) + (1.0 + 3.1i) = 51/10 + 3/2i";
    assertEquals(OutputFormat.toDecimal(output), expected);
    
    expected = "(100 + 2.3i) + (423.4 + 1.0i) = 523.4 + 3.3i";
    output = "(100 + 2.3i) + (423.4 + 1.0i) = 2617/5 + 33/10i";
    assertEquals(OutputFormat.toDecimal(output), expected);
  } 
}
