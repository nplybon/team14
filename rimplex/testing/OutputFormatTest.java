package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import util.OutputFormat;

class OutputFormatTest
{
  String output1 = "3.5 + 5.75 = 9.25";
  String expected1 = "3.5 + 5.75 = 37/4";
  String output2 = "1.0 + 1.5 = 2.5";
  String expected2 = "1.0 + 1.5 = 5/2";
  String output3 = "6.0i + 3.0i = 9.0i";
  String expected3 = "6.0i + 3.0i = 9/1i";
  String output4 = "(1.0 + 1.5i) + (1.0 + 3.1i) = (2.0 + 4.6i)";
  String expected4 = "(1.0 + 1.5i) + (1.0 + 3.1i) = (2/1 + 23/5i)";
  String output5 = "(100 + 2.3i) + (423.4 + 1.0i) = (523.4 + 3.3i)";
  String expected5 = "(100 + 2.3i) + (423.4 + 1.0i) = (2617/5 + 33/10i)";

  @Test
  void testFracReal()
  {
    String output = output1;
    String expected = expected1;
    assertEquals(OutputFormat.toFraction(output), expected);

    output = output2;
    expected = expected2;
    assertEquals(OutputFormat.toFraction(output), expected);
  }

  @Test
  void testDecReal()
  {
    String expected = output1;
    String output = expected1;
    assertEquals(OutputFormat.toDecimal(output), expected);

    expected = output2;
    output = expected2;
    assertEquals(OutputFormat.toDecimal(output), expected);
  }

  @Test
  void testFracImag()
  {
    String output = output2;
    String expected = expected2;
    assertEquals(OutputFormat.toFraction(output), expected);

    output = output3;
    expected = expected3;
    assertEquals(OutputFormat.toFraction(output), expected);
  }

  @Test
  void testDecImag()
  {
    String expected = "1.25i + 1.25i = 2.5i";
    String output = "1.25i + 1.25i = 5/2i";
    assertEquals(OutputFormat.toDecimal(output), expected);

    expected = output3;
    output = expected3;
    assertEquals(OutputFormat.toDecimal(output), expected);
  }

  @Test
  void testFracComplex()
  {
    String output = output4;
    String expected = expected4;
    assertEquals(OutputFormat.toFraction(output), expected);

    output = output5;
    expected = expected5;
    assertEquals(OutputFormat.toFraction(output), expected);
  }

  @Test
  void testDecComplex()
  {
    String expected = output4;
    String output = expected4;
    assertEquals(OutputFormat.toDecimal(output), expected);

    expected = output5;
    output = expected5;
    assertEquals(OutputFormat.toDecimal(output), expected);
  }
}
