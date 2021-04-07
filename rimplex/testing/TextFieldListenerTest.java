package testing;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import gui.TextFieldListener;

class TextFieldListenerTest {

	@Test
	void testVerify() {
		
		//one complex number
		assertTrue( TextFieldListener.getInstance().verifyTarget( "2i" ) );
		assertTrue( TextFieldListener.getInstance().verifyTarget( "-2i" ) );
		//two numbers one complex
		assertTrue( TextFieldListener.getInstance().verifyTarget( "0+20i" ) );
		//two numbers one complex with spaces
		assertTrue( TextFieldListener.getInstance().verifyTarget( "3+ 5i" ) );
		assertTrue( TextFieldListener.getInstance().verifyTarget( "1 - 16i" ) );
		//non-i letter input
		assertFalse( TextFieldListener.getInstance().verifyTarget( "a + 2i" ) );
		assertFalse( TextFieldListener.getInstance().verifyTarget( "G-10i" ) );
		assertFalse( TextFieldListener.getInstance().verifyTarget( "3+10q" ) );
		//capital I input
		assertFalse( TextFieldListener.getInstance().verifyTarget( "3I" ) );
		//multiply or divide input
		assertFalse( TextFieldListener.getInstance().verifyTarget( "2i x 3" ) );
		assertFalse( TextFieldListener.getInstance().verifyTarget( "2i/9" ) );
		//empty input
		assertFalse( TextFieldListener.getInstance().verifyTarget( "" ) );
		assertFalse( TextFieldListener.getInstance().verifyTarget( "	" ) );
		//wrong order input
		assertFalse( TextFieldListener.getInstance().verifyTarget( "+4i" ) );
		assertFalse( TextFieldListener.getInstance().verifyTarget( "13i - 1" ) );
		
	}

}
