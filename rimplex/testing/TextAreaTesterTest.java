package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gui.TextAreaTester;

class TextAreaTesterTest
{

  @Test
  void testVerifyTarget()
  {

    TextAreaTester text = TextAreaTester.getInstance();

    assertFalse(text.verifyTarget(""));
    assertTrue(text.verifyTarget("22"));
    assertTrue(text.verifyTarget("-45i"));
    assertTrue(text.verifyTarget("(22-10i)"));
    assertTrue(text.verifyTarget("(400+96i)"));
    assertFalse(text.verifyTarget("(-)"));
    assertFalse(text.verifyTarget("(+)"));
    assertFalse(text.verifyTarget(null));
    assertTrue(text.verifyTarget("69^6"));
    assertFalse(text.verifyTarget("(2-)"));

  }

}
