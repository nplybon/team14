package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
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
	private JToggleButton outputformat;
	
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
		topRow.add(  outputformat  );
		
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
	
	public boolean isNumEnabled() {
		
		return one.isEnabled();
	}
	
	public boolean isPlusEnabled() {
		
		return plus.isEnabled();
	
	}
	
	public boolean isDivEnabled() {
		
		return division.isEnabled();
		
	}
	
	public boolean isIEnabled() {
		
		return iButton.isEnabled();
	}
	
	public boolean isEqualsEnabled() {
		
		return equals.isEnabled();
	}
	
	public boolean isOpenParEnabled() {
		
		return openPar.isEnabled();
	}
	
	public boolean isCloseParEnabled() {
		
		return closePar.isEnabled();
	}
	
	public boolean isDecimalEnabled() {
		
		return decimal.isEnabled();
	}
	
	public void addToDisplay(String s) {
	  display.setText(display.getText() + s);
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
	
	public void resetDisplay() {
	  display.setText("");
	}
	
	@Override
	public void setParameters() {
		// TODO Auto-generated method stub
		setButtonText();
		
//		log.setEnabled( false );
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
		ButtonListener button = ButtonListener.getInstance();
		
		display.addKeyListener( button );
		display.setFocusTraversalKeysEnabled(false);
		
		plus.addActionListener(button);
		minus.addActionListener(button);
		multiply.addActionListener(button);
		division.addActionListener(button);
		reset.addActionListener(button);
		cancel.addActionListener(button);
		one.addActionListener(button);
		two.addActionListener(button);
		three.addActionListener(button);
		four.addActionListener(button);
		five.addActionListener(button);
		six.addActionListener(button);
		seven.addActionListener(button);
		eight.addActionListener(button);
		nine.addActionListener(button);
		zero.addActionListener(button);
		iButton.addActionListener(button);
		openPar.addActionListener(button);
		closePar.addActionListener(button);
		decimal.addActionListener(button);
		equals.addActionListener(button);
		backspace.addActionListener(button);
		inverse.addActionListener(button);
		log.addActionListener(button);
		sign.addActionListener(button);
		history.addActionListener(button);
		squareRoot.addActionListener(button);
		outputformat.addActionListener(button);
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
		outputformat = new JToggleButton();
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
		outputformat.setText("frac");

	}

	public static CalcPanel getInstance() {
		
		if ( panel == null ) {
			
			panel = new CalcPanel();
			
		}
		
		return panel;
		
	}
	
	public void enableImag() {
	  iButton.setEnabled(true);
	}
	
	public void disableImag() {
	  iButton.setEnabled(false);
	}
	
	public void disableDecimal() {
	  decimal.setEnabled(false);
	}
	
	public void disableAllNumsI() {
    one.setEnabled(false);
    two.setEnabled(false);
    three.setEnabled(false);
    four.setEnabled(false);
    five.setEnabled(false);
    six.setEnabled(false);
    seven.setEnabled(false);
    eight.setEnabled(false);
    nine.setEnabled(false);
    zero.setEnabled(false);
    decimal.setEnabled(false);
    iButton.setEnabled(false);
  }
	
	public void enableAllNums() {
    one.setEnabled(true);
    two.setEnabled(true);
    three.setEnabled(true);
    four.setEnabled(true);
    five.setEnabled(true);
    six.setEnabled(true);
    seven.setEnabled(true);
    eight.setEnabled(true);
    nine.setEnabled(true);
    zero.setEnabled(true);
    decimal.setEnabled(true);
    iButton.setEnabled(true);
  }
}