package gui;
import java.awt.BorderLayout;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalcFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static CalcFrame frame;
	
	private JMenuBar menuBar;
	
	private JMenu file;
	private JMenu about;
	
	private JMenuItem help;
	
	private JPanel current;
	
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
	
	private void addMenus() {
		
		about.add( help );
		
		menuBar.add( file );
		menuBar.add( about );
		
	}
	private void createCompnents() {
		
		menuBar = new JMenuBar();
		
		file = new JMenu();
		help = new JMenuItem();
		
		about = new JMenu();
		
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
    
    private void setLabels() {
    	
    	file.setText( "File" );
    	help.setText( "Help" );
    	about.setText( "About" );
    }
    
    private void setListeners() {
    	
    	this.addWindowListener( ButtonListener.getInstance() );
    	help.addActionListener( ButtonListener.getInstance() );
    }
}
