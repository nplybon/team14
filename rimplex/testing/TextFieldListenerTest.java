package testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import gui.TextAreaTester;

class TextFieldListenerTest
{

  @Test
  void testVerify()
  {

    // one complex number
    assertTrue(TextAreaTester.getInstance().verifyTarget("2i"));
    assertTrue(TextAreaTester.getInstance().verifyTarget("-2i"));
    // two numbers one complex
    assertTrue(TextAreaTester.getInstance().verifyTarget("0+20i"));
    // two numbers one complex with spaces
    assertTrue(TextAreaTester.getInstance().verifyTarget("3+ 5i"));
    assertTrue(TextAreaTester.getInstance().verifyTarget("1 - 16i"));
    // non-i letter input
    assertFalse(TextAreaTester.getInstance().verifyTarget("a + 2i"));
    assertFalse(TextAreaTester.getInstance().verifyTarget("G-10i"));
    assertFalse(TextAreaTester.getInstance().verifyTarget("3+10q"));
    // capital I input
    assertFalse(TextAreaTester.getInstance().verifyTarget("3I"));
    // multiply or divide input
    assertFalse(TextAreaTester.getInstance().verifyTarget("2i x 3"));
    assertFalse(TextAreaTester.getInstance().verifyTarget("2i/9"));
    // empty input
    assertFalse(TextAreaTester.getInstance().verifyTarget(""));
    assertFalse(TextAreaTester.getInstance().verifyTarget("	"));
    // wrong order input
    assertFalse(TextAreaTester.getInstance().verifyTarget("+4i"));
    assertFalse(TextAreaTester.getInstance().verifyTarget("13i - 1"));

  }

}
