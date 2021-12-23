import java.util.ArrayList;
import java.util.Arrays;
// Name: 
// USC NetID: 
// CSCI455 PA2
// Fall 2021


/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {

    /**
      Representation invariant:

      <put rep. invar. comment here>
        1.Uses ArrayList<Integer> pileOfBooks as a bookshelf.
        2.For each element in Bookshelf pileOfBooks,use 'height' as a indicator  of each book. height >=0.
        3.pileOfBooks contains an array list of 0 or more positive numbers. That is pileOfBooks.size()>=0.
        4.the books on this Bookshelf are in non-decreasing order.

   */
   
   // <add instance variables here>
   ArrayList<Integer> pileOfBooks;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      pileOfBooks=new ArrayList<Integer>();
      assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)
      
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      this.pileOfBooks= pileOfBooks;
      assert isValidBookshelf(); 
 
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      pileOfBooks.add(0, height);
      assert isValidBookshelf(); 
      
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      //lastIndex refers to the last index of the bookshelf and initialize it as 0.
	   int lastIndex=0;
	   if(pileOfBooks.size()!=0) 
     {
	   lastIndex= pileOfBooks.size();
	   pileOfBooks.add(lastIndex, height);
	  }
	   else
     {
		   pileOfBooks.add(lastIndex,height);
	    }
       assert isValidBookshelf(); 
      
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      //removedFrontBook to get the height of the removed book height.
	    int removedFrontBook = 0;
	    if(pileOfBooks.size()!= 0)
		{
		    removedFrontBook = pileOfBooks.get(0);
	       pileOfBooks.remove(0);
		}
       assert isValidBookshelf(); 
      return removedFrontBook;    // dummy code to get stub to compile
      
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      //initialize removedLastBook
	   int removedLastBook=0;
	   //use lastIndex to indicate the book at the end of the bookshelf. initialize it as 0;
	   int lastIndex=0;
	   if(pileOfBooks.size()!=0) {  
	   lastIndex= pileOfBooks.size()-1;
	   removedLastBook = pileOfBooks.get(lastIndex);
	   pileOfBooks.remove(lastIndex);
	   }
      assert isValidBookshelf();  
	   return removedLastBook;    // dummy code to get stub to compile      
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      
      //Initialize height
	   int height=0;
	   if(position>=0 && position<pileOfBooks.size()) {
        height =pileOfBooks.get(position);  // dummy code to get stub to compile
	   }
       assert isValidBookshelf(); 
	   return height;  // dummy code to get stub to compile
      
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
       assert isValidBookshelf(); 
      return pileOfBooks.size();   // dummy code to get stub to compile

   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      
      return pileOfBooks.toString();   // dummy code to get stub to compile

   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
     if(pileOfBooks.size()>0) {
	  int largest = pileOfBooks.get(0);
	  for (Integer book:pileOfBooks) {
		    if(book.compareTo(largest) < 0 ) {
		        return false;
		    }
		    largest = book;
		}
        
	   }
	   
       assert isValidBookshelf(); 
     return true;
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      int i=0;
      if(pileOfBooks.size()>=0) {
    	  for(Integer book:pileOfBooks) {
    		  if(book>0) {
    			  i++;
    		  }
    		  
    	  }
      if(i==pileOfBooks.size()){
       return true;  // dummy code to get stub to compile
      }
       return false;
      }
     return false;

   }

}
