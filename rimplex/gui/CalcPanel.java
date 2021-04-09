package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class CalcPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton plus;
	private JButton minus;
	private JButton multiply;
	private JButton division;
	private JButton reset;
	private JButton cancel;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton zero;
	private JButton iButton;
	private JButton openPar;
	private JButton closePar;
	private JButton decimal;
	private JButton equals;
	private JButton backspace;
	private JButton inverse;
	private JButton log;
	private JButton sign;
	private JButton history;
	private JButton squareRoot;
	
	private JPanel displayPanel;
	private JPanel center;
	private JPanel topRow;
	private JPanel secRow;
	private JPanel thirdRow;
	private JPanel lastRow;
	
	private JTextField display;
	
	private static CalcPanel panel;
	
	private CalcPanel() {
		
		super();
		
	}
	
	@Override
	public void createComponents() {
		// TODO Auto-generated method stub
		createButtons();
		
		displayPanel = new JPanel();
		center = new JPanel();
		topRow = new JPanel();
		secRow = new JPanel();
		thirdRow = new JPanel();
		lastRow = new JPanel();
		
		display = new JTextField();
		
		
		
	}

	@Override
	public void addComponents() {
		// TODO Auto-generated method stub
		displayPanel.add( display );
		
		topRow.add( sign );
		topRow.add( reset );
		topRow.add( cancel );
		topRow.add( plus );
		topRow.add( backspace );	
		topRow.add( one );
		topRow.add( two );
		topRow.add( three );
		topRow.add( minus );
		topRow.add( inverse );
		
		secRow.add( four );
		secRow.add( five );
		secRow.add( six );
		secRow.add( multiply );
		secRow.add( openPar );
		secRow.add( seven );
		secRow.add( eight );
		secRow.add( nine );
		secRow.add( division );
		secRow.add( closePar );
		
		thirdRow.add( decimal );
		thirdRow.add( zero );
		thirdRow.add( iButton );
		thirdRow.add( equals );
		thirdRow.add( log );
		
		center.add( displayPanel );
		center.add( new JPanel() );
		center.add( topRow );
		center.add( secRow );
		center.add( thirdRow );
		
		add( center, BorderLayout.CENTER );
		add( new JPanel(), BorderLayout.NORTH );
//		JPanel historyPanel = new JPanel();
//		historyPanel.setLayout( new GridLayout( 3, 0 ) ); 
//		historyPanel.add( new JPanel() );
//		historyPanel.add( history );
//		historyPanel.add( new JPanel() );
//		
//		add( historyPanel , BorderLayout.EAST );
		
	}

	public String getDisplay() {
	
		return display.getText();
	}
	
	public void setDisplay( int i ) {
		
		String str = display.getText();
		
		if ( str.length() > 1 ) {
			
			String sub = str.substring( 0, i );
			display.setText( sub );
			
		} else {
			
			display.setText( "" );
		}
	}
	
	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		setButtonText();
		
		log.setEnabled( false );
		sign.setEnabled( false );
		history.setEnabled( false );
		squareRoot.setEnabled( false );
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder( "Display" );
		
		display.setBorder( title );
		display.setEditable( true );
	}

	@Override
	public void setListeners() {
		// TODO Auto-generated method stub
		display.addKeyListener( KeyboardListener.getInstance() );
	}

	@Override
	public void setPanel() {
		// TODO Auto-generated method stub
		setLayout( new BorderLayout() );
		
		displayPanel.setLayout( new GridLayout( 1,0 ) );
		center.setLayout( new GridLayout( 5,0 ) );
	}

	private void createButtons() {
		
		plus = new JButton();
		minus = new JButton();
		multiply = new JButton();
		division = new JButton();
		reset = new JButton();
		cancel = new JButton();
		one = new JButton();
		two = new JButton();
		three = new JButton();
		four = new JButton();
		five = new JButton();
		six = new JButton();
		seven = new JButton();
		eight = new JButton();
		nine = new JButton();
		zero = new JButton();
		iButton = new JButton();
		openPar = new JButton();
		closePar = new JButton();
		decimal = new JButton();
		equals = new JButton();
		backspace = new JButton();
		inverse = new JButton();
		log = new JButton();
		sign = new JButton();
		history = new JButton();
		squareRoot = new JButton();
	}

	private void setButtonText() {
		plus.setText( "+" );
		minus.setText( "-" );
		division.setText( "/" );
		multiply.setText( "x" );
		reset.setText( "R" );
		cancel.setText( "C" );
		one.setText( "1" );
		two.setText( "2" );
		three.setText( "3" );
		four.setText( "4" );
		five.setText( "5" );
		six.setText( "6" );
		seven.setText( "7" );
		eight.setText( "8" );
		nine.setText( "9" );
		zero.setText( "0" );
		iButton.setText( "i" );
		openPar.setText( "(" );
		closePar.setText( ")" );
		decimal.setText( "." );
		equals.setText( "=" );
		backspace.setText( "<-" );
		inverse.setText( "inv" );
		log.setText( "log" );
		sign.setText( "+/-" );
		history.setText( ">" );
		squareRoot.setText( "sqr" );
	}

	public static CalcPanel getInstance() {
		
		if ( panel == null ) {
			
			panel = new CalcPanel();
			
		}
		
		return panel;
		
	}
}
