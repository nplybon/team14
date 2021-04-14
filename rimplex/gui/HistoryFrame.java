package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class HistoryFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static HistoryFrame frame;
	
	private JTextField windowDisplay;
	private JWindow historyWindow;
	
	private HistoryFrame() {
		
		createComponents();
		setLabels();
		addComponents();
		
		setLayout( new GridLayout( 1, 0 ) );
		setSize( 450, 450 );
		setTitle( "History" );
		setVisible( false );
	}
	
	private void addComponents() {
		
		add( windowDisplay );
	}
	
	private void createComponents() {
		
		windowDisplay = new JTextField();
		
		historyWindow = new JWindow();
	}
	
	private void setLabels() {
		
		windowDisplay.setFocusable( false );
		
		historyWindow.setVisible( false );
	}
	
	public void enableHistory() {
		
//		historyWindow.setVisible( true );
		setVisible( true );
	}
	
	public void incrementHistory( String str ) {
		
//		windowDisplay.add( str, null );
		windowDisplay.setText( windowDisplay.getText() 
				+ "\n" + str );
	}
	
	public static HistoryFrame getInstance() {
		
		if ( frame == null ) {
			
			frame = new HistoryFrame();
		}
		
		return frame;
	}
}
