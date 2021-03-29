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

//import tempWorkSpace.ButtonListener;
//import tempWorkSpace.CalcPanel;
//import tempWorkSpace.Panel;
//import tempWorkSpace.TextFieldListener;

public class CalcPanel extends Panel {

	JButton answerButton;
	JButton resetButton;
	JButton cancelButton;
	JButton addButton;
	JButton multiButton;
	JButton subButton;
	JButton divButton;
	JButton equalButton;
	
	JPanel buttonPanel;
	JPanel centerPanel;
	JPanel displayPanel;
	JPanel inputPanel;
	
	JScrollPane display;
	
	JTextField input;
	
	//JWindow window;
	JFrame frame;
	
	private static CalcPanel panel = new CalcPanel();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalcPanel() {
		
		super();
	}
	
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
		
		display = new JScrollPane();
		
		input = new JTextField();
		
		frame = new JFrame();
		//window = new JWindow();
		
	}

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
		
//		displayPanel.add( new JPanel() );
		displayPanel.add( display );
		
		inputPanel.add( new JPanel() );
		inputPanel.add( input );
		
		centerPanel.add( displayPanel );
//		centerPanel.add( new JPanel() );
		centerPanel.add( inputPanel );
		centerPanel.add( buttonPanel );
		centerPanel.add( new JPanel() );
		
	    add( centerPanel, BorderLayout.CENTER );
	    add( new JPanel(), BorderLayout.EAST );
	    add( new JPanel(), BorderLayout.WEST );
	    add( new JPanel(), BorderLayout.NORTH );
	}

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
	    
		TitledBorder inputTitle;
		inputTitle = BorderFactory.createTitledBorder( "Input" );
		input.setBorder( inputTitle );
		input.setEditable( true );
//		input.setBackground( Color.magenta );
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder( "Display" );
		
//		display.setBorder( BorderFactory.createLineBorder( Color.blue ) );
		display.setBorder( title );
//		display.setBackground( Color.blue );
//		setBackground( Color.blue );
		
		buttonPanel.setBorder( BorderFactory.createLineBorder( Color.black ) );
	}

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
		
		frame.addWindowListener( ButtonListener.getInstance() );
	}

	public void setPanel() {
		// TODO Auto-generated method stub
		setLayout( new BorderLayout() );
		
		buttonPanel.setLayout( new FlowLayout() );
		centerPanel.setLayout( new GridLayout( 4, 0 ) );
		displayPanel.setLayout( new GridLayout( 1, 0 ) );
		inputPanel.setLayout( new GridLayout( 2, 0 ) );
		 
	} 

//	public static CalcPanel getInstance() {
//		// TODO Auto-generated method stub
//        if ( panel == null ) {
//            panel = new CalcPanel();
//        }
//
//        return panel;
//	}
}
