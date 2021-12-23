
/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
import java.util.ArrayList;
import java.lang.Integer;
public class Nums {

   /**variable**/
   private ArrayList<Integer> arrList; 

   /**
      Create an empty sequence of nums.
   */
   public Nums () {
      arrList = new ArrayList<Integer>();     

   }

   /**
      Add a value to the end of the sequence.
   */
   public void add(int value) {
      arrList.add(value);

   }


   /**
      Return the minimum value in the sequence.
      If the sequence is empty, returns Integer.MAX_VALUE
   */
   public int minVal() {
      //minimum represents the minimum value in the sequence.
      int minimum = Integer.MAX_VALUE;
      //   {
       //    minimum = arrList.get(0);
         for(int i =0; i<arrList.size(); i++){
            if(minimum > arrList.get(i)){
               minimum = arrList.get(i);
            }
         }
     // }
      

      return minimum;    // stub code to get it to compile

   }

   /**
      Prints out the sequence of values as a space-separated list 
      on one line surrounded by parentheses.
      Does not print a newline.
      E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
   */
   public void printVals() {
      if(arrList.size()==0){
          System.out.println("()");
      }
      else{ 
         System.out.print("(");
         for(int i=0;i<arrList.size()-1;i++){
         System.out.print(arrList.get(i)+" ");
       }
         System.out.print(arrList.get(arrList.size()-1)+")");
     }

   }

   /**
      Returns a new Nums object with all the values from this Nums
      object that are above the given threshold.  The values in the
      new object are in the same order as in this one.
      E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
      returns      (19 21 19)
      myNums after call:  (3 7 19 4 21 19 10)
      The method does not modify the object the method is called on.
   */
   public Nums valuesGT(int threshold) {
      Nums numList = new Nums();
    //  private ArrayList<Integer> numList = new ArrayList<Integer>();
      int nums = 0;
      for(int i=0;i<arrList.size();i++){
         nums = arrList.get(i);
         if(nums>threshold){
           numList.add(nums);
         }
      }
      return numList;  // stub code to get it to compile

   }

    
}
