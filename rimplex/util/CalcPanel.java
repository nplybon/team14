package util;
import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.TitledBorder;
/**
 * The Imaginary Number Calculator panel.
 * 
 * @author Colton Shovlin
 * @version Sprint1 CS345
 */
public class CalcPanel extends Panel {

	private static CalcPanel panel;
	
	private JButton answerButton;
	private JButton resetButton;
	private JButton cancelButton;
	private JButton addButton;
	private JButton multiButton;
	private JButton subButton;
	private JButton divButton;
	private JButton equalButton;
	
	private JPanel buttonPanel;
	private JPanel centerPanel;
	private JPanel displayPanel;
	private JPanel inputPanel;
	
	private JTextField display;
	private JTextField input;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * singleton constructor.
	 */
	private CalcPanel() {
		
		super();
	}
	
	/**
	 * assemble JComponents.
	 */
	public void createComponents() {
		// TODO Auto-generated method stub
		answerButton = new JButton();
		addButton = new JButton();
		divButton = new JButton();
		equalButton = new JButton();
		multiButton = new JButton();
		subButton = new JButton();
		resetButton = new JButton();
		cancelButton = new JButton();
		
		buttonPanel = new JPanel();
		centerPanel = new JPanel();
		displayPanel = new JPanel();
		inputPanel = new JPanel();
		
		display = new JTextField();
		
		input = new JTextField();
		
	}

	/**
	 * add components to panel.
	 */
	public void addComponents() {
		// TODO Auto-generated method stub
		buttonPanel.add( cancelButton );
		buttonPanel.add( resetButton );
		buttonPanel.add( addButton );
		buttonPanel.add( subButton );
		buttonPanel.add( answerButton );
		buttonPanel.add( equalButton );
		buttonPanel.add( multiButton );
		buttonPanel.add( divButton );
		
		displayPanel.add( display );
		
		inputPanel.add( new JPanel() );
		inputPanel.add( input );
		
		centerPanel.add( displayPanel );
		centerPanel.add( inputPanel );
		centerPanel.add( buttonPanel );
		centerPanel.add( new JPanel() );
		
	    add( centerPanel, BorderLayout.CENTER );
	    add( new JPanel(), BorderLayout.EAST );
	    add( new JPanel(), BorderLayout.WEST );
	    add( new JPanel(), BorderLayout.NORTH );
	}
 
	/**
	 * grey out cancel.
	 */
	public void disableCancel() {
		
		cancelButton.setEnabled( false );
	}
	
	/**
	 * grey out equals
	 */
	public void disableEquals() {
		
		equalButton.setEnabled( false );
	}
	
	/**
	 * grey out operators button.
	 */
	public void disableOperators() {
		
		addButton.setEnabled( false );
		divButton.setEnabled( false );
		subButton.setEnabled( false );
		multiButton.setEnabled( false );
	}
	
	/**
	 * enable ans button.
	 */
	public void enableAnswer() {
		
		answerButton.setEnabled( true );
	}
	
	/**
	 * enable equals and cancel buttons.
	 */
	public void enableEquals() {
		
		equalButton.setEnabled( true );
		cancelButton.setEnabled( true );
	}
	
	/**
	 * enable operator buttons.
	 */
	public void enableOperators() {
		
		addButton.setEnabled( true );
		divButton.setEnabled( true );
		subButton.setEnabled( true );
		multiButton.setEnabled( true );
	}
	
	/**
	 * @return text in input field
	 */
	public String getInput() {
		
		return input.getText();
	}
	
	/**
	 * @return text in display field
	 */
	public String getDisplay() {
		
		return display.getText();
		
	}
	
	/**
	 * @param str set text in display field
	 */
	public void setDisplay( String str ) {
         
		display.setText( str );
	}
	
	/**
	 * @param str added to text already in display field
	 */
	public void incrementDisplay( String str ) {
		
		display.setText( display.getText() + str );
	}
	
	/**
	 * @param str Set text in input field
	 */
	public void setInput( String str ) {
		
		input.setText( str );
	}
	
	/**
	 * set parameters of JComponents.
	 */
	public void setParameters() {
		// TODO Auto-generated method stub
		answerButton.setText( "ans" );
		addButton.setText( "+" );
		divButton.setText( "÷" );
		equalButton.setText( "=" );
		multiButton.setText( "x" );
	    subButton.setText( "-" );
	    resetButton.setText( "R" );
	    cancelButton.setText( "C" ); 
	    
	    disableEquals();
	    answerButton.setEnabled( false );
	    cancelButton.setEnabled( false );
	    
		TitledBorder inputTitle;
		inputTitle = BorderFactory.createTitledBorder( "Input" );
		input.setBorder( inputTitle );
		input.setEditable( true );
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder( "Display" );
		
		display.setBorder( title );
		display.setEditable( false );
		
		buttonPanel.setBorder( BorderFactory.createLineBorder( Color.black ) );
	}

	/**
	 * add listeners to JComponents.
	 */
	public void setListeners() {
		// TODO Auto-generated method stub
		ActionListener button = ButtonListener.getInstance();

		addButton.addActionListener( button );
		subButton.addActionListener( button );
		multiButton.addActionListener( button );
		divButton.addActionListener( button );
		answerButton.addActionListener( button );
		cancelButton.addActionListener( button );
		resetButton.addActionListener( button );
		equalButton.addActionListener( button );
		
		input.addFocusListener( TextFieldListener.getInstance() );
		
	}

	/**
	 * set Layout for panels.
	 */
	public void setPanel() {
		// TODO Auto-generated method stub
		setLayout( new BorderLayout() );
		
		buttonPanel.setLayout( new FlowLayout() );
		centerPanel.setLayout( new GridLayout( 4, 0 ) );
		displayPanel.setLayout( new GridLayout( 1, 0 ) );
		inputPanel.setLayout( new GridLayout( 2, 0 ) );
		 
	} 

	/**
	 * Singleton method.
	 * 
	 * @return instance of CalcPanel
	 */
	public static CalcPanel getInstance() {
		// TODO Auto-generated method stub
        if ( panel == null ) {
            panel = new CalcPanel();
        }

        return panel;
	}
}
