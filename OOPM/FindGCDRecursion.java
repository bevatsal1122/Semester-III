// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;

class FindGCDRecursion {
   public static int findGCD(int a, int b) {
      if (b==0) return a;
      return findGCD(b, a%b);
   }

   public static void main (String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter Number 1: "); int a=s.nextInt();
      System.out.print("Enter Number 2: "); int b=s.nextInt();
      int gcd=findGCD(a, b);
      System.out.println("GCD: "+gcd);
   } 
}
