package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 * Class for creating the Calculator window and utilities.
 *
 * @author Colton Shovlin & Alex Walker
 * @version Sprint 3 This work complies with the JMU Honor Code.
 */

public class CalcPanel extends Panel
{

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static CalcPanel panel;

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
  private JToggleButton history;
  private JButton closeHistory;
  private JButton squareRoot;
  private JButton exponent;
  private JButton realPart;
  private JButton imagPart;
  private JButton conjugate;
  private JButton steps;
  private JToggleButton outputformat;

  private JPanel center;
  private JPanel topRow;
  private JPanel secRow;
  private JPanel thirdRow;

  private JScrollPane scrollPane;

  private int parenC;
  private boolean dPresent;

  private JTextArea display;

  // private JTextField windowDisplay;
  //
  // private JWindow historyWindow;

  /**
   * Private Constructor for Singleton Class.
   */
  private CalcPanel()
  {
    super();
    this.parenC = 0;
    this.dPresent = false;

  }

  /**
   * Creates the different components of the CalcPanel including all the entry fields and buttons.
   */
  @Override
  public void createComponents()
  {
    // TODO Auto-generated method stub
    createButtons();

    center = new JPanel();
    topRow = new JPanel();
    secRow = new JPanel();
    thirdRow = new JPanel();

    // display = new JTextArea();
    display = new JTextArea(
    // "This is an editable JTextArea. " +
    // "A text area is a \"plain\" text component, " +
    // "which means that although it can display text " +
    // "in any font, all of the text is in the same font."
    );
    // display.setFont(new Font("Serif", Font.ITALIC, 16));
    display.setLineWrap(true);
    display.setWrapStyleWord(true);

    // document = ((AbstractDocument) display.getDocument());
    // document.setDocumentFilter( new Filter() );
    // windowDisplay = new JTextField();
    //
    // historyWindow = new JWindow();

  }

  /**
   * Adds components to the Calculator window.
   */
  @Override
  public void addComponents()
  {
    // TODO Auto-generated method stub
    // displayPanel.add( display );
    // topRow.add( new JPanel() );
    topRow.add(new JPanel());
    topRow.add(new JPanel());
    topRow.add(new JPanel());
    topRow.add(new JPanel());
    topRow.add(new JPanel());
    // topRow.add( new JPanel() );

    // topRow.add( new JPanel() );
    topRow.add(sign);
    topRow.add(steps);
    topRow.add( outputformat );
    topRow.add(plus);
    topRow.add(reset);
    // topRow.add( new JPanel() );

    // topRow.add( new JPanel() );
    topRow.add(one);
    topRow.add(two);
    topRow.add(three);
    topRow.add(minus);
    topRow.add(inverse);

    // JPanel topBorder = new JPanel();
    // topBorder.setLayout( new BorderLayout() );
    // topBorder.add( secRow, BorderLayout.EAST );
    // topBorder.add( new JPanel(), BorderLayout.CENTER );

    secRow.add(four);
    secRow.add(five);
    secRow.add(six);
    secRow.add(multiply);
    secRow.add(openPar);
    // secRow.add( new JPanel() );

    // secRow.add( new JPanel() );
    secRow.add(seven);
    secRow.add(eight);
    secRow.add(nine);
    secRow.add(division);
    secRow.add(closePar);
    // secRow.add( openHistory );

//    JPanel panel = new JPanel();
//    panel.add(history);

    secRow.add(decimal);
    secRow.add(zero);
    secRow.add(iButton);
    secRow.add(equals);
    secRow.add(exponent);

    // JPanel secBorder = new JPanel();
    // secBorder.setLayout( new BorderLayout() );
    // secBorder.add( panel, BorderLayout.EAST );
    // secBorder.add( secRow, BorderLayout.CENTER );
    // secBorder.add( new JPanel(), BorderLayout.WEST );

    thirdRow.add(realPart);
    thirdRow.add(imagPart);
    thirdRow.add(log);
    thirdRow.add(conjugate);
    thirdRow.add(squareRoot);

    thirdRow.add(new JPanel());
    thirdRow.add( new JPanel() );
    thirdRow.add(history);
    thirdRow.add( new JPanel() );
    // thirdRow.add( closeHistory );
 //   thirdRow.add(outputformat);
    thirdRow.add(new JPanel());

    thirdRow.add(new JPanel());
    thirdRow.add(new JPanel());
    thirdRow.add(new JPanel());
    thirdRow.add(new JPanel());
    thirdRow.add(new JPanel());

    scrollPane = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    center.add(scrollPane);
    center.add(topRow);
    center.add(secRow);
    center.add(thirdRow);
    // JPanel centerBorder = new JPanel();
    // centerBorder.setLayout( new BorderLayout() );
    // centerBorder.add( center, BorderLayout.CENTER );

    // centerBorder.add( panel, BorderLayout.EAST );
    // JPanel bigCenter = new JPanel();
    // bigCenter.setLayout( new GridLayout( 3, 0 ) );
    // bigCenter.add( scrollPane );
    // bigCenter.add( new JPanel() );
    // bigCenter.add( centerBorder );
    add(center, BorderLayout.CENTER);
    // add( centerBorder, BorderLayout.CENTER );
    add(new JPanel(), BorderLayout.NORTH);
    // add( new JPanel(), BorderLayout.WEST );
    // add( panel, BorderLayout.EAST );

    // add( historyWindow );
    // JPanel historyPanel = new JPanel();
    // historyPanel.setLayout( new GridLayout( 3, 0 ) );
    // historyPanel.add( new JPanel() );
    // historyPanel.add( history );
    // historyPanel.add( new JPanel() );
    //
    // add( historyPanel , BorderLayout.EAST );

  }

  // public void enableHistory() {
  //
  // historyWindow.setVisible( true );
  // }
  //
  // public void incrementHistory( String str ) {
  //
  // windowDisplay.setText( windowDisplay.getText()
  // + "\n" + str );
  // }

  /**
   * Gets the display field.
   * 
   * @return JTextArea - the text field
   */
  public JTextArea getDisplayField()
  {

    return display;
  }

  /**
   * Gets the display text.
   * 
   * @return String - the display text
   */
  public String getDisplay()
  {

    return display.getText();
  }

  /**
   * Checks if the number one button is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isNumEnabled()
  {

    return one.isEnabled();
  }

  /**
   * Checks if the plus button is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isPlusEnabled()
  {

    return plus.isEnabled();

  }

  /**
   * Checks if the division button is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isDivEnabled()
  {

    return division.isEnabled();

  }

  /**
   * enables the exponent button.
   * 
   * @param bool
   *          - true or false
   */
  public void handleExponent(final boolean bool)
  {

    exponent.setEnabled(bool);
  }

  /**
   * Checks if the exponent button is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isExponentEnabled()
  {

    return exponent.isEnabled();
  }

  /**
   * checks if ibutton is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isIEnabled()
  {

    return iButton.isEnabled();
  }

  /**
   * Checks if the equals button is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isEqualsEnabled()
  {

    return equals.isEnabled();
  }

  /**
   * checks if open parenthesis is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isOpenParEnabled()
  {

    return openPar.isEnabled();
  }

  /**
   * checks if closed parenthesis is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isCloseParEnabled()
  {

    return closePar.isEnabled();
  }

  /**
   * checks if decimal is enabled.
   * 
   * @return boolean - true or false
   */
  public boolean isDecimalEnabled()
  {

    return decimal.isEnabled();
  }

  /**
   * adds the given string to the display text.
   * 
   * @param s
   *          - the given string to be added
   */
  public void addToDisplay(final String s)
  {
    display.setText(display.getText() + s);
  }

  /**
   * Sets the display to the given string.
   * 
   * @param str
   *          - string to be set as the display text.
   */
  public void setDisplay(final String str)
  {

    resetDisplay();
    display.append(str);
  }

  /**
   * Appends the display string.
   * 
   * @param i
   *          - the position where the display string is to be appended
   */
  public void subDisplay(final int i)
  {

    String str = display.getText();

    if (str.length() > 1)
    {

      String sub = str.substring(0, i);
      display.setText(sub);

    }
    else
    {

      display.setText("");
    }
  }

  /**
   * Resets the display text.
   */
  public void resetDisplay()
  {
    display.setText("");
  }

  @Override
  public void setParameters()
  {
    // TODO Auto-generated method stub
    setButtonText();

    // inverse.setEnabled( false );
    // log.setEnabled( false );
    exponent.setEnabled(false);
    // sign.setEnabled( false );
    // closeHistory.setEnabled( false );
    // squareRoot.setEnabled( false );
    closePar.setEnabled(false);
    cancel.setEnabled(false);

    TitledBorder title;
    title = BorderFactory.createTitledBorder("Display");

    // display.setSize( 750, 450 );
    display.setBorder(title);
    // display.setEditable( true );
    addToDisplay("\n");
    // windowDisplay.setEditable( false );
    // System.out.println( display.isEditable() );
    // display.append( "24\n" );
    // display.setEditable( true );
    // historyWindow.setVisible( false );
  }

  /**
   * Sets the button listeners for all buttons.
   */
  @Override
  public void setListeners()
  {
    // TODO Auto-generated method stub
    ButtonListener button = ButtonListener.getInstance();

    display.addKeyListener(button);
    // display.setFocusTraversalKeysEnabled(false);

    exponent.addActionListener(button);
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
    closeHistory.addActionListener(button);
    history.addActionListener(button);
    squareRoot.addActionListener(button);
    conjugate.addActionListener(button);
    outputformat.addActionListener(button);
    steps.addActionListener(button);
    realPart.addActionListener(button);
    imagPart.addActionListener(button);
  }

  @Override
  public void setPanel()
  {
    // TODO Auto-generated method stub
    setLayout(new BorderLayout());

    center.setLayout(new GridLayout(4, 0));
    topRow.setLayout(new GridLayout(3, 6));
    secRow.setLayout(new GridLayout(3, 6));
    thirdRow.setLayout(new GridLayout(3, 6));
  }

  /**
   * create JButtons.
   */
  private void createButtons()
  {

    steps = new JButton();
    exponent = new JButton();
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
    closeHistory = new JButton();
    conjugate = new JButton();
    history = new JToggleButton();
    squareRoot = new JButton();

    realPart = new JButton();
    imagPart = new JButton();

    outputformat = new JToggleButton();
  }

  /**
   * Sets the Text in each button.
   */
  private void setButtonText()
  {

    steps.setText("steps");
    exponent.setText("^");
    plus.setText("+");
    minus.setText("-");
    division.setText("\u00F7");
    multiply.setText("x");
    reset.setText("R");
    cancel.setText("C");
    one.setText("1");
    two.setText("2");
    three.setText("3");
    four.setText("4");
    five.setText("5");
    six.setText("6");
    seven.setText("7");
    eight.setText("8");
    nine.setText("9");
    zero.setText("0");
    iButton.setText("i");
    openPar.setText("(");
    closePar.setText(")");
    decimal.setText(".");
    equals.setText("=");
    backspace.setText("\u2190");
    inverse.setText("inv");
    log.setText("log");
    sign.setText("+/-");
    closeHistory.setText("<");
    history.setText(">");
    squareRoot.setText("sqr");
    outputformat.setText("frac");
    conjugate.setText("conj");
    realPart.setText("real");
    imagPart.setText("imag");
    setButtonTextColor();
    setButtonFont();
    setDisplayBackground();
  }

  /**
   * Sets the background color of the display.
   */
  private void setDisplayBackground()
  {
    display.setBackground(new Color(202, 238, 255));
  }

  /**
   * Sets the text color for each button.
   */
  private void setButtonTextColor()
  {
    Color cyan = new Color(27, 133, 135);

    Color grey = new Color(204, 204, 204);

    setForeground(grey);
    plus.setForeground(cyan);
    minus.setForeground(cyan);
    multiply.setForeground(cyan);
    division.setForeground(cyan);
    equals.setForeground(cyan);
    decimal.setForeground(cyan);
    closePar.setForeground(cyan);
    openPar.setForeground(cyan);
    inverse.setForeground(cyan);
    reset.setForeground(cyan);
    realPart.setForeground(cyan);
    imagPart.setForeground(cyan);
    log.setForeground(cyan);
    squareRoot.setForeground(cyan);
    conjugate.setForeground(cyan);
    exponent.setForeground(cyan);
    Color yellow = new Color(135, 124, 27);
    cancel.setForeground(yellow);
    backspace.setForeground(yellow);
    sign.setForeground(yellow);
    outputformat.setForeground(yellow);
    realPart.setForeground(yellow);
    imagPart.setForeground(yellow);
    log.setForeground(yellow);
    steps.setForeground(yellow);
    

  }

  /**
   * Sets the font of each button's text.
   */
  private void setButtonFont()
  {
    Font bolditalic = new Font("bolditalic", Font.BOLD + Font.ITALIC, 12);
    iButton.setFont(bolditalic);
  }

  /**
   * Gets the instance of the current calculator.
   * 
   * @return CalcPanel - either the current calcPanel or a new one
   */
  public static CalcPanel getInstance()
  {

    if (panel == null)
    {

      panel = new CalcPanel();

    }

    return panel;

  }

  /**
   * Turns the imaginary button on/off depending on the condition.
   * 
   * @param v
   *          - true or false depening on the condition
   */
  public void toggleImag(final boolean v)
  {
    iButton.setEnabled(v);
  }

  /**
   * Toggles the equals button depending on the condition.
   * 
   * @param v
   *          - true or false turns the button on or off
   */
  public void toggleEquals(final boolean v)
  {
    equals.setEnabled(v);
  }

  /**
   * Toggles the decimal button depending on the condition.
   * 
   * @param v
   *          - true or false turns the button on or off.
   */
  public void toggleDecimal(final boolean v)
  {
    decimal.setEnabled(v);
  }

  /**
   * disables numbers and decimal points after an i is added to the input field. this prevents
   * confusing formatting
   */
  public void disableAllNumsI()
  {
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
    toggleDecimal(false);
    toggleImag(false);
  }

  /**
   * Toggles decimal, numbers, and imaginary buttons.
   * 
   * @param v
   *          - true or false turns the buttons on or off
   */
  public void toggleAllNumsDI(final boolean v)
  {
    toggleAllNums(v);
    toggleDecimal(v);
    toggleImag(v);
  }

  /**
   * Disables the imaginary button.
   */
  public void disableIButton()
  {

    iButton.setEnabled(false);
  }

  /**
   * Enables all numbers + decimal + imaginary button.
   */

  public void enableAllNums()
  {
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

  /**
   * Toggles all numbers on or off.
   * 
   * @param v
   *          - boolean true or false
   */
  public void toggleAllNums(final boolean v)
  {
    one.setEnabled(v);
    two.setEnabled(v);
    three.setEnabled(v);
    four.setEnabled(v);
    five.setEnabled(v);
    six.setEnabled(v);
    seven.setEnabled(v);
    eight.setEnabled(v);
    nine.setEnabled(v);
    zero.setEnabled(v);

  }

  /**
   * Toggles the operators.
   * 
   * @param v
   *          - boolean true or false
   */
  public void toggleOperators(final boolean v)
  {
    plus.setEnabled(v);
    minus.setEnabled(v);
    multiply.setEnabled(v);
    division.setEnabled(v);
    inverse.setEnabled(v);
  }

  /**
   * Toggles Operators and i button.
   * 
   * @param v
   *          - boolean true or false
   */
  public void toggleOperatorsI(final boolean v)
  {
    plus.setEnabled(v);
    minus.setEnabled(v);
    multiply.setEnabled(v);
    division.setEnabled(v);
    inverse.setEnabled(v);
    toggleImag(v);
  }

  /**
   * Make close CParen enabled or disabled.
   */
  private void toggleCParen()
  {
    if (parenC > 0)
    {
      closePar.setEnabled(true);
      toggleEquals(false);
    }
    else
    {
      closePar.setEnabled(false);
      toggleEquals(true);
    }
  }

  /**
   * Enables the equals button.
   */
  public void enableEquals()
  {

    equals.setEnabled(true);
  }

  /**
   * Gets the parenC count.
   * 
   * @return int - paren count
   */
  public int getParenC()
  {
    return parenC;
  }

  /**
   * Changes the ParenC.
   * 
   * @param i
   *          - int to change ParenC
   */
  public void changeParenC(final int i)
  {
    parenC = parenC + i;
    toggleCParen();
  }

  /**
   * checks if the decimal is present.
   * 
   * @return boolean - true and false;
   */
  public boolean getdPresent()
  {
    return dPresent;
  }

  /**
   * Sets decimal present to false.
   */
  public void dPresentFalse()
  {
    dPresent = false;
  }

  /**
   * Sets decimal present to true.
   */
  public void dPresentTrue()
  {
    dPresent = true;
  }

  /**
   * Changes the sign based on the current attribute of the number (negavite becomes positive and
   * vice versa).
   */
  public void changeSign()
  {
    String str = panel.getDisplay();
    int newLine = str.indexOf('\n') + 1;
    String top = str.substring(0, newLine);
    String bottom = str.substring(newLine);
    str = str.substring(newLine).strip();

    if (bottom.charAt(0) == '-')
    {
      display.setText(top + bottom.substring(1));
    }
    else
    {
      display.setText(top + '-' + bottom);
    }
  }
}
