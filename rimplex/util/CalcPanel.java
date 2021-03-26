package util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	
	private static CalcPanel panel = new CalcPanel();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalcPanel() {
		
		super();
	}
	
	@Override
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
		
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		buttonPanel.add( answerButton );
		buttonPanel.add( cancelButton );
		buttonPanel.add( resetButton );
		buttonPanel.add( addButton );
		buttonPanel.add( subButton );
		buttonPanel.add( multiButton );
		buttonPanel.add( divButton );
		buttonPanel.add( equalButton );
		
		displayPanel.add( display );
		
		inputPanel.add( input );
		
		centerPanel.add( displayPanel );
		centerPanel.add( inputPanel );
		centerPanel.add( buttonPanel );
	}

	@Override
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
	    
		input.setEditable( true );
	}

	@Override
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

	@Override
	public void setPanel() {
		// TODO Auto-generated method stub
		setLayout( new BorderLayout() );
		
		buttonPanel.setLayout( new FlowLayout() );
		centerPanel.setLayout( new GridLayout( 0, 3 ) );
		displayPanel.setLayout( new FlowLayout() );
		inputPanel.setLayout( new FlowLayout() );
	} 

	public static CalcPanel getInstance() {
		// TODO Auto-generated method stub
        if ( panel == null ) {
            panel = new CalcPanel();
        }

        return panel;
	}
}
