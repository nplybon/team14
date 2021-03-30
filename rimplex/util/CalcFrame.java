package util;
import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 * Top-Level container for CalcPanel.
 * 
 * @author Colton Shovlin
 * @version Sprint1 CS345
 */
public class CalcFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CalcFrame frame;
	
	private JMenu file;
	private JMenu about;
	
	private JMenuBar menuBar;
	
	private JMenuItem help;
	
	private JPanel current;
	
	/**
	 * singleton constructor.
	 */
	private CalcFrame() {
		
		createCompnents();
		setLabels();
		addMenus();
		setPanel( CalcPanel.getInstance() );
		setListeners();
		setJMenuBar( menuBar );
		 
		setSize( 350, 450 );
		setTitle( "Calculator" );
		setVisible( true );
		centerForm();
		
	}
	
	/**
	 * @return visible content Pane
	 */
	public JPanel getPanel() {
		
		return current;
	}

	/**
	 * @param panel set panel to frame
	 */
	public void setPanel( JPanel panel ) { 
		
	    if ( current != null ) {
	        current.setVisible( false );
	        getContentPane().remove( current );
	    }
	    
	    getContentPane().add( panel, BorderLayout.CENTER );
	    current = panel;
	    current.setVisible( true );
	}

	/**
	 * add Menu items.
	 */
	private void addMenus() {
		
		about.add( help );
		
		menuBar.add( file );
		menuBar.add( about );
		
	}
	
	/**
	 * create JComponents
	 */
	private void createCompnents() {
		
		menuBar = new JMenuBar();
		
		file = new JMenu();
		help = new JMenuItem();
		
		about = new JMenu();
		
		current = new JPanel();
	}
	
	/**
	 * center frame.
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

    }
    
    /**
     * set Menu Labels
     */
    private void setLabels() {
    	
    	file.setText( "File" );
    	help.setText( "Help" );
    	about.setText( "About" );
    }
    
    /**
     * add Window Listener
     */
    private void setListeners() {
    	
    	this.addWindowListener( ButtonListener.getInstance() );
    	help.addActionListener( ButtonListener.getInstance() );
    }

    /**
     * Singleton method
     * 
     * @return frame instance
     */
	public static CalcFrame getInstance() {
		
		if ( frame == null ) {
			
			frame = new CalcFrame();
		}
		
		return frame;
	}
}
