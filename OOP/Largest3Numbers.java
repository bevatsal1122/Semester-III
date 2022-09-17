import java.util.*;

class Largest3Numbers {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter Number 1: "); int a=s.nextInt();
      System.out.print("Enter Number 2: "); int b=s.nextInt();
      System.out.print("Enter Number 3: "); int c=s.nextInt();
      if (a>=b && a>=c) System.out.println("\n"+a+" is the largest out of "+a+", "+b+" and "+c+".");
      else if (b>=a && b>=c) System.out.println("\n"+b+" is the largest out of "+a+", "+b+" and "+c+".");
      else if (c>=a && c>=b) System.out.println("\n"+c+" is the largest out of "+a+", "+b+" and "+c+".");
   }
}
