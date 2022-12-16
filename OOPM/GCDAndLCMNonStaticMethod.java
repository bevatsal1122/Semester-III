// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;

class Solution {
   public int gcd(int a, int b) {
      a=Math.abs(a);
      b=Math.abs(b);
      for (int i=Math.min(a, b); i>=1; --i) {
         if (a%i==0 && b%i==0) return i;
      }
      return 1;
   }
   
   public int lcm(int a, int b) {
      for (int i=Math.min(a, b); ; ++i) {
         if (i%a==0 && i%b==0) return Math.abs(i);
      }
   }
}

class GCDAndLCMNonStaticMethod {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      Solution here = new Solution();
      System.out.print("\n1. Find GCD\n2. Find LCM\nEnter Option: ");
      int choice=s.nextInt(), a, b;
      if (choice==1 || choice==2) {
         System.out.print("\nEnter Number1: "); a=s.nextInt();
         System.out.print("Enter Number2: "); b=s.nextInt();
         if (choice==1) {
            System.out.print("GCD: " + here.gcd(a, b) + "\n");  
         }
         else if (choice==2) {
            System.out.print("LCM: " + here.lcm(a, b) + "\n"); 
         }
      }
      else {
         System.out.print("Wrong Option!!\n");
      }
      s.close();  
   }
}
