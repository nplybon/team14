package util;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalcFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CalcFrame frame;
	
	private JPanel current;
	
	private CalcFrame() {
		
		createCompnents();
		setPanel( new CalcPanel() );
		setListeners();
		 
		setSize( 350, 450 );
		setTitle( "Calculator" );
		setVisible( true );
		centerForm();
		
	}
	
	public JPanel getPanel() {
		
		return current;
	}
	
	public void setPanel( JPanel panel ) { 
		
        if ( current != null ) {
            current.setVisible( false );
            getContentPane().remove( current );
        }
        
        getContentPane().add( panel, BorderLayout.CENTER );
        current = panel;
        current.setVisible( true );
	}
	
	public static CalcFrame getInstance() {
		
		if ( frame == null ) {
			
			frame = new CalcFrame();
		}
		
		return frame;
	}
	
	private void createCompnents() {
		
		current = new JPanel();
	}
	
    /**
     * center form on screen.
     */
    private void centerForm() {

        Dimension dimScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimFrameSize = getSize();

        if ( dimFrameSize.height > dimScreenSize.height ) {
            dimFrameSize.height = dimScreenSize.height;
        }
        if ( dimFrameSize.width > dimScreenSize.width ) {
            dimFrameSize.width = dimScreenSize.width;
        }

        setLocation( ( dimScreenSize.width - dimFrameSize.width ) / 2,
                        ( dimScreenSize.height - dimFrameSize.height ) / 2 );

    } // method centerForm
    
    private void setListeners() {
    	
    	this.addWindowListener( ButtonListener.getInstance() );
    	
    }
}
