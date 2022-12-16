import java.util.*;

class MyException extends Exception {
   MyException() {
      System.out.println("\nThe Number contains digit 0.");
   }
   public String containsNine() {
      return "The Number contains digit 9.";
   }
}

class ExceptionHandling {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);   
      System.out.print("\nEnter Number: ");
      int n=s.nextInt();
      int m=n;
      MyException a=new MyException();
            try {
         while (m>0) {
            int t=m%10;
            if (t==0) {
               s.close();
               throw a;
            }
            m/=10;
         }
         System.out.println("\nThe Number doesn't contain digit 0.");
      } catch (MyException e) {
         e.printStackTrace();
      }
      System.out.println();
      try {
         while (n>0) {
            int t=n%10;
            if (t==9) {
               s.close();  
               throw a;
            }
            n/=10;
         }
         System.out.println("The Number doesn't contain digit 9.");
      } catch (MyException e) {
         System.out.println(e.containsNine());
      }
      s.close();
   }
}