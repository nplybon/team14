package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class HistoryFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

//	private JLabel history;
	private static HistoryFrame frame;
	private JTextArea area;
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
		
		add( area );
	}
	
	private void createComponents() {
		
//	    history =  new JLabel();
	    area = new JTextArea();
	    
		windowDisplay = new JTextField();
		
		historyWindow = new JWindow();
	}
	
	private void setLabels() {
		
		area.setFocusable( false );
		windowDisplay.setFocusable( false );
//		windowDisplay.setAlignmentY(getAlignmentY());
		historyWindow.setVisible( false );
	}
	
	public void handleHistory( boolean bool ) {
		
//		historyWindow.setVisible( true );
		setVisible( bool );
	}
	
	public void incrementHistory( String str ) {
		
//		windowDisplay.add( str, null );
//	    history =  new JLabel( history.getText() + "/n" + str );
//		history.setVerticalAlignment(SwingConstants.TOP);
//		windowDisplay.setText( windowDisplay.getText() 
//				+ "\n" + str );
//		windowDisplay.setCaret( history );
		area.setText( area.getText() + "\n" + str );
		area.setAlignmentY( TOP_ALIGNMENT );
	}
	
	public static HistoryFrame getInstance() {
		
		if ( frame == null ) {
			
			frame = new HistoryFrame();
		}
		
		return frame;
	}
}
