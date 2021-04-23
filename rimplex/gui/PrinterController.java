package gui;

import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JFrame;

/**
 * A utility class for controlling the printing process.
 * 
 * @author Prof. David Bernstein, Nic Plybon
 * @version 1.0
 */
public class PrinterController
{
  /**
   * Print the given Printable (displaying any error messages in a JOptionPane).
   * 
   * @param printable
   *          The Printable to print
   * @param parent
   *          The parent JFrame
   */

  public static void print(final Printable printable, final JFrame parent)
  {
    PrinterJob job = PrinterJob.getPrinterJob();
    try
    {
      job.setPrintable(printable);

      HistoryFrame.getDisplay().print();
    }
    catch (PrinterException e)
    {

    }
  }

}
