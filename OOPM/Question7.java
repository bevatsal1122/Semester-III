// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;

class TimeException extends Exception {
   int m0, s0, m1, s1, sumSeconds;
   TimeException(int m0, int s0, int m1, int s1) {
      this.m0=m0;
      this.s0=s0;
      this.m1=m1;
      this.s1=s1;
      sumSeconds=this.s0+this.s1;
   }

   public String toString() {
      return ("\nTimeException: Total Time in Seconds excedeed Maximum Limit of 60.\nTotal Sum of Seconds found "+sumSeconds+".");
   }
}

class Question7 {
   public static void main(String[] args) {
      Scanner s=new Scanner(System.in);   
      System.out.print("\nEnter Time 1\nEnter Minutes: ");
      int m0=s.nextInt();
      System.out.print("Enter Seconds: ");
      int s0=s.nextInt();
      System.out.print("\nEnter Time 2\nEnter Minutes: ");
      int m1=s.nextInt();
      System.out.print("Enter Seconds: ");
      int s1=s.nextInt();
      int totalM=m0+m1, totalS=s0+s1;
      try {
         if (totalS>60) {
            totalM+=(int)(totalS/60);
            totalS=totalS%60;
            s.close();
            throw new TimeException(m0, s0, m1, s1);
         }
         System.out.println("\nTotal Time (MM:SS) - "+totalM+":"+totalS);
         System.out.println("Total Minutes: "+totalM);
         System.out.println("Total Seconds: "+totalS);
      } catch (TimeException e) {
         e.printStackTrace();
      }
   }
}
