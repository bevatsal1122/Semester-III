// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

// All Functions in 1 Class

import java.util.*;

class FindGCDAndLCMStaticMethod {
   public static int gcd(int a, int b) {
      for (int i=Math.min(a, b); i>=1; --i) {
         if (a%i==0 && b%i==0) return i;
      }
      return 1;
   }
   
   public static int lcm(int a, int b) {
      for (int i=Math.min(a, b); ; ++i) {
         if (i%a==0 && i%b==0) return Math.abs(i);
      }
   }

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\n1. Find GCD\n2. Find LCM\nEnter Choice: ");
      int choice=s.nextInt(), a, b;
      if (choice==1 || choice==2) {
         System.out.print("\nEnter Number1: "); a=s.nextInt();
         System.out.print("Enter Number2: "); b=s.nextInt();
         if (choice==1) {
            System.out.print("GCD: " + gcd(a, b) + "\n");  
         }
         else if (choice==2) {
            System.out.print("LCM: " + lcm(a, b) + "\n"); 
         }
      }
      else {
         System.out.print("Wrong Option!!\n");
      }
   }
}

// Functions in Different Classes

// import java.util.*;

// class Solution {
//    public static int gcd(int a, int b) {
//       for (int i=Math.min(a, b); i>=1; --i) {
//          if (a%i==0 && b%i==0) return i;
//       }
//       return 1;
//    }
   
//    public static int lcm(int a, int b) {
//       for (int i=Math.min(a, b); ; ++i) {
//          if (i%a==0 && i%b==0) return Math.abs(i);
//       }
//    }
// }

// class FindGCDAndLCMStaticMethod {
//    public static void main(String[] args) {
//       Scanner s = new Scanner(System.in);
//       System.out.print("\n1. Find GCD\n2. Find LCM\nEnter Choice: ");
//       int choice=s.nextInt(), a, b;
//       if (choice==1 || choice==2) {
//          System.out.print("\nEnter Number1: "); a=s.nextInt();
//          System.out.print("Enter Number2: "); b=s.nextInt();
//          if (choice==1) {
//             System.out.print("GCD: " + Solution.gcd(a, b) + "\n");  
//          }
//          else if (choice==2) {
//             System.out.print("LCM: " + Solution.lcm(a, b) + "\n"); 
//          }
//       }
//       else {
//          System.out.print("Wrong Option!!\n");
//       }
//    }
// }
