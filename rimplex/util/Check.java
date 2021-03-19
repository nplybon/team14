package util;

import java.util.List;

/**
 * A utility class that performs checks of various kinds.
 * 
 * @author Prof. David Bernstein, James Madison University
 * @version see the Git commit History
 */
public class Check
{
  /**
   * Check to see if an array of String objects (haystack) ends with a particular String(needle).
   * 
   * @param haystack
   *          The array of String objects to search through
   * @param needle
   *          The String object to search for
   * @return true if haystack contains needle; false otherwise
   */
  public static boolean forContains(final String[] haystack, final String needle)
  {
    for (int i = 0; i < haystack.length; i++)
    {
      // <<<<<<< HEAD
      if (haystack[i].endsWith(needle))
        return true;
      // =======
      // if (haystack[i].equalsIgnoreCase(needle)) return true;
      // >>>>>>> branch 'master' of https://github.com/bernstdh/team14.git
    }
    return false;
  }

  // <<<<<<< HEAD
  public static boolean forContains(final List<String> list, final String str)
  {
    for (String example : list)
    {
      if (example.equals(str))
        ;
      {
        return true;
      }
    }
    return false;
  }

  // =======
  public void forContainsIgnoreCase(String[] list, String word)
  {

    // >>>>>>> branch 'master' of https://github.com/bernstdh/team14.git
  }
}
