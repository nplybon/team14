package gui;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class that prints the history to a file.
 * 
 * @author Nic Plybon
 * 
 */
public class Printer
{

  /**
   * Takes the history and writes it to a file.
   * 
   * @param history
   *          the history of calculations
   */
  public static void print(final String history)
  {
    try
    {
      FileWriter fw = new FileWriter("rimplexcalculations.txt", false);
      fw.write(history);
      fw.close();
    }
    catch (IOException e)
    {
    }

    //PrinterJob pj = PrinterJob.getPrinterJob();
    //if (pj.printDialog())
    //{
      //try
      //{
        //pj.print();
      //}
      //catch (PrinterException e)
      //{
      //}
    //}

  }

}
