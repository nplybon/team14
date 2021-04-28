package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class HistoryFrame extends JFrame {

	private static final long serialVersionUID = 1L;

//	private JLabel history;
	private static HistoryFrame frame;
	private static JTextArea area;
	private static JTextField windowDisplay;
	private JWindow historyWindow;
	
	public HistoryFrame() {

		createComponents();
		setLabels();
		addComponents();
		
		setLayout( new GridLayout( 1, 0 ) );
		setSize( 450, 450 );
		setTitle( "History" );
		setVisible( false );
		setUndecorated(true);
		
	}
	
	public void addComponents() {
		
		add( area );
	}
	
	public void createComponents() {
		
//	    history =  new JLabel();
	    area = new JTextArea();
	    
//	    Color blue =  new Color( 51, 204, 255 );
//		area.setForeground( blue );
		
	    
		windowDisplay = new JTextField();
		
		historyWindow = new JWindow();
	}
	
	public void setLabels() {
		
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
	
	public static JTextArea getDisplay() {
	  return area;	
	}
	
	public static JFrame parent() {
	  return frame;
	}
	
	public static HistoryFrame getInstance() {
		
		if ( frame == null ) {
			
			frame = new HistoryFrame();
		}
		
		return frame;
	}
}
