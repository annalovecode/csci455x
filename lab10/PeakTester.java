/* 
 * Contains hasOnePeak method and
 * tests it on a bunch of hardcoded test cases, printing out test
 * data, actual results, and a FAILED message if actual results don't
 * match expected results.
 */

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PeakTester {


   /*
    * see lab assgt for specification of hasOnePeak method.
    */
   public static boolean hasOnePeak(LinkedList<Integer> list) {
      if (list.size() <= 2) {
         return false;
      }
      ListIterator<Integer> it1 = list.listIterator();
      int prev = Integer.MIN_VALUE;
      boolean switcher = false;
      while(it1.hasNext()) {
         int val = it1.next();
         if (val <= prev && !switcher) {
            switcher = true;
         } else if (val >= prev && switcher) {
            return false;
         }
         if (prev == Integer.MIN_VALUE) {
            if (it1.next() < val) {
               return false;
            }
            it1.previous();
         }
         if (!it1.hasNext() && !switcher) {
            return false;
         }
         prev = val;
      }
      return true;
   }


   public static void main(String args[]) {

      testPeak("", false);
      testPeak("3", false);
      testPeak("3 4", false);
      testPeak("4 2", false);
      testPeak("3 4 5", false);
      testPeak("5 4 3", false);
      testPeak("3 4 5 3", true);
      testPeak("3 4 5 3 2", true);
      testPeak("3 7 9 11 8 4 3 1", true);
      testPeak("3 5 4", true);
      testPeak("4 3 5", false);
      testPeak("2 4 3 5", false);
      testPeak("5 2 4 3 5", false);
      testPeak("5 2 4 3", false);
      testPeak("2 4 3 5 2", false);  // 2 peaks
   }

    
    
   /*  Assumes the following format for listString parameter, shown by example
    * (first one is empty list):
    *   "", "3", "3 4", "3 4 5", etc.
    */
   private static LinkedList<Integer> makeList(String listString) {
      Scanner strscan = new Scanner(listString);

      LinkedList<Integer> list = new LinkedList<Integer>();

      while (strscan.hasNextInt()) {
         list.add(strscan.nextInt());
      }

      return list;
   }


   /* Test hasOnePeak method on a list form of input given in listString
    * Prints test data, result, and whether result matched expectedResult
    *
    * listString is a string form of a list given as a space separated
    * sequence of ints.  E.g.,
    *  "" (empty string), "3" (1 elmt string), "2 4" (2 elmt string), etc.
    *
    */
   private static void testPeak(String listString, boolean expectedResult) {

      LinkedList<Integer> list = makeList(listString);

      boolean result = hasOnePeak(list);
      System.out.print("List: " + list
                       + " hasOnePeak? " + result);
      if (result != expectedResult) {
         System.out.print("...hasOnePeak FAILED");
      }
      System.out.println();
   }
}
