package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	private static ButtonListener listener;
	
	private ButtonListener() {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static ButtonListener getInstance() {
		// TODO Auto-generated method stub
        if ( listener == null ) {
            listener = new ButtonListener();
        }

        return listener;
	}

}
