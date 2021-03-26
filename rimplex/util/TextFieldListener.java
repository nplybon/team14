package util;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.InputVerifier;
import javax.swing.JComponent;

public class TextFieldListener extends InputVerifier implements FocusListener {

	private static TextFieldListener listener;
	
	private TextFieldListener() {
		
	}
	
	public static TextFieldListener getInstance() {
        if ( listener == null ) {
            listener = new TextFieldListener();
        }

        return listener;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verify(JComponent input) {
		// TODO Auto-generated method stub
		return false;
	}

}
