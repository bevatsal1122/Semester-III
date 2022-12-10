// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;

class Question3 {
   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      System.out.print("\nEnter No. of Players: ");
      int n=s.nextInt();
      int data[][]=new int [n][];
      for (int i=0; i<n; ++i) {
         System.out.print("\nEnter No. of Matches played by Player "+(int)(i+1)+": ");
         int matches=s.nextInt();
         data[i]=new int[matches];
         for (int j=0; j<matches; ++j) {
            System.out.print("Enter Runs in Match "+(int)(j+1)+": ");
            data[i][j]=s.nextInt();
         }
      }
      System.out.print("\n");
      for (int i=0; i<n; ++i) {
         int sum=0;
         for (int j=0; j<data[i].length; ++j) {
            sum+=data[i][j];
         }
         double average;
         if (data[i].length==0) average=0;
         else average=(sum*1.0)/data[i].length;
         System.out.println("Player "+(int)(i+1)+" Average: "+average);
      }
   }
}
