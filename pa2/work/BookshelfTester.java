import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BookshelfTester {

	public static void main(String[] args) {
		 Bookshelf bsf1 = new Bookshelf();
     // System.out.println(bsf);
		 System.out.println("expected :[]"+bsf1.toString());
		 ArrayList<Integer> pileOfBooks =new ArrayList<Integer>(Arrays.asList(1,3,4,8,11,14,15,18));
      //pileOfBooks.add(-20);
		 Bookshelf bsf = new Bookshelf(pileOfBooks);
		//BookshelfKeeper bk1 = new BookshelfKeeper(bsf1);
      System.out.println("expected:[1,3,4,8,11,14,15,18] "+bsf.toString());
      //test addFront
		 bsf.addFront(1);
		 System.out.println("expected:[1,1,3,4,8,11,14,15,18] "+bsf.toString());
		 //test removeFront
		 bsf.removeFront();
		 System.out.println("expected:[1,3,4,8,11,14,15,18] "+bsf.toString());
		//test isSorted
		System.out.println("expected:true "+bsf.isSorted());
       //test addLast
      bsf.addLast(1);
      System.out.println("expected:[1,3,4,8,11,14,15,18,1] "+bsf.toString());
       //test isSorted
      System.out.println("expected:false "+bsf.isSorted());
       //test removeLast
      bsf.removeLast();
       System.out.println("expected:[1,3,4,8,11,14,15,18] "+bsf.toString());
		//test getHeight
		System.out.println("expected:8 "+bsf.getHeight(3));
		//test addLast
		bsf.addLast(30);
		System.out.println("expected:[1,3,4,8,11,14,15,18,30] "+bsf.toString());
       //test size
     System.out.println("expected:9 "+bsf.size());
		
    }
}
     
      