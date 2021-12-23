import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BookshelfTester {

	public static void main(String[] args) {
		 Bookshelf bsf = new Bookshelf();
     // System.out.println(bsf);
		 System.out.println(bsf.toString());
		 ArrayList<Integer> pileOfBooks =new ArrayList<Integer>(Arrays.asList(1,3,4,8,11,14,15,18));
      //pileOfBooks.add(-20);
		 Bookshelf bsf1 = new Bookshelf(pileOfBooks);
		//BookshelfKeeper bk1 = new BookshelfKeeper(bsf1);
      System.out.println(bsf1.toString());
    }
}
     
      