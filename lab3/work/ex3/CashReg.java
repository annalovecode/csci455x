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
   private static final int QUARTER_VALUE = 25;
   private static final int DIME_VALUE = 10;
   private static final int NICKEL_VALUE = 5;
   private static final int PENNY_VALUE = 1;
   private static final int DOLLAR_VALUE = 100;

   private double purchase;
   private double payment;
   private int purchaseCents;
   private int paymentCents;
   

   /**
      Constructs a cash register with no money in it.
   */
   public CashReg()
   {
      purchase = 0;
      payment = 0;
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
      @param dollars the number of dollars in the payment
      @param quarters the number of quarters in the payment
      @param dimes the number of dimes in the payment
      @param nickels the number of nickels in the payment
      @param pennies the number of pennies in the payment
   */
   public void receivePayment(int dollars, int quarters, 
         int dimes, int nickels, int pennies)
   {
      paymentCents = dollars * DOLLAR_VALUE + quarters * QUARTER_VALUE + dimes * DIME_VALUE
            + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;
      payment = (double) paymentCents / DOLLAR_VALUE;
   }
   
   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {
      int change = paymentCents - purchaseCents;
      purchase = 0;
      payment = 0;
      purchaseCents = 0;
      paymentCents = 0;
      return (double) change / DOLLAR_VALUE;
   }
}
