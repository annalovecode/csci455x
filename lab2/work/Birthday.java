import java.time.LocalDate;
import java.util.Scanner;
class Birthday {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your birth month [1..12]:");
        int month=input.nextInt();
        System.out.print("Enter your birth day of month:");
        int day=input.nextInt();
        System.out.print("Enter your birth year [4-digit year]:");
        int year=input.nextInt();
        LocalDate nowDate=LocalDate.now();
        int year1=nowDate.getYear();
        LocalDate birthdayDate=LocalDate.of(year1,month,day);
        if(birthdayDate.isBefore(nowDate))
        {
           System.out.println("Your birthday has already happened this year.");
        }
       else{
           System.out.println("Your birthday has not yet happened this year.");
       }
        int age=year1-year;
        if(nowDate.getDayOfYear()<birthdayDate.getDayOfYear()){
           age--;
       }
         System.out.println("You're "+age+" years old.");
   }
   
}