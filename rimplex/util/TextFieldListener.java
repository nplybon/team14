package util;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextFieldListener implements FocusListener {

	private static TextFieldListener listener;
	
	private TextFieldListener() {
		
	}
	
	public static TextFieldListener getInstance() {
		// TODO Auto-generated method stub
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

}
