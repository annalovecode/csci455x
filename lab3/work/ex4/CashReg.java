/**
   A cash register totals up sales and computes change due.

   Version for CS 455 lab 3.  Modified from version from Big Java, 6th
   ed.

   Changes [made by CMB]:

     * This version of the class is called CashReg (instead of CashRegister)
     * Added getTotal() accessor function.
     *  Made constants private.

   Ex:
   CashReg register = new CashReg();
   register.recordPurchase(0.59);  // ring something up
   register.recordPurchase(1.99);  // ring up another item
   register.recordPurchase(5.0);   // ring up a third item
   double tot = register.getTotal();    // total of purchases so far: 7.58
   register.receivePayment(10,0,0,0,0);  // customer pays with a 10
   int change = register.giveChange();  // compute change owed: 2.42
                                        // and zeroes out register

   register.recordPurchase(1.0);  // now we start ringing up someone else . . .

*/
public class CashReg
{
   private static final int DOLLAR_VALUE = 100;

   private double purchase;
   private int purchaseCents;
   private int paymentCents;
   

   /**
      Constructs a cash register with no money in it.
   */
   public CashReg()
   {
      purchase = 0;
      purchaseCents = 0;
      paymentCents = 0;
   }

   /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   public void recordPurchase(double amount)
   {
      purchaseCents = purchaseCents + (int) (Math.round(amount * DOLLAR_VALUE));
      purchase = (double) purchaseCents / DOLLAR_VALUE;      
   }
   
   /**
      Gets total of all purchases made.
   */
    public double getTotal() {
       return purchase;
    }; 

   /**
      Enters the payment received from the customer.
      @param Change object consisting of change
   */
   public void receivePayment(Change money)
   {
      paymentCents = money.totalValue();
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public Change giveChange()
   {
      int change = paymentCents - purchaseCents;
      int dollars = change / 100;
      change = change - (dollars * DOLLAR_VALUE);
      int quarters = 0;
      while (change >= 25) {
         change =- 25;
         quarters++;
      }
      int dimes = 0;
      while (change >= 10) {
         change =- 10;
         dimes++;
      }
      int nickels = 0;
      while (change >= 5) {
         change =- 5;
         nickels++;
      }
      int pennies = 0;
      while (change >= 1) {
         change =- 1;
         pennies++;
      }
      
      purchase = 0;
      purchaseCents = 0;
      paymentCents = 0;
      return new Change(dollars, quarters, dimes, nickels, pennies);
   }
}
