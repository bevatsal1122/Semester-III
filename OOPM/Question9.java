// Code by bevatsal1122 (GitHub)
// Trust God, Your Code Will Work

import java.util.*;
import Engineering.*;

class Question9 {
   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.print("\nEnter No. of Students: ");
      int n=sc.nextInt(), i=-1;
      Vector<Engineering.Student> s=new Vector<Engineering.Student>(n, 5);
      System.out.print("\nOptions -\n1. Add Student Data\n2. Display Sorted Students Data\n3. Exit\nEnter Choice: ");
      int choice=sc.nextInt();
      while (choice!=3) {
         if (choice==1) {
            Engineering.Student newStudent=new Engineering.Student();
            s.addElement(newStudent);
            s.get(++i).getMarks();
         }
         else if (choice==2) {
            System.out.println("\nSorted Student Data -\nFormat \n");
            Marks.sort(s);
            Marks.display(s);
         }
         else System.out.println("\nWrong Option!!");
         System.out.print("\nOptions -\n1. Add Student Data\n2. Display Sorted Students Data\n3. Exit\nEnter Choice: ");
         choice=sc.nextInt();
      }
      System.out.println("\nExiting...");
      sc.close();
   }
}
